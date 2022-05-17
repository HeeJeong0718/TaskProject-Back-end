package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.StringUtil;
import com.example.demo.model.BoardVO;
import com.example.demo.model.EmpVO;
import com.example.demo.model.MemberVO;
import com.example.demo.model.TestVO;
import com.example.demo.service.TestService;


@CrossOrigin(origins="*") 
@RestController

public class TestController {
	
	
	/*
	 * @GetMapping(value = "/members") public Map<Integer, Object>
	 * testByResponseBody() {
	 * 
	 * Map<Integer, Object> members = new HashMap<>();
	 * 
	 * for (int i = 1; i <= 20; i++) { Map<String, Object> member = new HashMap<>();
	 * member.put("idx", i); member.put("nickname", i + "길동"); member.put("height",
	 * i + 20); member.put("weight", i + 30); members.put(i, member); }
	 * 
	 * return members; }
	 */
	
	
	@Resource 
	private TestService testService;
	
	@RequestMapping(value = "/test2")
	public ResponseEntity<String> mainList(ModelMap model,@RequestBody  EmpVO  empVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		List<HashMap<String,Object>> resultList = testService.selectList(empVO);


		jsonStr = StringUtil.jsonStrSearch(resultList);
		resHeader.add("Content-Type", "application/json");		
		return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	}
	
	
	 /*@CrossOrigin(origins="*")
		@RequestMapping(value = "/testSearch2")
		@ResponseBody
		public ResponseEntity<String> mainsearch(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody BoardVO  boardVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			try {
				HashMap<String , Object> resultList = testService.selectSearch(boardVO);
				
				jsonStr = StringUtil.jsonStrOneSearch(resultList);
				System.out.println("jsonStr" + jsonStr);
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}*/
		 
	
	
	@RequestMapping(value = "/testSearch")
	public ResponseEntity<String> mainsearch(ModelMap model,@RequestBody  BoardVO  boardVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		List<HashMap<String,Object>> resultList = testService.selectSearch(boardVO);


		jsonStr = StringUtil.jsonStrSearch(resultList);
		resHeader.add("Content-Type", "application/json");		
		return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	}
	
	
	//<!--로그인한 데이터가 내가 쓴글 가져오기-->
	
	@RequestMapping(value = "/testAll")
	public ResponseEntity<String> mainListAll(ModelMap model,@RequestBody  MemberVO  memberVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		List<HashMap<String,Object>> resultList = testService.selectListAll(memberVO);


		jsonStr = StringUtil.jsonStrSearch(resultList);
		resHeader.add("Content-Type", "application/json");		
		return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	}
	
	
	
	
	
	@RequestMapping(value = "/testinsert")
	@ResponseBody //@requestbody 꼭넣어주자
	public ResponseEntity<String> maininsert(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody BoardVO  boardVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
			int insertYn = 0;
			insertYn += testService.insertTest(boardVO);	
		
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
	
	@RequestMapping(value = "/testregister")
	@ResponseBody //@requestbody 꼭넣어주자
	public ResponseEntity<String> registerinsert(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody MemberVO  memberVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
			int insertYn = 0;
			insertYn += testService.insertRegister(memberVO);	
		
			System.out.println("insertYn" + insertYn);
			if(insertYn > 0) {
				jsonStr = StringUtil.jsonSimpleReturn3(memberVO);
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
	
	
	
	
	
	
	
	@RequestMapping(value = "/testupdate")
	@ResponseBody //@requestbody 꼭넣어주자
	public ResponseEntity<String> mainupdate(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody BoardVO  boardVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
			int updateYn = 0;
			updateYn += testService.updateTest(boardVO);	
		
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
	
	
	
	@RequestMapping(value = "/testdelete")
	@ResponseBody //@requestbody 꼭넣어주자
	public ResponseEntity<String> maindelete(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody BoardVO  boardVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
			int deleteYn = 0;
			deleteYn += testService.deleteTest(boardVO);	
		
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
	@RequestMapping(value = "/testDetail")
	@ResponseBody
	public ResponseEntity<String> menuDetail(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody BoardVO  boardVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		try {
			HashMap<String , Object> selectDetail = testService.selectDetail(boardVO);
			
			jsonStr = StringUtil.jsonStrOneSearch(selectDetail);
			System.out.println("jsonStr" + jsonStr);
		}catch(Exception e){
			jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	}
	 
	 @CrossOrigin(origins="*")
	@RequestMapping(value = "/testlogin")
	@ResponseBody
	public ResponseEntity<String> testlogin(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody MemberVO  memberVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		HttpSession session = request.getSession();
		
		try {
		     //MemberVO memberVO = (MemberVO)session.getAttribute("memberVO");
			HashMap<String , Object> testlogin = testService.testlogin(memberVO);
		   
			jsonStr = StringUtil.jsonStrOneSearch(testlogin);
			System.out.println("jsonStr" + jsonStr);
		}catch(Exception e){
			jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	}
	
	 
	 @CrossOrigin(origins="*")
	@RequestMapping(value = "/testadmin")
	@ResponseBody
	public ResponseEntity<String> testadmin(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody MemberVO  memberVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		HttpSession session = request.getSession();
		
		List<HashMap<String,Object>> testadmin = testService.testadmin(memberVO);

		jsonStr = StringUtil.jsonStrSearch(testadmin);
		resHeader.add("Content-Type", "application/json");		
		return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	
	}
	 
	 
	//
	
	
	/* @CrossOrigin(origins="*")
	@RequestMapping(value = "/testDetail")
	@ResponseBody  //상세페이지 하나만 가져와야하니까 HashMap<String ,Object> 형식으로 가져온다
	public ResponseEntity<String> mainiDetail(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody  TestVO testVO) throws Exception{
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		
		try {
		  
			HashMap<String , Object> selectDetail = testService.DetailTest(testVO); // 카테고리 전체 조회
		   
			System.out.println("select"+ selectDetail);
			jsonStr = StringUtil.jsonStrOneSearch(selectDetail);
			System.out.println("jsonStr"+ jsonStr);
		 }catch(Exception e){
		
			 jsonStr = StringUtil.jsonSimpleReturn("999");
		}
		
		resHeader.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
	}*/

	
	

}
