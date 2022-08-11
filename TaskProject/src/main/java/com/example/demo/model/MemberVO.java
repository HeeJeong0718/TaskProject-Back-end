package com.example.demo.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Getter
@Setter
public class MemberVO {
	private String mem_no="";
	private String mem_id="";
	private String mem_nm="";
    private String mem_pwd="";
    private String mem_dp_id="";
    //private List<String> mem_dp_id; 
    private String mem_dp_nm="";
	private String insert_date="";
	private String update_date="";
	private String loginlevel="";
	private String start_date="";
	private String end_date="";
	private String b_id="";
	private String use_flag="";
}
