<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--1.	아이디와 비밀번호를 입력 받는 폼 구현 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<%--2.	전송 버튼 클릭시 login.do  로 post 방식으로 데이터 전송 --%>
  <form action="login.do" method="post">
    <p>
      이름
      <input type="text" name="id" />
    </p>
    <p>
      비밀번호
      <input type="text" name="pw" />
    </p>
    <input type="submit" value="로그인" />
  </form>
	<%--
	3.	request 에 ERROR 속성이 null 이 아니면  ERROR 속성을 JSTL을 이용해서 출력
		A.	<c:if test="${조건}">
		조건이 참일 때 할일 구현
		</c:if>
	 --%>
  <c:if test="${!empty ERROR}">
    ERROR: ${ERROR}
  </c:if>
</body>
</html>