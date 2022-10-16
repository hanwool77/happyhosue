<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Framework Project</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/apt.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<header id="index_header" class="jumbotron text-center mb-1">
			<img id="logo" src="/img/happyhouse.png">
		</header>
		<!-- nav start -->
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark rounded">
			<div class="collapse navbar-collapse justify-content-between"
				id="collapsibleNavbar">
				<ul class="nav navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>

					<li class="nav-item"><a class="nav-link" href="#">Notice</a></li>
					<li class="nav-item"><a class="nav-link"
						href="${root}/aptlist">아파트 매매</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav">
					<c:if test="${empty userinfo}">
						<li class="nav-item"><a class="nav-link" href="${root}/user/login">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="${root}/user/register">회원가입</a></li>
						<br />
					</c:if>
					<c:if test="${!empty userinfo}">
						<li class="nav-item"><a class="nav-link" href="${root}/user/modify?userId=${userinfo.userId}">정보 수정</a></li>
						<li class="nav-item"><a class="nav-link" href="${root}/user/logout">로그 아웃</a></li>
					</c:if>
				</ul>
			</div>

		</nav>