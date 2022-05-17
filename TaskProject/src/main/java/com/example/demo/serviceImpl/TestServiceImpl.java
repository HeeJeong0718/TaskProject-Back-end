package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.model.BoardVO;
import com.example.demo.service.TestService;



@Repository
public class TestServiceImpl implements TestService {
	
	@Resource
	private TestMapper testMapper;
    
	@Override
	public List<HashMap<String, Object>> selectList(EmpVO empVO) throws Exception {
		return testMapper.selectList(empVO);
	}

	@Override
	public List<HashMap<String, Object>> selectSearch( BoardVO boardVO) throws Exception {
		return testMapper.selectSearch(boardVO);
	}
	
	/*
	 * @Override public HashMap<String, Object> selectSearch ( BoardVO boardVO)
	 * throws Exception { return testMapper.selectSearch(boardVO); }
	 */
   
   
	
	
	@Override
	public List<HashMap<String, Object>> selectListAll(MemberVO memberVO) throws Exception {
		return testMapper.selectListAll(memberVO);
	}
	

	@Override
	public int insertTest(BoardVO boardVO)   throws Exception {
		return testMapper.insertTest(boardVO);
	}
	
 //회원가입
	@Override
	public int insertRegister(MemberVO   memberVO)   throws Exception {
		return testMapper.insertRegister(memberVO);
	}
	
	
	/*@Override
	public HashMap<String , Object> insertRegister(MemberVO   memberVO)   throws Exception {
		return testMapper.insertRegister(memberVO);
	}*/
	
	
	
	@Override
	public int deleteTest(BoardVO boardVO)   throws Exception {
		return testMapper.deleteTest(boardVO);
	}
	
	@Override
	public int updateTest(BoardVO boardVO)   throws Exception {
		return testMapper.updateTest(boardVO);
	}
	

	@Override
	public HashMap<String, Object> selectDetail ( BoardVO  boardVO)   throws Exception {
		return testMapper.selectDetail(boardVO);
	}

	/*
	 * public MemberVO testlogin(MemberVO memberVO) throws Exception { return
	 * testMapper.testlogin(memberVO);
	 */
	
	
	  @Override public HashMap<String, Object> testlogin (MemberVO memberVO) throws
	  Exception { return testMapper.testlogin(memberVO); }
	 
	  
		@Override
		public List<HashMap<String, Object>> testadmin(MemberVO memberVO) throws Exception {
			return testMapper.testadmin(memberVO);
		}
	  
	
	
}
