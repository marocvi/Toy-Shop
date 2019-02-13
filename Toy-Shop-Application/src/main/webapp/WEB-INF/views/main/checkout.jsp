<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="image" value="/resources/images"></c:url>
<c:url var="js" value="/resources/js"></c:url>
<!-- banner -->
<div class="inner_page-banner one-img"></div>
<!-- short -->
<div class="using-border py-3">
	<div class="inner_breadcrumb  ml-4">
		<ul class="short_ls">
			<li><a href="index.html">Home</a> <span>/ /</span></li>
			<li>Checkout</li>
		</ul>
	</div>
</div>
<!-- //short-->
<!--Checkout-->
<!-- //banner -->
<!-- top Products -->
<section class="checkout py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-4 py-sm-4 py-3">
		<div class="shop_inner_inf">
			<div class="privacy about">
				<h3>
					Chec<span>kout</span>
				</h3>
				<p id="test"></p>
				<br>
				<div class="checkout-right">
					<table class="timetable_sub">
						<thead>
							<tr>
								<th>SL No.</th>
								<th>Product</th>
								<th>Quality</th>
								<th>Product Name</th>
								<th>Price</th>
								<th>Remove</th>
							</tr>
						</thead>
						<tbody id="tableItems">
							<tr class="rem1">
								<td class="invert">1</td>
								<td class="invert-image"><a href="single.html"> <img
										src="${image}/f1.jpg" alt=" " class="img-responsive "></a>
									<ul>
										<li>Color: <strong>Green</strong>
										</li>
										<li>Size: <strong>Big</strong>
										</li>
									</ul></td>
								<td class="invert">
									<div class="quantity">
										<div class="quantity-select">
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value">
												<span>1</span>
											</div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</td>
								<td class="invert">Bella Toes</td>
								<td class="invert">$675.00</td>
								<td class="invert">
									<div class="rem">
										<div class="close1"></div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="checkout-left">
					<div class="col-md-4 checkout-left-basket">
						<h4>Continue to basket</h4>
						<ul id="total">
							<li>Price Total<i>-</i> <span>$1500</span></li>
							<li>Total Service Charges <i>-</i> <span>$55.00</span></li>
							<li>Total <i>-</i> <span>$1405.00</span></li>
						</ul>
					</div>
					<div class="col-md-8 address_form">
						<h4>Add a new Details</h4>
						<form action="payment.html" method="post"
							class="creditly-card-form agileinfo_form">
							<section class="creditly-wrapper wrapper">
								<div class="information-wrapper">
									<div class="first-row form-group">
										<div class="controls">
											<label class="control-label">Full name: </label> <input
												class="billing-address-name form-control" type="text"
												name="name" placeholder="Full name">
										</div>
										<div class="card_number_grids">
											<div class="card_number_grid_left">
												<div class="controls">
													<label class="control-label">Mobile number:</label> <input
														class="form-control" type="text"
														placeholder="Mobile number">
												</div>
											</div>
											<div class="card_number_grid_right">
												<div class="controls">
													<label class="control-label">Landmark: </label> <input
														class="form-control" type="text" placeholder="Landmark">
												</div>
											</div>
											<div class="clear"></div>
										</div>
										<div class="controls">
											<label class="control-label">Town/City: </label> <input
												class="form-control" type="text" placeholder="Town/City">
										</div>
										<div class="controls">
											<label class="control-label">Address type: </label> <select
												class="form-control option-w3ls">
												<option>Office</option>
												<option>Home</option>
												<option>Commercial</option>
											</select>
										</div>
									</div>
									<button class="submit check_out">Delivery to this
										Address</button>
								</div>
							</section>
						</form>
						<div class="checkout-right-basket">
							<a href="payment.html">Make a Payment </a>
						</div>
					</div>
					<div class="clearfix"></div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!-- //top products -->
	</div>
</section>
<!-- JS WORKING  -->
<!-- //Modal 1-->
<!--${js} working-->
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
<!--// cart-js -->

<!--quantity-->
<script>
	$('.value-plus')
			.on(
					'click',
					function() {
						var divUpd = $(this).parent().find('.value'), newVal = parseInt(
								divUpd.text(), 10) + 1;
						divUpd.text(newVal);
					});

	$('.value-minus')
			.on(
					'click',
					function() {
						var divUpd = $(this).parent().find('.value'), newVal = parseInt(
								divUpd.text(), 10) - 1;
						if (newVal >= 1)
							divUpd.text(newVal);
					});
</script>
<!--quantity-->
<!--closed-->

<script>
	$(document).ready(function(c) {
		var items = toys.cart.items();
		for(var i=0;i<items.length;i++){
			$('.close'+i+'').on('click', function(c) {
				$('.rem'+i).fadeOut('slow', function(c) {
					$('.rem'+i).remove();
				});
			});
		}
		
	});
</script>
<!--//closed-->
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
<!-- Add Item to Cart for check Out -->
<script>
	var items = toys.cart.items();
	for (var i = 0; i < items.length; i++) {
		console.log(items[i]._data.profileImage);
		//Add item to table
		$('#tableItems')
				.append(
						'<tr class="rem'+i+'" >'
								+ '<td class="invert">'+(i+1)+'</td>'
								+ '<td class="invert-image">'
								+ '<a href="single.html"><img src="${image}/'+items[i]._data.profileImage+'.jpg" alt=" " class="img-responsive "></a>'
								+ '<ul>'
								+ '<li>Color: <strong>'+items[i]._data.color+'</strong></li>'
								+ '<li>Size: <strong>'+items[i]._data.size+'</strong></li>'
								+ '</ul>'
								+ '</td>'
								+ '<td class="invert">'
								+ '<div class="quantity">'
								+ '<div class="quantity-select">'
								+ '<div class="entry value-minus">&nbsp;</div>'
								+ '<div class="entry value"><span>'+items[i]._data.quantity+'</span></div>'
								+ '<div class="entry value-plus active">&nbsp;</div>'
								+ '</div>'
								+ '</div>'
								+ '</td>'
								+ '<td class="invert">'+items[i]._data.toys_item +'</td>'
								+ '<td class="invert">$'+items[i]._data.amount+'</td>'
								+ '<td class="invert"><div class="rem"><div class="close'+i+' close1"></div></div></td>'
								+ '</tr>'

				);
	}

	//Add price and total price

	//If no cart item exist , show msg at table and assign total to 0, disable make payment
</script>
