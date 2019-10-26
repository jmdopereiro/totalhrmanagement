<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--sx:head cache="true"/-->
</head>
<body>
<div id="container">
	<br><br><!-- header block START -->
	<div id="header">
		<div id="logo"><span>logo text hidden</span></div>
	</div>
	<!-- header block End -->
	<!-- content block START -->
	<div id="conent">
		<div class="right_col">
		<!-- design box 2 start -->
				<div class="db2" style="margin-top:0px" >
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<div class="db2_content_container">
						<h3><s:text name="global.identificate"/></h3>
						<s:form id="loginForm" action="login" method="post" theme="xhtml">
							<s:actionerror/>
							<s:textfield label="%{getText('inicio.acceso.dni')}" name="dni"/><br/>
							<s:textfield label="%{getText('inicio.acceso.email')}" name="email"/><br/>
							<s:password label="%{getText('inicio.acceso.pass')}" name="password"/><br/>
							<s:submit type="image" src="images/login_button.jpg" alt="Login" width="100" height="50"/>
						</s:form>
					</div>
					</div>
					<div class="bd2_bot">
						<div class="bd2_bot_content">&nbsp;</div>
					</div>
				</div>
				<!-- design box 2 end -->
				<div class="db3" style="" >
					<div class="bd3_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db3_content">
						<h3><s:text name="global.registro"/><br/></h3>
							<s:text name="inicio.mensajeRegistro"/><br /><br /><br />
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<s:url var="urlRegistro" action="mostrarRegistro"/>
							<a href="<s:property value="#urlRegistro"/>"><img src="images/register-now.jpg" alt="Register Now" width="100" height="100"></a>
					</div>
					<div class="bd3_bot">
						<div class="bd3_bot_content">&nbsp;</div>
					</div>
				</div>
				<div class="db4" style="" >
					<div class="bd4_top">
						<div class="bd4_top_content">&nbsp;</div>
					</div>
					<div class="db4_content">
						<h3><s:text name="global.politica"/><br /></h3>
						<span><s:text name="global.mensajePolitica"/> <br/></span>

					</div>
					<div class="bd4_bot">
						<div class="bd4_bot_content">&nbsp;</div>
					</div>
				</div>
		</div>
		<!-- left column start-->
		<div class="left_col">
			<div class="db1">
				<div class="db1_title">
					<h3><s:text name="global.sobreAplicacion"/><br /></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
					<br/>
					<p><strong><s:text name="global.aplicacion.pregunta1"/></strong></p>
					<p><br/></p>
					<s:text name="global.aplicacion.respuesta1"/> <br/><br/>
					<ul>
						<li><p><s:text name="global.aplicacion.respuesta1a"/></p></li><br/>
						<li><p><s:text name="global.aplicacion.respuesta1b"/></p></li>
					</ul>
					<br/><br/>
					<p><strong><s:text name="global.aplicacion.pregunta2"/></strong></p>
					<p><br/></p>
					<ul>
						<li><p><s:text name="global.aplicacion.respuesta2a"/></p></li><br/>
						<li><p><s:text name="global.aplicacion.respuesta2b"/></p></li><br/>
						<li><p><s:text name="global.aplicacion.respuesta2c"/></p></li>
					</ul>
					<br/><br/>
					<div class="db1" style="width:575px; float:left; margin-right:25px;">
						<div class="db1_title">
							<h3><s:text name="global.aplicacion.recomendaciones"/></h3>
						</div>					
						<div class="db1_content">
							<div class="db1_container">
							<div class="db3" style="width: 527px; margin:10px;" >
							<div class="bd3_top"><div class="bd3_top_content">&nbsp;</div></div>
							<div class="db3_content">
								<ul>
									<li><p><s:text name="global.aplicacion.recomendacion1"/></p></li><br/>
									<li><p><s:text name="global.aplicacion.recomendacion2"/></p></li><br/>
									<li><p><s:text name="global.aplicacion.recomendacion3"/></p></li>
								</ul>
							</div>
							<div class="bd3_bot"><div class="bd3_bot_content">&nbsp;</div></div>
						</div>

							</div>
						</div>
					</div>
					<br/>
					<br/>
					<div class="db1" style="width:575px; float:left; margin-right:25px;">
						<div class="db1_title">
							<h3><s:text name="global.aplicacion.atencion"/></h3>
						</div>					
						<div class="db1_content">
							<div class="db1_container">
							<div class="db4" style="width: 527px; margin:10px;" >
							<div class="bd4_top"><div class="bd4_top_content">&nbsp;</div></div>
							<div class="db4_content">
									<b><p><s:text name="global.aplicacion.atencion.texto"/></p></b>
							</div>
							<div class="bd4_bot"><div class="bd3_bot_content">&nbsp;</div></div>
						</div>

							</div>
						</div>
					</div>
					
					</div>
				</div>
			</div>
		</div>
	<!-- content block End -->
	<!-- Footer block START -->	
	<div id="footer">
		<div id="copyright">  <s:text name="global.copyright"/>  </div>
		<div id="designby">Design by <a href="http://www.flashdaweb.com/">Flashdaweb</a></div>
		<div id="bottom_menu"> </div>
	</div>
	
</div>

</div>
</body>

</html>
