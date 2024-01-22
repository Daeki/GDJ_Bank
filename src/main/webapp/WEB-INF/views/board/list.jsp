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
<title>${board}List</title>
<!-- 사용전 경로를 꼭 수정 하세요 -->
<c:import url="../temps/head_css.jsp"></c:import>
</head>
<body class="d-flex flex-column h-100">
	<main class="flex-shrink-0">
		<!-- Navigation-->
		<!-- 사용전 경로를 꼭 수정 하세요 -->
		<c:import url="../temps/header.jsp"></c:import>

		<section class="py-5">
			<div class="text-center mb-5">
				<h1 class="display-5 fw-bolder mb-0">
					<span class="text-gradient d-inline">${board}List</span>
				</h1>
			</div>
			<div class="row gx-5 justify-content-center">
				<div class="col-lg-11 col-xl-9 col-xxl-8">
					<!-- table -->
					<div>
						<table class="table table-hover">
							<thead>
								<tr class="table-dark">
									<th>No</th>
									<th>Title</th>
									<th>Writer</th>
									<th>Date</th>
									<th>Hit</th>
								</tr>
							</thead>
							<tbody>
								<c:if test="${list.size()==0}">
									<tr>
										<td colspan="4">검색결과 없습니다</td>
									<tr>
								</c:if>
							
								<c:forEach items="${list}" var="dto">
									<c:set var="f" value="0"></c:set>

									<c:catch>
										<c:set var="f" value="${dto.flag}"></c:set>
										<c:if test="${f eq 1}">
											<tr>
												<td></td>
												<td>삭제되었다</td>
												<td></td>
												<td></td>
												<td></td>
											</tr>

										</c:if>
									</c:catch>
									<c:if test="${f eq 0}">
										<tr>
											<td>${dto.boardNum}</td>
											<td><a href="./detail?boardNum=${dto.boardNum}"> <c:catch>
														<c:forEach begin="1" end="${dto.boardDepth}">--</c:forEach>
													</c:catch> ${dto.boardTitle}
											</a></td>
											<td>${dto.boardWriter}</td>
											<td>${dto.boardDate}</td>
											<td>${dto.boardHit}</td>
										</tr>
									</c:if>

								</c:forEach>
							</tbody>
						</table>

						<div>
							<form class="row g-3" action="./list">
								<div class="col-auto">
									<select name="kind" class="form-select"
										aria-label="Default select example">
										<option class="a" value="kind1">Title</option>
										<option class="a" value="kind2">Contents</option>
										<option class="a" value="kind3">Writer</option>
										<option class="a" value="kind4">Title+Contents+Writer</option>
									</select>
								</div>

								<div class="col-auto">
									<label for="search" class="visually-hidden">Search</label> <input
										type="text" name="search" class="form-control" id="search">
								</div>

								<div class="col-auto">
									<button type="submit" class="btn btn-primary mb-3">검색</button>
								</div>
							</form>
						</div>

						<div>
							<nav aria-label="Page navigation example">
								<ul class="pagination">
									<c:if test="${!pager.start}">
										<li class="page-item"><a class="page-link"
											href="./list?page=${pager.startNum-1}&search=${pager.search}&kind=${pager.kind}"
											aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
										</a></li>
									</c:if>
									<c:forEach begin="${pager.startNum}" end="${pager.lastNum}"
										var="i">
										<li class="page-item"><a class="page-link"
											href="./list?page=${i}&search=${pager.search}&kind=${pager.kind}">${i}</a></li>
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
						
						<c:if test="${not empty member}">
						<div>
							<a href="./add" class="btn btn-danger">글쓰기</a>
						</div>
						</c:if>
					
					</div>

				</div>
			</div>

		</section>

	</main>
	<!-- Footer-->
	<!-- 사용전 경로를 꼭 수정 하세요 -->
	<c:import url="../temps/footer.jsp"></c:import>

</body>
</html>
