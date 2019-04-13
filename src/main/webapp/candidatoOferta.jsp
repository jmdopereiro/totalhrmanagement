<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" lang="es"/>
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<sj:head compressed="false" jqueryui="true" defaultIndicator="indicadorEspera" jquerytheme="ui-lightness" locale="es"/>
<script language="javascript">
$(document).ready(function()
{
	var mostrarEliminar =<%=request.getAttribute("inscripcionError")%>;
	if(mostrarEliminar==false || mostrarEliminar==null)
	{
		$('#capaEliminarInscripcion').hide();
	}
	$('#botonEliminarInscripcion').bind('click',function() 
	{
		$('#capaEliminarInscripcion').show('slow');
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
				<li class="active"><a href="<s:property value="#urlCandidatos"/>"><b><s:text name="responsable.candidatos"/></b></a></li>
				<li><a href="<s:property value="#urlPerfil"/>"><b><s:text name="responsable.perfil"/></b></a></li>
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
			<s:if test="oferta.estado=='Preseleccion' && inscripcion.estado=='Preseleccion'">
				<div class="db3" style="margin-top:0px" >
					<div class="bd3_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db3_content">
					
					<h3>
						<s:text name="oferta.general.aceptarCandidatura"/>
					</h3>
						<s:text name="oferta.general.aceptarCandidatura.texto"/><i>&nbsp;"<s:property value="oferta.nombre"/>"</i><br/><br/><br/>
						
						<s:url var="urlAceptar" action="aceptarCandidatura">
									<s:param name="idOferta">
										<s:property value="%{oferta.idoferta}"/>
									</s:param>
									<s:param name="idCandidato">
										<s:property value="%{candidato.idcandidato}"/>
									</s:param>
								</s:url>
								<s:a href="%{#urlAceptar}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Aceptar candidatura</s:a>
						
					</div>
					<div class="bd3_bot">
						<div class="bd3_bot_content">&nbsp;</div>
					</div>
				</div>
					
				<!-- design box 2 start -->
				<div class="db2">
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<div class="db2_content_container">
							
							<h3>
								<s:text name="oferta.general.desestimarCandidatura"/>
							</h3>
								<s:text name="oferta.general.desestimarCandidatura.texto"/><i>&nbsp;"<s:property value="oferta.nombre"/>"</i><br/><br/><br/>	
									
								<s:url var="urlDesestimar" action="desestimarCandidatura">
									<s:param name="idOferta">
										<s:property value="%{oferta.idoferta}"/>
									</s:param>
									<s:param name="idCandidato">
										<s:property value="%{candidato.idcandidato}"/>
									</s:param>
								</s:url>
								<s:a href="%{#urlDesestimar}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Desestimar candidatura</s:a>
						</div>
					</div>
					<div class="bd2_bot">
						<div class="bd2_bot_content">&nbsp;</div>
					</div>
				</div>
			</s:if>
		</div>
		<!-- left column start-->
		<div class="left_col">
			<div class="db1">
				<div class="db1_title">
					<h3><s:property value="candidato.nombre"/> <s:property value="candidato.apellidos"/></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
			
					<div class="db1" style="width:518px; float:left; margin-right:25px; margin-left:25px;">
			
							<sj:accordion id="acordeon">
   								<sj:accordionItem title="%{getText('candidato.datosPersonales.titulo')}">
								<strong><s:text name="candidato.datosPersonales.dni"/>:</strong><s:property value="#request.candidato.dni"/> <br/>
								<strong><s:text name="candidato.datosPersonales.nombre"/>:</strong> <s:property value="#request.candidato.nombre"/> <br/>
								<strong><s:text name="candidato.datosPersonales.apellidos"/>:</strong> <s:property value="#request.candidato.apellidos"/> <br/>
								<strong><s:text name="candidato.datosPersonales.fechaNacimiento"/>:</strong> <s:date name="#request.candidato.fechaNacimiento" format="%{getText('global.formatoFecha')}"/> <br/>
								<strong><s:text name="candidato.datosPersonales.direccion"/>:</strong> <s:property value="#request.candidato.direccion"/> <br/>
								<strong><s:text name="candidato.datosPersonales.fijo"/>:</strong><s:property value="#request.candidato.fijo"/> <br/>
								<strong><s:text name="candidato.datosPersonales.movil"/>:</strong> <s:property value="#request.candidato.movil"/> <br/>
								<strong><s:text name="candidato.datosPersonales.fax"/>:</strong>	<s:property value="#request.candidato.fax"/> <br/>
								<strong><s:text name="candidato.datosPersonales.email"/>:</strong>	<s:property value="#request.candidato.email"/> <br/>
								<strong><s:text name="candidato.datosPersonales.genero"/>:</strong>	<s:property value="#request.candidato.genero"/> <br/>
								<strong><s:text name="candidato.datosPersonales.nacionalidad"/>:</strong>	<s:property value="#request.candidato.nacionalidad"/> <br/>
								<strong><s:text name="candidato.datosPersonales.estadoCivil"/>:</strong>	<s:property value="#request.candidato.estadocivil"/> <br/>
								<strong><s:text name="candidato.datosPersonales.carnet"/>:</strong>
								<s:if test="#request.candidato.carnetconducir==true">
									<s:text name="global.si"/>
								</s:if>
								<s:else>
									<s:text name="global.no"/>
								</s:else>
								<br/>
								<strong><s:text name="candidato.datosPersonales.vehiculo"/>:</strong>
								<s:if test="#request.candidato.vehiculopropio==true">
									<s:text name="global.si"/>
								</s:if>
								<s:else>
									<s:text name="global.no"/>
								</s:else>
								<br/>
								<strong><s:text name="candidato.datosPersonales.trabaja"/>:</strong>
								<s:if test="#request.candidato.trabajaactualmente==true">
									<s:text name="global.si"/>
								</s:if>
								<s:else>
									<s:text name="global.no"/>
								</s:else>
								<br/>
								<strong><s:text name="candidato.datosPersonales.movilidad"/>:</strong>	<s:property value="#request.candidato.movilidad"/> <br/>
								<strong><s:text name="candidato.datosPersonales.otrosDatos"/>:</strong><s:property value="#request.candidato.otrosdatos"/> <br/>
								</sj:accordionItem>
							
							<sj:accordionItem title="%{getText('candidato.datosFormacion.titulo')}">
								<s:if test="%{#request.candidato.formaciones.size()==0}"> 
									<strong><s:text name="candidato.datosFormacion.sinFormacion"/></strong>
								</s:if>
								<s:else> 
									<table width="500" border="1"> 
									<tr>
									<td><strong><s:text name="candidato.datosFormacion.nombre"/></strong></td>
									<td><strong><s:text name="candidato.datosFormacion.tipo"/></strong></td>
									<td><strong><s:text name="candidato.datosFormacion.centro"/></strong></td>
									<td><strong><s:text name="candidato.datosFormacion.añoInicio"/></strong></td>
									<td><strong><s:text name="candidato.datosFormacion.añoFin"/></strong></td>
									<td><strong><s:text name="candidato.datosFormacion.notaMedia"/></strong></td>
									</tr>
									<s:iterator value="#request.candidato.formaciones" var="form">
										<tr>
										<td><s:property value="#form.cursos.curso"/> <br/></td>
										<td><s:property value="#form.cursos.tipo"/> <br/></td>
										<td><s:property value="#form.centro"/> <br/></td>
										<td><s:property value="#form.annoinicio"/></td>
										<td><s:property value="#form.annofin"/></td>
										<td><s:property value="#form.notamedia"/> <br/></td>
										</tr>
									</s:iterator>
									</table>
								</s:else>
							</sj:accordionItem>
							
							<sj:accordionItem title="%{getText('candidato.datosExperiencia.titulo')}">
								<s:if test="%{#request.candidato.experienciases.size()==0}"> 
									<strong><s:text name="candidato.datosExperiencia.sinExperiencia"/> </strong>
								</s:if>
								<s:else> 
									<table width="500" border="1"> 
									<tr>
									<td><strong><s:text name="candidato.datosExperiencia.tipo"/></strong></td>
									<td><strong><s:text name="candidato.datosExperiencia.puestoTrabajo"/></strong></td>
									<td><strong><s:text name="candidato.datosExperiencia.empresa"/></strong></td>
									<td><strong><s:text name="candidato.datosExperiencia.departamento"/></strong></td>
									<td><strong><s:text name="candidato.datosExperiencia.añoInicio"/></strong></td>
									<td><strong><s:text name="candidato.datosExperiencia.añoFin"/></strong></td>
									<td><strong><s:text name="candidato.datosExperiencia.duracion"/></strong></td>
									</tr>
									<s:iterator value="#request.candidato.experienciases" var="exp">
										<tr>
										<td><s:property value="#exp.tipo"/> <br/></td>
										<td><s:property value="#exp.puestotrabajo"/></td>
										<td><s:property value="#exp.empresa"/></td>
										<td><s:property value="#exp.departamento"/></td>
										<td><s:property value="#exp.annoinicio"/></td>
										<td><s:property value="#exp.annofin"/></td>
										<td><s:property value="#exp.duracion"/></td>
										</tr>
									</s:iterator>
									</table>
								</s:else>
							</sj:accordionItem>
						</sj:accordion>
							
					</div>
					
						<p class="clear_left"></p>
						
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

</div>
</body>

</html>


