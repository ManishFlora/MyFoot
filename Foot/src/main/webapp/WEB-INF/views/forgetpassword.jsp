<%@include file="header.jsp" %>
<div class="columns-container">
<div class="wrapper it_MSYCVDAWVRSQ topcolumn-preset1">
<div class="row it_BPFSWOXAMUFW ">
<div class="it_XMGGKMZYAINS    col-lg-12 ">
<div class="module "></div>
<div class="module "></div></div></div></div>
 
<div class="breadcrumb clearfix">
<ul class="container">
<li class="home">
<a class="home" href="index.html" title="Return to Home">
Home
</a>
</li>
<li class="crumb-1">
<a href="/Foot/login" title="Authentication" rel="nofollow">Authentication</a> </li>
<li class="crumb-2 last">
Forgot your password
</li>
</ul>
</div>
 
<div id="columns" class="container">
<div class="row">
<div class="large-left col-sm-12">
<div class="row">
<div id="center_column" class="center_column col-xs-12 col-sm-12 accordionBox">
<div class="box">
<h1 class="page-subheading">Forgot your password?</h1>
<p>Please enter the UserName that you selected while registering. </p>
<form:form modelAttribute="userDetail" method="post" class="std" id="form_forgotpassword">
<fieldset>
<div class="clearfix">
<div class="col-xs-12 col-md-3">
<div class="form-group">
<label for="user">Username</label>
<form:input path="userName" class="form-control" type="text" id="email" name="email" value=""/>
<form:errors cssStyle="color: red;" path="userName"/>
</div>
</div>
</div>
<p class="submit">
<button type="submit" name="_eventId_submit" class="btn btn-default btn-md icon-right"><span>Retrieve Password</span></button>
</p>
</fieldset>
</form:form>
</div>
<ul class="clearfix footer_links">
<li>
<a class="btn btn-default btn-sm icon-left" name="_eventId_cancel" href="#" title="Back to Login" rel="nofollow">
<span>
Back to Login
</span>
</a>
</li>
</ul>
</div> 
</div> 
</div> 
</div> 
</div> 
<div class="wrapper it_ZGMGQDGNWEAS container home-preset1">
<div class="row it_OMEMJXWGTWWQ ">
<div class="it_BMLRHIIHSZDK    col-lg-12 ">
<div class="module "></div>
<div class="module "></div></div></div></div>
</div>
<%@include file="footer.jsp" %>