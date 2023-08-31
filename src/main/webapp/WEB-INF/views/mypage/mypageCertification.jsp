<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div style="display: flex;">
			<div>
				<div>맘시터</div>
				<c:forEach var="mc" items="${msconfirm }">
					<div style="display: flex">
						<div>이름 : ${mc.mm.user_name }</div>
						<div>아이디 : ${mc.ms_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${mc.ms_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div>
							<form action="mypage.MsAccept.go">
								<input name="ms_id" value="${mc.ms_id }" hidden="hidden">
								<button>accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.MsReject.go">
								<input name="ms_id" value="${mc.ms_id }" hidden="hidden">
								<button>reject</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<div>
				<div>케어시터</div>
				<c:forEach var="cc" items="${csconfirm }">
					<div style="display: flex">
						<div>이름 : ${cc.mm.user_name }</div>
						<div>아이디 : ${cc.cs_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${cc.cs_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div>
							<form action="mypage.CsAccept.go">
								<input name="cs_id" value="${cc.cs_id }" hidden="hidden">
								<button>accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.CsReject.go">
								<input name="cs_id" value="${cc.cs_id }" hidden="hidden">
								<button>reject</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<div>
				<div>펫시터</div>
				<c:forEach var="pc" items="${psconfirm }">
					<div style="display: flex">
						<div>이름 : ${pc.mm.user_name }</div>
						<div>아이디 : ${pc.ps_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${pc.ps_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div>
							<form action="mypage.PsAccept.go">
								<input name="ps_id" value="${pc.ps_id }" hidden="hidden">
								<button>accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.PsReject.go">
								<input name="ps_id" value="${pc.ps_id }" hidden="hidden">
								<button>reject</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div style="display: flex;">
			<div>
				<div>맘테이커</div>
				<c:forEach var="mc" items="${mtconfirm }">
					<div style="display: flex">
						<div>이름 : ${mc.mm.user_name }</div>
						<div>아이디 : ${mc.mt_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${mc.mt_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div>
							<form action="mypage.MtAccept.go">
								<input name="mt_id" value="${mc.mt_id }" hidden="hidden">
								<button>accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.MtReject.go">
								<input name="mt_id" value="${mc.mt_id }" hidden="hidden">
								<button>reject</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<div>
				<div>케어테이커</div>
				<c:forEach var="cc" items="${ctconfirm }">
					<div style="display: flex">
						<div>이름 : ${cc.mm.user_name }</div>
						<div>아이디 : ${cc.ct_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${cc.ct_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div>
							<form action="mypage.CtAccept.go">
								<input name="ct_id" value="${cc.ct_id }" hidden="hidden">
								<button>accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.CtReject.go">
								<input name="ct_id" value="${cc.ct_id }" hidden="hidden">
								<button>reject</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
			<div>
				<div>펫테이커</div>
				<c:forEach var="pc" items="${ptconfirm }">
					<div style="display: flex">
						<div>이름 : ${pc.mm.user_name }</div>
						<div>아이디 : ${pc.pt_id }</div>

						<div>
							<form action="download" method="post">
								<input type="hidden" name="name" value="${pc.pt_file }" /> <input
									type="submit" value="download" />
							</form>
						</div>
						<div>
							<form action="mypage.PtAccept.go">
								<input name="pt_id" value="${pc.pt_id }" hidden="hidden">
								<button>accept</button>
							</form>
						</div>
						<div>
							<form action="mypage.PtReject.go">
								<input name="pt_id" value="${pc.pt_id }" hidden="hidden">
								<button>reject</button>
							</form>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>



</body>
</html>