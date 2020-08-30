<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="header-sty">
	<c:if test="${sessMember.ID eq null}"><a href="/login">로그인</a></c:if>
	<c:if test="${sessMember.ID ne null}">
		<a href="/mypage/info">마이페이지</a>
		<a href="/logout">로그아웃</a>
	</c:if>
</div>
<jsp:include page="mainNav.jsp"/>