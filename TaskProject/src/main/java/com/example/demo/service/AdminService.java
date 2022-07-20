package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;

@Service
public interface AdminService {
	
	public List<HashMap<String,Object>> selectDepartMent(DepartMentVO  departmentVO) throws Exception;
	

}
