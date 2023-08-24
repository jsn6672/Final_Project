<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 이용내역 페이지의 전체 컨테이너 -->
	<div class="mpU">
		<h1>이용내역</h1>
	</div>
	<!-- 시터 등록 및 수정 페이지의 전체 컨테이너 -->
	<div class="mpS">
		<!-- <h1>시터 등록 및 수정</h1> -->
		<div>시터 요청</div>
		<div>${SitterNotice }</div>
		<!-- 페이지 본문 컨테이너 -->
		<div id="Accordion_wrap">
			<c:forEach items="${contractSitterInfo }" var="s">
				<div class="message">
					<c:if test="${s.cnt_type eq 3 }">
						<span>${s.cnt_memberDTO.user_name }님에게 펫시터가 되어달라는 신청이
							들어왔습니다.</span>
					</c:if>
					<c:if test="${s.cnt_type eq 2 }">
						<span>${s.cnt_memberDTO.user_name }님에게 맘시터가 되어달라는 신청이
							들어왔습니다.</span>
					</c:if>
					<c:if test="${s.cnt_type eq 1 }">
						<span>${s.cnt_memberDTO.user_name }님에게 요양시터가 되어달라는 신청이
							들어왔습니다.</span>
					</c:if>
				</div>
				<div class="messageans">
					<div
						onclick="location.href='detail.go?inquiry_no=${s.cnt_dolbomdto.d_no}'">이름
						: ${s.cnt_dolbomdto.d_name}</div>
					<div>나이 : ${s.age }${s.agetype }</div>
					<div>활동 : ${s.cnt_can_do }</div>
					<c:if test="${s.cnt_sitter_ok eq 1 and s.cnt_dolbom_ok eq 1}">
						<div style="display: flex; justify-content: flex-end; gap: 10px;">
							<span
								onclick="location.href='cntSitterUpdate.do?cnt_no=${s.cnt_no}'">체결</span>
							<span
								onclick="location.href='cntSitterUpdate.nope?cnt_no=${s.cnt_no}'">거절</span>
							<span>삭제</span>
						</div>
					</c:if>
					<c:if test="${s.cnt_sitter_ok eq 1 and s.cnt_dolbom_ok eq 2}">
						<div style="display: flex; justify-content: flex-end; gap: 10px;">
							상대가 체결버튼을 눌렀습니다 시터가 되시려면 체결버튼을 눌러주세요 <span
								onclick="location.href='cntSitterUpdate.do?cnt_no=${s.cnt_no}'">체결</span>
							<span
								onclick="location.href='cntSitterUpdate.nope?cnt_no=${s.cnt_no}'">거절</span>
							<span>삭제</span>
						</div>
					</c:if>
					<c:if test="${s.cnt_sitter_ok eq 2 and s.cnt_dolbom_ok eq 1}">
						<div style="display: flex; justify-content: flex-end; gap: 10px;">
							아직 상대편에서 체결버튼을 누르지 않았습니다 확인해주세요^^</div>
					</c:if>
					<c:if test="${s.cnt_sitter_ok eq 2 and s.cnt_dolbom_ok eq 2}">
						<div style="display: flex; justify-content: flex-end; gap: 10px;">
							계약이 체결되었습니다 체결되지 않은 나머지 신청은 거절을 눌러주세요</div>
					</c:if>
				</div>

			</c:forEach>
		</div>
		<hr>
		<div>테이커 요청</div>
		<div>${TakerNotice }</div>
		<div id="Accordion_wrap">
			<c:forEach items="${contractTakerInfo }" var="s">
				<div class="message">${s.d_name }</div>
				<div class="messageans">
					<c:choose>
						<c:when test="${s.cntDTOMessage eq '1' }">
							<c:forEach items="${s.cntDTOs }" var="ss">

								<div class="message">${ss.cnt_memberDTO.user_name }께서시터가
									되고 싶다는 요청을 하셨습니다</div>
								<div class="messageans">
									<div>
										사진 : <img alt=""
											src="resources/img/${ss.cnt_memberDTO.user_pic }"
											width="100px">
									</div>
									<div>나이 : ${ss.age }</div>
									<div>이름 : ${ss.cnt_memberDTO.user_name }</div>
									<div>활동 : ${ss.cnt_can_do }</div>
									<c:if test="${ss.cnt_dolbom_ok eq 1 and ss.cnt_sitter_ok eq 1}">
										<div
											style="display: flex; justify-content: flex-end; gap: 10px;">
											<span
												onclick="location.href='cntDolbomUpdate.do?cnt_no=${ss.cnt_no}'">체결</span>
											<span
												onclick="location.href='cntDolbomUpdate.nope?cnt_no=${ss.cnt_no}'">거절</span>
											<span>삭제</span>
										</div>
									</c:if>
									<c:if test="${ss.cnt_dolbom_ok eq 1 and ss.cnt_sitter_ok eq 2}">
										<div
											style="display: flex; justify-content: flex-end; gap: 10px;">
											상대가 체결버튼을 눌렀습니다 시터로 맞아주시려면 체결버튼을 눌러주세요 <span
												onclick="location.href='cntDolbomUpdate.do?cnt_no=${ss.cnt_no}'">체결</span>
											<span
												onclick="location.href='cntDolbomUpdate.nope?cnt_no=${ss.cnt_no}'">거절</span>
											<span>삭제</span>
										</div>
									</c:if>
									<c:if test="${ss.cnt_dolbom_ok eq 2 and ss.cnt_sitter_ok eq 1}">
										<div
											style="display: flex; justify-content: flex-end; gap: 10px;">
											아직 상대편에서 체결버튼을 누르지 않았습니다 확인해주세요^^</div>
									</c:if>
									<c:if test="${ss.cnt_dolbom_ok eq 2 and ss.cnt_sitter_ok eq 2}">
										<div
											style="display: flex; justify-content: flex-end; gap: 10px;">
											계약이 체결되었습니다 체결되지 않은 나머지 신청은 거절을 눌러주세요
											 </div>
									</c:if>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div>${s.cntDTOMessage }</div>
						</c:otherwise>

					</c:choose>
				</div>

			</c:forEach>
		</div>

	</div>
</body>
</html>