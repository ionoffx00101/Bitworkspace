<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
			            사람인에서는 다음과 같은 xml 데이터인 result의 내용은 다음과 같다.
			            <job-search>
			  <jobs count="5" start="0" total="5">
			    <job>   ---1
			      <id>10671680</id>
			      2--><url>http://www.saramin.co.kr/zf_user/recruit/recruit-view/idx/10671680</url>
			      <active>1</active>  
			      <posting-timestamp>1322619010</posting-timestamp>  
			      <modification-timestamp>1322646519</modification-timestamp> 
			      3-><opening-timestamp>1322578800</opening-timestamp>  
			      4--><expiration-timestamp>1322619010</expiration-timestamp> 
			      <close-type code="1">접수마감일</closing_dt> 
			      <company>
			      5-->  <name href="http://www.saramin.co.kr/zf_user/bbs-tong/view/com_idx/5601"> --7.6
			        <![CDATA[(주)사람인HR]]>
			        </name>
			      </company>
			      <position>
			      6-->  <title><![CDATA[사람인HR 콘텐츠기획팀 인턴십 채용]]></title>
			      7-->  <location code="101070"><![CDATA[서울 &gt; 구로구]]></location>
			        <job-type code="11,4">인턴직,인턴직 (정규직 전환가능)</job-type>--7.7
			        <industries code="305">포털·인터넷</industries> --7.8
			        <job-category code="108,403,415"> 
			                         사무보조·OA, 웹기획·PM, IT강의·교육</job-category>
			        <open-quantity>0</open-quantity> 
			        <experience-level>신입</experience-level> 
			        <required-education-level code="8">
			                         대학교졸업(4년)이상
			        </required-education-level>
			      </position>
			      <keyword> 
			      종합포털,컨텐츠제공,취업포털,사무보조,OA,워드·문서작성,Excel·도표,PowerPoint,전산입력·편집,홈페이지관리,웹기획,자료조사,게시판관리,컨텐츠관리,OA·컴퓨터
			      </keyword>
			      <salary code="0">회사내규에 따름</salary>--7.14
				    </job>
				    ...
				    </job>
				  </jobs>
				</job-search>
			            
	           --%>
	            
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>사람인 OpenAPI를 이용한 검색</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#search").click(function(){
		
	  	$.ajax({ 
	  	 url:"<c:url value="/JobService"/>",
	  	 type:"post",
	  	 dataType:"text",
	     data:{
	             query: $("#query").val(),
	             method: "searchJobList"
	     },
	     success:function(result){
	             //응답 데이터의 처리
	             //id 속성의 값이 searchResult 인 객체에 기존에 출력했던 메시지 삭제
	             $("#searchResult").empty();	
	            
	           
	            //result에서 태그들을 찾을수 잇도록 설정
	            result=$.parseXML(result);
	            //result에서 "job"태그를 찾아서 반복문을 실행
	            $(result).find("job").each(function(){
	            	//name 태그(회사이름)를 찾아서 값을 변수name에 저장
	            	var name=$(this).find("name").text();
	            	
	            	//title 태그(하는일) 을 찾아서 변수 title에 저장
	            	var title=$(this).find("title").text();
	            	
	            	//location 태그(회사위치) 을 찾아서 변수 location에 저장
	            	var location=$(this).find("location").text();
	            	
	            	//url 태그(공고 url) 을 찾아서 변수 url에 저장
	            	var url=$(this).find("url").text();
	            	
	            	//expiration-timestamp 태그(마감일) 을 찾아서 변수 exp에 저장
	            	var exp=$(this).find("expiration-timestamp").text();
	            	
	            	//exp는 유닉스 타임스탬프(1970년 1월 1일 0시부터 몆초가 흘럿나)타입이기 때문에 
                    // 그냥 출력하면 숫자값이 출력되기 때문에 다음과 같이 날짜로 변환해야 한다
                    var date = new Date(exp*1000).toLocaleDateString(); 
	            	
	            		            	
	            	//id속성이 searchResult 인 객체에 name 변수에 저장된 값과 title 변수에 저장된 값
	            	//location변수에 저장된 값  date 변수에 저장된 값을 추가
	            	 
	            	//추가형태는 <tr><td>name</td><td><a href="공고url">title</td><td>location</td><td>date</td></tr>"
	            	$("#searchResult").append(
	            		"<tr>"+
	            			"<td width='100'><a href='"+url+"'>"+name+"</a></td>"+
	            			"<td width='100'>"+date+"</td>"+
	            			"<td width='100'>"+location+"</td>"+
	            			"<td width='100'>"+title+"</td>"
	            			+"</tr>"
	            	);
	            
	            });
	            
				}
			}
		);			
	 	
	});
	
});

</script>	

</head>
<body>
<h4 align="center">취업검색</h4>
	
		검색어<input type="text"  id="query" name="query" value="자바"/>
		<input type="button"  id="search"  value="검색"/>
<table align="center" border="1">
	<tr>
		<td  width="100">회사명</td>
		<td width="100">마감일</td>
		<td width="100">지역</td>
		<td width="100">업무</td>
	</tr>
</table>
<table align="center" border="1" id="searchResult"><!-- id="searchResult" -->
	
</table>