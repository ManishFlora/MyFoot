<%@include file="header.jsp"%>
<div id="columns" class="container">
<h1 class="page-heading bottom-indent">Payment Page</h1>
<div class="contact-form-box" style="padding:23px 0 0 0;margin:0 0 30px 0;background:url('resources/images/contact-form.png') repeat-x white;-moz-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;-webkit-box-shadow:rgba(0,0,0,0.17) 0 5px 13px;box-shadow:rgba(0,0,0,0.17) 0 5px 13px;">
<form:form>
<fieldset style="padding:0 19px 21px 19px;background:url(resources/images/form-contact-shadow.png">
<h3 class="page-subheading">Payment Details</h3>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Card-Holder Name</label>
<input type="text" class="form-control" placeholder="NAME ON CARD"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">CVV</label>
<input type="text" class="form-control" max="3" maxlength="3" placeholder="CVV"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Password</label>
<input type="password" class="form-control" placeholder="PASSWORD"/>
</p>
</div>
<div class="col-xs-12 col-md-3">
<p class="form-group">
<label for="email">Price</label>
<input type="password" readonly="readonly" class="form-control" value="${session.sesionScope.price}"/>
</p>
</div>
</div>
<div class="submit">
<input type="submit" name="_eventId_submit" class="btn btn-default btn-sm" value="Submit">
</div>
</fieldset>
</form:form>
</div>
</div>
<%@include file="footer.jsp"%>