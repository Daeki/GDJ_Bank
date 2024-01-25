<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SeokHun-Project</title>
<!-- 사용전 경로를 꼭 수정하세요  -->
<!-- head_css  -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- 사용전 경로를 꼭 수정하세요  -->
		<!-- Navigation-->
		<c:import url="../temps/header.jsp"></c:import>
		<div class="container">
			<div class="text-center my-5">
				<h1 class="display-5 fw-bolder mb-0">
					<span class="text-gradient d-inline"> 
						내 계좌 목록
					</span>
				</h1>
			</div>
			<table class="table table-hover">
				<thead>
					<tr class="table-dark">
						<th>상품명</th>
						<th>계좌번호</th>
						<th>계좌잔액</th>
						<th>이자율</th>
						<th>가입일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="dto">
						<c:forEach items="${dto.accountDTOs}" var="acc">
							<tr>
								<td>${dto.productName}</td>
								<td>${acc.accountNum}</td>
								<td>${acc.accountBalance}</td>
								<td>${dto.productRate}</td>
								<td>${acc.accountDate}</td>
							</tr>
						</c:forEach>
					</c:forEach>
					<%-- <c:if test="${list.size() != 10}">
							<c:forEach begin="1" end="${11-list.size()}">
								<tr>
									<td style="color : white" disable>빈셀</td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</c:forEach>
						</c:if> --%>
				</tbody>
			</table>

			<nav aria-label="Page navigation example"
				class="d-flex justify-content-center">
				<ul class="pagination">
					<c:if test="${!pager.start}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.startNum-1}" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link"
							href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">
								${i} </a></li>
					</c:forEach>

					<c:if test="${!pager.last}">
						<li class="page-item"><a class="page-link"
							href="./list?page=${pager.lastNum+1}&search=${pager.search}&kind=${pager.kind}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</main>
	<!-- 사용전 경로를 꼭 수정하세요  -->
	<!-- Footer  -->
	<c:import url="../temps/footer.jsp"></c:import>
</body>
</html>
