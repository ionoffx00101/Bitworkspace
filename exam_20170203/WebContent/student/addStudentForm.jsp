<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>학생추가</title>
<script type="text/javascript" src="<c:url value='/js/jquery-1.11.0.min.js'/>"></script>

<script>
$(document).ready(function() {
  <%-- 2.1 아이디를 입력하고 다른 부분을 클릭했을때 호출 --%>
  $("#userid").change(function(){
	  
  	
			  	$.ajax({ 
			  	 url:"/exam_20170203/StudentService",
			  	 type:"post",
			  	 dataType:"text",
			     data:{
			             userid:$("#userid").val(),
			             method:"checkUserid"
			            },
			     success:function(result){
			             //응답 데이터의 처리
			             //id 속성의 값이 checkResult 인 객체에 기존에 출력했던 메시지 삭제
			             $("#checkResult").empty();	
			            //서블렛에서 전달된 데이터 result를 id 속성의 값이 checkResult 인 객체에 추가한다
						$("#checkResult").append(result);
			            
						}
					}
				);			
			 	
  });
  
  	<%--3.1 단대를 클릭했을때 호출되는 메서드 
	    id 속성의 값이 colno인 객체를 선택했을 때 서버로 요청 전송되는 부분
	   --%>
	$("#colno").change(function(){
		
					  	$.ajax({ 
					  	 url:"/exam_20170203/StudentService",
					     data:{
					        colno: $("#colno").val(),
					        method:"viewDeptList"
					        },
					     type:"post",
					     success:function(result){
					    	
					             //응답 데이터의 처리
					             //id 속성의 값이 deptno 인 객체에 기존에 출력했던 메시지 삭제
					             $("#deptno").empty();
					             
					             //result에서 태그들을 찾을수 잇도록 설정
					             result=$.parseXML(result);
					             	    
					            // $(result).find("deptList").each(function(){
					             	//$(this).find("dept").each(function(){
					             	$(result).find("dept").each(function(){
						             	//deptno 태그를 찾아서 값을 변수 deptno에 저장
						             	var deptno=$(this).find("deptno").text();

						             	//dname태그를 찾아서 값을 변수 dname에 저장
						             	var dname=$(this).find("dname").text();
						             	 
						             	//id속성이 deptno인 객체에 deptno변수에 저장된 값과 dname변수에 저장된 값을 추가 
						             	//추가형태는 <option value='deptno변수에 저장된값'>dname변수에 저장된값</option>
						             	$("#deptno").append("<option value='"+deptno+"'>"+dname+"</option>");
					             	 });
						          //   });
					            // });
							}
					  	});			  	  
				
				
				   });
					  
 
 });
</script>
</head>
<body>
	<form  action="StudentService" method="post">
		
			 <p>
				학번
				<input name="stuno" type="text">
			</p>
	  
			<p>
				이름
				<input id="name" name="name" type="text">
			</p>
			<p>
			 단과대학
			 <select id="colno"  name="colno">
			 	<c:forEach items="${COLLEGE_LIST}" var="col">
			 	<option value="${col.colno}">
			 	${col.colname}
			 	</option>
			 	</c:forEach>
			 </select>		
			</p>
			<p>
			 학과
			 <select id="deptno"  name="deptno">
			 	<c:forEach items="${DEPT_LIST}" var = "dept">
			 	<option value="${dept.deptno}">
			 	${dept.dname}
			 	</option>
			 	</c:forEach>
			 </select>		
			</p>
			<p>
				아이디
				<input id="userid" name="userid" id="userid" type="text"/><span id="checkResult"></span>

			</p>		
			<p>
				비밀번호
				<input id="pw" name="pw" type="password"/>
			</p>
			
			
			<p>
				<input class="submit" type="submit" value="학생추가">
			</p>
			<input type="hidden" name="method" value="addStudent"/>
	</form>
</body>
</html>
