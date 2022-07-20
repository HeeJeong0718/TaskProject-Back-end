package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;

@Service
public interface DepartmentService {
	
	public List<HashMap<String,Object>> selectListAll(DepartMentVO  depVO) throws Exception;
	

	int depInsert(DepartMentVO  depVO) throws Exception;
	
	int depDelete(DepartMentVO  depVO) throws Exception;
	
	int depUpdate(DepartMentVO  depVO) throws Exception;
	
	HashMap<String, Object> depDetail(DepartMentVO  depVO)throws Exception;
	

}
