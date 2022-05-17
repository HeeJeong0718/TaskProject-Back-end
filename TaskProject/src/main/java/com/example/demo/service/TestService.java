package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;

@Service
public interface TestService {
	
	
	
		public List<HashMap<String,Object>> selectList(EmpVO empVO) throws Exception;
		
		public List<HashMap<String,Object>> selectSearch(BoardVO  boardVO) throws Exception;
		//HashMap<String, Object> selectSearch( BoardVO  boardVO)throws Exception;
		
		
        //로그인한 아이디가 가져오기
		
		public List<HashMap<String,Object>> selectListAll(MemberVO memberVO) throws Exception;
		
		
		int insertTest(BoardVO boardVO) throws Exception;
		
		int deleteTest(BoardVO BoardVO) throws Exception;
		
		int updateTest(BoardVO BoardVO) throws Exception;
		
		HashMap<String, Object> selectDetail( BoardVO  boardVO)throws Exception;
		
		// public MemberVO testlogin(MemberVO memberVO) throws Exception;

		
		HashMap<String, Object> testlogin(MemberVO memberVO)throws Exception;
		
		public List<HashMap<String,Object>> testadmin(MemberVO memberVO) throws Exception;

		
  //회원가입
		int insertRegister(MemberVO memberVO) throws Exception;
       
		//HashMap<String , Object> insertRegister(MemberVO memberVO) throws Exception;
}
