<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>학생추가</title>
</head>
<body>
	<form action="StudentService" method="post">

		<p>
			학번
			<input name="studno" type="text">
		</p>

		<p>
			이름
			<input id="name" name="name" type="text">
		</p>
		<p>
			단과대학
			<select id="colno" name="colno">
				<c:forEach items="${COLLEGE_LIST}" var="col">
					<option>${col.colname}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			학과
			<select id="deptno" name="deptno">
				<c:forEach items="${DEPT_LIST}" var="dept">
					<option value="${dept.deptno}">${dept.dname}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			아이디
			<input id="userid" name="userid" id="userid" type="text" />

		</p>
		<p>
			비밀번호
			<input id="pw" name="pw" type="password" />
		</p>


		<p>
			<input class="submit" type="submit" value="학생추가">
		</p>
		<input type="hidden" name="method" value="addStudent" />
	</form>
</body>
</html>
