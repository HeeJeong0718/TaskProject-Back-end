package com.example.demo.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.BoardVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;



@Mapper
public interface TestMapper {

	List<HashMap<String, Object>>  selectList(EmpVO empVO )throws Exception, SQLException;
	
	List<HashMap<String, Object>>  selectSearch(BoardVO boardVO)throws Exception, SQLException;
  
	//HashMap<String, Object> selectSearch (BoardVO boardVO)throws Exception, SQLException;
	
	//로그인한 아이디의 리스트
	List<HashMap<String, Object>>  selectListAll(MemberVO memberVO)throws Exception, SQLException;
	
	
	int insertTest (BoardVO boardVO)throws Exception, SQLException;
	
	int deleteTest (BoardVO boardVO)throws Exception, SQLException;
	
	int updateTest (BoardVO boardVO)throws Exception, SQLException;

	 
	HashMap<String, Object> selectDetail (BoardVO boardVO)throws Exception, SQLException;
	
	public MemberVO memberLogin(MemberVO memberVO) throws Exception;

	
	HashMap<String, Object> testlogin (MemberVO memberVO) throws Exception, SQLException;
	
	List<HashMap<String, Object>>  testadmin(MemberVO memberVO )throws Exception, SQLException;
	
	
	//회원가입
	int insertRegister (MemberVO memberVO)throws Exception, SQLException;
	//HashMap<String, Object>  insertRegister(MemberVO memberVO)throws Exception, SQLException;

	//MemberVO testlogin(MemberVO memberVO);
}
