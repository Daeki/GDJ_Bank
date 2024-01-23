<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Personal - Start Bootstrap Theme</title>
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
						<span class="text-gradient d-inline">약관동의</span>
					</h1>
				</div>
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-11 col-xl-9 col-xxl-8">
						<div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="checkAll">
						  <label class="form-check-label" for="checkAll">
						    모두동의
						  </label>
						</div>
						<div class="form-check">
						  <input class="form-check-input checks req" type="checkbox" value="" id="a1">
						  <label class="form-check-label" for="a1">
						    필수동의 1
						  </label>
						</div>
						<div class="form-check">
							<input class="form-check-input checks req" type="checkbox" value="" id="a2">
							<label class="form-check-label" for="a2">
							  필수동의 2
							</label>
						</div>

						<div class="form-check">
							<input class="form-check-input checks req" type="checkbox" value="" id="a3">
							<label class="form-check-label" for="a3">
							  필수동의 3
							</label>
						</div>

						<div class="form-check">
							<input class="form-check-input checks opts" type="checkbox" value="" id="a4">
							<label class="form-check-label" for="a4">
							  선택 동의 1
							</label>
						</div>						
					
						<div class="form-check">
							<input class="form-check-input checks opts" type="checkbox" value="" id="a5">
							<label class="form-check-label" for="a5">
							  선택 동의 2
							</label>
						</div>
						
						<div>
							<a id="btn" class="btn btn-primary" href="./join">회원가입</a>
						</div>
						
					</div>
				</div>
			</section>
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정 하세요 -->
        <c:import url="../temps/footer.jsp"></c:import>
		<script src="../resources/js/member/agreement.js" type="text/javascript"></script>
    </body>
</html>
    