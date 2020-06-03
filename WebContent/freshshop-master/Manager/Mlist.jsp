<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<c:if test="${ result==1 }">
	<script>
		alert("삭제되었습니다.");
	</script>
</c:if>



<c:if test="${ result_M==2 }">
	<script>
		alert("수정이 실패했습니다. 다시 시도하세요.");
	</script>
</c:if>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>ThewayShop - Ecommerce Bootstrap 4 HTML Template</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/freshshop-master/images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon"
	href="<%=request.getContextPath()%>/freshshop-master/images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/freshshop-master/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/freshshop-master/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/freshshop-master/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/freshshop-master/css/custom.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<!-- Start Main Top -->
	<div class="main-top">
      <div class="container-fluid">
         <div class="row">

            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
               <div class="text-slid-box">
                  <div id="offer-box" class="carouselTicker">

                     <ul class="offer-box">
                        <li><i class="fab fa-opencart"></i> Welcome To Our Shop</li>
                        <li><i class="fab fa-opencart"></i> Dear Our Customers</li>
                        <li><i class="fab fa-opencart"></i> We Always Deal In Fresh</li>
                        <li><i class="fab fa-opencart"></i> Enjoy Our Shop</li>
                     </ul>

                  </div>
               </div>
            </div>

            <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
               <div class="our-link">
                  <ul>

                     <c:choose>
                        <c:when test="${sessionScope.USER != null}">
                           <li id=idcolor><a href="#"><i
                                 class="fa fa-user s_color"></i> ${sessionScope.USER}</a></li>
                           <li><a href="/123/MemberServlet?command=logout"><i class="fas fa-location-arrow"></i>
                                Logout</a></li>
                                  <div class="login-box">
                 <select onchange="if(this.value) location.href=(this.value);"
							id="basic" class="selectpicker show-tick form-control">
							<option value="">::Choice::</option>
							<option value="/123/ShoppingServlet?command=shop">Shopping</option>
							<option value="/123/MemberServlet?command=logout">Logout</option>
						</select>
               </div>
                        </c:when>

                        <c:otherwise>
                           <li><a href="#"><i class="fa fa-user s_color"></i>Guest</a></li>
                           <li><a href="<%=request.getContextPath()%>/freshshop-master/login.jsp"><i
                                 class="fas fa-location-arrow"></i>Login</a></li>
                                    <div class="login-box">
                  <select onchange="if(this.value) location.href=(this.value);"
							id="basic" class="selectpicker show-tick form-control">
							<option value="">::Choice::</option>
							<option value="<%=request.getContextPath()%>/freshshop-master/join.jsp">Sign up</option>
							<option value="<%=request.getContextPath()%>/freshshop-master/login.jsp">Login</option>
						</select>
               </div>
                        </c:otherwise>
                     </c:choose>

                  </ul>
               </div>
            </div>
         </div>
      </div>
   </div>
	<!-- End Main Top -->

	<!-- Start Main Top -->
	<header class="main-header">
		<!-- Start Navigation -->
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
			<div class="container">
				<!-- Start Header Navigation -->
				<div class="navbar-header">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbar-menu" aria-controls="navbars-rs-food"
						aria-expanded="false" aria-label="Toggle navigation">
						<i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand" href="<%=request.getContextPath()%>/freshshop-master/Manager/index_for_manager.jsp"><img
						src="<%=request.getContextPath()%>/freshshop-master/images/logo.png"
						class="logo" alt=""></a>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li class="nav-item active"><a class="nav-link"
							href="<%=request.getContextPath()%>/freshshop-master/Manager/index_for_manager.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/freshshop-master/Manager/insertform.jsp">MANAGEMENT</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<%=request.getContextPath()%>/ManagerServlet?command=list">List</a></li>
						<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/QnAServlet?command=list">QnA</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- Start Side Menu -->
			<div class="side">
				<a href="#" class="close-side"><i class="fa fa-times"></i></a>
				<li class="cart-box">
					<ul class="cart-list">
						<li><a href="#" class="photo"><img
								src="<%=request.getContextPath()%>/freshshop-master/images/img-pro-01.jpg"
								class="cart-thumb" alt="" /></a>
							<h6>
								<a href="#">Delica omtantur </a>
							</h6>
							<p>
								1x - <span class="price">$80.00</span>
							</p></li>
						<li><a href="#" class="photo"><img
								src="<%=request.getContextPath()%>/freshshop-master/images/img-pro-02.jpg"
								class="cart-thumb" alt="" /></a>
							<h6>
								<a href="#">Omnes ocurreret</a>
							</h6>
							<p>
								1x - <span class="price">$60.00</span>
							</p></li>
						<li><a href="#" class="photo"><img
								src="<%=request.getContextPath()%>/freshshop-master/images/img-pro-03.jpg"
								class="cart-thumb" alt="" /></a>
							<h6>
								<a href="#">Agam facilisis</a>
							</h6>
							<p>
								1x - <span class="price">$40.00</span>
							</p></li>
						<li class="total"><a href="#"
							class="btn btn-default hvr-hover btn-cart">VIEW CART</a> <span
							class="float-right"><strong>Total</strong>: $180.00</span></li>
					</ul>
				</li>
			</div>
			<!-- End Side Menu -->
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->

	<!-- Start Top Search -->
	<div class="top-search">
		<div class="container">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-search"></i></span>
				<input type="text" class="form-control" placeholder="Search">
				<span class="input-group-addon close-search"><i
					class="fa fa-times"></i></span>
			</div>
		</div>
	</div>
	<!-- End Top Search -->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Wishlist</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Shop</a></li>
						<li class="breadcrumb-item active">Wishlist</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Wishlist  -->
	<div class="wishlist-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="table-main table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Number</th>
									<th>Images</th>
									<th>Name</th>
									<th>Type</th>
									<th>Origin</th>
									<th>Modify</th>
									<th>Remove</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${list }">
									<tr>

										<td class="price-pr">
											<p>${list.num}</p>
										</td>

										<td class="thumbnail-img"><a
											href="<%=request.getContextPath()%>/freshshop-master/#">
												<img class="img-fluid"
												src="./freshshop-master/upload/${list.image}" alt="" />
										</a></td>

										<td class="name-pr"><a
											href="<%=request.getContextPath()%>/freshshop-master/#">
												${list.name} </a></td>

										<td class="price-pr">
											<p>${list.type}</p>
										</td>
										<td class="quantity-box">${list.origin}</td>
										<td class="add-pr"><a class="btn hvr-hover"
											href="<%=request.getContextPath()%>/ManagerServlet?command=modF&num=${list.num}">modify</a>
										</td>
										<td class="remove-pr"><a
											href="<%=request.getContextPath()%>/ManagerServlet?command=del&num=${list.num}">
												<i class="fas fa-times"></i>
										</a></td>
									</tr>


									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Wishlist -->

	<!-- Start Instagram Feed  -->
	<div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-01.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-02.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-03.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-04.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-05.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-06.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-07.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-08.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-09.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img
						src="<%=request.getContextPath()%>/freshshop-master/images/instagram-img-05.jpg"
						alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Instagram Feed  -->


	<!-- Start Footer  -->
	<footer>
		<div class="footer-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Business Time</h3>
							<ul class="list-time">
								<li>Monday - Friday: 08.00am to 05.00pm</li>
								<li>Saturday: 10.00am to 08.00pm</li>
								<li>Sunday: <span>Closed</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Newsletter</h3>
							<form class="newsletter-box">
								<div class="form-group">
									<input class="" type="email" name="Email"
										placeholder="Email Address*" /> <i class="fa fa-envelope"></i>
								</div>
								<button class="btn hvr-hover" type="submit">Submit</button>
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Social Media</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<ul>
								<li><a href="#"><i class="fab fa-facebook"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-twitter"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-linkedin"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-google-plus"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-pinterest-p"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-whatsapp"
										aria-hidden="true"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-widget">
							<h4>About Freshshop</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-link">
							<h4>Information</h4>
							<ul>
								<li><a href="#">About Us</a></li>
								<li><a href="#">Customer Service</a></li>
								<li><a href="#">Our Sitemap</a></li>
								<li><a href="#">Terms &amp; Conditions</a></li>
								<li><a href="#">Privacy Policy</a></li>
								<li><a href="#">Delivery Information</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-link-contact">
							<h4>Contact Us</h4>
							<ul>
								<li>
									<p>
										<i class="fas fa-map-marker-alt"></i>Address: Michael I. Days
										3756 <br>Preston Street Wichita,<br> KS 67213
									</p>
								</li>
								<li>
									<p>
										<i class="fas fa-phone-square"></i>Phone: <a
											href="tel:+1-888705770">+1-888 705 770</a>
									</p>
								</li>
								<li>
									<p>
										<i class="fas fa-envelope"></i>Email: <a
											href="mailto:contactinfo@gmail.com">contactinfo@gmail.com</a>
									</p>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2018 <a href="#">ThewayShop</a> Design By
			: <a href="https://html.design/">html design</a>
		</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/jquery-3.2.1.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/jquery.superslides.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/bootstrap-select.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/inewsticker.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/bootsnav.js."></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/images-loded.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/isotope.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/baguetteBox.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/form-validator.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/contact-form-script.js"></script>
	<script
		src="<%=request.getContextPath()%>/freshshop-master/js/custom.js"></script>
</body>

</html>