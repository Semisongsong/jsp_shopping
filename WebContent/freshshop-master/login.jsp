<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login</title>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/freshshop-master/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/freshshop-master/vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/freshshop-master/css/util.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/freshshop-master/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	<c:if test="${ message_M == 1}">
		<script>
			alert("회원가입이 되었습니다.");
		</script>
	</c:if>

	<c:if test="${ message_L == -1 }">
		<script>
			alert("아이디 혹은 비밀번호가 틀렸습니다.");
		</script>
	</c:if>

	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-85 p-b-20">
				<form class="login100-form validate-form" name="login_form"
					action="<%=request.getContextPath()%>/MemberServlet" method="post">
					<input type="hidden" name="command" value="login"> <span
						class="login100-form-title p-b-70"> Welcome </span> <span
						class="login100-form-avatar"> <img src="<%=request.getContextPath()%>/freshshop-master/images/bg_2.jpg"
						alt="AVATAR">
					</span>

					<div class="wrap-input100 validate-input m-t-85 m-b-35"
						data-validate="Enter ID">
						<input class="input100" type="text" name="id"> <span
							class="focus-input100" data-placeholder="ID"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-50"
						data-validate="Enter password">
						<input class="input100" type="password" name="pwd"> <span
							class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" onclick="erchk()">
							Login</button>
					</div>

					<ul class="login-more p-t-190">
						<li class="m-b-8"><span class="txt1"> Forgot </span> <a
							href="#" class="txt2"> Username / Password? </a></li>

						<li><span class="txt1"> Don’t have an account? </span> <a
							href="../join/join.html" class="txt2"> Sign up </a></li>
					</ul>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/daterangepicker/moment.min.js"></script>
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/freshshop-master/js/main.js"></script>

</body>
</html>