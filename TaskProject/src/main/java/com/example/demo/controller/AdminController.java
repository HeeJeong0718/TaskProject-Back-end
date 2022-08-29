package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.StringUtil;
import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.MemberVO;
import com.example.demo.service.AdminService;


@CrossOrigin(origins="*") 
@RestController
public class AdminController {
	@Resource
	private AdminService adminService;
	

		/* 유저 task조회  */
		@GetMapping(value = "/userAll")
		public ResponseEntity<String> userAll(ModelMap model,  MemberVO  memberVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
			
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			List<HashMap<String,Object>> resultList = adminService.selectUserAll(memberVO);


			jsonStr = StringUtil.jsonStrSearch(resultList);
			resHeader.add("Content-Type", "application/json");		
			return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
		}
			
		/* 관리자 알림 리스트 */
		@GetMapping(value = "/adminNotice")
		public ResponseEntity<String> adminNotice(ModelMap model,  MemberVO  memberVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
			
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			List<HashMap<String,Object>> resultList = adminService.adminNotice(memberVO);


			jsonStr = StringUtil.jsonStrSearch(resultList);
			resHeader.add("Content-Type", "application/json");		
			return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
		}
		
	 	
		 @CrossOrigin(origins="*")
			@RequestMapping(value = "/adminDetail")
			@ResponseBody
			public ResponseEntity<String> adminDetail(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody MemberVO  memberVO) throws Exception{
				String jsonStr = "";
				HttpHeaders resHeader = new HttpHeaders();
				HttpSession session = request.getSession();
				
				List<HashMap<String,Object>> adminDetail = adminService.adminDetail(memberVO);

				jsonStr = StringUtil.jsonStrSearch(adminDetail);
				resHeader.add("Content-Type", "application/json");		
				return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
			
			}	 
		 

		 @CrossOrigin(origins="*")
		 @GetMapping(value = "/boardDetail2")
		public ResponseEntity<String> menuDetail2(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model ,  BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			try {
				HashMap<String , Object> adminDetail2 = adminService.adminDetail2(boardVO);
				
				jsonStr = StringUtil.jsonStrOneSearch(adminDetail2);
				System.out.println("jsonStr" + jsonStr);
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}
		 	
		
			
}
