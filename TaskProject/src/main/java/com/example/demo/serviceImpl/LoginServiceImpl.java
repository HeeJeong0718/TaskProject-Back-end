package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.model.BoardVO;
import com.example.demo.service.LoginService;



@Repository
public class LoginServiceImpl implements LoginService {
	
	@Resource
	private LoginMapper loginMapper;
    

	
	  @Override public HashMap<String, Object> tasklogin (MemberVO memberVO) throws Exception { 
		  return loginMapper.tasklogin(memberVO); 
	}
	 
	  //회원가입
		@Override
		public int insertRegister(MemberVO   memberVO)   throws Exception {
			return loginMapper.insertRegister(memberVO);
		}
		
	  
		@Override
		public List<HashMap<String, Object>> taskadmin(MemberVO memberVO) throws Exception {
			return loginMapper.taskadmin(memberVO);
		}
	  
}
	  
	  
	
	
	

