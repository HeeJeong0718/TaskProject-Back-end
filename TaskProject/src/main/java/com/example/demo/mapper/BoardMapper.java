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
public interface BoardMapper {

	//로그인한 아이디의 리스트
	List<HashMap<String, Object>>  selectListAll(MemberVO memberVO)throws Exception, SQLException;
	
	
	int boardInsert (BoardVO boardVO)throws Exception, SQLException;
	
	int boardDelete (BoardVO boardVO)throws Exception, SQLException;
	
	int boardUpdate (BoardVO boardVO)throws Exception, SQLException;

	 
	HashMap<String, Object> boardDetail (BoardVO boardVO)throws Exception, SQLException;
	
	List<HashMap<String, Object>>  selectSearch(BoardVO boardVO)throws Exception, SQLException;
	
	List<HashMap<String, Object>>  adminDetail(MemberVO memberVO )throws Exception, SQLException;
	
}
