package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.service.AdminService;



@Repository
public class AdminServiceImpl implements AdminService {
	
	@Resource
	private AdminMapper adminMapper;
    


	
	@Override
	public List<HashMap<String, Object>> selectUserAll(MemberVO memberVO) throws Exception {
		return adminMapper.selectUserAll(memberVO);
	}
	

	@Override
	public List<HashMap<String, Object>> adminNotice(MemberVO memberVO) throws Exception {
		return adminMapper.adminNotice(memberVO);
	}
	
	
	
	@Override
	public List<HashMap<String, Object>> adminDetail(MemberVO memberVO) throws Exception {
		return adminMapper.adminDetail(memberVO);
	}
	
	@Override
	public HashMap<String, Object> adminDetail2 (BoardVO  boardVO)   throws Exception {
		return adminMapper.adminDetail2(boardVO);
	}

	
}
	  
	  
	
	
	

