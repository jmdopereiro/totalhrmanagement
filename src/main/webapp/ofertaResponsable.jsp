<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>
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
				<li class="active"><a href="<s:property value="#urlOfertas"/>"><b><s:text name="responsable.ofertas"/></b></a></li>
				<li><a href="<s:property value="#urlCandidatos"/>"><b><s:text name="responsable.candidatos"/></b></a></li>
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
				<!--s:if test="oferta.estado!='Creada' && oferta.estado!='Eliminada'"-->
					<div class="db3" style="margin-top:0px" >
						<div class="bd3_top">
							<div class="bd3_top_content">&nbsp;</div>
						</div>
						<div class="db3_content">
								<h3><s:text name="oferta.general.consultarCandidatos"/></h3>
								<s:url var="enlaceBuscarCandidatos" action="buscarCandidatosOferta">
									<s:param name="id" value="%{oferta.key.id}"/>
								</s:url>
								<s:a href="%{enlaceBuscarCandidatos}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Pulsa aqui </s:a>
						</div>
						<div class="bd3_bot">
							<div class="bd3_bot_content">&nbsp;</div>
						</div>
					</div>
				<!--/s:if-->
				<!-- design box 2 start -->
				<!--s:if test="%{#request.oferta.estado=='Creada' || oferta.estado == null}"-->
					<div class="db2">
						<div class="bd2_top">
							<div class="bd2_top_content">&nbsp;</div>
						</div>
						<div class="db2_content">
							<div class="db2_content_container">
								<h3><s:text name="oferta.general.modificarOferta"/></h3>
								
									<s:url var="enlaceModificarOferta" action="mostrarEditarOferta">
										<s:param name="id" value="%{oferta.key.id}"/>
									</s:url>
									<s:a href="%{enlaceModificarOferta}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Pulsa aqui </s:a>
								
							</div>
						</div>
						<div class="bd2_bot">
							<div class="bd2_bot_content">&nbsp;</div>
						</div>
					</div>
					
					<div class="db3">
						<div class="bd3_top">
							<div class="bd3_top_content">&nbsp;</div>
						</div>
						<div class="db3_content">
							<div class="db3_content_container">
							<h3><s:text name="oferta.general.eliminarOferta"/></h3>
								
									<s:url var="enlaceEliminarOferta" action="eliminarOferta">
										<s:param name="id" value="%{oferta.key.id}"/>
									</s:url>
									<s:a href="%{enlaceEliminarOferta}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Pulsa aqui </s:a>
							</div>
						</div>
						<div class="bd3_bot">
							<div class="bd3_bot_content">&nbsp;</div>
						</div>
					</div>
				<!--/s:if-->
				<s:else>
					<s:if test="%{#request.oferta.estado!='Eliminada'}">
						<div class="db2">
						<div class="bd2_top">
							<div class="bd2_top_content">&nbsp;</div>
						</div>
						<div class="db2_content">
							<div class="db2_content_container">
								<h3><s:text name="oferta.general.modificarOferta"/></h3>
									<b><s:text name="oferta.noModificable"/></b>
							</div>
						</div>
						<div class="bd2_bot">
							<div class="bd2_bot_content">&nbsp;</div>
						</div>
					</div>		
					</s:if>	
				</s:else>
		</div>
		<!-- left column start-->
		<div class="left_col">
			<div class="db1">
				<div class="db1_title">
					<h3><s:property value="oferta.nombre"/><s:date name="%{oferta.fechafin}" nice="true"/></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
			
					<div class="db1" style="width:518px; float:left; margin-right:25px; margin-left:25px;">
							<s:if test="%{#request.oferta==null}"> 
								<strong><s:text name="oferta.noExiste"/> </strong>
							</s:if>
							<s:else>
								<sj:accordion id="acordeon">
    							<sj:accordionItem title="Características">
    							<table>
    								<tr><td colspan="2"><strong><s:text name="oferta.datosGenericos.empresa"/></strong> <s:property value="oferta.empresa.nombre"/> <s:property value="oferta.empresa.tiposociedad"/></td> </tr>
									<tr><td colspan="2"><strong><s:text name="oferta.datosGenericos.tipoContrato"/></strong> <s:property value="oferta.tipoContrato"/> </td></tr>
									<tr><td><strong><s:text name="oferta.datosGenericos.duracion"/></strong> <s:property value="oferta.duracion"/> </td>
									<td><strong><s:text name="oferta.datosGenericos.jornada"/></strong> <s:property value="oferta.jornada"/> </td></tr>
									<tr><td><strong><s:text name="oferta.datosGenericos.fechaInicio"/></strong> <s:date name="%{oferta.fechainicio}" format="%{getText('global.formatoFecha')}"/> </td>
									<td><strong><s:text name="oferta.datosGenericos.fechaFin"/></strong> <s:date name="%{oferta.fechafin}" format="%{getText('global.formatoFecha')}"/> </td></tr>
									<tr><td><strong><s:text name="oferta.datosGenericos.poblacion"/></strong> <s:property value="oferta.poblacion"/> </td>
									<td><strong><s:text name="oferta.datosGenericos.pais"/></strong> <s:property value="oferta.pais"/> </td></tr>
									<tr><td><strong><s:text name="oferta.datosGenericos.remunMin"/></strong> <s:property value="oferta.remuneracionminima"/> </td>
									<td><strong><s:text name="oferta.datosGenericos.remunMax"/></strong> <s:property value="oferta.remuneracionmaxima"/> </td></tr>
									<tr><td colspan="2"><strong><s:text name="oferta.datosGenericos.otrasRetribuciones"/></strong> <s:property value="oferta.otrasretribuciones"/></td> </tr>
									<tr><td colspan="2"><strong><s:text name="oferta.datosGenericos.descripcion"/></strong> <s:property value="oferta.descripcion"/></td> </tr>
									<tr><td colspan="2"><strong><s:text name="oferta.datosGenericos.otrosDatos"/></strong> <s:property value="oferta.otrosdatos"/> </td></tr>
								</table>
								</sj:accordionItem>
								<sj:accordionItem title="%{getText('oferta.requisitos.titulo')}">
								<table>
									<tr><td><strong><s:text name="oferta.requisitos.experienciaMin"/></strong> <s:property value="oferta.experienciaminima"/> </td>
									<td><strong><s:text name="oferta.requisitos.experienciaMax"/></strong> <s:property value="oferta.experienciaMaxima"/> </td></tr>
									<tr><td><strong><s:text name="oferta.requisitos.edadMin"/></strong> <s:property value="oferta.edadMinima"/> </td>
									<td><strong><s:text name="oferta.requisitos.edadMax"/> </strong><s:property value="oferta.edadMaxima"/> </td></tr>
									<tr><td>
										<strong><s:text name="oferta.requisitos.carne"/></strong>
										<s:if test="oferta.carnetconducir==true">
											<s:text name="global.si"/>
										</s:if>
										<s:else>
											<s:text name="global.no"/>
										</s:else>
									</td>
									<td>
										<strong><s:text name="oferta.requisitos.vehiculo"/></strong>
										<s:if test="oferta.vehiculo==true">
											<s:text name="global.si"/>
										</s:if>
										<s:else>
											<s:text name="global.no"/>
										</s:else>
									</td></tr>
									<tr><td>
										<strong><s:text name="oferta.requisitos.trabaja"/></strong>
										<s:if test="oferta.trabajaactualmente==true">
											<s:text name="global.si"/>
										</s:if>
										<s:else>
											<s:text name="global.no"/>
										</s:else>
									</td>
										<td><strong><s:text name="oferta.requisitos.movilidad"/></strong> <s:property value="oferta.movilidad"/> </td></tr>
								</table>
								</sj:accordionItem>
								
								<sj:accordionItem title="Formación académica">
									<s:if test="%{#request.oferta.cursoses.size()==0}"> 
										<strong> <s:text name="oferta.datosFormacion.sinFormacion"/> </strong>
									</s:if>
									<s:else> 
										<table>
										<caption><s:text name="oferta.formacion.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="oferta.datosFormacion.tipoCurso"/></th>
										<th scope="col"><s:text name="oferta.datosFormacion.nombreCurso"/></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="1"><s:property value="#request.oferta.cursoses.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
											<s:iterator value="#request.oferta.cursoses" var="curso" status="contadorF">
											<s:if test="#contadorF.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url var="urlVerOferta" action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#curso.tipo"/></a></th>
											<td><s:property value="#curso.curso"/></td>
											</tr>
											</s:iterator>
										</tbody>
										</table>
									</s:else>
								</sj:accordionItem>
								
								<sj:accordionItem title="%{getText('oferta.idiomas.titulo')}">
									<s:if test="%{#request.oferta.idiomasenofertases.size()==0}"> 
										<strong> <s:text name="oferta.datosIdiomas.sinIdiomas"/> </strong>
									</s:if>
									<s:else> 
										<table>
										<caption><s:text name="oferta.idiomas.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="oferta.datosIdiomas.nombre"/></th>
										<th scope="col"><s:text name="oferta.datosIdiomas.nivelHablado"/></th>
										<th scope="col"><s:text name="oferta.datosIdiomas.nivelEscrito"/></th>
										<th scope="col"><s:text name="oferta.datosIdiomas.nivelTraduccion"/></th>
										<th scope="col"><s:text name="oferta.datosIdiomas.nivelTecnico"/></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="4"><s:property value="#request.oferta.idiomasenofertases.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
											<s:iterator value="#request.oferta.idiomasenofertases" var="idioma" status="contadorI">
											<s:if test="#contadorI.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url var="urlVerOferta" action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#idioma.idiomas.nombre"/></a></th>
											<td><s:property value="#idioma.hablado"/></td>
											<td><s:property value="#idioma.escrito"/></td>
											<td><s:property value="#idioma.traduccion"/></td>
											<td><s:property value="#idioma.tecnico"/></td>
											</tr>
											</s:iterator>
										</tbody>
										</table>
									</s:else>
								</sj:accordionItem>
									
								<sj:accordionItem title="Conocimientos informáticos">
									<s:if test="%{#request.oferta.conocimientosEnOfertas.size()==0}"> 
										<strong> <s:text name="oferta.datosConocimientos.sinConocimientos"/> </strong>
									</s:if>
									<s:else> 
										<table>
										<caption><s:text name="oferta.conocimientos.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="oferta.datosConocimientos.nombre"/></th>
										<th scope="col"><s:text name="oferta.datosConocimientos.nivel"/></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="1"><s:property value="#request.oferta.conocimientosEnOfertas.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
											<s:iterator value="#request.oferta.conocimientosEnOfertas" var="conocimiento" status="contadorC">
											<s:if test="#contadorC.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url var="urlVerOferta" action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#conocimiento.conocimientos.nombre"/></a></th>
											<td><s:property value="#conocimiento.nivel"/></td>
											</tr>
											</s:iterator>
										</tbody>
										</table>
									</s:else>
								
								</sj:accordionItem>
							</sj:accordion>
							</s:else>
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


