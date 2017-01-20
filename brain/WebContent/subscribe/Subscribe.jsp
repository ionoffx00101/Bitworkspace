<%@page import="java.io.IOException"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	// 동의 여부 파라미터로 받아옴
    String agree = request.getParameter("agree");
    String result = null;
    
    if(agree.equals("agree")){
    	// 동의 했을 때만 세션에 있는 데이터 세개를 연다
    	String id = (String) session.getAttribute("id");
    	String pw = (String)session.getAttribute("pw");
    	String name = (String) session.getAttribute("name");
    	String address = (String) session.getAttribute("address");
    	String phone = (String)session.getAttribute("phone");
    	String email = (String) session.getAttribute("email");
    	
    	// txt파일을 만들기 위해 writer객체를 만든다
    	PrintWriter writer =null;
    	try{
    		// 파일 만들 진짜 주소를 만든다
    		String filePath = application.getRealPath("/WEB-INF/"+id+".txt");
    		System.out.print(filePath);
    		// writer에 진짜 주소 객체를 넣어주고 초기화 시켜준다
    		writer = new PrintWriter(filePath);
    		writer.println("id : "+id);
    		writer.println("pw : "+pw);
    		writer.println("name : "+name);
    		//추가 문제
    		writer.println("address : "+address);
    		writer.println("phone : "+phone);
    		writer.println("email : "+email);
    		result="SUCCESS";
    		
    		
    	}catch(IOException e){
    		result="FAIL";
    	}finally{
    		try{
    			// 글 다썼으니 writer를 종료시킨다
    			writer.close();
    		}
    		catch(Exception e){
    			
    		}
    	}
    	
    }else{
    	result="FAIL";
    }
    // 세션 끝내기
    //session.invalidate();
    // 페이지 넘기기
    response.sendRedirect("Result.jsp?RESULT="+result);
%>
