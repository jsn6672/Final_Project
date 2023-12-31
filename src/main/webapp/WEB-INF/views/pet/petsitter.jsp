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

<script type="text/javascript">
      $(function() {

    	const write_date = $('#write_date').text();
    	
    	console.log(write_date);
    	console.log(new Date(write_date));
        
        
      	const test = $(".date").text(elapsedTime(write_date));
		console.log(test);


      }) //레디펑션

      const TIME_ZONE = 3240 * 10000;

      function elapsedTime(date) {
    	  console.log(date);
        const start = new Date(date);
        console.log(start);
        console.log('-----------')
        const end = new Date(new Date().getTime() + TIME_ZONE); // 현재 날짜

        const diff = (end - start) / 1000; // 경과 시간
        console.log(start);
        console.log(end);
        console.log(diff);

        const times = [
          { name: '년', milliSeconds: 60 * 60 * 24 * 365 },
          { name: '개월', milliSeconds: 60 * 60 * 24 * 30 },
          { name: '일', milliSeconds: 60 * 60 * 24 },
          { name: '시간', milliSeconds: 60 * 60 },
          { name: '분', milliSeconds: 60 },
        ];

        // 년 단위부터 알맞는 단위 찾기
        for (const value of times) {
          const betweenTime = Math.floor(diff / value.milliSeconds);

          console.log(betweenTime);
          const namevalue = value.name;
          console.log(namevalue);

          // 큰 단위는 0보다 작은 소수 단위 나옴
          if (betweenTime > 0) {
          	console.log(namevalue);
          	return betweenTime + namevalue + "전";
          }
        }

        // 모든 단위가 맞지 않을 시
        return "방금 전";
      }
    </script>

</head>

<body>

	<main id="main">
		<section style="background-color: #EDE7F6;  height: 46vw;">
			<div class="container">
				<div class="row">

					<div class="col-md-9" data-aos="fade-up">
						<!-- ======= Stats Counter Section ======= -->
						<section id="stats-counter" class="stats-counter section-bg">
							<div class="container">
								<div class="row gy-4">
									<form action="page.change2">
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
											<div
												style="background-color: white; border: 2px solid white; width: 20%; border-radius: 10px;">
												<div class="mom-select-img">
													<div>
														<img alt="" src="resources/img/${p.mm.user_pic }">
													</div>
												</div>
											</div>
											<div style="padding-left: 25px;">
												<div class="post-meta">
													<span class="date">00전 작성 </span> <span>${p.ps_write_date }</span>
												</div>
												<div>
													<a href="petsitter.detail.go?ps_id=${p.ps_id }">펫시터:${p.mm.user_name }</a>
													<span>${p.mm.user_age }세</span>
													<c:choose>
														<c:when test="${p.mm.user_gender eq 'female'}">
															<span>여</span>
														</c:when>
														<c:otherwise>
															<span>남</span>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${p.ps_cctv == 1 }">
															<span>CCTV촬영 - 가능</span>
														</c:when>
														<c:otherwise>
															<span>CCTV촬영 - 불가능</span>
														</c:otherwise>
													</c:choose>
												</div>
												<div style="display: flex;">
													<div>시급: ${p.ps_pay }</div>
													<div style="margin-left: 10px;">
														<c:choose>
															<c:when test="${p.ps_term  == 1}">
																<div style="margin-left: 10px;">(정기)</div>
															</c:when>
															<c:otherwise>
																<div style="margin-left: 10px;">(단기)</div>
															</c:otherwise>
														</c:choose>
													</div>
												</div>
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
									<div class="row mt-5">
										<div class="col text-center">
											<div class="text-start py-4"
												style="display: flex; justify-content: center;">
												<div class="custom-pagination">
													<c:if test="${curPage != 1 }">
														<a
															href="page.change2?p=${curPage - 1}&ps_search=${searchSession.ps_search}"
															class="prev">Previous</a>
													</c:if>
													<c:forEach begin="${startPage}" end="${endPage}"
														varStatus="loop">
														<c:choose>
															<c:when test="${curPage == loop.index}">
																<a
																	href="page.change2?p=${loop.index}&ps_search=${searchSession.ps_search}"
																	class="active">${loop.index}</a>
															</c:when>
															<c:otherwise>
																<a
																	href="page.change2?p=${loop.index}&ps_search=${searchSession.ps_search}">${loop.index}</a>
															</c:otherwise>
														</c:choose>
													</c:forEach>
													<c:if test="${curPage != pageCount }">
														<a
															href="page.change2?p=${curPage + 1}&ps_search=${searchSession.ps_search}"
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
<!-- 								<li class="nav-item" role="presentation">
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
								<c:forEach var="p" items="${ss }">

									<div class="tab-pane fade show active" id="pills-popular"
										role="tabpanel" aria-labelledby="pills-popular-tab">
										<div class="post-entry-1 border-bottom">
											<div class="post-meta">
												<span class="mx-1">&bullet;</span> <span>${p.ps_write_date }전
													작성</span>
											</div>
											<span class="author mb-3 d-block"> <a
												href="pettaker.detail.go?d_no=${p.ps_id }">대상:
													${p.mm.user_name }</a> 시급: ${p.ps_pay }원
											</span> <span class="author mb-3 d-block">지역:
												${p.ps_location1  }</span>
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