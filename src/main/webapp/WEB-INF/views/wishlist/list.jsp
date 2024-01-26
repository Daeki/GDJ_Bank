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
<style type="text/css">
a {
	text-decoration: none;
	color: black
}
</style>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- 사용전 경로를 꼭 수정하세요  -->
		<!-- Navigation-->
		<c:import url="../temps/header.jsp"></c:import>
		<div class="container px-5 mt-5">
			<div class="row g-4 align-items-end">
				<form class="col row g-3 mb-3">
					<div class="col-auto">
						<select class="form-select" name="kind">
							<option value="kind1">이름</option>
							<option value="kind2">내용</option>
							<option value="kind3">이름&내용</option>
						</select>
					</div>
					<div class="col-auto">
						<label for="search" class="visually-hidden">Search</label> <input
							type="text" name="search" class="form-control" id="search"
							value="${pager.search}">
					</div>
					<div class="col-auto">
						<button type="submit" class="btn btn-light">Search</button>
					</div>
				</form>
				<div class="col-auto d-flex justify-content-end">
					<a class="btn btn-light mb-3" href="./add">상품 등록</a>
				</div>
			</div>
		</div>



		<div class="container">
			<div>
				<button id="del">삭제</button>
				<button id="add">가입</button>
			</div>

			<table class="table table-hover">
				<thead>
					<tr class="table-dark">
						<th>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value="" id="checkAll">
								<label class="form-check-label" for="checkAll">
									전체선택
								</label>
						  	</div>
						</th>
						<th>No</th>
						<th>Product Name</th>
						<th>Rate</th>
					</tr>
				</thead>
				<form id="deleteForm">
				<tbody id="ajaxList">
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>
								<div class="form-check">
									<input class="form-check-input checks" type="checkbox" name="productNum" value="${dto.productNum}" >
								</div>
							</td>
							<td>${dto.productNum}</td>
							<td><a href="../product/detail?productNum=${dto.productNum}">${dto.productName}</a></td>
							<td>${dto.productRate}</td>
							
						</tr>
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
			</form>
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
	<script src="/resources/js/wish/wishlist.js" type="text/javascript"></script>
</body>
</html>
