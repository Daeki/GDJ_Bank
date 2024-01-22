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
        <title>Board Detail</title>
    <!-- 사용전 경로를 꼭 수정 하세요 -->
	<c:import url="../temps/head_css.jsp"></c:import>
    
    </head>
    <body class="d-flex flex-column h-100">
        <main class="flex-shrink-0">
            <!-- Navigation-->
            <!-- 사용전 경로를 꼭 수정 하세요 -->
			<c:import url="../temps/header.jsp"></c:import>
            <section class="py-5">
                <div class="container px-5 mb-5">
                    <div class="text-center mb-5">
                        <h1 class="display-5 fw-bolder mb-0"><span class="text-gradient d-inline">${board}Detail</span></h1>
                    </div>
                    <div class="row gx-5 justify-content-center">
                        <div class="col-lg-11 col-xl-9 col-xxl-8">
                            
                            <!--project-->
                            <div class="card overflow-hidden shadow rounded-4 border-0 mb-5">
                                <div class="card-body p-0">
                                    <div class="d-flex align-items-center">
                                        <div class="p-5">
                                            <h2 class="fw-bolder">${boardDTO.boardTitle}</h2>
                                            <div>
                                            	${boardDTO.boardContents}
                                            </div>

                                            <div>
                                                <c:forEach items="${boardDTO.fileDTOs}" var="f">
                                                    <a href="../resources/upload/${board}/${f.fileName}">${f.oriName}</a>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div>
                                <c:if test="${bbs eq '1'}">
                                    <a class="btn btn-primary" href="reply?boardNum=${boardDTO.boardNum}">답글</a>
                                </c:if>

                                <c:if test="${boardDTO.boardWriter eq member.userName}">
                                <a id="update" class="btn btn-info" href="#">Update</a>
                                <a id="delete" class="btn btn-primary" href="#">Delete</a>
                                </c:if>
                                <form id="frm" action="./update" method="get">
                                    <input type="hidden" name="boardNum" value="${boardDTO.boardNum}">
                                </form>
                            </div>


                        </div>
                    </div>
                </div>
            </section>    

        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정 하세요 -->
        <c:import url="../temps/footer.jsp"></c:import>
        <script src="/resources/js/boardDetail.js"></script>

    </body>
</html>
    