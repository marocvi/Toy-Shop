<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="image" value="/resources/images"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<!-- banner -->
<div class="inner_page-banner one-img"></div>
<!--//banner -->
<div class="using-border py-3">
	<div class="inner_breadcrumb  ml-4">
		<ul class="short_ls">
			<li><a href="index.html">Home</a> <span>/ /</span></li>
			<li>Contact</li>
		</ul>
	</div>
</div>
<!-- //short-->
<!--contact -->
<section class="contact py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
		<h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Contact
			US</h3>
		<div class="contact-list-grid">
			<form action="#" method="post">
				<div class=" agile-wls-contact-mid">
					<div class="form-group contact-forms">
						<input type="text" class="form-control" placeholder="Name">
					</div>
					<div class="form-group contact-forms">
						<input type="email" class="form-control" placeholder="Enter">
					</div>
					<div class="form-group contact-forms">
						<input type="text" class="form-control" placeholder="Phone">
					</div>
					<div class="form-group contact-forms">
						<textarea class="form-control" rows="3"></textarea>
					</div>
					<button type="submit" class="btn btn-block sent-butnn" onclick="developmentAlert(event)">Send</button>
				</div>
			</form>
		</div>
	</div>
	<!--//contact-map -->
</section>
<!-- //Modal 1-->
<!--js working-->
<script src='${js}/jquery-2.2.3.min.js'></script>
<!--//js working-->
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
<!-- //OnScroll-Number-Increase-JavaScript -->