<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<c:url var="css" value="/resources/css/"></c:url>
<c:url var="js" value="/resources/js/"></c:url>
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
<link href="${css}/JiSlider.css" rel="stylesheet">
<!--Shoping cart-->
<link rel="stylesheet" href="${css}/shop.css" type="text/css" />
<!--//Shoping cart-->
<!--stylesheets-->
<link href="${css}/style.css" rel='stylesheet' type='text/css'
	media="all">
<!--//stylesheets-->
<link href="//fonts.googleapis.com/css?family=Sunflower:500,700"
	rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet">

</head>
<body>


	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="banner" />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />







	<!--js working-->
	<script src='${js}/jquery-2.2.3.min.js'></script>
	<!--//js working-->

	</script>
	<!-- cart-js -->
	<script src="${js}/minicart.js"></script>
	<script>
		toys.render();

		toys.cart.on('toys_checkout', function(evt) {
			var items, len, i;

			if (this.subtotal() > 0) {
				items = this.items();

				for (i = 0, len = items.length; i < len; i++) {
				}
			}
		});
	</script>
	<!-- //cart-js -->
	<!--responsiveslides banner-->
	<script src="${js}/responsiveslides.min.js"></script>
	<script>
		// You can also use "$(window).load(function() {"
		$(function() {
			// Slideshow 4
			$("#slider4").responsiveSlides({
				auto : true,
				pager : false,
				nav : true,
				speed : 900,
				namespace : "callbacks",
				before : function() {
					$('.events').append("<li>before event fired.</li>");
				},
				after : function() {
					$('.events').append("<li>after event fired.</li>");
				}
			});

		});
	</script>
	<!--// responsiveslides banner-->



	<!--slider flexisel -->
	<script src="${js}/jquery.flexisel.js"></script>
	<script>
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems : 3,
				animationSpeed : 3000,
				autoPlay : true,
				autoPlaySpeed : 2000,
				pauseOnHover : true,
				enableResponsiveBreakpoints : true,
				responsiveBreakpoints : {
					portrait : {
						changePoint : 480,
						visibleItems : 1
					},
					landscape : {
						changePoint : 640,
						visibleItems : 2
					},
					tablet : {
						changePoint : 768,
						visibleItems : 2
					}
				}
			});

		});
	</script>
	<!-- //slider flexisel -->
	<!-- start-smoth-scrolling -->
	<script src="${js}/move-top.js"></script>
	<script src="${js}/easing.js"></script>
	<script>
		jQuery(document).ready(function($) {
			$(".scroll").click(function(event) {
				event.preventDefault();
				$('html,body').animate({
					scrollTop : $(this.hash).offset().top
				}, 900);
			});
		});
	</script>
	<!-- start-smoth-scrolling -->
	<!-- here stars scrolling icon -->
	<script>
		$(document).ready(function() {

			var defaults = {
				containerID : 'toTop', // fading element id
				containerHoverID : 'toTopHover', // fading element hover id
				scrollSpeed : 1200,
				easingType : 'linear'
			};
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<!-- //here ends scrolling icon -->
	<!--bootstrap working-->
	<script src="${js}/bootstrap.min.js"></script>
	<!-- //bootstrap working-->
	<script>
	$(window).bind("load", function() { 
		
	
		if(${verifyError!=null}){
			alert("${verifyError}");
		}
		else if(${verifySucess!=null}){
			alert("${verifySucess}")
		}
	
	})
		
	</script>
</body>
</html>