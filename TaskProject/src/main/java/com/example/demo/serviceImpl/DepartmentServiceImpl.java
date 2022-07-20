package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.mapper.DepartMentMapper;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.service.DepartmentService;



@Repository
public class DepartmentServiceImpl implements DepartmentService {
	
	@Resource
	private DepartMentMapper depMapper;
    

	
	@Override
	public List<HashMap<String, Object>> selectListAll(DepartMentVO  depVO) throws Exception {
		return depMapper.selectListAll(depVO);
	}
	

	@Override
	public int depInsert(DepartMentVO  depVO)   throws Exception {
		return depMapper.depInsert(depVO);
	}
  
	

	@Override
	public int depDelete(DepartMentVO  depVO)   throws Exception {
		return depMapper.depDelete(depVO);
	}
	
	@Override
	public int depUpdate(DepartMentVO  depVO)   throws Exception {
		return depMapper.depUpdate(depVO);
	}
	

	@Override
	public HashMap<String, Object> depDetail (DepartMentVO  depVO)   throws Exception {
		return depMapper.depDetail(depVO);
	}



}
	  
	  
	
	
	

