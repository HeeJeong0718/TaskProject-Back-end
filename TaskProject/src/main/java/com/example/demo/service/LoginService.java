package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;

@Service
public interface LoginService {
	
	  HashMap<String, Object> tasklogin(MemberVO memberVO)throws Exception;
		
	  public List<HashMap<String,Object>> taskadmin(MemberVO memberVO) throws Exception;
	  
	  //회원가입
		int insertRegister(MemberVO memberVO) throws Exception;
     
	
}
