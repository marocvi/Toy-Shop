<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cu" uri="CustomTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<s:url var="image" value="/resources/images/"></s:url>
<s:url var="js" value="/resources/js/"></s:url>
<c:set var="contextURL" value="${pageContext.request.contextPath}"></c:set>
<!-- banner -->
<div class="inner_page-banner one-img"></div>
<!--//banner -->
<!-- short -->
<div class="using-border py-3">
	<div class="inner_breadcrumb  ml-4">
		<ul class="short_ls">
			<li><a href="index.html">Home</a> <span>/ /</span></li>
			<li>Products</li>
		</ul>
	</div>
</div>
<!-- //short-->
<!--show Now-->
<section class="contact py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container-fluid py-lg-5 py-md-4 py-sm-4 py-3">
		<h3 class="title text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Toys
			Shop</h3>
		<div class="row">
			<div class="side-bar col-lg-3">
				<div class="search-hotel">
					<h3 class="agileits-sear-head">Search Here..</h3>
					<form action="#" method="post">
						<input type="search" placeholder="Product name..." name="search">
						<input type="submit" value=" ">
					</form>
				</div>
				<!-- price range -->

				<form:form action="product?page=1" modelAttribute="filterCommand"
					method="post">
					<form:hidden path="minPrice" />
					<form:hidden path="maxPrice" />
					<div class="range">
						<h3 class="agileits-sear-head">Price range</h3>
						<ul class="dropdown-menu6">
							<li>

								<div id="slider-range"></div> <input type="text" id="amount"
								style="border: 0; color: #ffffff; font-weight: normal;" />
							</li>
						</ul>
					</div>
					<!-- //price range -->
					<!--preference -->
					<div class="left-side">
						<h3 class="agileits-sear-head">Category</h3>
						<ul>
							<c:forEach var="category" items="${listOfCategories}"
								varStatus="categoryCount">
								<!-- Check whether category have check before-->
								<c:set var="checkExist" value="false"></c:set>
								<c:forEach items="${filterCommand.category}" var="categoryName">
									<c:if test="${categoryName eq category.name}">
										<c:set var="checkExist" value="true" />
									</c:if>
								</c:forEach>
								<c:choose>
									<c:when test="${checkExist eq true}">
										<li><input id="category${categoryCount.count}"
											type="checkbox" class="checked" name="category"
											value="${category.name}" checked="checked"><input
											type="hidden" name="_category" value="on"> <span
											class="span">${category.name}</span></li>
									</c:when>
									<c:otherwise>
										<li><input id="category${categoryCount.count}"
											type="checkbox" class="checked" name="category"
											value="${category.name}"><input type="hidden"
											name="_category" value="on"> <span class="span">${category.name}</span></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>


						</ul>
					</div>
					<!-- // preference -->
					<!-- discounts -->
					<div class="left-side">
						<h3 class="agileits-sear-head">Promotion</h3>
						<ul>
							<li><form:checkbox path="promotion" cssClass="checked"
									value="0" /> <span class="span">0% - 10%</span></li>
							<li><form:checkbox path="promotion" cssClass="checked"
									value="10" /> <span class="span">10% - 20%</span></li>
							<li><form:checkbox path="promotion" cssClass="checked"
									value="20" /> <span class="span">20% - 30%</span></li>
							<li><form:checkbox path="promotion" cssClass="checked"
									value="30" /> <span class="span">30% - 40%</span></li>
							<li><form:checkbox path="promotion" cssClass="checked"
									value="40" /><span class="span">40% - 50%</span></li>
							<li><form:checkbox path="promotion" cssClass="checked"
									value="50" /> <span class="span">50% or More</span></li>
						</ul>
					</div>
					<!-- //discounts -->
					<!-- reviews -->
					<div class="customer-rev left-side">
						<h3 class="agileits-sear-head">Customer Review</h3>
						<ul>
							<li><form:checkbox path="review" cssClass="checked"
									value="5" /> <i class="fas fa-star"></i> <i
								class="fas fa-star"></i> <i class="fas fa-star"></i> <i
								class="fas fa-star"></i> <i class="fas fa-star"></i> <span>5.0</span></li>
							<li><form:checkbox path="review" cssClass="checked"
									value="4" /> <i class="fas fa-star"></i> <i
								class="fas fa-star"></i> <i class="fas fa-star"></i> <i
								class="fas fa-star"></i> <i class="far fa-star"></i> <span>4.0</span></li>
							<li><form:checkbox path="review" cssClass="checked"
									value="3" /> <i class="fas fa-star"></i> <i
								class="fas fa-star"></i> <i class="fas fa-star"></i> <i
								class="fas fa-star-half"></i> <i class="far fa-star"></i> <span>3.0</span></li>
							<li><form:checkbox path="review" cssClass="checked"
									value="2" /><i class="fas fa-star"></i> <i class="fas fa-star"></i>
								<i class="fas fa-star"></i> <i class="far fa-star"></i> <i
								class="far fa-star"></i> <span>2.0</span></li>

						</ul>
					</div>
					<!-- //reviews -->
					<div class="d-flex justify-content-sm-center mt-4 mb-4 "
						style="position: sticky; bottom: 0; z-index: 100;">
						<a role="button" class="btn bg-dark border col-lg-6 text-light"
							href='<c:url value="/product"></c:url>'>Delete Filter</a>
						<button type="submit" id="submit"
							class="btn bg-primary border col-lg-6 text-light">Apply
							Filter</button>
					</div>
				</form:form>
				<!-- deals -->
				<div class="deal-leftmk left-side">
					<h3 class="agileits-sear-head">Special Deals</h3>
					<div class="row special-sec1">
						<div class="col-xs-4 img-deals">
							<img src="${image}/g1.jpg" alt="" class="img-fluid">
						</div>
						<div class="col-xs-8 img-deal1">
							<h3>toys(barbie)</h3>
							<a href="single.html">$180.00</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="row special-sec1">
						<div class="col-xs-4 img-deals">
							<img src="${image}/g2.jpg" alt="" class="img-fluid">
						</div>
						<div class="col-xs-8 img-deal1">
							<h3>toy(todos)</h3>
							<a href="single.html">$99.00</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="row special-sec1">
						<div class="col-xs-4 img-deals">
							<img src="${image}/g3.jpg" alt="" class="img-fluid">
						</div>
						<div class="col-xs-8 img-deal1">
							<h3>toys (Grey)</h3>
							<a href="single.html">$165.00</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="row special-sec1">
						<div class="col-xs-4 img-deals">
							<img src="${image}/g2.jpg" alt="" class="img-fluid">
						</div>
						<div class="col-xs-8 img-deal1">
							<h3>Soft bear</h3>
							<a href="single.html">$225.00</a>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="row special-sec1">
						<div class="col-xs-4 img-deals">
							<img src="${image}/g4.jpg" alt="" class="img-fluid">
						</div>
						<div class="col-xs-8 img-deal1">
							<h3>pink bear</h3>
							<a href="single.html">$169.00</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</div>
				<!-- //deals -->
			</div>
			<div class="left-ads-display col-lg-9">
				<div class="row">
					<c:forEach var="product" items="${products}">
						<div class="col-lg-4 col-md-6 col-sm-6 product-men women_two">
							<div class="product-toys-info">
								<div class="men-pro-item">
									<div class="men-thumb-item">
										<img src="${image}/${product.profileImage}.jpg"
											class="img-thumbnail img-fluid" alt="">
										<div class="men-cart-pro">
											<div class="inner-men-cart-pro">
												<a href='<c:url value="product/${product.id}" />'
													class="link-product-add-cart">Quick View</a>
											</div>
										</div>
										<span class="product-new-top">New</span>
									</div>
									<div class="item-info-product">
										<div class="info-product-price">
											<div class="grid_meta">
												<div class="product_price">
													<h4>
														<a href="single.html">${product.name}</a>
													</h4>
													<div class="grid-price mt-2">
														<c:choose>
															<c:when test="${cu:promotionRate(product.promotions)>0}">
																<span class="money ">$<cu:currentPrice
																		productPrices="${product.productPrices}"
																		promotionRate="${cu:promotionRate(product.promotions)}" /></span>
																<span
																	style="text-decoration: line-through; color: grey;">
																	$<cu:currentPrice
																		productPrices="${product.productPrices}" />
																</span>

															</c:when>
															<c:otherwise>
																<span class="money ">$<cu:currentPrice
																		productPrices="${product.productPrices}" /></span>
															</c:otherwise>
														</c:choose>

													</div>
												</div>
												<ul class="stars">

													<c:forEach begin="1"
														end="${cu:reviewRate(product.reviews)}">
														<li><i class="fas fa-star"></i></li>
													</c:forEach>
												</ul>
											</div>
											<div class="toys single-item hvr-outline-out">
												<form action="#" method="post">
													<input type="hidden" name="cmd" value="_cart"> <input
														type="hidden" name="add" value="1"> <input
														type="hidden" name="toys_item" value="toys(barbie)">
													<input type="hidden" name="amount" value="575.00">
													<button type="submit" class="toys-cart ptoys-cart">
														<i class="fas fa-cart-plus"></i>
													</button>
												</form>
											</div>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<nav aria-label="Page navigation example ">
					<ul class="pagination justify-content-center pt-5">
						<li class="page-item "><a class="page-link" tabindex="-1"
							id="pagePrevious" onclick="clickPrevious(${param.page})">Previous</a></li>
						<c:forEach begin="1" end="${requestScope.numberOfPages}" var="i">
							<c:choose>
								<c:when test="${i==param.page}">
									<li class="page-item active"><a id="click_page"
										class="page-link " onclick="clickPage(${i })">${i }</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item "><a class="page-link "
										onclick="clickPage(${i })" id="click_page">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li class="page-item"><a class="page-link" id="pageNext"
							onclick="clickNext(${param.page},${requestScope.numberOfPages})">Next</a></li>
					</ul>
				</nav>
				<!-- Sumbit form filter by clicking page -->
				<script type="text/javascript">
					function clickPage(selectedPage) {
						//Change action of form
						$("#filterCommand").attr("action","product?page="+selectedPage);
						//Submit
						document.getElementById('submit').click();
					}
					function clickNext(selectedPage,numberOfPages) {
						if(selectedPage<numberOfPages){
							//Change action of form
							var action = selectedPage+1
							$("#filterCommand").attr("action","product?page="+action);
							//Submit
							document.getElementById('submit').click();
						}
					}
					function clickPrevious(selectedPage){
						if(selectedPage>1){
						//Change action of form
							var action = selectedPage-1
							$("#filterCommand").attr("action","product?page="+action);
							//Submit
							document.getElementById('submit').click();
						}
					}
				</script>

			</div>
		</div>
	</div>
</section>
<!-- Js go here -->
<!-- //Modal 1-->
<!--js working-->
<script src='${js}jquery-2.2.3.min.js'></script>
<!--//js working-->
<!-- cart-js -->
<script src="${js}minicart.js"></script>
<script>
    toys.render();

    toys.cart.on('toys_checkout', function (evt) {
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
     $(window).load(function () {
         	$("#slider-range").slider({
         		range: true,
         		min: 0,
         		max: 2000,
         		values: [${filterCommand.minPrice}, ${filterCommand.maxPrice}],
         		slide: function (event, ui) {
         			$("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
         			$("#minPrice").val( ui.values[0]);
         			$("#maxPrice").val( ui.values[1]);
         		}
         	});
         	$("#amount").val("$" + $("#slider-range").slider("values", 0) + " - $" + $("#slider-range").slider("values", 1));

         });  //]]>
</script>
<!-- //price range (top products) -->
<!-- start-smoth-scrolling -->
<script src="${js}move-top.js"></script>
<script src="${js}easing.js"></script>
<script>
    jQuery(document).ready(function ($) {
        $(".scroll").click(function (event) {
            event.preventDefault();
            $('html,body').animate({
                scrollTop: $(this.hash).offset().top
            }, 900);
        });
    });
</script>
<!-- start-smoth-scrolling -->
<!-- here stars scrolling icon -->
<script>
    $(document).ready(function () {

        var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
        };


        $().UItoTop({
            easingType: 'easeOutQuart'
        });

    });
</script>
<!-- //here ends scrolling icon -->
<!--bootstrap working-->
<script src="${js}bootstrap.min.js"></script>
<!-- //bootstrap working-->
<!-- //OnScroll-Number-Increase-JavaScript -->


