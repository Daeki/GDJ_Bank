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
            <div class="row gx-5 justify-content-center">
                <div class="col-lg-11 col-xl-9 col-xxl-8">
                    <form action="./update" method="post" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="userName" class="form-label">ID</label>
                            <input type="text" value="${member.userName}" disabled class="form-control" id="userName" name="userName">
                        </div>

                        <div class="mb-3">
                            <label for="name" class="form-label">NAME</label>
                            <input type="text" value="${requestScope.member.name}" class="form-control" id="name" name="name">
                        </div>

                        <div class="mb-3">
                            <label for="phone" class="form-label">PHONE</label>
                            <input type="text" value="${member.phone}" class="form-control" id="phone" name="phone">
                        </div>

                        <div class="mb-3">
                          <label for="email" class="form-label">EMAIL</label>
                          <input type="email" value="${member.email}" class="form-control" id="email" name="email">
                        </div>

                        <div class="mb-3">
                            <label for="address" class="form-label">Address</label>
                            <input type="text" value="${member.address}" class="form-control" id="address" name="address">
                        </div>
                        <div class="mb-3">
                            <label for="avatar" class="form-label">AVATAR</label>
                            <input type="file" class="form-control" id="avatar" name="avatar">
                        </div>

                        <button type="submit" class="btn btn-primary">Update</button>
                      </form>
                </div>
            </div>                    
        </main>
        <!-- Footer-->
        <!-- 사용전 경로를 꼭 수정 하세요 -->
        <c:import url="../temps/footer.jsp"></c:import>

    </body>
</html>
    