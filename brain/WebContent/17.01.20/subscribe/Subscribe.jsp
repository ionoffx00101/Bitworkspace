<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	// ���� ���� �Ķ���ͷ� �޾ƿ�
    String agree = request.getParameter("agree");
    String result = null;
    
    if(agree.equals("agree")){
    	// ���� ���� ���� ���ǿ� �ִ� ������ ������ ����
    	String id = (String) session.getAttribute("id");
    	String pw = (String)session.getAttribute("pw");
    	String name = (String) session.getAttribute("name");
    	String address = (String) session.getAttribute("address");
    	String phone = (String)session.getAttribute("phone");
    	String email = (String) session.getAttribute("email");
    	
    	// txt������ ����� ���� writer��ü�� �����
    	PrintWriter writer =null;
    	try{
    		// ���� ���� ��¥ �ּҸ� �����
    		String filePath = application.getRealPath("/WEB-INF/"+id+".txt");
    		System.out.print(filePath);
    		// writer�� ��¥ �ּ� ��ü�� �־��ְ� �ʱ�ȭ �����ش�
    		writer = new PrintWriter(filePath);
    		writer.println("id : "+id);
    		writer.println("pw : "+pw);
    		writer.println("name : "+name);
    		//�߰� ����
    		writer.println("address : "+address);
    		writer.println("phone : "+phone);
    		writer.println("email : "+email);
    		result="SUCCESS";
    		
    		
    	}catch(IOException e){
    		result="FAIL";
    	}finally{
    		try{
    			// �� �ٽ����� writer�� �����Ų��
    			writer.close();
    		}
    		catch(Exception e){
    			
    		}
    	}
    	
    }else{
    	result="FAIL";
    }
    // ���� ������
    //session.invalidate();
    // ������ �ѱ��
    response.sendRedirect("Result.jsp?RESULT="+result);
%>