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
public interface AdminMapper {

	
	List<HashMap<String, Object>>  selectDepartMent(DepartMentVO  departmentVO)throws Exception, SQLException;
	
	List<HashMap<String, Object>>  selectUserAll(MemberVO memberVO)throws Exception, SQLException;
	
	List<HashMap<String, Object>>  adminDetail(MemberVO memberVO )throws Exception, SQLException;

	List<HashMap<String, Object>>  adminNotice(MemberVO memberVO)throws Exception, SQLException;
	
	HashMap<String, Object> adminDetail2 (BoardVO  boardVO)throws Exception, SQLException;
	
	
}
