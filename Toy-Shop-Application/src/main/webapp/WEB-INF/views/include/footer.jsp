<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<section class="subscribe">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6 col-md-6 map-info-right px-0">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d3150859.767904157!2d-96.62081048651531!3d39.536794757966845!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2sin!4v1408111832978">
				</iframe>
			</div>
			<div class="col-lg-6 col-md-6 address-w3l-right text-center">
				<div class="address-gried ">
					<span class="far fa-map"></span>
					<p>
						25478 Road St.121<br>USA New Hill
					<p>
				</div>
				<div class="address-gried mt-3">
					<span class="fas fa-phone-volume"></span>
					<p>
						+(000)123 4565<br>+(010)123 4565
					</p>
				</div>
				<div class=" address-gried mt-3">
					<span class="far fa-envelope"></span>
					<p>
						<a href="mailto:info@example.com">info@example1.com</a> <br>
						<a href="mailto:info@example.com">info@example2.com</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!--//subscribe-address-->
<section class="sub-below-address py-lg-4 py-md-3 py-sm-3 py-3">
	<div class="container py-lg-5 py-md-5 py-sm-4 py-3">
		<h3 class="title clr text-center mb-lg-5 mb-md-4 mb-sm-4 mb-3">Get
			In Touch Us</h3>
		<div class="icons mt-4 text-center">
			<ul>
				<li><a href="#"><span class="fab fa-facebook-f"></span></a></li>
				<li><a href="#"><span class="fas fa-envelope"></span></a></li>
				<li><a href="#"><span class="fas fa-rss"></span></a></li>
				<li><a href="#"><span class="fab fa-vk"></span></a></li>
			</ul>
			<p class="my-3">velit sagittis vehicula. Duis posuere ex in
				mollis iaculis. Suspendisse tincidunt velit sagittis vehicula. Duis
				posuere velit sagittis vehicula. Duis posuere</p>
		</div>
		<div class="email-sub-agile">
			<form action="#" method="post">
				<div class="form-group sub-info-mail">
					<input type="email" class="form-control email-sub-agile"
						placeholder="Email">
				</div>
				<div class="text-center">
					<button type="submit" class="btn subscrib-btnn">Subscribe</button>
				</div>
			</form>
		</div>
	</div>
</section>
<!--//subscribe-->
<!-- footer -->
<footer class="py-lg-4 py-md-3 py-sm-3 py-3 text-center">
	<div class="copy-agile-right">
		<p>
			© 2018 Toys-Shop. All Rights Reserved | Design by <a
				href="http://www.W3Layouts.com" target="_blank">W3Layouts</a>
		</p>
	</div>
</footer>
<!-- //footer -->
<!-- Modal 1-->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<!--Divide 2 tab for login and create account-->
				<ul class="nav nav-tabs">
					<security:authorize access="!isAuthenticated()">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#login">Login</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link active"
							data-toggle="tab" href="#userInfor">User Information</a></li>
					</security:authorize>
					<li class="nav-item"><a class="nav-link" data-toggle="tab"
						href="#create-user">Create User Account</a></li>
				</ul>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="tab-content">
				<security:authorize access="!isAuthenticated()">
					<div class="tab-pane container active" id="login">
						<div class="modal-body">
							<div class="register-form">
								<form action="loginUser" method="post">
									<p class="error">${loginError}</p>
									<p class="sucess">${verifySucess}</p>
									<p class="error">${loginRequire}</p>
									<p class="sucess">${logoutSucess}</p>
									<div class="fields-grid">
										<div class="styled-input">
											<input type="email" placeholder="Your Email" name="email" />
										</div>
										<div class="styled-input">
											<input type="password" placeholder="Password" name="password" />
										</div>
										<div class="form-check">
											<label class="form-check-label"> <input
												type="checkbox" class="form-check-input" name="remember-me" />
												Remember Me
											</label>
										</div>
										<button type="submit" class="btn btn-secondary mt-3">Login</button>
									</div>
								</form>
							</div>
						</div>
						<!--Social Login-->
						<div class="modal-footer ">
							<div class="card-body">
								<h5 class="card-title">Sign in using social provider</h5>
								<div class="row">
									<div class="col-lg-4">
										<!--Add Facebook sign in button-->
										<a href="#">
											<button class="btn btn-primary">
												<i class="fa fa-facebook-square"
													style="font-size: 20px; color: white"></i> | Facebook Login
											</button>
										</a>
									</div>
								</div>
								<div class="row mt-2">
									<div class="col-lg-4">
										<!--Add Facebook sign in button-->
										<a href="#">
											<button class="btn"
												style="background-color: #1da1f2; color: white;">
												<i class="fa fa-twitter-square"
													style="font-size: 20px; color: white"></i> | Twitter Login
											</button>
										</a>
									</div>

								</div>
							</div>
						</div>
					</div>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<div class="tab-pane container active" id="userInfor">
						<div class="modal-body">
							<div class="register-form">
								<form action="logout" method="post">
									<button type="submit" class="btn btn-secondary mt-3">Logout</button>
								</form>
							</div>
						</div>
					</div>
				</security:authorize>
				<div class="tab-pane container fade" id="create-user">
					<div class="modal-body">
						<div class="register-form">
							<form:errors path="notMatch" />
							<form:form action="signup" method="post"
								modelAttribute="userSignupCommand">
								<div class="fields-grid">
									<div class="styled-input">
										<form:input type="text" placeholder="First Name"
											path="firstName" />
										<form:errors path="firstName" cssClass="error" />
									</div>
									<div class="styled-input">
										<form:input type="text" placeholder="Last Name"
											path="lastName" />
										<form:errors path="lastName" cssClass="error" />
									</div>
									<div class="styled-input">
										<form:input type="text" placeholder="Address" path="address" />
										<form:errors path="address" cssClass="error" />
									</div>
									<div class="styled-input">
										<form:input type="email" placeholder="Your Email" path="email" />
										<form:errors path="email" cssClass="error" />
									</div>
									<div class="styled-input">
										<form:input type="password" placeholder="Password"
											path="password" />
										<form:errors path="password" cssClass="error" />
									</div>
									<div class="styled-input">
										<form:input type="password" placeholder="Retype Password"
											path="retypePassword" />
										<form:errors path="retypePassword" cssClass="error" />

									</div>

									<button type="submit" class="btn btn-secondary">SIGN
										UP</button>
								</div>
							</form:form>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>
</div>