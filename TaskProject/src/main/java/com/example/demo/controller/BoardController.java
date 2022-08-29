package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.StringUtil;
import com.example.demo.model.BoardVO;
import com.example.demo.model.MemberVO;
import com.example.demo.service.BoardService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@CrossOrigin(origins="*") 
@RestController
public class BoardController {

	@Resource 
	private BoardService boardService;
	
	
	/*리스트 전체조회
	 * @param mem_no,
	 * @param mem_id
	 */
	@GetMapping(value = "/taskall")
	public ResponseEntity<String> mainListAll(ModelMap model,  MemberVO  memberVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		List<HashMap<String,Object>> resultList = boardService.selectListAll(memberVO);


		jsonStr = StringUtil.jsonStrSearch(resultList);
		resHeader.add("Content-Type", "application/json");		
		return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	}
	
    /* 관리자 알림 리스트삭제
     * @param b_no
     * @param use_flag ='N'
     * */	
	//@RequestMapping(value = "/NoticeDelete")
	@PutMapping(value = "/NoticeDelete")
	//@ResponseBody //@requestbody 꼭넣어주자
	public ResponseEntity<String> NoticeDelete(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody BoardVO  boardVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
			int updateYn = 0;
			updateYn += boardService.NoticeDelete(boardVO);	
		
			System.out.println("updateYn" + updateYn);
			if(updateYn > 0) {
				jsonStr = StringUtil.jsonSimpleReturn("000");
				System.out.println("str" + jsonStr); 
			}else { 
				jsonStr = StringUtil.jsonSimpleReturn("997");
			}
		}catch(Exception e){
			jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	}
	
		
		
		@PostMapping(value = "/boardInsert")
		@ResponseBody //@requestbody 꼭넣어주자
		public ResponseEntity<String> maininsert(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				int insertYn = 0;
				insertYn += boardService.boardInsert(boardVO);	
			
				System.out.println("insertYn" + insertYn);
				if(insertYn > 0) {
					jsonStr = StringUtil.jsonSimpleReturn("000");
					System.out.println("str" + jsonStr); 
				}else { 
					jsonStr = StringUtil.jsonSimpleReturn("997");
				}
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}
		
	   

		
		@PutMapping(value = "/boardUpdate")
		//@ResponseBody //@requestbody 꼭넣어주자
		public ResponseEntity<String> mainupdate(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				HashMap<String , Object> boardUpdate =  boardService.boardUpdate(boardVO);	
				
				jsonStr = StringUtil.jsonStrOneSearch(boardUpdate);
				System.out.println("jsonStr" + jsonStr);
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
			
			/*try {
				int updateYn = 0;
				updateYn += boardService.boardUpdate(boardVO);	
			
				System.out.println("updateYn" + updateYn);
				if(updateYn > 0) {
					jsonStr = StringUtil.jsonSimpleReturn("000");
					System.out.println("str" + jsonStr); 
				}else { 
					jsonStr = StringUtil.jsonSimpleReturn("997");
				}
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}*/
			
			
		}
		
		 
		@DeleteMapping(value = "/boardDelete/{b_no}")
		@ResponseBody //@requestbody 꼭넣어주자
		@JsonProperty("boardVO")
		@CrossOrigin(origins="*")
		public ResponseEntity<String> maindelete(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model,  BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				int deleteYn = 0;
				deleteYn += boardService.boardDelete(boardVO);	
			
				System.out.println("deleteYn" + deleteYn);
				if(deleteYn > 0) {
					jsonStr = StringUtil.jsonSimpleReturn("000");
					System.out.println("str" + jsonStr); 
				}else { 
					jsonStr = StringUtil.jsonSimpleReturn("997");
				}
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}
		

		 @CrossOrigin(origins="*")
		 @GetMapping(value = "/boardDetail")
		public ResponseEntity<String> menuDetail(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model ,  BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			try {
				HashMap<String , Object> boardDetail = boardService.boardDetail(boardVO);
				
				jsonStr = StringUtil.jsonStrOneSearch(boardDetail);
				System.out.println("jsonStr" + jsonStr);
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}
		 

		 @CrossOrigin(origins="*")
		@RequestMapping(value = "/boardCount")
		@ResponseBody
		public ResponseEntity<String> boardCount(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			try {
				HashMap<String , Object> boardCount = boardService.boardCount(boardVO);
				
				jsonStr = StringUtil.jsonStrOneSearch(boardCount);
				System.out.println("jsonStr" + jsonStr);
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}
		 
		 
		 
		 
		@RequestMapping(value = "/boardSearch")
		public ResponseEntity<String> mainsearch(ModelMap model,@RequestBody  BoardVO  boardVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
			
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			List<HashMap<String,Object>> resultList = boardService.selectSearch(boardVO);


			jsonStr = StringUtil.jsonStrSearch(resultList);
			resHeader.add("Content-Type", "application/json");		
			return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
		}

		 
}
