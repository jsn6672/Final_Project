<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
	rel="stylesheet">

<title>WoOx Travel Bootstrap 5 Theme</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/rbootstrap.min.css" rel="stylesheet">

<!-- Additional CSS Files -->
<link rel="stylesheet" href="resources/css/fontawesome.css">
<link rel="stylesheet" href="resources/css/templatemo-woox-travel.css">
<link rel="stylesheet" href="resources/css/owl.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<!--

TemplateMo 580 Woox Travel

https://templatemo.com/tm-580-woox-travel

-->

</head>

<body>
	<main id="main">
		<section style="background-color: #EDE7F6; padding-bottom: 30px;  height: 46vw;">
			<div class="container">
				<div class="row">

					<div class="col-md-9" data-aos="fade-up">
						<!-- ======= Stats Counter Section ======= -->
						<section id="stats-counter" class="stats-counter section-bg">
							<div class="container">

								<div class="row gy-4">
									<form action="page.change3">
										<div class="category-title"
											style="display: flex; justify-content: center">
											<input id="searchBar" type="text" name="ps_search"
												value="${param.ps_search}" placeholder="검색어를 입력해주세요.">
											<button class="QnA-searchbutton" type="submit" name="p"
												value="1">검색</button>
										</div>
									</form>

									<c:forEach var="p" items="${s }">
										<div class="d-md-flex post-entry-2 half">
											<div class="d-md-flex post-entry-2 half"
												style="border-bottom: 1px solid #dee2e6 !important;">
												<div style="display: flex; gap: 30px;">
													<div>
														<div class="post-meta">
															<span class="date">00전 작성 </span> <span>${p.d_writedate }</span>
														</div>
														<a href="pettaker.detail.go?d_no=${p.d_no }">대상:
															${p.d_name }</a>
													</div>
													<div>
														<div>
															<span>나이: <c:set var="currentYear"
																	value="<%=java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)%>" />${currentYear - p.d_year + 1}살</span>
														</div>
														<div>
															<span>성별 : ${p.d_gender }</span>
														</div>
													</div>

													<div style="padding-top: 3px;">
														<span>cctv촬영 -<c:choose>
																<c:when test="${p.d_cctv == 1}">
						   									   가능
						        							</c:when>
																<c:otherwise>
						           							불가능
						        							</c:otherwise>
															</c:choose></span>
														<div>시급: ${p.d_pay }원</div>
													</div>
													<div>
														<div>활동 가능 지역:</div>
														<div>${p.m_addr1 }</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>



									<div class="row mt-5">
										<div class="col text-center">
											<div class="text-start py-4"
												style="display: flex; justify-content: center;">
												<div class="custom-pagination">
													<c:if test="${curPage != 1 }">
														<a
															href="page.change3?p=${curPage - 1}&ps_search=${searchSession.ps_search}"
															class="prev">Previous</a>
													</c:if>
													<c:forEach begin="${startPage}" end="${endPage}"
														varStatus="loop">
														<c:choose>
															<c:when test="${curPage == loop.index}">
																<a
																	href="page.change3?p=${loop.index}&ps_search=${searchSession.ps_search}"
																	class="active">${loop.index}</a>
															</c:when>
															<c:otherwise>
																<a
																	href="page.change3?p=${loop.index}&ps_search=${searchSession.ps_search}">${loop.index}</a>
															</c:otherwise>
														</c:choose>
													</c:forEach>
													<c:if test="${curPage != pageCount }">
														<a
															href="page.change3?p=${curPage + 1}&ps_search==${searchSession.ps_search}"
															class="prev">Next</a>
													</c:if>
												</div>
											</div>

										</div>

									</div>

								</div>

							</div>
						</section>
						<!-- End Stats Counter Section -->
					</div>
					<div class="col-md-3">
						<!-- ======= Sidebar ======= -->
						<div class="aside-block">
							<ul class="nav nav-pills custom-tab-nav mb-4" id="pills-tab"
								role="tablist">
								<li class="nav-item" role="presentation">
									<button class="nav-link active" id="pills-popular-tab"
										data-bs-toggle="pill" data-bs-target="#pills-popular"
										type="button" role="tab" aria-controls="pills-popular"
										aria-selected="true" onclick="">Popular</button>
								</li>
								<!-- <li class="nav-item" role="presentation">
									<button class="nav-link" id="pills-trending-tab"
										data-bs-toggle="pill" data-bs-target="#pills-trending"
										type="button" role="tab" aria-controls="pills-trending"
										aria-selected="false">Trending</button>
								</li>
								<li class="nav-item" role="presentation">
									<button class="nav-link" id="pills-latest-tab"
										data-bs-toggle="pill" data-bs-target="#pills-latest"
										type="button" role="tab" aria-controls="pills-latest"
										aria-selected="false">Latest</button>
								</li> -->
							</ul>

							<div class="tab-content" id="pills-tabContent">
								<!-- Popular -->
								<c:forEach var="p" items="${s }">

									<div class="tab-pane fade show active" id="pills-popular"
										role="tabpanel" aria-labelledby="pills-popular-tab">
										<div class="post-entry-1 border-bottom">
											<div class="post-meta">
												<span class="mx-1">&bullet;</span> <span>OO전 작성</span>
											</div>
											<span class="author mb-3 d-block"> <a
												href="pettaker.detail.go?d_no=${p.d_no }">대상: ${p.d_name }</a>
												시급: ${p.d_pay }원
											</span> <span class="author mb-3 d-block">지역: ${p.m_addr1 }</span>
										</div>
									</div>
									<!-- End Popular -->
								</c:forEach>

							</div>
						</div>
						<div style="width: 40vw">
							<div class="col-lg-3 col-md-6">
								<div class="stats-items">
									<i class="bi bi-emoji-smile color-blue flex-shrink-0"></i>
									<div>
										<span class="purecounter" data-count="180">0</span>
										<p>행복한 돌보미들</p>
									</div>
								</div>
							</div>
							<!-- End Stats Item -->

							<div class="col-lg-3 col-md-6">
								<div class="stats-items">
									<i class="bi bi-journal-richtext color-orange flex-shrink-0"></i>
									<div>
										<span class="purecounter" data-count="250">0</span>
										<p>돌보미가 필요한 가족들</p>
									</div>
								</div>
							</div>
							<!-- End Stats Item -->

							<div class="col-lg-3 col-md-6">
								<div class="stats-items">
									<i class="bi bi-people color-pink flex-shrink-0"></i>
									<div>
										<span class="purecounter" data-count="666">0</span>
										<p>계약완료갯수</p>
									</div>
								</div>
							</div>
						</div>

						<!-- 						<div class="aside-block">
							<h3 class="aside-title">Video</h3>
							<div class="video-post">
								<a href="https://www.youtube.com/watch?v=AiFfDjmd0jU"
									class="glightbox link-video"> <span class="bi-play-fill"></span>
									<img src="assets/img/post-landscape-5.jpg" alt=""
									class="img-fluid">
								</a>
							</div>
						</div>
						End Video

						<div class="aside-block">
							<h3 class="aside-title">Tags</h3>
							<ul class="aside-tags list-unstyled">
								<li><a href="category.html">Business</a></li>
								<li><a href="category.html">Culture</a></li>
								<li><a href="category.html">Sport</a></li>
								<li><a href="category.html">Food</a></li>
								<li><a href="category.html">Politics</a></li>
								<li><a href="category.html">Celebrity</a></li>
								<li><a href="category.html">Startups</a></li>
								<li><a href="category.html">Travel</a></li>
							</ul>
						</div>
						End Tags -->

					</div>

				</div>
			</div>
		</section>

	</main>
	<!-- End #main -->


	<!-- Scripts -->
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

	<script src="resources/js/isotope.min.js"></script>
	<script src="resources/js/owl-carousel.js"></script>
	<script src="resources/js/wow.js"></script>
	<script src="resources/js/tabs.js"></script>
	<script src="resources/js/popup.js"></script>
	<script src="resources/js/custom.js"></script>

	<script>
		function bannerSwitcher() {
			next = $('.sec-1-input').filter(':checked').next('.sec-1-input');
			if (next.length)
				next.prop('checked', true);
			else
				$('.sec-1-input').first().prop('checked', true);
		}

		var bannerTimer = setInterval(bannerSwitcher, 5000);

		$('nav .controls label').click(function() {
			clearInterval(bannerTimer);
			bannerTimer = setInterval(bannerSwitcher, 5000)
		});
	</script>
	<script
		src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.6.0.min.js"></script>
	<script>
		//숫자 카운트 애니메이션
		$('.purecounter').each(function() {
			const $this = $(this), countTo = $this.attr('data-count');

			$({
				countNum : $this.text()
			}).animate({
				countNum : countTo
			}, {
				duration : 1600,
				easing : 'linear',
				step : function() {
					$this.text(Math.floor(this.countNum));
				},
				complete : function() {
					$this.text(this.countNum);
				}
			});
		});
	</script>

</body>

</html>