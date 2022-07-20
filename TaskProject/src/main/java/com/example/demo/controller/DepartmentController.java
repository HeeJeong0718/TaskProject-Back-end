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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Util.StringUtil;
import com.example.demo.model.BoardVO;
import com.example.demo.model.DepartMentVO;
import com.example.demo.model.MemberVO;
import com.example.demo.service.DepartmentService;

@CrossOrigin(origins="*") 
@RestController
public class DepartmentController {

	@Resource 
	private DepartmentService depService;
	
	//조회
	@RequestMapping(value = "/departmentlist")
	public ResponseEntity<String> depListAll(ModelMap model,@RequestBody  DepartMentVO  depVO , HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		
		String jsonStr = "";
		HttpHeaders resHeader = new HttpHeaders();
		List<HashMap<String,Object>> resultList = depService.selectListAll(depVO);
		


		jsonStr = StringUtil.jsonStrSearch(resultList);
		resHeader.add("Content-Type", "application/json");		
		return new ResponseEntity<String>(jsonStr,resHeader, HttpStatus.CREATED);
	}
	
	
		//추가
		
		@RequestMapping(value = "/depInsert")
		@ResponseBody //@requestbody 꼭넣어주자
		public ResponseEntity<String> maininsert(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody DepartMentVO  depVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				int insertYn = 0;
				insertYn += depService.depInsert(depVO);	
			
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
		
	   
        //수정
		
		@RequestMapping(value = "/depUpdate")
		@ResponseBody //@requestbody 꼭넣어주자
		public ResponseEntity<String> mainupdate(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody DepartMentVO  depVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				int updateYn = 0;
				updateYn += depService.depUpdate(depVO);	
			
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
		
        //삭제
		@RequestMapping(value = "/depDelete")
		@ResponseBody //@requestbody 꼭넣어주자
		public ResponseEntity<String> maindelete(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model, @RequestBody DepartMentVO  depVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			
			try {
				int deleteYn = 0;
				deleteYn += depService.depDelete(depVO);	
			
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
		
          //상세
		 @CrossOrigin(origins="*")
		@RequestMapping(value = "/depDetail")
		@ResponseBody
		public ResponseEntity<String> menuDetail(String httpParam, HttpServletRequest request, HttpServletResponse response, ModelMap model , @RequestBody DepartMentVO  depVO) throws Exception{
			String jsonStr = "";
			HttpHeaders resHeader = new HttpHeaders();
			try {
				HashMap<String , Object> boardDetail = depService.depDetail(depVO);
				
				jsonStr = StringUtil.jsonStrOneSearch(boardDetail);
				System.out.println("jsonStr" + jsonStr);
			}catch(Exception e){
				jsonStr = StringUtil.jsonSimpleReturn("999");
			}
			resHeader.add("Content-Type", "application/json;charset=UTF-8");
			return new ResponseEntity<String>(jsonStr, resHeader, HttpStatus.CREATED);
		}
		 
		 
				 
}
