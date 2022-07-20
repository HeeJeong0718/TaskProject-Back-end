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
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.MemberVO;
import com.example.demo.service.AdminService;

@CrossOrigin(origins="*") 
@RestController
public class AdminController {
	
	

	@Resource 
	private AdminService adminService;
	
	 @CrossOrigin(origins="*")
	@RequestMapping(value = "/departlist")
	@ResponseBody
	public ResponseEntity<String> departmentlist(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody DepartMentVO  departmentVO) throws Exception{
		 String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			List<HashMap<String,Object>> resultList = adminService.selectDepartMent(departmentVO);


			jsonStr = StringUtil.jsonStrSearch(resultList);
			resHeader.add("Content-Type", "application/json");		
			return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	}
	
		
	   

}
