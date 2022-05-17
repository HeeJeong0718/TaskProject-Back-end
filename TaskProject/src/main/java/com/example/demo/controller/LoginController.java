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
import com.example.demo.model.MemberVO;
import com.example.demo.service.LoginService;

@CrossOrigin(origins="*") 
@RestController
public class LoginController {
	
	

	@Resource 
	private LoginService loginService;
	
	 @CrossOrigin(origins="*")
	@RequestMapping(value = "/login")
	@ResponseBody
	public ResponseEntity<String> tasklogin(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody MemberVO  memberVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		HttpSession session = request.getSession();
		
		try {
		     //MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
			HashMap<String , Object> testlogin = loginService.tasklogin(memberVO);
		   
			jsonStr = StringUtil.jsonStrOneSearch(testlogin);
			System.out.println("jsonStr" + jsonStr);
		}catch(Exception e){
			jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	}
		@RequestMapping(value = "/taskregister")
		@ResponseBody //@requestbody 꼭넣어주자
		public ResponseEntity<String> registerinsert(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody MemberVO  memberVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				int insertYn = 0;
				insertYn += loginService.insertRegister(memberVO);	
			
				System.out.println("insertYn" + insertYn);
				if(insertYn > 0) {
					jsonStr = StringUtil.jsonSimpleReturn3(memberVO);
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
