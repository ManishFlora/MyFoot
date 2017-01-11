
<%@include file="header.jsp"%>
<div class="columns-container">

	<div class="wrapper it_MSYCVDAWVRSQ topcolumn-preset1">
		<div class="row it_BPFSWOXAMUFW ">
			<div class="it_XMGGKMZYAINS    col-lg-12 ">
				<div class="module "></div>
				<div class="module "></div>
			</div>
		</div>
	</div>

	<!-- Breadcrumb -->

	<div class="breadcrumb clearfix">
		<ul class="container">
			<li class="home"><a class="home"
				href="http://ld-prestashop.template-help.com/prestashop_61157/"
				title="Return to Home"> Home </a></li>
			<li class="last">Addresses</li>
		</ul>
	</div>

	<!-- /Breadcrumb -->

	<div id="columns" class="container">
		<div class="row">
			<div class="large-left col-sm-12">
				<div class="row">
					<div id="center_column"
						class="center_column col-xs-12 col-sm-12 accordionBox">

						<h1 class="page-heading">Addresses</h1>


						<!-- Steps -->
						<ul class="step clearfix" id="order_step">
							<li class="step_done first"><a
								href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=order">
									<em>01.</em> Summary
							</a></li>
							<li class="step_done step_done_last second"><a
								href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=order&amp;step=1">
									<em>02.</em> Sign in
							</a></li>
							<li class="step_current third"><span><em>03.</em>
									Address</span></li>
							<li class="step_todo four"><span><em>04.</em>
									Shipping</span></li>
							<li id="step_end" class="step_todo last"><span><em>05.</em>
									Payment</span></li>
						</ul>
						<!-- /Steps -->


						<form
							action="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=order"
							method="post">
							<div class="addresses clearfix">
								<div class="row">
									<div class="col-xs-12 col-sm-6">
										<div class="address_delivery select form-group selector1">
											<label for="id_address_delivery">Choose a delivery
												address:</label>
											<div class="selector" id="uniform-id_address_delivery"
												style="width: 246px;">
												<span style="width: 225px; user-select: none;"> My
													addressdfhfddsh </span><select name="id_address_delivery"
													id="id_address_delivery"
													class="address_select form-control">
													<option value="30" selected="selected">My
														addressdfhfddsh</option>
												</select>
											</div>
											<span class="waitimage" style="display: none;"></span>
										</div>
										<p class="checkbox addressesAreEquals">
											<input type="checkbox" name="same" id="addressesAreEquals"
												value="1" checked="checked"> <label
												for="addressesAreEquals">Use the delivery address as
												the billing address.</label>
										</p>
									</div>
									<div class="col-xs-12 col-sm-6">
										<div id="address_invoice_form"
											class="select form-group selector1" style="display: none;">
											<a
												href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=address&amp;back=order.php%3Fstep%3D1&amp;select_address=1"
												title="Add" class="btn-sm btn btn-default icon-right"> <span>
													Add a new address </span>
											</a>
										</div>
									</div>
								</div>
								<!-- end row -->
								<div class="row">
									<div class="col-xs-12 col-sm-6">
										<ul class="address item box" id="address_delivery">
											<li class="address_title"><h3 class="page-subheading">Your
													delivery address</h3></li>
											<li class="address_firstname address_lastname">Manish
												Flora</li>
											<li class="address_company">fhgd</li>
											<li class="address_address1 address_address2">fjf dhfffg</li>
											<li class="address_city address_state_name address_postcode">sggjhf,
												Florida 10454</li>
											<li class="address_country_name">United States</li>
											<li class="address_phone">9819457525</li>
											<li class="address_phone_mobile">9999999999</li>
											<li class="address_update"><a
												class="btn btn-success btn-sm"
												href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=address&amp;back=order.php%3Fstep%3D1&amp;id_address=30"
												title="Update"><span>Update<i
														class="fa fa-refresh right"></i></span></a></li>
										</ul>
									</div>
									<div class="col-xs-12 col-sm-6">
										<ul class="address alternate_item box" id="address_invoice">
											<li class="address_title"><h3 class="page-subheading">Your
													billing address</h3></li>
											<li class="address_firstname address_lastname">Manish
												Flora</li>
											<li class="address_company">fhgd</li>
											<li class="address_address1 address_address2">fjf dhfffg</li>
											<li class="address_city address_state_name address_postcode">sggjhf,
												Florida 10454</li>
											<li class="address_country_name">United States</li>
											<li class="address_phone">9819457525</li>
											<li class="address_phone_mobile">9999999999</li>
											<li class="address_update"><a
												class="btn btn-success btn-sm"
												href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=address&amp;back=order.php%3Fstep%3D1&amp;id_address=30"
												title="Update"><span>Update<i
														class="fa fa-refresh right"></i></span></a></li>
										</ul>
									</div>
								</div>
								<!-- end row -->
								<p class="address_add submit">
									<a
										href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=address&amp;back=order.php%3Fstep%3D1"
										title="Add" class="btn-sm btn btn-default icon-right"> <span>
											Add a new address </span>
									</a>
								</p>
								<div id="ordermsg" class="form-group">
									<label>If you would like to add a comment about your
										order, please write it in the field below.</label>
									<textarea class="form-control" cols="60" rows="6"
										name="message"></textarea>
								</div>
							</div>
							<!-- end addresses -->

							<p class="cart_navigation clearfix">
								<input type="hidden" class="hidden" name="step" value="2">
								<input type="hidden" name="back" value=""> <a
									href="http://ld-prestashop.template-help.com/prestashop_61157/index.php?controller=order"
									title="Previous" class="btn btn-default btn-md icon-left">
									<span>Continue Shopping</span>
								</a>
								<button type="submit" name="processAddress"
									class="btn btn-default btn-md icon-right">
									<span> Proceed to checkout </span>
								</button>
							</p>
						</form>


					</div>
					<!-- #center_column -->
				</div>
				<!--.large-left-->
			</div>
			<!--.row-->
		</div>
		<!-- .row -->
	</div>
	<!-- #columns -->


	<div class="wrapper it_ZGMGQDGNWEAS container home-preset1">
		<div class="row it_OMEMJXWGTWWQ ">
			<div class="it_BMLRHIIHSZDK    col-lg-12 ">
				<div class="module "></div>
				<div class="module "></div>
			</div>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>