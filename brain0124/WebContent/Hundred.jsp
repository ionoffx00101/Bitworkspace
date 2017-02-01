<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	int sum = 0;
	for (int cnt = 1; cnt <= 100; cnt++)
	{
		sum += cnt;

	}
	request.setAttribute("result", new Integer(sum));
%>
<jsp:forward page="HundredView.jsp"></jsp:forward>
<%-- <jsp:forward page="HundredView.jsp" /> --%>