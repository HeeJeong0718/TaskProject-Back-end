package com.example.demo.serviceImpl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.model.BoardVO;
import com.example.demo.service.BoardService;



@Repository
public class BoardServiceImpl implements BoardService {
	
	@Resource
	private BoardMapper boardMapper;
    

	
	@Override
	public List<HashMap<String, Object>> selectListAll(MemberVO memberVO) throws Exception {
		return boardMapper.selectListAll(memberVO);
	}
	

	@Override
	public List<HashMap<String, Object>> selectUserAll(MemberVO memberVO) throws Exception {
		return boardMapper.selectUserAll(memberVO);
	}
	
	
	
	@Override
	public List<HashMap<String, Object>> adminNotice(MemberVO memberVO) throws Exception {
		return boardMapper.adminNotice(memberVO);
	}
	

	@Override
	public int NoticeDelete(BoardVO boardVO)   throws Exception {
		return boardMapper.NoticeDelete(boardVO);
	}
	

	@Override
	public int boardInsert(BoardVO boardVO)   throws Exception {
		return boardMapper.boardInsert(boardVO);
	}
  
	

	@Override
	public int boardDelete(BoardVO boardVO)   throws Exception {
		return boardMapper.boardDelete(boardVO);
	}
	
	/*@Override
	public int boardUpdate(BoardVO boardVO)   throws Exception {
		return boardMapper.boardUpdate(boardVO);
	}*/
	

	@Override
	public HashMap<String, Object> boardUpdate ( BoardVO  boardVO)   throws Exception {
		return boardMapper.boardUpdate(boardVO);
	}

	

	@Override
	public HashMap<String, Object> boardDetail ( BoardVO  boardVO)   throws Exception {
		return boardMapper.boardDetail(boardVO);
	}

	
	@Override
	public HashMap<String, Object> boardCount ( BoardVO  boardVO)   throws Exception {
		return boardMapper.boardCount(boardVO);
	}


	@Override
	public List<HashMap<String, Object>> selectSearch( BoardVO boardVO) throws Exception {
		return boardMapper.selectSearch(boardVO);
	}
	
	
	
	/*
	 * @Override public List<HashMap<String, Object>> adminDetail(MemberVO memberVO)
	 * throws Exception { return boardMapper.adminDetail(memberVO); }
	 */
}
	  
	  
	
	
	

