<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

</head>
<body>
<div id="container">
	<!-- header block START -->
	<div id="header">
		<div id="top_menu">
			<div id="topmenu_container">
				<s:if test="#session.logueado=true"> 
				Usuario: <s:property value="#session.usuario" />
				<br/>
				<s:property value="session.tipo"/>
				</s:if>
				
			</div>
		</div>
		<div id="logo"><span>logo text hidden</span></div>
		<div id="primary_menu">
			<div id="pm_main">
				<ul>
				<s:url var="urlInicio" action="mostrarPrincipalCandidato"/>
				<s:url var="urlOfertas" action="mostrarOfertas"/>
				<s:url var="urlEmpresas" action="mostrarEmpresas"/>
				<s:url var="urlInscripciones" action="mostrarInscripciones"/>
				<s:url var="urlPerfil" action="mostrarPerfil"/>
				<s:url var="urlAyuda" action="mostrarAyuda"/>
				<s:url var="urlSalir" action="logout"/>
				<li class="active"><a href="<s:property value=""/>"><b><s:text name="global.inicio"/></b></a></li>
				<li><a href="<s:property value="#urlOfertas"/>"><b><s:text name="candidato.ofertas"/></b></a></li>
				<li><a href="<s:property value="#urlEmpresas"/>"><b><s:text name="candidato.empresas"/></b></a></li>
				<li><a href="<s:property value="#urlInscripciones"/>"><b><s:text name="candidato.inscripciones"/></b></a></li>
				<li><a href="<s:property value="#urlPerfil"/>"><b><s:text name="candidato.perfil"/></b></a></li>
				</ul>
			</div>
			
			<div id="pm_sub">
				<ul>
					<li><a href="<s:property value="#urlSalir"/>"><s:text name="global.salir"/></a></li>
				</ul>
			</div>


		</div>
	</div>
	<!-- header block End -->
	<!-- content block START -->
	<div id="conent">
		<div class="right_col">
		<!-- design box 2 start -->
				<div class="db2" style="margin-top:0" >
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<div class="db2_content_container">
							<h3><s:text name="oferta.ofertasRecomendadas"/></h3>
							<s:iterator value="#request.ofertas" var="ultimasOfertas" status="contadorOR">
								<s:url var="urlVerOfertaRecomendada" action="verOferta">
									<s:param name="id" value="#ultimasOfertas.idoferta"/>
								</s:url>
								<a href="<s:property value="#urlVerOfertaRecomendada"/>"><s:property value="%{#contadorOR.count}"/>-<s:property value="%{#request.ultimasOfertas.nombre}"/></a><br/>
							</s:iterator>	
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
						<h3><s:text name="candidato.ultimasEmpresas"/></h3>
							<s:iterator value="#request.empresas" var="ultimasEmpresas" status="contadorE">
								<s:url var="urlVerEmpresa" action="buscarEmpresas">
									<s:param name="palabraClave">
										<s:property value="%{#ultimasEmpresas.nombre}"/>
									</s:param>
								</s:url>
								<a href="<s:property value="#urlVerEmpresa"/>"><s:property value="%{#contadorE.count}"/>-<s:property value="%{#request.ultimasEmpresas.nombre}"/></a><br/>
							</s:iterator>
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
						<h3><s:text name="candidato.ultimasOfertas"/></h3>
						<s:iterator value="#request.ofertas" var="ultimasOfertas" status="contadorO">
							<s:url var="urlVerOferta" action="verOferta">
								<s:param name="id">
									<s:property value="%{#ultimasOfertas.idoferta}"/>
								</s:param>
							</s:url>
							<a href="<s:property value="#urlVerOferta"/>"><s:property value="%{#contadorO.count}"/>-<s:property value="%{#request.ultimasOfertas.nombre}"/></a><br/>
						</s:iterator>
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
					<h3><s:property value="#session.usuario"/></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
					<p><s:text name="global.fecha"/><s:date name="hoy" format="%{getText('global.formatoFecha')}"/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
						<s:text name="global.hora"/><s:date name="hoy" format="hh:mm a" /> 
					</p>
					<br/><br/>
					<p>
						<s:if test="#request.mensaje=='bienvenida'">
							<strong> <u><s:text name="mensajes.bienvenida"/></u>  </strong>
						</s:if>
						<s:if test="#request.mensaje=='inscripcionExito'">
							<strong> <u><s:text name="mensajes.inscripcion.exito"/></u>  </strong>
						</s:if>
						<s:if test="#request.mensaje=='inscripcionError'">
							<strong><u> <s:text name="mensajes.inscripcion.error"/> </u> </strong>
						</s:if>
						<s:if test="#request.mensaje=='eliminarInscripcionExito'">
							<strong> <u><s:text name="mensajes.eliminarInscripcion.exito"/></u>  </strong>
						</s:if>
						<s:if test="#request.mensaje=='eliminarInscripcionError'">
							<strong><u> <s:text name="mensajes.eliminarInscripcion.error"/> </u> </strong>
						</s:if>
						<s:if test="#request.mensaje=='subirFotoExito'">
							<strong><u> <s:text name="mensajes.foto.exito"/>  </u></strong>
						</s:if>
						<s:if test="#request.mensaje=='subirFotoError'">
							<strong><u> <s:text name="mensajes.foto.error"/> </u> </strong>
						</s:if>
						<s:if test="#request.mensaje=='subirCurriculumExito'">
							<strong><u> <s:text name="mensajes.curriculum.exito"/></u>  </strong>
						</s:if>
						<s:if test="#request.mensaje=='subirCurriculumError'">
							<strong><u> <s:text name="mensajes.curriculum.error"/> </u> </strong>
						</s:if>
						<s:if test="#request.mensaje=='cambioPasswordExito'">
							<strong><u> <s:text name="mensajes.cambioPassword.exito"/> </u> </strong>
						</s:if>
						<s:if test="#request.mensaje=='cambioPasswordError'">
							<strong><u> <s:text name="mensajes.cambioPassword.error"/> </u> </strong>
						</s:if>
						<s:if test="#request.mensaje==null">
						</s:if>
					</p>
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
