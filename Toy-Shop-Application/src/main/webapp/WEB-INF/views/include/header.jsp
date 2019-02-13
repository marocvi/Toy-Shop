<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="header-outs" id="home">
	<div class="header-bar">
		<div class="info-top-grid">
			<div class="info-contact-agile">
				<ul>
					<li><span class="fas fa-phone-volume"></span>
						<p>+(000)123 4565 32</p></li>
					<li><span class="fas fa-envelope"></span>
						<p>
							<a href="mailto:info@example.com">info@example1.com</a>
						</p></li>
					<li></li>
				</ul>
			</div>
		</div>
		<div class="container-fluid">
			<div class="hedder-up row">
				<div class="col-lg-3 col-md-3 logo-head">
					<h1>
						<a class="navbar-brand" href="index.html">Toys-Shop</a>
					</h1>
				</div>
				<div class="col-lg-5 col-md-6 search-right">
					<form class="form-inline my-lg-0">
						<input class="form-control mr-sm-2" type="search" style="color:black;"
							placeholder="Search" >
						<button class="btn" type="submit" onclick="developmentAlert(event)">Search</button>
					</form>
				</div>
				<div class="col-lg-4 col-md-3 right-side-cart">
					<div class="cart-icons">
						<ul>
							<li><span class="far fa-heart" onclick="developmentAlert(event)"></span></li>
							<li>
								<button type="button" data-toggle="modal"
									data-target="#exampleModal" id="user">
									<span class="far fa-user"></span>
								</button>
							</li>
							<li class="toyscart toyscart2 cart cart box_1">
								<form action="#" method="post" class="last">
									<input type="hidden" name="cmd" value="_cart"> <input
										type="hidden" name="display" value="1">
									<button class="top_toys_cart" type="submit" name="submit"
										value="">
										<span class="fas fa-cart-arrow-down"></span>
									</button>
								</form>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-center"
				id="navbarSupportedContent">
				<ul class="navbar-nav ">
					<li class="nav-item active"><a class="nav-link"
						href='${contextURL}/home'>Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a href="${contextURL}/about" class="nav-link">About</a>
					</li>
					<li class="nav-item"><a href="${contextURL}/service" class="nav-link">Service</a>
					</li>
					<li class="nav-item"><a href='${contextURL}/product?page=1' class="nav-link">Shop
							Now</a></li>
					<li class="nav-item"><a href="${contextURL}/contact" class="nav-link">Contact</a>
					</li>
				</ul>
			</div>
		</nav>
	</div>
	<!-- Slideshow 4 -->

</div>
<!-- //banner -->