package com.example.demo.mapper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;



@Mapper
public interface DepartMentMapper {

	//로그인한 아이디의 리스트
	List<HashMap<String, Object>>  selectDepartMent(DepartMentVO  departmentVO)throws Exception, SQLException;
	
	
	int depInsert (DepartMentVO  depVO)throws Exception, SQLException;
	
	int depDelete (DepartMentVO  depVO)throws Exception, SQLException;
	
	int depUpdate (DepartMentVO  depVO)throws Exception, SQLException;

	 
	HashMap<String, Object> depDetail (DepartMentVO  depVO)throws Exception, SQLException;
	
	
}
