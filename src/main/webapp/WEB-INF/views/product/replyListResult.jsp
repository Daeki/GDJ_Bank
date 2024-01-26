<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
<c:forEach items="${list}" var="r">
	<tr>
		<td>${r.userName}</td>
		<td>${r.replyContents}</td>
		<td>${r.replyDate}</td>
	</tr>
</c:forEach>

</table>

<div>
	<button id="more" data-replyList-page="${pager.page}">더보기(${pager.page}/${pager.totalPage})</button>
</div>
