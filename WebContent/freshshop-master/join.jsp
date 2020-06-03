<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:if test="${ message1== 1}">
	<script>
		alert("중복된 아이디가 있습니다.");
	</script>
</c:if>

<c:if test="${ message_M== 2}">
	<script>
		alert("회원가입에 실패했습니다. 다시 시도해주세요.");
	</script>
</c:if>
<title>Login V13</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="images/png" href="<%=request.getContextPath()%>/freshshop-master/images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/freshshop-master/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/freshshop-master/css/utill.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/freshshop-master/css/Jmain.css">
<!--===============================================================================================-->
</head>
<body style="background-color: #999999;">

	<div class="limiter">
		<div class="container-login100">
			<div class="login100-more"
				style="background-image: url('<%=request.getContextPath()%>/freshshop-master/images/bg_2.jpg');"></div>

			<div class="wrap-login100 p-l-50 p-r-50 p-t-72 p-b-50">
				<form class="login100-form validate-form" name="join_form"
					action="../MemberServlet" method="post">
					<input type="hidden" name="command" value="join"> 
					<span class="login100-form-title p-b-59"> Sign Up </span>

					<div class="wrap-input100 validate-input"
						data-validate="Name is required">
						<span class="label-input100">Name</span> <input class="input100"
							type="text" name="name" placeholder="Name..."> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is required: ex@abc.xyz">
						<span class="label-input100">Email</span> <input class="input100"
							type="text" name="email" placeholder="Email addess..."> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Username is required">
						<span class="label-input100">Id</span> <input class="input100"
							type="text" name="username" placeholder="Id..."> <span
							class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Password is required">
						<span class="label-input100">Password</span> <input
							class="input100" type="text" name="pwd"
							placeholder="*************"> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Addess is required">
						<span class="label-input100">Address</span> <input
							class="input100" type="text" name="address"
							placeholder="Addess..."> <span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Repeat Phone is required">
						<span class="label-input100">Call</span><br> <select
							id="txtM1" name="phone1" class="label-input100">
							<option value="">::Choice::</option>
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
							<option value="017">017</option>
							<option value="019">019</option>
						</select> &nbsp&nbsp-&nbsp&nbsp&nbsp<input class="input100" type="text"
							name="phone2" id="txtM2" maxlength="4" size="4"
							onkeypress="onlyNumber();"> &nbsp-&nbsp <input
							class="input100" type="text" onkeypress="onlyNumber();"
							name="phone3" id="txtM3" maxlength="4" size="4"> <span
							class="focus-input100"></span>
					</div>



					<div class="flex-m w-full p-b-33">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox"
								name="remember-me"> <label class="label-checkbox100"
								for="ckb1"> <span class="txt1"> I agree to the <a
									href="#" class="txt2 hov1"> Terms of User </a>
							</span>
							</label>
						</div>


					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" onclick="erchk()">
								Sign Up</button>
						</div>

						<a href="#"
							class="dis-block txt3 hov1 p-r-30 p-t-10 p-b-10 p-l-30"> Sign
							in <i class="fa fa-long-arrow-right m-l-5"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>

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