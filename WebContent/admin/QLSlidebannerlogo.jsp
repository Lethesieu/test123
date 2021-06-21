<%@page import="DAO.slidebannerLogoDAO"%>
<%@page import="Model.slidebannerLogo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>LT-SHOP Dashboard</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Copyright" content="arirusmanto.com">
<meta name="description" content="Admin MOS Template">
<meta name="keywords" content="Admin Page">
<meta name="author" content="Ari Rusmanto">
<meta name="language" content="Bahasa Indonesia">

<link rel="shortcut icon" href="stylesheet/img/devil-icon.png"> <!--Pemanggilan gambar favicon-->
<link rel="stylesheet" type="text/css" href="mos-css/mos-style.css"> <!--pemanggilan file css-->
</head>

<body>
<%
 		slidebannerLogoDAO slidebannerLogo = new slidebannerLogoDAO();
		List <slidebannerLogo> listSlideBanner = slidebannerLogo.getListslidebannerLogo();
%>
<!-- header -->
<jsp:include page="header.jsp"></jsp:include>
<!-- header -->

<div id="wrapper">
	<!-- memnu -->
	<jsp:include page="menu.jsp"></jsp:include>
	<!-- memnu -->
	<div id="rightContent">
	<h3>Quản lí SlideLogo</h3>
	<a href = "addSlidebannerLogo">Thêm slideLogo</a>
	
	
		<table class="data">
			<tr class="data">
				<th class="data" width="30px">STT</th>
				<th class="data">SlideBannerID</th>
				<th class="data">SlideBannerImage</th>
				<th class="data" width="75px">Tùy chọn</th>
			</tr>
			<% int i=1;
							for(slidebannerLogo s:slidebannerLogoDAO.getListslidebannerLogo()){ 
								%>
								<tr class="data">
				<td class="data" width="30px"><%=i++%></td>
				<td class="data"><%=s.getSlidebannerLogoID()%></td>
				<td class="data"><%=s.getSlidebannerLogoName()%></td>
				<td class="data" width="75px">
				<center>
				<a href="update_slidebannerLogo?command=update&ma_slide=<%=s.getSlidebannerLogoID()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
				<a href="qlSlidebannerLogo?command=delete&ma_slide=<%=s.getSlidebannerLogoID()%>">Xóa</a>
				</center>
				</td>
			
			<% 
			}
				%>
				</tr>
		</table>
	</div>
<!-- footer -->
<jsp:include page="footer.jsp"></jsp:include>
<!-- footer -->
</div>
</div>
</body>
</html>
