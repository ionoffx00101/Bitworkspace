<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="org.apache.tomcat.dbcp.dbcp2.*"%>
<%@page import="org.apache.commons.pool2.impl.*"%>
<%@ page import="java.sql.*"%>

<%-- <%@page import="org.apache.tomcat.dbcp.dbcp2.*"%> --%>
<%-- <%@page import="org.apache.commons.pool.impl.GenericObjectPool"%>
<%@page import="org.apache.commons.pool2.impl.GenericObjectPool"%> --%>
<%-- <%@ page import="org.apache.commons.dbcp2.PoolableConnectionFactory" %> --%>

<%-- <%@ page import="org.apache.commons.dbcp.*" %>
<%@ page import="org.apache.commons.pool.impl.*" %> --%>
<%
	GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();


	ConnectionFactory connectionFactory = new DriverManagerConnectionFactory("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");
	
	PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory,null);
	//GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, poolConfig);
	
    //poolableConnectionFactory.setPool(connectionPool);
    
    
	/* GenericObjectPool objectPool = new GenericObjectPool();
	DriverManagerConnectionFactory connectionFactory = new DriverManagerConnectionFactory("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott","tiger");
	new PoolableConnectionFactory(connectionFactory, objectPool, null, null, false, true);
	PoolingDriver driver = new PoolingDriver();
	driver.registerPool("/webdb_pool", objectPool); */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>untitled</title>
</head>
<body>
	커넥션 풀 테스트
	<br>
	<%
		Class.forName("org.apache.commons.dbcp.PoolingDricer");
		Connection conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:/webdb_pool");
		if (conn != null) {
			out.println("연결 취득 완료<br>");
			conn.close();
			out.println("연결 반환 완료<br>");
		} else {
			out.println("연결 취득 실패<br>");
		}
	%>
</body>
</html>