<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <style>
@font-face {
	font-family: 'CustomFont';
	src: url('<%= request.getContextPath() %>/resources/css/sur.ttf')
		format('truetype');
	/* 다른 폰트 포맷에 대한 지원을 추가할 수 있습니다. */
}

body {
	font-family: 'CustomFont', sans-serif;
	font-size: 16px;
	width: 80vw;
	height: 1600px;

}

.certif-btn {
	width: 100px;
	margin-top: 5px;
	background-color: #e7b5ac;
}

.sitterC {
	display: flex;
	flex-wrap: wrap;
	justify-content: space-between;
}

.sitterC-in {
	width: calc(20% - 20px);
	margin-bottom: 20px;
	display: flex;
	flex-direction: column;
	background-color: white;/*  rgba(255, 255, 255, 0.5); */
	border: 3px solid gray;
	border-radius: 5%;
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px;
	  box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
	
}

.C-name {
	font-size: 15pt;
}


.C-btn {
	width: 100%;
	display: flex;
	justify-content: space-around;
}


</style>
<body>
	<div class="certifContainer">
		<!-- <div style="display: flex;"> -->
				<div class="C-name">맘시터</div>
			<div class="sitterC">
				<c:forEach var="mc" items="${msconfirm }">
					<div class="sitterC-in">
					<!-- <div style="display: flex"> -->
						<div>이름 : ${mc.mm.user_name }</div>
						<div>아이디 : ${mc.ms_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${mc.ms_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
				<div class="C-btn">
					<div>
						<form action="mypage.MsAccept.go">
							<input name="ms_id" value="${mc.ms_id }" hidden="hidden">
							<button class="certif-btn">accept</button>
						</form>
					</div>
					<div>
						<form action="mypage.MsReject.go">
							<input name="ms_id" value="${mc.ms_id }" hidden="hidden">
							<button class="certif-btn">reject</button>
						</form>
					</div>
				</div>
				<!-- </div> -->
					</div>
				</c:forEach>
			</div>
			
			
				<div class="C-name">케어시터</div>
				<div class="sitterC">
				<c:forEach var="cc" items="${csconfirm }">
	<div class="sitterC-in">
					
						<div>이름 : ${cc.mm.user_name }</div>
						<div>아이디 : ${cc.cs_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${cc.cs_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						
					<div class="C-btn">
						<div>
							<form action="mypage.CsAccept.go">
								<input name="cs_id" value="${cc.cs_id }" hidden="hidden">
								<button class="certif-btn">accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.CsReject.go">
								<input name="cs_id" value="${cc.cs_id }" hidden="hidden">
								<button class="certif-btn">reject</button>
							</form>
						</div>
					</div>
					
	</div>
				</c:forEach>
			</div>
			
				
		
				<div class="C-name">펫시터</div>
			<div class="sitterC">
				<c:forEach var="pc" items="${psconfirm }">
					<div class="sitterC-in">
						<div>이름 : ${pc.mm.user_name }</div>
						<div>아이디 : ${pc.ps_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${pc.ps_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div class="C-btn">
						<div>
							<form action="mypage.PsAccept.go">
								<input name="ps_id" value="${pc.ps_id }" hidden="hidden">
								<button class="certif-btn">accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.PsReject.go">
								<input name="ps_id" value="${pc.ps_id }" hidden="hidden">
								<button class="certif-btn">reject</button>
							</form>
						</div>
						</div>
					</div>
					
				</c:forEach>
			</div>
		
		<!-- </div> -->
		
		<!-- <div style="display: flex;"> -->
			<div>
				<div class="C-name">맘테이커</div>
				<div class="sitterC">
				<c:forEach var="mc" items="${mtconfirm }">
						<div class="sitterC-in">
						<div>이름 : ${mc.mm.user_name }</div>
						<div>아이디 : ${mc.mt_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${mc.mt_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>

						<div class="C-btn">
							<div>
								<form action="mypage.MtAccept.go">
									<input name="mt_id" value="${mc.mt_id }" hidden="hidden">
									<button class="certif-btn">accept</button>
								</form>
							</div>
							<div>
								<form action="mypage.MtReject.go">
									<input name="mt_id" value="${mc.mt_id }" hidden="hidden">
									<button class="certif-btn">reject</button>
								</form>
							</div>
						</div>


					</div>
				</c:forEach>
				</div>
			</div>

			<div>
				<div class="C-name">케어테이커</div>
				<div class="sitterC">
				<c:forEach var="cc" items="${ctconfirm }">
				<div class="sitterC-in">
						<div>이름 : ${cc.mm.user_name }</div>
						<div>아이디 : ${cc.ct_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${cc.ct_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div class="C-btn">
						<div>
							<form action="mypage.CtAccept.go">
								<input name="ct_id" value="${cc.ct_id }" hidden="hidden">
								<button class="certif-btn">accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.CtReject.go">
								<input name="ct_id" value="${cc.ct_id }" hidden="hidden">
								<button class="certif-btn">reject</button>
							</form>
						</div>
					
				</div>					
				</c:forEach>
				</div>
						</div>
			</div>
			<div>
				<div class="C-name">펫테이커</div>
				<div class="sitterC">
				<c:forEach var="pc" items="${ptconfirm }">
<div class="sitterC-in">
						<div>이름 : ${pc.mm.user_name }</div>
						<div>아이디 : ${pc.pt_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${pc.pt_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div class="C-btn">
						<div>
							<form action="mypage.PtAccept.go">
								<input name="pt_id" value="${pc.pt_id }" hidden="hidden">
								<button class="certif-btn">accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.PtReject.go">
								<input name="pt_id" value="${pc.pt_id }" hidden="hidden">
								<button class="certif-btn">reject</button>
							</form>
						</div>
						</div>
</div>				
				
				</c:forEach>
				</div>
			</div>
		<!-- </div> -->
	
	</div>



</body>
</html>