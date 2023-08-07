<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<meta charset="utf-8">
<title>Tea House - Tea Shop Website Template</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="resources/img/favicon.ico" rel="icon">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Playfair+Display:wght@700;900&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="resources/lib/animate/animate.min.css" rel="stylesheet">
<link href="resources/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">

<!-- js script -->
<script type="text/javascript" src="resources/js/mypage/mypage.js"></script>

<!-- Customized Bootstrap Stylesheet -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="resources/css/style.css" rel="stylesheet">

<link href="resources/css/point.css" rel="stylesheet">
<!-- zenblog에서 퍼온 css -->
<link href="resources/css/index_index.css" rel="stylesheet">
<link href="resources/css/ask.css" rel="stylesheet">
<link href="resources/css/index_index_variables.css" rel="stylesheet">
<link href="resources/css/mypage/mypage.css" rel="stylesheet">
</head>

<body>
	<!-- Spinner Start -->
	<div id="spinner"
		class="show bg-white 
    position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
		<div class="spinner-border text-primary" role="status"
			style="width: 3rem; height: 3rem;"></div>
	</div>
	<!-- Spinner End -->


	<!-- Navbar Start -->
	<div class="container-fluid bg-white sticky-top" style="background-color:${background_color}">
		<div class="container" style="background-color:${background_color}">
			<nav
				class="navbar navbar-expand-lg bg-white navbar-light py-2 py-lg-0" style="background-color:${background_color}">
				<a href="go.home" class="navbar-brand"> <img
					class="img-fluid" src="resources/img/logo2.png" alt="Logo">
				</a>
				<button type="button" class="navbar-toggler ms-auto me-0"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse" style="background-color:${background_color}">
					<div class="navbar-nav ms-auto">
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown">간병인</a>
							<div class="dropdown-menu bg-light rounded-0 m-0">
								<a href="caresitter.go" class="dropdown-item">간병인모집</a> <a
									href="caretaker.go" class="dropdown-item">일자리모집</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown">맘시터</a>
							<div class="dropdown-menu bg-light rounded-0 m-0">
								<a href="momsitter.go" class="dropdown-item">맘시터모집</a> <a
									href="momtaker.go" class="dropdown-item">일자리모집</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown">펫시터</a>
							<div class="dropdown-menu bg-light rounded-0 m-0">
								<a href="petsitter.go" class="dropdown-item">펫시터모집</a> <a
									href="pettaker.go" class="dropdown-item">일자리모집</a>
							</div>
						</div>
						<div class="nav-item dropdown">
							<a href="#" class="nav-link dropdown-toggle"
								data-bs-toggle="dropdown">Q&A</a>
							<div class="dropdown-menu bg-light rounded-0 m-0">
								<a href="mainask.go" class="dropdown-item">공지사항</a> <a
									href="manyask.go" class="dropdown-item">자주묻는질문</a> <a
									href="qanda.go" class="dropdown-item">문의사항</a>
							</div>
						</div>
					</div>
					<div class="border-start ps-4 d-none d-lg-block">
						<button type="button" class="btn btn-sm p-0">
							<i class="fa fa-search"></i>
						</button>
					</div>
					<div>
						<jsp:include page="${loginPage }"></jsp:include>
					</div>
					<div>
						<a href="mypage.go" class="nav-item nav-link">마이페이지</a>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<!-- Navbar End -->

	<jsp:include page="${contentPage }"></jsp:include>

	<!-- Footer Start -->
	<div class="container-fluid bg-dark footer mt-5 py-5 wow fadeIn"
		data-wow-delay="0.1s">
		<div class="container py-5">
			<div class="row g-5">
				<div class="col-lg-3 col-md-6">
					<h4 class="text-primary mb-4">Our Office</h4>
					<p class="mb-2">
						<i class="fa fa-map-marker-alt text-primary me-3"></i>123 Street,
						New York, USA
					</p>
					<p class="mb-2">
						<i class="fa fa-phone-alt text-primary me-3"></i>+012 345 67890
					</p>
					<p class="mb-2">
						<i class="fa fa-envelope text-primary me-3"></i>info@example.com
					</p>
					<div class="d-flex pt-3">
						<a class="btn btn-square btn-primary rounded-circle me-2" href=""><i
							class="fab fa-twitter"></i></a> <a
							class="btn btn-square btn-primary rounded-circle me-2" href=""><i
							class="fab fa-facebook-f"></i></a> <a
							class="btn btn-square btn-primary rounded-circle me-2" href=""><i
							class="fab fa-youtube"></i></a> <a
							class="btn btn-square btn-primary rounded-circle me-2" href=""><i
							class="fab fa-linkedin-in"></i></a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<h4 class="text-primary mb-4">Quick Links</h4>
					<a class="btn btn-link" href="">About Us</a> <a
						class="btn btn-link" href="">Contact Us</a> <a
						class="btn btn-link" href="">Our Services</a> <a
						class="btn btn-link" href="">Terms & Condition</a> <a
						class="btn btn-link" href="">Support</a>
				</div>
				<div class="col-lg-3 col-md-6">
					<h4 class="text-primary mb-4">Business Hours</h4>
					<p class="mb-1">Monday - Friday</p>
					<h6 class="text-light">09:00 am - 07:00 pm</h6>
					<p class="mb-1">Saturday</p>
					<h6 class="text-light">09:00 am - 12:00 pm</h6>
					<p class="mb-1">Sunday</p>
					<h6 class="text-light">Closed</h6>
				</div>
				<div class="col-lg-3 col-md-6">
					<h4 class="text-primary mb-4">Newsletter</h4>
					<p>Dolor amet sit justo amet elitr clita ipsum elitr est.</p>
					<div class="position-relative w-100">
						<input class="form-control bg-transparent w-100 py-3 ps-4 pe-5"
							type="text" placeholder="Your email">
						<button type="button"
							class="btn btn-primary py-2 position-absolute top-0 end-0 mt-2 me-2">SignUp</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Footer End -->


	<!-- Copyright Start -->
	<div class="container-fluid copyright py-4">
		<div class="container">
			<div class="row">
				<div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
					&copy; <a class="fw-medium" href="#">Your Site Name</a>, All Right
					Reserved.
				</div>
				<div class="col-md-6 text-center text-md-end">
					<!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
					Designed By <a class="fw-medium" href="https://htmlcodex.com">HTML
						Codex</a> Distributed By <a class="fw-medium"
						href="https://themewagon.com">ThemeWagon</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Copyright End -->


	<!-- Back to Top -->
	<a href="#"
		class="btn btn-lg btn-primary btn-lg-square rounded-circle back-to-top"><i
		class="bi bi-arrow-up"></i></a>


	<!-- JavaScript Libraries -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="resources/lib/wow/wow.min.js"></script>
	<script src="resources/lib/easing/easing.min.js"></script>
	<script src="resources/lib/waypoints/waypoints.min.js"></script>
	<script src="resources/lib/owlcarousel/owl.carousel.min.js"></script>
	<script src="resources/js/point.js"></script>
	<!-- Template Javascript -->
	<script src="resources/js/main.js"></script>
	<script src="resources/js/ask.js"></script>
</body>
</html>