package com.bitacademy.good;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

/**
 * Servlet implementation class GoodService
 */

public class GoodService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String method=request.getParameter("method");
		try{
			if("viewGoodList".equals(method)){
				viewGoodList(request,response);
			}else if("viewGood".equals(method)){
				viewGood(request,response);
			
			}else{
				viewGoodList(request,response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//전체 물건 조회
	private void viewGoodList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. GoodDAO.selectGoodList()메서드를 호출하고 
				//리턴된 전체 물건정보를  ArrayList 변수에 저장
			//List<Good>goodList = GoodDAO.selectGoodList();
		
			//2. 1의 객체를 JSP에서 출력할수 있도록 설정
			//  request.setAttribute("JSP에서 사용할 이름",1의 객체);	
			//request.setAttribute("GOOD_LIST", goodList);

			//3./good/viewGoodList.jsp로 페이지 이동
			/*
			 * RequestDispatcher rd=request.getRequestDispatcher("/good/viewGoodList.jsp");
			 * rd.forward(request,response);
			 */	
		// 전체 물건정보를 불러오는 메소드를 호출해서 받아오고 그걸 goodList에 저장함
		List<Good> goodList = GoodDAO.selectGoodList();
		
		// request를 통해 jsp로 데이터를 보냄
		request.setAttribute("GOOD_LIST", goodList);
		
		// /good/viewGoodList.jsp 페이지 이동 시킴
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGoodList.jsp");
		rd.forward(request,response);

	}
	
	//물건 1개 조회
	private void viewGood(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 조회하고자 하는 물건의 번호 gnum을 리턴받아서 String 변수에 저장
		// request.getParameter("gnum")
		//String gnum = request.getParameter("gnum");
		
		//2. GoodDAO.selectGood(1의 변수)를 호출해서 조회하고자 하는 물건정보를 Good 타입 변수에 저장
		//Good good = GoodDAO.selectGood(gnum);
		
		//2. 2의 객체를 JSP에서 출력할수 있도록 설정
		//  request.setAttribute("JSP에서 사용할 이름",2의 객체);
		//request.setAttribute("GOOD", good);
		
		//3./good/viewGood.jsp로 페이지 이동
				/*
				 * RequestDispatcher rd=request.getRequestDispatcher("/good/viewGood.jsp");
				 * rd.forward(request,response);
				 */	
		String gnum = request.getParameter("gnum");
		
		// 받고자 하는 gnum의 정보만 불러오는 메소드를 호출해서 받아오고 그걸 goodList에 저장함
		Good good = GoodDAO.selectGood(Long.parseLong(gnum));
				
		// request를 통해 jsp로 데이터를 보냄
		request.setAttribute("good", good);
				
		// /good/viewGood.jsp 페이지 이동 시킴
		RequestDispatcher rd=request.getRequestDispatcher("/good/viewGood.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}