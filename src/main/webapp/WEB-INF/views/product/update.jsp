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
        <title>SeokHun-Project</title>
        <!-- 사용전 경로를 꼭 수정하세요  -->
        <!-- head_css  -->
        <c:import url="../temps/head_css.jsp"></c:import>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
       		<!-- 사용전 경로를 꼭 수정하세요  -->
            <!-- Navigation-->
           	<c:import url="../temps/header.jsp"></c:import>
           	
			<section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="bg-light rounded-4 py-5 px-4 px-md-5">
                        <div class="text-center mb-5">
                            <div class="feature bg-primary bg-gradient-primary-to-secondary text-white rounded-3 mb-3"><i class="bi bi-envelope"></i></div>
                            <h1 class="fw-bolder">상품 수정 페이지</h1>
                            <p class="lead fw-normal text-muted mb-0">Let's work together!</p>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- * * SB Forms Contact Form * *-->
                                <!-- * * * * * * * * * * * * * * *-->
                                <!-- This form is pre-integrated with SB Forms.-->
                                <!-- To make this form functional, sign up at-->
                                <!-- https://startbootstrap.com/solution/contact-forms-->
                                <!-- to get an API token!-->
                                <form id="contactForm" action="update" method="post">
                                    <!-- 상품명 input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="productName" id="name" type="text" placeholder="상품명을 입력하세요" data-sb-validations="required" value="${dto.productName}"/>
                                        <label for="name">상품명</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">상품명은 필수항목 입니다</div>
                                    </div>
                                    <!-- Message input-->
                                    <div class="form-floating mb-3">
                                        <textarea class="form-control" name="productContents" id="message" type="text" placeholder="상품 상세 설명을 입력하세요" style="height: 40rem" data-sb-validations="required"></textarea>
                                        <label for="message"></label>
                                        <div class="invalid-feedback" data-sb-feedback="message:required">상품설명은 필수항목 입니다.</div>
                                    </div>
                                    <!-- 이자율 input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control" name="productRate" id="rate" type="text" placeholder="이자율을 입력하세요" data-sb-validations="required" value="${dto.productRate}"/>
                                        <label for="name">이자율</label>
                                        <div class="invalid-feedback" data-sb-feedback="rate:required">이자율은 필수항목 입니다</div>
                                    </div>
                                    <!-- an error submitting the form-->
                                    <div class="d-none" id="submitErrorMessage"><div class="text-center text-danger mb-3">Error sending message!</div></div>
                                    <!-- Submit Button-->
                                    <div class="d-grid"><button class="btn btn-primary btn-lg" id="submitButton" type="submit">Submit</button></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
        </main>
    <!-- 사용전 경로를 꼭 수정하세요  -->
	<!-- Footer  -->
	<c:import url="../temps/footer.jsp"></c:import>
	<script>
	$(document).ready(function() {
		//여기 아래 부분
		$('#message').summernote({
			  height: 300,                 // 에디터 높이
			  minHeight: null,             // 최소 높이
			  maxHeight: null,             // 최대 높이
			  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			  lang: "ko-KR",					// 한글 설정
		});
		$('#message').summernote('code','${dto.productContents}');
	});
	</script>
    </body>
</html>
