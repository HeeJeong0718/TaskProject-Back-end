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
public interface LoginMapper {

	
	HashMap<String, Object> tasklogin (MemberVO memberVO) throws Exception, SQLException;
   
	List<HashMap<String, Object>>  taskadmin(MemberVO memberVO )throws Exception, SQLException;
	
	//회원가입
	int insertRegister (MemberVO memberVO)throws Exception, SQLException;
}
