package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;

@Service
public interface UserService {
	
	public HashMap<String,Object> selectMyPage(MemberVO memberVO) throws Exception;
	
	
	int updateMyPage(MemberVO memberVO) throws Exception;

}
