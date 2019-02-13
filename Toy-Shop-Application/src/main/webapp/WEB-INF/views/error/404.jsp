<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="image" value="/resources/images/"></c:url>
<c:url var="js" value="/resources/js/"></c:url>
<div class="inner_page-banner one-img"></div>
<!--//banner -->
<!-- short -->
<div class="using-border py-3">
	<div class="inner_breadcrumb  ml-4">
		<ul class="short_ls">
			<li><a href="index.html">Home</a> <span>/ /</span></li>
			<li>Icons</li>
		</ul>
	</div>
</div>
<section class="about-inner py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container-fluid py-lg-5 py-md-4 py-sm-4 py-3">
		<div class="page-not-agile text-center">
			<h4>404</h4>
			<div class="sub-text-page">
				<p>Sorry but the page that you requested doesn't exist</p>
			</div>
			<div class="icons-social pt-lg-4 pt-md-3 pt-3">
				<ul>
					<li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
					<li><a href="#"><span class="fas fa-envelope"></span></a></li>
					<li><a href="#"><span class="fas fa-rss"></span></a></li>
					<li><a href="#"><span class="fab fa-vk"></span></a></li>
				</ul>
			</div>
		</div>
	</div>
</section>
<!-- JS go here -->
<!-- //Modal 1-->
<!--js working-->
<script src='${js}jquery-2.2.3.min.js'></script>
<!--//js working-->
<!-- cart-js -->
<script src="${js}minicart.js"></script>
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
<script src="${js}move-top.js"></script>
<script src="${js}easing.js"></script>
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
<script src="${js}bootstrap.min.js"></script>
<!-- //bootstrap working-->
<!-- //OnScroll-Number-Increase-JavaScript -->
