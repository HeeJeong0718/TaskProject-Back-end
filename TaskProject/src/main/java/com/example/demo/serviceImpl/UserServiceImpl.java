package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.service.UserService;



@Repository
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserMapper userMapper;
    

	
	@Override
	public HashMap<String, Object> selectMyPage(MemberVO memberVO) throws Exception {
		return userMapper.selectMyPage(memberVO);
	}
	
	
	
	@Override
	public int updateMyPage(MemberVO memberVO)   throws Exception {
		return userMapper.updateMyPage(memberVO);
	}
}
	  
	  
	
	
	

