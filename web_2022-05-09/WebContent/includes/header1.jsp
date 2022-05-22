<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="header_title" value="홈"/>
<c:if test="${param.active eq 'product_list'}">
	<c:set var="header_title" value="모든 상품"/>
</c:if>

<header class="bg-dark py-5">
	<div class="container px-4 px-lg-5 my-5">
		<div class="text-center text-white">
			<h1 class="display-4 fw-bolder">${header_title }</h1>
			<p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
		</div>
	</div>
</header>