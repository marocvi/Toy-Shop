<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<c:url var="css" value="/resources/css/"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<c:url var="image" value="/resources/images/"></c:url>
<!-- Titles -->
<title><tiles:getAsString name="title" /></title>
<!--meta tags -->
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords"
	content="Toys Shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
         Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- Add favicon -->
<link href="${image}/favicon.ico" rel="shortcut icon">
<!--//meta tags ends here-->
<!--booststrap-->
<link href="${css}/bootstrap.min.css" rel="stylesheet" type="text/css"
	media="all">

<!--//booststrap end-->
<!-- font-awesome icons -->
<link href="${css}/fontawesome-all.min.css" rel="stylesheet"
	type="text/css" media="all">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- //font-awesome icons -->
<!-- For Clients slider -->
<link rel="stylesheet" href="${css}/flexslider.css" type="text/css"
	media="all" />
<!--flexs slider-->

<!--Shoping cart-->
<link rel="stylesheet" href="${css}/shop.css" type="text/css" />
<!--//Shoping cart-->
<!--stylesheets-->
<link href="${css}/style.css" rel='stylesheet' type='text/css'
	media="all">
<link href="${css}/jquery-ui1.css" rel="stylesheet" type="text/css">
<link href="${css}/checkout.css" rel="stylesheet" type="text/css">
<link href="${css}/creditly.css" rel="stylesheet" type="text/css">
<link href="${css}/easy-responsive-tabs.css" rel="stylesheet"
	type="text/css">
<link href="${css}/shop.css" rel="stylesheet" type="text/css">

<!--//stylesheets-->
<link href="//fonts.googleapis.com/css?family=Sunflower:500,700"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">
<!-- Custome CSS -->
<link href="${css}/mystyle.css" rel="stylesheet" type="text/css">
<c:set var="contextURL" value="${pageContext.request.contextPath}" scope="session"></c:set>
<script>
window.contextURL = "${contextURL}";
</script>
</head>
<body>


	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="banner" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />







	<script type="text/javascript">
	//Show login modal
	$(document).ready(function(){
		 if(${verifySucess!=null}){
			//show modal
			$("#exampleModal").modal("show");
			//Ative login tab
			$('.nav-tabs a[href="#login"]').tab('show');	
		}
		else if(${loginError!=null}){
			//show modal
			$("#exampleModal").modal("show");
			//Ative login tab
			$('.nav-tabs a[href="#login"]').tab('show');	
		}
		else if(${logoutSucess!=null}){
			//show modal
			$("#exampleModal").modal("show");
			//Ative login tab
			$('.nav-tabs a[href="#login"]').tab('show');	
		}
		else if(${loginRequire!=null}){
			//show modal
			$("#exampleModal").modal("show");
			//Ative login tab
			$('.nav-tabs a[href="#login"]').tab('show');	
		}
		if(${signupError!=null}){
			//show modal
			$("#exampleModal").modal("show");
			//Ative signup tab
			$('.nav-tabs a[href="#create-user"]').tab('show');
			
		}
	})
	
	</script>
	<!--  Alert function is not develop yet -->
	
	<script type="text/javascript">
	function developmentAlert(event) {
		event.preventDefault();
		alert("Sorry!. This type of function is in development mode");
	}
	</script>
</body>
</html>