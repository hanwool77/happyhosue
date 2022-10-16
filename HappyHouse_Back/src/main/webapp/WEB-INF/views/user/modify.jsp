<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>

<script type="text/javascript">
	
</script>

<div class="container text-center mt-3">
	<div class="col-lg-8 mx-auto">
		<h2 class="p-3 mb-3 shadow bg-light">
			<mark class="orange">회원수정</mark>
		</h2>
		<form id="memberform" class="text-left mb-3" method="post" action="">
			<div class="form-group">
				<label for="username">이름</label> <input type="text"
					class="form-control" id="username" name="userName"
					value="${userInfo.userName}">
			</div>
			<div class="form-group">
				<label for="userid">아이디</label> <input type="text"
					class="form-control" id="userid" name="userId"
					value="${userInfo.userId}">
				<div id="idresult" class="mt-1"></div>
			</div>
			<div class="form-group">
				<label for="userpwd">비밀번호</label> <input type="password"
					class="form-control" id="userpwd" name="userPwd"
					value="${userInfo.userPwd}">
			</div>
			<div class="form-group">
				<label for="pwdcheck">비밀번호재입력</label> <input type="password"
					class="form-control" id="pwdcheck" name="pwdcheck"
					value="${userInfo.userPwd}">
			</div>

			<div class="form-group">
				<label for="email">이메일</label><br> <input type="text"
					class="form-control" id="email" name="email"
					value="${userInfo.email}" size="25">


			</div>

			<div class="form-group text-center">
				<button type="button" id="modifyBtn" class="btn btn-outline-primary">회원
					수정</button>
				<button type="button" id="deleteBtn" class="btn btn-outline-primary">회원
					탈퇴</button>
				<button type="reset" class="btn btn-outline-danger">초기화</button>
			</div>
		</form>
	</div>
</div>
<script>
	$("#modifyBtn").click(function() {
		$("#memberform").attr("action", "${root}/user/modify").submit();

	});
	$("#deleteBtn").click(function() {
		$("#memberform").attr("action", "${root}/user/delete").submit();

	});
</script>
</body>
</html>