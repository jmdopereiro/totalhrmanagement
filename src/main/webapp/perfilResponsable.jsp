<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<%--<sx:head/>--%>
<sj:head compressed="false" jqueryui="true" defaultIndicator="indicadorEspera" jquerytheme="ui-lightness" locale="es"/>
<script language="javascript">
	$(document).ready(function()
	{
		var mostrarModificarPerfil =<%=request.getParameter("modificarPerfilError")%>;
		var mostrarCambiarPassword =<%=request.getParameter("modificarPasswordError")%>;
	
		$('#capaEliminarPerfil').hide();
		if(mostrarModificarPerfil==true)
		{
			$('#capaModificarPerfil').show('slow');
		}
		if(mostrarCambiarPassword==true)
		{
			$('#capaCambiarPassword').show('slow');
		}
		if(mostrarModificarPerfil!=true && mostrarCambiarPassword!=true)
		{
			$('#capaMostrarDatos').show('slow');
		}
		
		$('#botonModificarPerfil').click(function() 
		{
			$('#capaMostrarDatos').hide();
			$('#capaCambiarPassword').hide();
	  		$('#capaModificarPerfil').show('slow');
		});
		
		$('#botonCambiarPassword').click(function() 
		{
			$('#capaMostrarDatos').hide();
			$('#capaModificarPerfil').hide();
	  		$('#capaCambiarPassword').show('slow');
		});
		
		$("#botonEliminarPerfil").bind('click',function() 
		{
			$('#capaEliminarPerfil').show('slow');
		});
	});
</script>
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
				<s:url var="urlInicio" action="mostrarPrincipalResponsable"/>
				<s:url var="urlOfertas" action="mostrarOfertasResponsable"/>
				<s:url var="urlCandidatos" action="mostrarCandidatos"/>
				<s:url var="urlPerfil" action="mostrarPerfilResponsable"/>
				<s:url var="urlAyuda" action="mostrarAyuda"/>
				<s:url var="urlSalir" action="logout"/>
				<li><a href="<s:property value="#urlInicio"/>"><b><s:text name="global.inicio"/></b></a></li>
				<li><a href="<s:property value="#urlOfertas"/>"><b><s:text name="responsable.ofertas"/></b></a></li>
				<li><a href="<s:property value="#urlCandidatos"/>"><b><s:text name="responsable.candidatos"/></b></a></li>
				<li class="active"><a href="#urlPerfil"><b><s:text name="responsable.perfil"/></b></a></li>
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
				
				<div class="db2" style="" >
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<h3><s:text name="candidato.modificarPerfil"/></h3>
							<sj:a id="botonModificarPerfil" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Pulsa aqui</sj:a>	
					</div>
					<div class="bd2_bot">
						<div class="bd2_bot_content">&nbsp;</div>
					</div>
				</div>
				
				<div class="db3" style="" >
					<div class="bd3_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db3_content">
							<h3><s:text name="candidato.cambiarContraseña"/></h3>
							<sj:a id="botonCambiarPassword" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"> Pulsa aqui</sj:a>	
					</div>
					<div class="bd3_bot">
						<div class="bd3_bot_content">&nbsp;</div>
					</div>
				</div>
				
				
				<div class="db4" style="" >
					<div class="bd4_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db4_content">
						<h3><s:text name="candidato.eliminarPerfil"/></h3>
						
						<sj:submit  id="botonEliminarPerfil" button="true" value="Pulsa aqui"/>
						<sj:div id="capaEliminarPerfil" bindOn="botonEliminarPerfil">
							<s:form id="eliminarPerfil" method="post" action="">
								<s:textfield label="Introduzca (ELIMINAR)" name="eliminarResponsable" />
								<sj:submit button="true" value="Confirmar baja"/>
							</s:form>
						</sj:div>
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
					<h3><s:text name="candidato.bienvenida"/> <s:property value="#session.usuario"/></h3>
				</div>
					<div class="db1_content">
						<div class="db1_container">
						
								<sj:div id="capaMostrarDatos" indicator="indicadorEspera" cssStyle="display:none">					
									
										<table>
											<tr><td colspan=""><strong><s:text name="responsable.datosPersonales.empresa"/>:</strong> <s:property value="#request.responsable.empresa.nombre"/></td>
											<td><strong><s:text name="responsable.datosPersonales.dni"/>:</strong> <s:property value="#request.responsable.dni"/></td></tr>
											<tr><td><strong><s:text name="responsable.datosPersonales.nombre"/>:</strong> <s:property value="#request.responsable.nombre"/></td>
											<td><strong><s:text name="responsable.datosPersonales.apellidos"/>:</strong> <s:property value="#request.responsable.apellidos"/></td></tr>
											<tr><td><strong><s:text name="responsable.datosPersonales.fijo"/>:</strong> <s:property value="#request.responsable.fijo"/> </td>
											<td><strong><s:text name="responsable.datosPersonales.movil"/>:</strong> <s:property value="#request.responsable.movil"/></td></tr>
											<tr><td><strong><s:text name="responsable.datosPersonales.fax"/>:</strong> <s:property value="#request.responsable.fax"/> </td>
											<td><strong><s:text name="responsable.datosPersonales.email"/>:</strong> <s:property value="#request.responsable.email"/> </td></tr>
										</table>
								</sj:div>
								
								<sj:div id="capaModificarPerfil" indicator="indicadorEspera" cssStyle="display:none">			
									<s:form id="formPerfil" action="modificarPerfilResponsable" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" >
										<s:actionerror/>
										<s:textfield label="%{getText('registro.datosPersonales.dni')}" name="responsable.dni" required="true" requiredposition="left"/>
										<s:textfield label="%{getText('registro.datosPersonales.nombre')}" name="responsable.nombre" required="true" requiredposition="left"/>
										<s:textfield label="%{getText('registro.datosPersonales.apellidos')}" name="responsable.apellidos" required="true" requiredposition="left"/>
										<s:textfield label="%{getText('registro.datosPersonales.email')}" name="email" required="true" requiredposition="left"/>
										<s:textfield label="%{getText('registro.datosPersonales.repetirEmail')}" name="responsable.email" required="true" requiredposition="left"/>
										<s:textfield label="%{getText('registro.datosPersonales.fijo')}" name="responsable.fijo"/>
										<s:textfield label="%{getText('registro.datosPersonales.movil')}" name="responsable.movil"/>
										<s:textfield label="%{getText('registro.datosPersonales.fax')}" name="responsable.fax"/>	
										<s:submit value="%{getText('global.modificar')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
									</s:form>
							</sj:div>
							
							<sj:div id="capaCambiarPassword" bindOn="botonCambiarPassword" cssStyle="display:none">
								<s:form id="cambiarPass" method="post" action="cambiarPasswordResponsable">
									<s:password label="%{getText('modificarPerfilCandidato.datosPersonales.passwordAntigua')}" name="passwordAntigua" required="true"/>
									<s:password label="%{getText('modificarPerfilCandidato.datosPersonales.passwordNueva')}" name="passwordNueva" required="true"/>
									<s:password label="%{getText('modificarPerfilCandidato.datosPersonales.repetirPassword')}" name="password" required="true"/>
									<s:submit value="Cambiar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"/>
								</s:form>
							</sj:div>
								
					
								
								</div>
							</div>
						</div>
						</div>
					</div>
				
	<!-- content block End -->
	<!-- Footer block START -->	
	<div id="footer">
		<div id="copyright"> <s:text name="global.copyright"/> </div>
		<div id="designby">Design by <a href="http://www.flashdaweb.com/">Flashdaweb</a></div>
		<div id="bottom_menu"> </div>
	</div>
	
</div>

</body>

</html>

