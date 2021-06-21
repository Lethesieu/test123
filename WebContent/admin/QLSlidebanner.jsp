<%@page import="DAO.slidebannerDAO"%>
<%@page import="Model.slidebanner"%>

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
 		slidebannerDAO slidebanner = new slidebannerDAO();
		List <slidebanner> listSlideBanner = slidebanner.getListslidebanner();
%>
<!-- header -->
<jsp:include page="header.jsp"></jsp:include>
<!-- header -->

<div id="wrapper">
	<!-- memnu -->
	<jsp:include page="menu.jsp"></jsp:include>
	<!-- memnu -->
	<div id="rightContent">
	<h3>Quản lí SlideBanner</h3>
	<a href = "addSlideBanner">Thêm slidebanner</a>
	
		<table class="data">
			<tr class="data">
				<th class="data" width="30px">STT</th>
				<th class="data">SlideBannerID</th>
				<th class="data">SlideBannerImage</th>
				<th class="data" width="75px">Tùy chọn</th>
			</tr>
			<% int i=1;
							for(slidebanner s:slidebannerDAO.getListslidebanner()){ 
								%>
								<tr class="data">
				<td class="data" width="30px"><%=i++%></td>
				<td class="data"><%=s.getSlidebannerID()%></td>
				<td class="data"><%=s.getSlidebannerImage()%></td>
				<td class="data" width="75px">
				<center>
				<a href="update_slidebanner?command=update&ma_slide=<%=s.getSlidebannerID()%>">Sửa</a>&nbsp;&nbsp; | &nbsp;&nbsp;
				<a href="qlSlideBanner?command=delete&ma_slide=<%=s.getSlidebannerID()%>">Xóa</a>
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
