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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.StringUtil;
import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.MemberVO;
import com.example.demo.service.UserService;

@CrossOrigin(origins="*") 
@RestController
public class UserController {
	
	@Resource 
	private UserService userService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/Mypage")
	@ResponseBody
	public ResponseEntity<String> Mypage(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody MemberVO memberVO) throws Exception {

		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		try {
			HashMap<String , Object> MyPageDetail = userService.selectMyPage(memberVO);
			
			jsonStr = StringUtil.jsonStrOneSearch(MyPageDetail);
			System.out.println("jsonStr" + jsonStr);
		}catch(Exception e){
			jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	  }
	
	@RequestMapping(value = "/MypageUpdate")
	@ResponseBody //@requestbody 꼭넣어주자
	public ResponseEntity<String> mypageupdate(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody MemberVO memberVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
			int updateYn = 0;
			updateYn += userService.updateMyPage(memberVO);	
		
			System.out.println("updateYn" + updateYn);
			if(updateYn > 0) {
				jsonStr = StringUtil.jsonSimpleReturn("000");
				System.out.println("str" + jsonStr); 
			}else { 
				jsonStr = StringUtil.jsonSimpleReturn("997");
			}
		}catch(Exception e){
			jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	}
	
	
	
	
	} 
	 


