<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="cu" uri="CustomTag"%>

<s:url var="image" value="/resources/images/"></s:url>
<s:url var="js" value="/resources/js/"></s:url>
<!-- banner -->
<div class="inner_page-banner one-img"></div>
<!--//banner -->
<!-- short -->
<div class="using-border py-3">
	<div class="inner_breadcrumb  ml-4">
		<ul class="short_ls">
			<li><a href="index.html">Home</a> <span>/ /</span></li>
			<li>Single Page</li>
		</ul>
	</div>
</div>
<!-- //short-->
<!--//banner -->
<!--/shop-->
<section class="banner-bottom py-lg-5 py-3">
	<div class="container">
		<div class="inner-sec-shop pt-lg-4 pt-3">
			<div class="row">
				<div class="col-lg-4 single-right-left ">
					<div class="grid images_3_of_2">
						<div class="flexslider1">
							<ul class="slides">
								<c:forEach var="item" items="${product.productImages}">
									<li data-thumb="${image}/${item.image}">
										<div class="thumb-image">
											<img src="${image}/${item.image}" data-imagezoom="true"
												class="img-fluid" alt=" ">
										</div>
									</li>
								</c:forEach>
							</ul>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-lg-8 single-right-left simpleCart_shelfItem">
					<h3>${product.name}</h3>
					<p>
						<c:choose>
							<c:when test="${cu:promotionRate(product.promotions)>0}">
								<span class="item_price"><cu:currentPrice
										productPrices="${product.productPrices}"
										promotionRate="${cu:promotionRate(product.promotions)}" /></span>
								<span style="text-decoration: line-through; color: grey;"><cu:currentPrice
										productPrices="${product.productPrices}" /></span>

							</c:when>
							<c:otherwise>
								<span class="item_price"><cu:currentPrice
										productPrices="${product.productPrices}" /></span>
							</c:otherwise>
						</c:choose>

					</p>
					<div class="rating1">
						<ul class="stars">
							<c:forEach begin="1" end="${cu:reviewRate(product.reviews)}">
								<li><a href="#"><i class="fa fa-star"
										aria-hidden="true"></i></a></li>

							</c:forEach>
						</ul>
					</div>
					<div class="description">
						<h5>Check delivery, payment options and charges at your
							location</h5>
						<input class="form-control" type="text" name="Email"
							placeholder="Please enter you country..." id="checkLocation">
						<input type="submit" value="Check" onclick="checkLocation()">
					</div>
					<div class="color-quality">
						<div class="color-quality-right">

							<h5>Size :</h5>
							<select id="selectSize"
								class="frm-field required sect">
								<c:forEach var="productSize" items="${product.productSizes}">
									<option value="${productSize.size}">${productSize.size}</option>
								</c:forEach>

							</select>
						</div>
					</div>
					<div class="occasional">
						<h5>Color :</h5>
						<c:forEach var="productColor" items="${product.productColors}" varStatus="colorCount">
							<c:choose>
								<c:when test="${colorCount.count==1}">
									<div class="colr ert">
									<label class="radio"><input type="radio" name="radio" value="${productColor.name}" id="selectColor" checked="checked"><i></i>
										${productColor.name}</label>
									</div>
								</c:when>
								<c:otherwise>
									<div class="colr ert">
										<label class="radio"><input type="radio" name="radio" value="${productColor.name}" id="selectColor"><i></i>
											${productColor.name}</label>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<div class="clearfix"></div>
					</div>
					<div class="occasion-cart">
						<div class="toys single-item singlepage">
							<form action="#" method="post">
								<input type="hidden" name="cmd" value="_cart"> <input
									type="hidden" name="add" value="1"> <input
									type="hidden" name="toys_item" value="${product.name}"> <input
									type="hidden" name="amount" value='<cu:currentPrice
										productPrices="${product.productPrices}"
										promotionRate="${cu:promotionRate(product.promotions)}" />'>
								<input type="hidden" name="size" value="" id="size">
								<input type="hidden" name="color" value="" id="color">
								<input type="hidden" name="profileImage" value="${product.profileImage}"/>
								<button type="submit" class="toys-cart ptoys-cart add" onclick="fillOut()">
									Add to Cart</button>
							</form>
						</div>
					</div>
					<ul class="footer-social text-left mt-lg-4 mt-3">
						<li>Share On :</li>
						<li class="mx-1"><a href="#"> <span
								class="fab fa-facebook-f"></span>
						</a></li>
						<li class=""><a href="#"> <span class="fab fa-twitter"></span>
						</a></li>
						<li class="mx-1"><a href="#"> <span
								class="fab fa-google-plus-g"></span>
						</a></li>
						<li class=""><a href="#"> <span
								class="fab fa-linkedin-in"></span>
						</a></li>
						<li class="mx-1"><a href="#"> <span class="fas fa-rss"></span>
						</a></li>
					</ul>
				</div>
				<div class="clearfix"></div>
				<!--/tabs-->
				<div class="responsive_tabs" style="width: 100%;">
					<div id="horizontalTab">
						<ul class="resp-tabs-list">
							<li>Description</li>
							<li>Reviews</li>
						</ul>
						<div class="resp-tabs-container">
							<!--/tab_one-->
							<div class="tab1">
								<div class="single_page">
									<p>${product.description}</p>
								</div>
							</div>
							<!--//tab_one-->
							<div class="tab2">
								<div class="single_page">
									<div class="bootstrap-tab-text-grids">
										<div class="bootstrap-tab-text-grid">
											<div class="bootstrap-tab-text-grid-left">
												<img src='${image}/<s:message code="admin.image"/>' alt=" "
													class="img-fluid">
											</div>
											<div class="bootstrap-tab-text-grid-right">
												<ul>
													<li><a href="#"><s:message code="admin.role" /></a></li>
												</ul>
												<p>
													<s:message code="comment.rule" />
												</p>
											</div>
											<div class="clearfix"></div>
										</div>
										<div class="add-review">
											<h4>add a review</h4>
											<div class='rating-stars'>
												<ul id='stars'>
													<li class='star' title='Poor' data-value='1'><i
														class='fa fa-star fa-fw'></i></li>
													<li class='star' title='Fair' data-value='2'><i
														class='fa fa-star fa-fw'></i></li>
													<li class='star' title='Good' data-value='3'><i
														class='fa fa-star fa-fw'></i></li>
													<li class='star' title='Excellent' data-value='4'><i
														class='fa fa-star fa-fw'></i></li>
													<li class='star' title='WOW!!!' data-value='5'><i
														class='fa fa-star fa-fw'></i></li>
												</ul>
											</div>


											<form:form
												action="${contextURL}/product/review/${product.id}"
												method="post" modelAttribute="reviewCommand">
												<security:authorize access="!isAuthenticated()">
													<div class="row">
														<div class="col-md-6">
															<form:input path="email" placeholder="Email" />
															<form:errors path="email" cssClass="error" />
														</div>
														<div class="col-md-3">
															<form:input path="firstName" placeholder="First Name" />
															<form:errors path="firstName" cssClass="error" />
														</div>
														<div class="col-md-3">
															<form:input path="lastName" placeholder="Last Name" />
															<form:errors path="lastName" cssClass="error" />
														</div>
													</div>
												</security:authorize>
												<security:authorize access="isAuthenticated()">
													<div style="display: none;">
														<input id="email" name="email" placeholder="Email"
															type="text" value="${user.email}" /> <input
															id="firstName" name="firstName" placeholder="First Name"
															type="text" value="${user.firstName}" /> <input
															id="lastName" name="lastName" placeholder="Last Name"
															type="text" value="${user.lastName}" />
													</div>
												</security:authorize>
												<form:hidden path="reviewRate" />
												<form:textarea path="content" placeholder="Comment" />
												<form:errors path="content" cssClass="error" />
												<input type="submit" value="SEND" style="display: block"
													class="mt-4">
											</form:form>

										</div>
									</div>
									<div class="comments mt-4">
										<ul>
											<c:forEach var="review" items="${product.reviews}">
												<li class="mt-4 ">
													<div class="comment">
														<div class="title">
															<h5>${review.firstName}</h5>
														</div>
														<div class="content">
															<div class="rating1">
																<ul class="stars">
																	<c:forEach begin="1" end="${review.reviewRate}">
																		<li><i class="fa fa-star" aria-hidden="true"></i></li>
																	</c:forEach>

																</ul>
															</div>
															<p>${review.content}</p>

														</div>
													</div>
												</li>
											</c:forEach>

										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--//tabs-->
			</div>
		</div>
	</div>
</section>
<!-- The java script for this page -->
<!-- //Modal 1-->
<!--jQuery-->
<script src="${js}jquery-2.2.3.min.js"></script>
<!-- newsletter modal -->
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
<!-- price range (top products) -->
<script src="${js}jquery-ui.js"></script>
<script>
	//<![CDATA[ 
	$(window).load(
			function() {
				$("#slider-range").slider(
						{
							range : true,
							min : 0,
							max : 9000,
							values : [ 50, 6000 ],
							slide : function(event, ui) {
								$("#amount").val(
										"$" + ui.values[0] + " - $"
												+ ui.values[1]);
							}
						});
				$("#amount").val(
						"$" + $("#slider-range").slider("values", 0) + " - $"
								+ $("#slider-range").slider("values", 1));

			}); //]]>
</script>
<!-- //price range (top products) -->
<!-- single -->

<script src="${js}imagezoom.js"></script>
<!-- single -->
<!-- script for responsive tabs -->
<script src="${js}easy-responsive-tabs.js"></script>
<script>
	$(document).ready(function() {
		$('#horizontalTab').easyResponsiveTabs({
			type : 'default', //Types: default, vertical, accordion           
			width : 'auto', //auto or any width like 600px
			fit : true, // 100% fit in a container
			closed : 'accordion', // Start closed if in accordion view
			activate : function(event) { // Callback function if tab is switched
				var $tab = $(this);
				var $info = $('#tabInfo');
				var $name = $('span', $info);
				$name.text($tab.text());
				$info.show();
			}
		});
		$('#verticalTab').easyResponsiveTabs({
			type : 'vertical',
			width : 'auto',
			fit : true
		});
	});
</script>
<!-- FlexSlider -->
<script src="${js}jquery.flexslider.js"></script>
<script>
	// Can also be used with $(document).ready()
	$(window).load(function() {
		$('.flexslider1').flexslider({
			animation : "slide",
			controlNav : "thumbnails"
		});
	});
</script>
<!-- //FlexSlider-->
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
<!-- Star at review -->
<script>
	$(document).ready(
			function() {

				/* 1. Visualizing things on Hover - See next part for action on click */
				$('#stars li').on('mouseover', function() {
					var onStar = parseInt($(this).data('value'), 10); // The star currently mouse on

					// Now highlight all the stars that's not after the current hovered star
					$(this).parent().children('li.star').each(function(e) {
						if (e < onStar) {
							$(this).addClass('hover');
						} else {
							$(this).removeClass('hover');
						}
					});

				}).on('mouseout', function() {
					$(this).parent().children('li.star').each(function(e) {
						$(this).removeClass('hover');
					});
				});

				/* 2. Action to perform on click */
				$('#stars li').on(
						'click',
						function() {
							var onStar = parseInt($(this).data('value'), 10); // The star currently selected
							var stars = $(this).parent().children('li.star');

							for (i = 0; i < stars.length; i++) {
								$(stars[i]).removeClass('selected');
							}

							for (i = 0; i < onStar; i++) {
								$(stars[i]).addClass('selected');
							}

							// JUST RESPONSE (Not needed)
							var ratingValue = parseInt($('#stars li.selected')
									.last().data('value'), 10);
							$('#reviewRate').val(ratingValue);

						});

			});
</script>
<!-- Add Comment Ajax -->
<script src="${js}jquery.validate.js"></script>
<script>
	//Check information or Validate
	$().ready(function() {
		$("#reviewCommand").validate({
			onfocusout : false,
			onkeyup : false,
			onclick : false,
			rules : {
				"email" : {
					required : true,
					email : true
				},
				"firstName" : {
					required : true,
					minlength : 3
				},
				"lastName" : {
					required : true,
					minlength : 3
				},
				"content" : {
					required : true,
					minlength : 10
				}
			}
		});
	});
</script>

<script type="text/javascript">
	function checkLocation() {
		var data = {};
		data['deliveryLocation'] = $('#checkLocation').val();
		$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "${contextURL}/api/checkLocation",
					data : JSON.stringify(data),
					dataType : 'json',
					timeout : 100000,
					success : function(jsonData) {
						console.log("SUCCESS: ", jsonData);
						var result = jsonData.available;
						if (result === true) {
							showbox("Your location is available. Please keep shopping");

						} else {
							showbox("Your location is not available. Please try other locations");
						}

					},
					error : function(e) {
						console.log("ERROR: ", e);
						showbox("There is somthing wrong. Please try again");
					},
					done : function(e) {
						console.log("DONE");
					}
				});

	}
	function showbox(msg) {
		//Show model
		alert(msg);

	}
</script>
<!-- Change Color and Size off product to add to cart -->
<script>


	function fillOut() {

		//fill out infomation
		//Add size
		$('#size').val($('#selectSize').val());
		
		//Add color
		$('#color').val($('#selectColor').val());
		
	}
	
	
</script>
<!-- Like and dislike Ajax -->
<!-- //here ends scrolling icon -->
<!-- //smooth-scrolling-of-move-up -->
<!--bootstrap working-->
<script src="${js}bootstrap.min.js"></script>
<!-- //bootstrap working-->
