package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.BoardVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;

@Service
public interface BoardService {
	
	public List<HashMap<String,Object>> selectListAll(MemberVO memberVO) throws Exception;
	public List<HashMap<String,Object>> selectUserAll(MemberVO memberVO) throws Exception;
	
	public List<HashMap<String,Object>> adminNotice(MemberVO memberVO) throws Exception;
	
	int NoticeDelete(BoardVO BoardVO) throws Exception;

	int boardInsert(BoardVO boardVO) throws Exception;
	
	int boardDelete(BoardVO BoardVO) throws Exception;
	
	//int boardUpdate(BoardVO BoardVO) throws Exception;
	
	HashMap<String, Object> boardUpdate( BoardVO  boardVO)throws Exception;
	
	HashMap<String, Object> boardDetail( BoardVO  boardVO)throws Exception;
	
	HashMap<String, Object> boardCount( BoardVO  boardVO)throws Exception;
	
	public List<HashMap<String,Object>> selectSearch(BoardVO  boardVO) throws Exception;
	
	//public List<HashMap<String,Object>> adminDetail(MemberVO memberVO) throws Exception;
	
}
