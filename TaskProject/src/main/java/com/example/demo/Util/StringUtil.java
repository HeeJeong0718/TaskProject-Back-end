package com.example.demo.Util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.MemberVO;
import com.google.gson.Gson;



public class StringUtil {
	private static final Logger logger = LoggerFactory.getLogger(StringUtil.class);
	
	/**
     * @param str - 체크 대상 스트링오브젝트이며 null을 허용함
     * @return true - 입력받은 String 이 빈 문자열 또는 null인 경우
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }
    
    public static int checkNullInt(String str) {
    	
    	if(str == null || str.length() == 0){
    		return 0;
    	}else{
    		return Integer.parseInt(str);
    	}
    }

    /**
 	 * 모든 태그 제거
 	 *
 	 * @param content
 	 * @return
 	 * @throws SQLException
 	 */
 	public static String removeTag(String content) {
 		Pattern SCRIPTS = Pattern.compile(
 				"<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL
 						| Pattern.CASE_INSENSITIVE);

 		Pattern STYLE = Pattern.compile("<style[^>]*>.*</style>",
 				Pattern.DOTALL| Pattern.CASE_INSENSITIVE);
 		
 		
 		content = content.replaceAll("&lt;","<");
 		content = content.replaceAll("&gt;",">");
 		
 		Pattern TAGS = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");
 		//Pattern nTAGS = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
 		Pattern ENTITY_REFS = Pattern.compile("&[^;]+;");
 		Pattern WHITESPACE = Pattern.compile("\\s\\s+");
 		Pattern ETC = Pattern.compile("nbsp;");

 		Matcher m;

 		m = SCRIPTS.matcher(content);
 		content = m.replaceAll("");

 		m = STYLE.matcher(content);
 		content = m.replaceAll("");
 		
 		
 		m = TAGS.matcher(content);
 		content = m.replaceAll("");
 		m = ENTITY_REFS.matcher(content);
 		content = m.replaceAll("");
 		m = WHITESPACE.matcher(content);
 		content = m.replaceAll(" ");
 		
 		m = ETC.matcher(content);
 		content = m.replaceAll(" ");
 		
 		return content;
 	}
 	
	/**
	 * 랜덤으로 패스위드 생성 P:특수기호, A:대문자, S:소문자, I:숫자 , C: 소문자/숫자 혼합
	 * 
	 * @param type
	 * @param cnt
	 * @return
	 */
	public static String randomValue(String type, int cnt) {
		
		StringBuffer strPwd = new StringBuffer();
		char str[] = new char[1];
		// 특수기호 포함
		if (type.equals("P")) {
			for (int i = 0; i < cnt; i++) {
				str[0] = (char) ((Math.random() * 94) + 33);
				strPwd.append(str);
			}
			// 대문자로만
		} else if (type.equals("A")) {
			for (int i = 0; i < cnt; i++) {
				str[0] = (char) ((Math.random() * 26) + 65);
				strPwd.append(str);
			}
			// 소문자로만
		} else if (type.equals("S")) {
			for (int i = 0; i < cnt; i++) {
				str[0] = (char) ((Math.random() * 26) + 97);
				strPwd.append(str);
			}
			// 숫자형으로
		} else if (type.equals("I")) {
			int strs[] = new int[1];
			for (int i = 0; i < cnt; i++) {
				strs[0] = (int) (Math.random() * 9);
				strPwd.append(strs[0]);
			}
			// 소문자, 숫자형
		} else if (type.equals("C")) {
			Random rnd = new Random();
			for (int i = 0; i < cnt; i++) {
				if (rnd.nextBoolean()) {
					strPwd.append((char) ((int) (rnd.nextInt(26)) + 97));
				} else {
					strPwd.append((rnd.nextInt(10)));
				}
			}
		}
		return strPwd.toString();
	}   
	
	/**
	 * 문자열 날짜 비교
	 * 
	 * @param Object
	 * @return String
	 */
	public static boolean diffOfDate(String begin, String end) throws Exception {
		try {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date thisdate = formatter.parse(formatter.format(new Date()));

			Date beginDate = formatter.parse(begin);
			Date endDate = formatter.parse(end);

			if ((thisdate.equals(beginDate) || thisdate.after(beginDate)) && (thisdate.equals(endDate) || thisdate.before(endDate))) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Get string(if object is null, return empty string).
	 * 
	 * @param Object
	 * @return String
	 */
	public static String getString(Object object) {
		if (object == null)
			return "";
		else
			return (String) object;
	}
	public static int getInt(Object object) {
		if (getString(object).equals(""))
			return 1;
		else
			return (Integer) object;
	}
	
	/**
	 * Gt Lt tag변경
	 * 
	 * @param i
	 * @return
	 */
	public static String replaceEditorTag(String content) {
		String str = content;
		if(str != null && !str.equals("")){
			str = str.replaceAll("&amp;", "&");
			str = str.replaceAll("&lt;", "<");
			str = str.replaceAll("&gt;", ">");
		}else{
			str = "";
		}
		return str;
	}

	
	public static String getDateToString(String format) {
		Date date = new Date();
		SimpleDateFormat simpleDate = new SimpleDateFormat(format);
		return simpleDate.format(date);
	}	
	
	public static String getTimeStamp() {
    	String rtnStr = null;

		// 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
		String pattern = "yyyyMMddhhmmssSSS";
	    SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
	    Timestamp ts = new Timestamp(System.currentTimeMillis());

	    rtnStr = sdfCurrent.format(ts.getTime());
	    return rtnStr;
    }
	
	public static String getWeekName(String wk){
		int tmp = Integer.parseInt(wk); 
		if(getString(wk).equals("")){	
			tmp = 0;
		}
		String[] str = {"*", "일", "월", "화", "수", "목", "금", "토"};		
		return str[tmp];
	}
	
	public static String replace(String source, String fromStr, String toStr) {
		if (source == null)
			return null;
		int start = 0;
		int end = 0;
		StringBuffer result = new StringBuffer();
		while ((end = source.indexOf(fromStr, start)) >= 0) {
			result.append(source.substring(start, end));
			result.append(toStr);
			start = end + fromStr.length();
		}
		result.append(source.substring(start));
		return result.toString();
	}
	
	/**
	 * 휴대폰번호 리스트
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String> pcsList() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("010");
		list.add("011");
		list.add("016");
		list.add("017");
		list.add("018");
		list.add("019");
		
		return list;
	}
	
	/**
	 * 전화번호 지역번호/휴대폰번호 리스트
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ArrayList<String> phoneHpList() throws Exception {
		ArrayList<String> list = new ArrayList<String>();

		list.add("010");
		list.add("011");
		list.add("016");
		list.add("017");
		list.add("018");
		list.add("019");
		list.add("02");
		list.add("031");
		list.add("032");
		list.add("033");
		list.add("041");
		list.add("042");
		list.add("043");
		list.add("051");
		list.add("052");
		list.add("053");
		list.add("054");
		list.add("055");
		list.add("061");
		list.add("062");
		list.add("063");
		list.add("064");
		list.add("0502");
		list.add("0505");
		list.add("070");
		
		return list;
	}
	
	//IPIN용
	public static String requestReplace (String paramValue, String gubun) {
        String result = "";
        
        if (paramValue != null) {
        	
        	paramValue = paramValue.replaceAll("<", "&lt;").replaceAll(">", "&gt;");

        	paramValue = paramValue.replaceAll("\\*", "");
        	paramValue = paramValue.replaceAll("\\?", "");
        	paramValue = paramValue.replaceAll("\\[", "");
        	paramValue = paramValue.replaceAll("\\{", "");
        	paramValue = paramValue.replaceAll("\\(", "");
        	paramValue = paramValue.replaceAll("\\)", "");
        	paramValue = paramValue.replaceAll("\\^", "");
        	paramValue = paramValue.replaceAll("\\$", "");
        	paramValue = paramValue.replaceAll("'", "");
        	paramValue = paramValue.replaceAll("@", "");
        	paramValue = paramValue.replaceAll("%", "");
        	paramValue = paramValue.replaceAll(";", "");
        	paramValue = paramValue.replaceAll(":", "");
        	paramValue = paramValue.replaceAll("-", "");
        	paramValue = paramValue.replaceAll("#", "");
        	paramValue = paramValue.replaceAll("--", "");
        	paramValue = paramValue.replaceAll("-", "");
        	paramValue = paramValue.replaceAll(",", "");
        	
        	if(gubun != "encodeData"){
        		paramValue = paramValue.replaceAll("\\+", "");
        		paramValue = paramValue.replaceAll("/", "");
            paramValue = paramValue.replaceAll("=", "");
        	}
        	
        	result = paramValue;
            
        }
        return result;
	}
    /**
	 * 문자수 단위로 문자열을 자른다.
	 *
	 * @param s 자를 문자열
	 * @param i 자를 수
	 * @param plusStr 플러스될 문자열
	 */
	public static String cutStringPlus(String s, int i, String plusStr){
	      String str = "";
		  if(s.length() <= i) return s;
		  str = s.substring(0, i);
	      return str + plusStr;
	}
	
	/**
	 * 바이트 단위로 문자열을 자른다.
	 *
	 * @param s 자를 문자열
	 * @param i 자를 수
	 * @param plusStr 플러스될 문자열
	 */
	public static String cutStringBytesPlus(String s, int i, String plusStr) {
		if(getString(s).equals(""))
			return "";

		byte abyte0[] = s.getBytes();
		int j = abyte0.length;
		int k = 0;
		if (i >= j)
			return s;
		for (int l = i - 1; l >= 0; l--)
			if ((abyte0[l] & 0x80) != 0)
				k++;
		String str = new String(abyte0, 0, i - k % 3);
		return str + plusStr;
	}
	
	/**
	 * 바이트 사이즈 체크 대상 문자열 입력시 바이트 사이즈  리턴처리함
	 * @param s
	 * @return
	 */
	public static String sizeByte (String s ) {
		int listByte = 100;//포스 전문 전체 사이즈에 부족 할 경우 대비 증가 시킴
		String sListByte = "";
		try {
			listByte = listByte + s.getBytes("utf-8").length;
			
			sListByte = String.format("%010d", listByte);
		} catch (UnsupportedEncodingException e) {
			
			logger.error("error:"+e);
		}
		return sListByte;
	}
	/**
	 * JSON 메시지 공통화
	 * @param typeCode
	 * @return
	 */
	public static String jsonMsg (String typeCode) {
		String sMg = "";
		if(typeCode.equals("999")) {
			sMg = " {\n\"successYn\": \"N\", \"statusCode\": \"999\", \"statusMessage\": \"관리자에게 문의 해주세요\", \"list\": \"null\" }";
		}else if(typeCode.equals("000")) {
			sMg = " {\n\"successYn\": \"Y\", \"statusCode\": \"000\", \"statusMessage\": \"성공\", \"list\": ";
		}else if(typeCode.equals("121") ) {
			sMg = " {\n\"successYn\": \"Y\", \"statusCode\": \""+typeCode+"\", \"statusMessage\": \"출근 가능\", \"list\": \"null\" }";
		}else if(typeCode.equals("122") ) {
			sMg = " {\n\"successYn\": \"Y\", \"statusCode\": \""+typeCode+"\", \"statusMessage\": \"퇴근 가능\", \"list\": \"null\" }";
		}else if(typeCode.equals("991")) {
			sMg = " {\n\"successYn\": \"N\", \"statusCode\": \""+typeCode+"\", \"statusMessage\": \"결제 취소를 할 수 없습니다\", \"list\": \"null\" }";
		}else if(typeCode.equals("997") || typeCode.equals("998") || typeCode.equals("999")) {
			sMg = " {\n\"successYn\": \"N\", \"statusCode\": \""+typeCode+"\", \"statusMessage\": \"파라미터 누락 또는 잘 못된 파라미터 입력, 관리자에게 문의 하세요\", \"list\": \"null\" }";
		}else{
			sMg = " {\n\"successYn\": \"N\", \"statusCode\": \""+typeCode+"\", \"statusMessage\": \"결과 코드값을 확인 해주세요\", \"list\": \"null\" }";
		}
		return sMg;
	}
	
	
	/**
	 * 쿼리 조회 이후 VO에 담긴 데이터를  JSON으로 전환
	 * @param s
	 * @return
	 */
	public static String jsonStrSearch(List<?> s) {
		String jsonStr = "";
		try {
			if(s.size() > 0 && s != null) {
				jsonStr =  jsonMsg("000");
				jsonStr = jsonStr+ new Gson().toJson(s)+"}";
			}else {
				jsonStr = jsonMsg("101");
			}
		} catch (Exception e) {
			jsonStr =  jsonMsg("999");
//			logger.error("JsonStrSearch Error :"+e.getMessage());
		}
		return jsonStr;
	}
	
	/**
	 * ArrayList의HashMap 받아서 JSON 형식의 ArrayList 타입으로 리턴 
	 * @param s
	 * @return
	 */
	public static String jsonStrSearchHash(ArrayList<HashMap<String, String>> s, String type ) {
//		String sTemp = "";
		String jsonStr = "";
//		sTemp = new Gson().toJson(s);
//		int listByte = 100 ; //POS 메모리 사용 목적으로 바이트 초기 값 설정
		try {
			if(type.equals("Y")) {
				if(s.size() > 0 && s != null) {
//					listByte = listByte + sTemp.getBytes("utf-8").length;
					jsonStr =  jsonMsg("000");
					jsonStr =jsonStr+ new Gson().toJson(s)+"}";	
				}else {
					jsonStr = jsonMsg("101");
				}	
			}else {
				if(s.size() > 0 && s != null) {
					jsonStr = new Gson().toJson(s);	
				}else {
					jsonStr = jsonMsg("101");
				}	
			}
		} catch (Exception e) {
			jsonStr =  jsonMsg("999");
			logger.error("JsonStrSearch Error :"+e.getMessage());
		}
		return jsonStr;
	}
	
	/**
	 * ArrayList의HashMap 받아서 JSON 형식으로 리턴 
	 * @param vo
	 * @return
	 */
	public static String jsonStrOneSearch(HashMap<?, ?> vo) {
		String jsonStr = "";
		try {
			if(vo.size() > 0) {
				jsonStr =  jsonMsg("000");
				jsonStr =jsonStr+new Gson().toJson(vo)+"}";
				System.out.println("jsonStr" +jsonStr);
			}else {
				jsonStr = jsonMsg("101");
			}
		} catch (Exception e) {
			jsonStr =  jsonMsg("999");
			logger.error("JsonOneSearch Error :"+e.getMessage());
		}
		return jsonStr;
	}
	
	
	
	
	/**
	 * 리스트에 결과 없는 경우 상태 코드 값으로 만 표현되는 경우 사용
	 * @param code
	 * @return
	 */
	public static String jsonSimpleReturn(String code) {
		String jsonStr = "";
		if(code.equals("000")) {
			//jsonStr =  jsonMsg("000");
			jsonStr =jsonStr+new Gson().toJson(code)+"}";
			jsonStr =  "{\n\"successYn\": \"Y\", \"statusCode\": \""+code+"\", \"statusMessage\": \"성공\", \"list\": \"null\" }" ;	
		}else {
			jsonStr =  jsonMsg(code);
		}
		return jsonStr;
	}
    /*희정*/
	public static String jsonSimpleReturn2(String vo) { 
		String jsonStr = "";
		
			//jsonStr =  jsonMsg("000");
			jsonStr =jsonStr+new Gson().toJson(jsonStr)+"}";
			jsonStr =  "{\n\"successYn\": \"Y\", \"statusCode\": \""+vo+"\", \"statusMessage\": \"성공\", \"new Gson().toJson(vo)\": \"null\" } " ;	
		
		return jsonStr;
	}
	
	public static String jsonSimpleReturn3(MemberVO memberVO) {
		String jsonStr = "";
		//jsonStr =  jsonMsg("000");
		jsonStr =jsonStr+new Gson().toJson(memberVO)+"}";
		jsonStr =  "{\n\"successYn\": \"Y\", \"result\":" +	new Gson().toJson(memberVO)+" }" ;	
	
	return jsonStr;

	}
	

	
	/**
	 * HashMap와 ArrayList 두가지를 하나의 JSON으로 만들어 리턴한다.
	 * @param map
	 * @param arr
	 * @return
	 */
	public static String jsonStrSearchMultiHash(HashMap<String, String> map,ArrayList<HashMap<String, String>> arr) {
		String sTemp = "";
		String sTemp2 = "";
		String jsonStr = "";
		sTemp = new Gson().toJson(arr);
		sTemp2 =new Gson().toJson(map);
//		Integer iTemp = sizeByte(sTemp).hashCode() ;
//		Integer iTemp2 = sizeByte(sTemp2).hashCode() ;
		int listByte = 100 ; //POS 메모리 사용 목적으로 바이트 초기 값 설정
		try {
			if(map.size() > 0 && map != null) {
				listByte = listByte + sTemp.getBytes("utf-8").length+sTemp2.getBytes("utf-8").length;
				jsonStr =  jsonMsg("000");
				jsonStr +="\n"+ new Gson().toJson(map)+" , \"arrayList\": "+new Gson().toJson(arr)+"}";
			}else {
				jsonStr =  jsonMsg("101");
			}
		} catch (UnsupportedEncodingException e) {
			jsonStr =  jsonMsg("999");
			logger.error("JsonStrSearch Error :"+e.getMessage());
		}
		return jsonStr;
	}
	
	
	/**
	 * jdk 1.5 지원하는 uuid
	 * @return
	 */
	public static String getUuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/**
	 * 소수점 경우 true 리턴 해준다
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str){
		boolean result = false; 
		try{
			Double.parseDouble(str) ;
			result = true ;
		}catch(Exception e){}
		return result ;
	}
	
	/**
	 * Server에서 Post로 특정URL로 parameter포함 하여 전송시 공통 모듈<br>
	 * apiUrl: 대상 URL 주소, param 전달하는 파라미터 값
	 * @param apiUrl
	 * @param param
	 * @return
	 */
	public static String getUrlResult(String apiUrl, String param){
		String requestStr = null;
		try{
			final String userAgent = "Mozilla/5.0";
			URL url = new URL(apiUrl+param); 
			HttpURLConnection con = (HttpURLConnection)url.openConnection();

			// HTTP POST 메소드 설정 
			con.setDoOutput(true); 
			con.setRequestMethod("POST"); // HTTP POST 메소드 설정
			con.setRequestProperty("User-Agent", userAgent);
			int responseCode = con.getResponseCode();
			if(responseCode == 200 || responseCode == 201){
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				requestStr = response.toString();	
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return requestStr; 
	}


	
	/**
	 * gjon 
	 * @param httpParam
	 * @return
	 */

}