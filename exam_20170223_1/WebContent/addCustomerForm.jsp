<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				/*   id check  */
				$("#idCheck").change(function() {
					$.ajax({
						url : "<c:url value="idCheck.do"/>",
						type : "post",
						dataType : "text",
						data : {
							userid:$("#idCheck").val()
						},
						success : function(data) {
							$("#idCheckResult").empty();
							$("#idCheckResult").append(data);
						}
					});
				}); 
				/* 단과 쳐서 학과 가져오기 */
				$("#collegeListSelect").change(
						function() {
							$.ajax({
								url : "<c:url value="viewDeptList.do"/>",
								type : "post",
								dataType : "json",
								data : {
									"colno" : $("#collegeListSelect").val()
								},
								success : function(data) {
									console.log(data);
									/* 비우기 */
									$("#deptListSelect").empty();
									/* 반복해서 데이터 꺼내기 */
									for (var i = 0; i < data.length; i++) {
										/* 코드를 더 줄일 수도 있지만 가독성이 떨어질 수도 있으니 그만 줄이자 */
										var code = data[i].deptno;
										var name = data[i].dname;
										$("#deptListSelect").append(
												"<option value='"+code+"'>"
														+ name + "</option>");
									}
								}
							});
						});
			});
</script>
</head>
<body>
	<div align="center">
		<form action="addCustomer.do" method="post">
			이름 :
			<input type="text" name="name">
			<br /> 아이디 :
			<input type="text" name="userid" id="idCheck">
			<span id="idCheckResult"></span> <br /> 비번 :
			<input type="password" name="pw">
			<br /> 단과대학 :
			<select id="collegeListSelect">
				<c:forEach items="${collegeList}" var="college">
					<option value="${college.colno}">${college.cname}</option>
				</c:forEach>
			</select>
			<br /> 학과 :
			<select id="deptListSelect">
				<c:forEach items="${deptList}" var="dept">
					<option value="${dept.deptno}">${dept.dname}</option>
				</c:forEach>
			</select>
			<br /> <br />
			<input type="submit" value="등록" />
			<input type="reset" value="초기화" />
			<br />
		</form>
		<br />
	</div>
</body>
</html>