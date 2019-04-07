<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>FeedbackPerticularProduct</title>
<link type="text/css" href="resources/Css/style.css" rel="stylesheet" />
<link type="text/css" href="resources/Css/login.css" rel="stylesheet" />
<!-- <script src="resources/Script/SearchScript.js"></script> -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
<script src="resources/Script/login.js"></script>
<script src="resources/Script/scripts.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script src="resources/Script/jquery-2.0.3.min.js"></script>
<script src="resources/Script/jquery.slides.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/Css/example.css">
		<link rel="stylesheet" href="resources/Css/font-awesome.min.css">

			<style>
.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<body oncontextmenu="return false;">
	<!--Header Section-->
	<div class="header-tile"></div>
	<div class="header">
		<div class="header-title">
			<img src="resources/Images/fly.png" border="0" class="fly"
				height="3px" width="30px" /> <img src="resources/Images/fly.png"
				border="0" class="fly1" height="3px" width="30px" /> <img
				src="resources/Images/fly.png" border="0" class="fly2" height="3px"
				width="30px" />Cap Store
		</div>

		<form action="tsearch" method="get">
			<input type="text" class="mainSearchBar" list="awards"
				style="color: #000" title="query" type="text" id="query"
				name="query" onblur="showText()" onfocus="hideText();" value=""
				placeholder="       Search Here">
				<div id="InitializeSearch"></div> <input class="mainSubmit"
				value=" " id="searchbutton" type="button"
				style="position: relative; margin-left: -76px;">
		</form>
		<!--Search Bar Ends Here-->
	</div>

	<!-- Logout Starts Here -->
	<div class="user">
		Welcome ${Customername } <input type="button" value="Logout"
			onclick="parent.location='Home.jsp'"></input>
	</div>
	<!-- Logout Ends Here -->
	<div class="left-border"></div>
	<!--Header Section Ends Here-->
	<!--Menu Section-->
	<div id='cssmenu'>
		<ul>
			<li class='active'><a href='Home.jsp'><span>Home</span></a></li>
			<li><a href='#'><span>Mobiles @ Accessories</span></a></li>
			<li><a href='#'><span>Clothing</span></a></li>
			<li><a href='#'><span>Footwears</span></a></li>
			<li><a href='#'><span>Cosmetics</span></a></li>
			<li class='last'><a href='#'><span>Computers &
						Accessories</span></a></li>
		</ul>
	</div>
	<!--Menu Section-->
	<div style="margin-top: 7%; margin-left: 30%">
	<form action="addProductFeedback" method="get">
		<table>
			<tr>
				<td>Enter Feedback</td>
				<td><textarea id="feedback" name="feedback" rows=10 cols=30></textarea></td>
			</tr>
			<tr>
				<td>Enter Rating between 1 to 5</td>
				<td><input type=text id="rating" name="rating"></input></td>
			</tr>
			<tr>
				<td><input type="submit" class="button"></input></td>
			</tr>
		</table>
		</form>
	</div>
	<!--Footer Section-->
	<div class="right-border"></div>
	<div class="footer">@Copyright Cap Store</div>
	<div class="footer-tile"></div>
	<!--Footer Section-->
</body>
</html>
