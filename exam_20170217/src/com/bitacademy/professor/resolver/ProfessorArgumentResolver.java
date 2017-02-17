package com.bitacademy.professor.resolver;

import java.text.SimpleDateFormat;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.bitacademy.professor.vo.Dept;
import com.bitacademy.professor.vo.Professor;

public class ProfessorArgumentResolver implements WebArgumentResolver
{

	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest request) throws Exception
	{
		// 메소드 파라미터 타입이 Professor일때만 끼어든다
		if (methodParameter.getParameterType() == Professor.class)
		{
			// 데이터 담을 객체를 만든다. professor안에 dept가 담겨있어서 같이 만든다. ㅎㅎ..
			Professor professor = new Professor();
			Dept dept = new Dept();

			// 데이터를 넣는다 차곡차곡
			professor.setProfno(Long.parseLong(request.getParameter("profno")));
			professor.setName(request.getParameter("name"));
			professor.setSal(Long.parseLong(request.getParameter("sal")));
			professor.setComm(Long.parseLong(request.getParameter("comm")));
			//
			String requestDate = request.getParameter("date");
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date utilDate = transFormat.parse(requestDate);
			professor.setHiredate(new java.sql.Date(utilDate.getTime()));
			//
			dept.setDeptno(Long.parseLong(request.getParameter("deptno")));
			professor.setDept(dept);
			//
			professor.setUserid(request.getParameter("userid"));

			// 데이터가 담긴 professor를 리턴한다
			return professor;
		}
		// 기본 리턴값 WebArgumentResolver.UNRESOLVED 난 아무것도 안하고 서블렛으로 넘어간다.
		return WebArgumentResolver.UNRESOLVED;
	}

}
