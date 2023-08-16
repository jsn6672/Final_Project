<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<link href="resources/css/mom/mom.css" rel="stylesheet">

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
		<section style="background-color: #EDE7F6;">
			<div class="container">
				<div class="row">

					<div class="col-md-9" data-aos="fade-up">
						<!-- ======= Stats Counter Section ======= -->
						<section id="stats-counter" class="stats-counter section-bg">
							<div class="container">

								<div class="row gy-4">

									<div class="col-lg-3 col-md-6">
										<div class="stats-item d-flex align-items-center w-100 h-100"
											style="background-color: #FCE4EC">
											<i class="bi bi-emoji-smile color-blue flex-shrink-0"></i>
											<div>
												<span class="purecounter" data-count="180">0</span>
												<p>행복한 돌보미들</p>
											</div>
										</div>
									</div>
									<!-- End Stats Item -->

									<div class="col-lg-3 col-md-6">
										<div class="stats-item d-flex align-items-center w-100 h-100"
											style="background-color: #FCE4EC">
											<i class="bi bi-journal-richtext color-orange flex-shrink-0"></i>
											<div>
												<span class="purecounter" data-count="250">0</span>
												<p>돌보미가 필요한 가족들</p>
											</div>
										</div>
									</div>
									<!-- End Stats Item -->

									<div class="col-lg-3 col-md-6">
										<div class="stats-item d-flex align-items-center w-100 h-100"
											style="background-color: #FCE4EC">
											<i class="bi bi-headset color-green flex-shrink-0"></i>
											<div>
												<span class="purecounter" data-count="1500">0</span>
												<p>총 운영 시간</p>
											</div>
										</div>
									</div>
									<!-- End Stats Item -->

									<div class="col-lg-3 col-md-6">
										<div class="stats-item d-flex align-items-center w-100 h-100"
											style="background-color: #FCE4EC">
											<i class="bi bi-people color-pink flex-shrink-0"></i>
											<div>
												<span class="purecounter" data-count="666">0</span>
												<p>계약완료갯수</p>
											</div>
										</div>
									</div>
									<!-- End Stats Item -->
									<h3 class="category-title"
										style="display: flex; justify-content: center">
										<input id="searchBar" placeholder="검색을 해주세요">
									</h3>
									<c:forEach var="p" items="${petsitter }">
										<div class="d-md-flex post-entry-2 half">
											<div class="mom-select-img">
												<div>사진</div>
											</div>
											<div>
												<div class="post-meta">
													<span class="date">00전 작성 </span> 
													<span>${p.ps_write_date }</span>
												</div>
												<div>
													<a href="momsitter.detail.go?ms_no=${p.ps_no }">맘시터: ${p.ps_id }(이름)</a>
													<span>나이</span>
													<span>성별</span>
													<span>cctv촬영 - ${p.ps_cctv }</span>
												</div>
												<div>시급: ${p.ps_pay }</div>
												<div class="mom-select-locations">
													<div>
														<div>활동 가능 지역:</div>
													</div>
													<div class="mom-select-location">
														<div>${p.ps_location1 }</div>
														<div>${p.ps_location2 }</div>
														<div>${p.ps_location3 }</div>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>



									<div class="text-start py-4"
										style="display: flex; justify-content: center;">
										<div class="custom-pagination">
											<a href="#" class="prev">Prevous</a> <a href="#"
												class="active">1</a> <a href="#">2</a> <a href="#">3</a> <a
												href="#">4</a> <a href="#">5</a> <a href="#" class="next">Next</a>
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
										aria-selected="true">Popular</button>
								</li>
								<li class="nav-item" role="presentation">
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
								</li>
							</ul>

							<div class="tab-content" id="pills-tabContent">

								<!-- Popular -->
								<div class="tab-pane fade show active" id="pills-popular"
									role="tabpanel" aria-labelledby="pills-popular-tab">
									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Sport</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">How to Avoid Distraction and Stay Focused
												During Video Calls?</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>


									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">Life Insurance And Pregnancy: A Working Mom’s
												Guide</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>


									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">10 Life-Changing Hacks Every Working Mom
												Should Know</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>
								</div>
								<!-- End Popular -->

								<!-- Trending -->
								<div class="tab-pane fade" id="pills-trending" role="tabpanel"
									aria-labelledby="pills-trending-tab">
									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">17 Pictures of Medium Length Hair in Layers
												That Will Inspire Your New Haircut</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Culture</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">9 Half-up/half-down Hairstyles for Long and
												Medium Hair</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">Life Insurance And Pregnancy: A Working Mom’s
												Guide</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Sport</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">How to Avoid Distraction and Stay Focused
												During Video Calls?</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>
									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Business</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">The Best Homemade Masks for Face (keep the
												Pimples Away)</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">10 Life-Changing Hacks Every Working Mom
												Should Know</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>
								</div>
								<!-- End Trending -->

								<!-- Latest -->
								<div class="tab-pane fade" id="pills-latest" role="tabpanel"
									aria-labelledby="pills-latest-tab">
									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">Life Insurance And Pregnancy: A Working Mom’s
												Guide</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Business</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">The Best Homemade Masks for Face (keep the
												Pimples Away)</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">10 Life-Changing Hacks Every Working Mom
												Should Know</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Sport</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">How to Avoid Distraction and Stay Focused
												During Video Calls?</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Lifestyle</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">17 Pictures of Medium Length Hair in Layers
												That Will Inspire Your New Haircut</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

									<div class="post-entry-1 border-bottom">
										<div class="post-meta">
											<span class="date">Culture</span> <span class="mx-1">&bullet;</span>
											<span>Jul 5th '22</span>
										</div>
										<h2 class="mb-2">
											<a href="#">9 Half-up/half-down Hairstyles for Long and
												Medium Hair</a>
										</h2>
										<span class="author mb-3 d-block">Jenny Wilson</span>
									</div>

								</div>
								<!-- End Latest -->

							</div>
						</div>

						<div class="aside-block">
							<h3 class="aside-title">Video</h3>
							<div class="video-post">
								<a href="https://www.youtube.com/watch?v=AiFfDjmd0jU"
									class="glightbox link-video"> <span class="bi-play-fill"></span>
									<img src="assets/img/post-landscape-5.jpg" alt=""
									class="img-fluid">
								</a>
							</div>
						</div>
						<!-- End Video -->

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
						<!-- End Tags -->

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