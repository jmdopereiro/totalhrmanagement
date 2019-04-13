<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%--<%@ taglib prefix="img" uri="/struts-images"%>--%>
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
				<div class="db3" style="margin-top:0px" >
					<div class="bd3_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db3_content">
					
						<h3>
							<s:text name="candidato.curriculum"/>
						</h3>
						<s:if test="#request.candidato.curriculums.size()==0">
							<b><s:text name="candidato.curriculum.noTiene"/></b>
						</s:if>
						<s:else>
							<s:iterator value="%{#request.candidato.curriculums}" var="curriculum" status="contadorC">
								<s:url var="urlDescargarCurriculum" action="descargarCurriculum">	
									<s:param name="curriculumId" value="#curriculum.key.id"/>
									<s:param name="id" value="candidato.key.id"/>
								</s:url>
								
								<s:property value="#curriculum.idioma"/>&nbsp;
								<i><s:date name="%{#curriculum.fechainsercion}" format="%{getText('global.formatoFecha')}"/></i>&nbsp;
								<s:a href="%{#urlDescargarCurriculum}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Descargar</s:a>
								<br/>
							</s:iterator>
						</s:else>
						
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
								<s:text name="candidato.fotografia"/>
							</h3>
							<s:if test="candidato.foto==null">
								<b><s:text name="candidato.fotografia.noTiene"/></b>
							</s:if>
							<s:else>

								<s:url var="urlFoto" action="mostrarFoto">
									<s:param name="id" value="candidato.key.id"/>
								</s:url>
								<img src="<s:property value="#urlFoto"/>" width="351" />

							  <br/><br/>
							</s:else>
						</div>
					</div>
					<div class="bd2_bot">
						<div class="bd2_bot_content">&nbsp;</div>
					</div>
			</div>	
					
					
				<!-- design box 2 start -->
		
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
								<table>
										<tr><td><strong><s:text name="candidato.datosPersonales.dni"/>:</strong> <s:property value="#request.candidato.dni"/></td>
										<td><strong><s:text name="candidato.datosPersonales.fechaNacimiento"/>:</strong> <s:date name="#request.candidato.fechaNacimiento" format="%{getText('global.formatoFecha')}"/></td></tr>
										<tr><td><strong><s:text name="candidato.datosPersonales.nombre"/>:</strong> <s:property value="#request.candidato.nombre"/></td>
										<td><strong><s:text name="candidato.datosPersonales.apellidos"/>:</strong> <s:property value="#request.candidato.apellidos"/></td></tr>
										<tr><td colspan="2"><strong><s:text name="candidato.datosPersonales.direccion"/>:</strong> <s:property value="#request.candidato.direccion"/></td></tr>
										<tr><td><strong><s:text name="candidato.datosPersonales.fijo"/>:</strong> <s:property value="#request.candidato.fijo"/> </td>
										<td><strong><s:text name="candidato.datosPersonales.movil"/>:</strong> <s:property value="#request.candidato.movil"/></td></tr>
										<tr><td><strong><s:text name="candidato.datosPersonales.fax"/>:</strong> <s:property value="#request.candidato.fax"/> </td>
										<td><strong><s:text name="candidato.datosPersonales.email"/>:</strong> <s:property value="#request.candidato.email"/> </td></tr>
										<tr><td><strong><s:text name="candidato.datosPersonales.genero"/>:</strong>	<s:property value="#request.candidato.genero"/> </td>
										<td><strong><s:text name="candidato.datosPersonales.nacionalidad"/>:</strong> <s:property value="#request.candidato.nacionalidad"/></td></tr>
										<tr><td><strong><s:text name="candidato.datosPersonales.estadoCivil"/>:</strong> <s:property value="#request.candidato.estadocivil"/></td>
										<td><strong><s:text name="candidato.datosPersonales.carnet"/>:</strong>
										<s:if test="#request.candidato.carnetconducir==true">
											<s:text name="global.si"/>
										</s:if>
										<s:else>
											<s:text name="global.no"/>
										</s:else>
										</td></tr>
										<tr><td><strong><s:text name="candidato.datosPersonales.vehiculo"/>:</strong>
										<s:if test="#request.candidato.vehiculopropio==true">
											<s:text name="global.si"/>
										</s:if>
										<s:else>
											<s:text name="global.no"/>
										</s:else>
										</td>
										<td><strong><s:text name="candidato.datosPersonales.trabaja"/>:</strong>
										<s:if test="#request.candidato.trabajaactualmente==true">
											<s:text name="global.si"/>
										</s:if>
										<s:else>
											<s:text name="global.no"/>
										</s:else>
										</td></tr>
										<tr><td colspan="2"><strong><s:text name="candidato.datosPersonales.movilidad"/>:</strong>	<s:property value="#request.candidato.movilidad"/></td></tr>
										<tr><td colspan="2"><strong><s:text name="candidato.datosPersonales.otrosDatos"/>:</strong><s:property value="#request.candidato.otrosdatos"/></td></tr>	
									</table>
								</sj:accordionItem>
							
							<sj:accordionItem title="%{getText('candidato.datosFormacion.titulo')}">
								<s:if test="%{#request.candidato.formaciones.size()==0}"> 
									<strong><s:text name="candidato.datosFormacion.sinFormacion"/></strong>
									</s:if>
									<s:else> 
										<table>
										<caption><s:text name="candidato.datosFormacion.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="candidato.datosFormacion.nombre"/></th>
										<th scope="col"><s:text name="candidato.datosFormacion.tipo"/></th>
										<th scope="col"><s:text name="candidato.datosFormacion.centro"/></th>
										<th scope="col"><s:text name="candidato.datosFormacion.añoInicio"/></th>
										<th scope="col"><s:text name="candidato.datosFormacion.añoFin"/></th>
										<th scope="col"><s:text name="candidato.datosFormacion.notaMedia"/></th>
										<th scope="col"><s:text name="candidato.datosFormacion.expediente"/></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="6"><s:property value="#request.candidato.formaciones.size()"/></td> 
										</tr> 
										</tfoot>
										<s:iterator value="#request.candidato.formaciones" var="formacion">
											<tr>
											<td><s:property value="#formacion.cursos.curso"/> <br/></td>
											<td><s:property value="#formacion.cursos.tipo"/> <br/></td>
											<td><s:property value="#formacion.centro"/> <br/></td>
											<td><s:property value="#formacion.annoinicio"/></td>
											<td><s:property value="#formacion.annofin"/></td>
											<td><s:property value="#formacion.notamedia"/> <br/></td>
											<td><s:if test="#formacion.expediente!=null">
												<s:url var="urlDescargarExpediente" action="descargarExpediente">
													<s:param name="id" value="#request.candidato.key.id"/>
													<s:param name="formacionId" value="#formacion.key.id"/>
												</s:url>
												<s:a href="%{#urlDescargarExpediente}" >Descargar Expediente</s:a>
											</s:if></td>
											</tr>
										</s:iterator>
										</table>
									</s:else>
									<br/><br/>			
									<s:if test="%{#request.candidato.idiomasencandidatoses.size()==0}"> 
										<strong> <s:text name="candidato.datosFormacion.sinIdiomas"/> </strong>
									</s:if>
									<s:else> 
										<table>
										<caption><s:text name="candidato.datosIdiomas.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="candidato.datosIdiomas.nombre"/></th>
										<th scope="col"><s:text name="candidato.datosIdiomas.nivelEscrito"/></th>
										<th scope="col"><s:text name="candidato.datosIdiomas.nivelHablado"/></th>
										<th scope="col"><s:text name="candidato.datosIdiomas.nivelTraduccion"/></th>
										<th scope="col"><s:text name="candidato.datosIdiomas.nivelTecnico"/></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="4"><s:property value="#request.candidato.idiomasencandidatoses.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
											<s:iterator value="#request.candidato.idiomasencandidatoses" var="idiomaC" status="contadorI">
											<s:if test="#contadorI.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#idiomaC.idiomas.nombre"/></a></th>
											<td><s:property value="#idiomaC.escrito"/></td>
											<td><s:property value="#idiomaC.hablado"/></td>
											<td><s:property value="#idiomaC.traduccion"/></td>
											<td><s:property value="#idiomaC.tecnico"/></td>
											</tr>
											</s:iterator>
										</tbody>
										</table>
									</s:else>	
									<br/><br/>
									<s:if test="%{#request.candidato.conocimientosencandidatoses.size()==0}"> 
										<strong> <s:text name="candidato.datosFormacion.sinConocimientos"/> </strong>
									</s:if>
									<s:else> 
										<table>
										<caption><s:text name="candidato.datosConocimientosInformaticos.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="candidato.datosConocimientos.nombre"/></th>
										<th scope="col"><s:text name="candidato.datosConocimientos.nivel"/></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="2"><s:property value="#request.candidato.conocimientosencandidatoses.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
											<s:iterator value="#request.candidato.conocimientosencandidatoses" var="conocimientoC" status="contadorC">
											<s:if test="#contadorC.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url var="urlVerOferta" action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#conocimientoC.conocimientos.nombre"/></a></th>
											<td><s:property value="#conocimientoC.nivel"/></td>
											</tr>
											</s:iterator>
										</tbody>
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


