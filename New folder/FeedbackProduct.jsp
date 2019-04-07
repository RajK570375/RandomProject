<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html xmlns="http://www.w3.org/1999/xhtml">


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Merchants</title>
<link type="text/css" href="resources/Css/style.css" rel="stylesheet"  />
<link type="text/css" href="resources/Css/login.css" rel="stylesheet"  />

 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js?ver=1.4.2"></script>
    <script src="resources/Script/login.js"></script>
    <script src="resources/Script/scripts.js"></script>
</head>


<body oncontextmenu="return false;">
<!--Header Section-->

<div class="header-tile"></div>
<div class="header" >
<div class="header-title">
<img src="resources/Images/fly.png" border="0" class="fly" height="3px" width="30px"  />
<img src="resources/Images/fly.png" border="0" class="fly1" height="3px" width="30px"/>
<img src="resources/Images/fly.png" border="0" class="fly2" height="3px" width="30px"/>Cap Store</div>
<!--Header Section->
<!--Search Bar Starts Here-->
<form action="tsearch" method="get">
<input  type="text" class="mainSearchBar" list="awards"  style="color: #000" title="Search" type="text" name="Search" onblur="showText()" onfocus="hideText();" value="" placeholder="       Search Here" >

<datalist id="awards" list="awards" class="datalist1">
<select>
<option value="Best Picture"></option>
<option value="Best Director"></option>
<option value="Best Adapted Screenplay"></option>
<option value="Best Original Screenplay"></option>
</select>
</datalist>

<input class="mainSubmit" value=" " type="submit" style="position:relative;margin-left:-76px;">
</form>
<!--Search Bar Ends Here-->      
</div>
   <!-- Logout Starts Here -->
	<div class="user">Welcome ${Adminname }
	<input  type="button" value="Logout" onclick="parent.location='Home.jsp'"></input></div>
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
   <li class='last'><a href='#'><span>Computers & Accessories</span></a></li>
</ul>
</div>  
  
     <!--navside-bar starts here  --> 
      <div class="navbox-sidebar">
<ul class="nav-sidebar">
			<li><a href="AddProductsByAdmin.jsp">Add Products</a></li>
<li><a href="DeleteProductsByAdmin.jsp">Delete Products</a></li>
<li><a href="ShowInventoryForAdmin.jsp">Show Inventory</a></li>
<li><a href="AllMerchants.jsp">Merchant Details</a></li>
<li><a href="Pending.jsp">Add Merchants</a></li>
<li><a href="CreateOfferByAdmin.jsp">Create Offers</a></li>
<li><a href="FeedbackMerchant">MerchantFeedback</a></li>
<li><a href="FeedbackProduct">ProductFeedback</a></li>

</ul>
</div>
    <!--navside-bar ends here  --> 
    
    <!--  -->
     <div class="middle-container">
<c:if test="${not empty list}">
	<table border="1">
		<tr>
			
			<th>PRODUCT FEEDBACK</th>	
			<th>RATING</th>
			<th>CUSTOMERID</th>
			
		</tr>
		<c:forEach var="feedback" items="${list}">
			<tr>
				<td>${feedback.productFeedback}</td>
				<td>${feedback.rating}</td>
				<td>${feedback.customer.customerId}</td>		
				<td><button id="m_feed">Forward</button></td>					
			</tr>
		</c:forEach>
	</table>
	</c:if>
	<c:if test="${empty list}"> NO RECORDS FOUND </c:if>
      </div> 
 
<!--Footer Section-->
<div class="right-border"></div>
<div class="footer">@Copyright Cap Store</div>
<div class="footer-tile"></div>
<!--Footer Section-->
</body>
</html>