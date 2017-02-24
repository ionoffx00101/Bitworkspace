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
				$("#brand").change(
						function() {
							$.ajax({
								url : "<c:url value="viewCarListForm.do"/>",
								type : "post",
								dataType : "json",
								data : {
									"code" : $("#brand").val()
								},
								success : function(data) {
									console.log(data);
									/* 비우기 */
									$("#car").empty();
									/* 반복해서 데이터 꺼내기 */
									for (var i = 0; i < data.length; i++) {
										/* 코드를 더 줄일 수도 있지만 가독성이 떨어질 수도 있으니 그만 줄이자 */
										var code = data[i].code;
										var name = data[i].cname;
										$("#car").append(
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
		<p>브랜드</p>
		<select id="brand">
			<c:forEach items="${brandList}" var="brand">
				<option value="${brand.code}">${brand.name}</option>
			</c:forEach>
		</select>
		<p>자동차</p>
		<select id="car">
			<c:forEach items="${carList}" var="car">
				<option value="${car.ccode}">${car.cname}</option>
			</c:forEach>
		</select>
	</div>
</body>
</html>