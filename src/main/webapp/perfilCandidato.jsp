<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="img" uri="/struts-images"%>--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<%--<sx:head/>--%>
<sj:head jqueryui="true" jquerytheme="ui-lightness" locale="es"/>
<script language="javascript">
$(document).ready(function()
{
	var mostrarEliminar =<%=request.getParameter("perfilError")%>;
	if(mostrarEliminar==false || mostrarEliminar==null)
	{
		$('#capaEliminarPerfil').hide();
	}
	else if (mostrarEliminar==true)
	{
		$('#capaEliminarPerfil').show('slow');
	}
	$('#capaSubirCurriculum').hide();
	$('#capaSubirFoto').hide();
	$('#capaModificarFoto').hide();
	$('#botonEliminarPerfil').bind('click',function() 
	{
		$('#capaEliminarPerfil').show('slow');
	});
	$('#botonSubirCurriculum').bind('click',function() 
	{
		$('#capaSubirCurriculum').show('slow');
	});
	$('#botonSubirFoto').bind('click',function() 
	{
		$('#capaSubirFoto').show('slow');
	});
	$('#botonModificarFoto').bind('click',function() 
	{
		$('#capaModificarFoto').show('slow');
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
				<s:url var="urlInicio" action="mostrarPrincipalCandidato"/>
				<s:url var="urlOfertas" action="mostrarOfertas"/>
				<s:url var="urlEmpresas" action="mostrarEmpresas"/>
				<s:url var="urlInscripciones" action="mostrarInscripciones"/>
				<s:url var="urlPerfil" action="mostrarPerfil"/>
				<s:url var="urlAyuda" action="mostrarAyuda"/>
				<s:url var="urlSalir" action="logout"/>
				<li><a href="<s:property value="#urlInicio"/>"><b><s:text name="global.inicio"/></b></a></li>
				<li><a href="<s:property value="#urlOfertas"/>"><b><s:text name="candidato.ofertas"/></b></a></li>
				<li><a href="<s:property value="#urlEmpresas"/>"><b><s:text name="candidato.empresas"/></b></a></li>
				<li><a href="<s:property value="#urlInscripciones"/>"><b><s:text name="candidato.inscripciones"/></b></a></li>
				<li class="active"><a href="<s:property value="#urlPerfil"/>"><b><s:text name="candidato.perfil"/></b></a></li>
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
				<div class="db2" style="margin-top:0px" >
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<div class="db2_content_container">
							<h3><s:text name="candidato.modificarPerfil"/></h3>
							<s:url var="modificarPerfil" action="modificarPerfilCandidato"/>
							<s:a href="%{#modificarPerfil}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Pulsa aqui</s:a>	
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
						<h3><s:text name="candidato.curriculum"/></h3>
							<s:if test="%{#request.curriculums.size()==0}">
								<strong> <s:text name="candidato.sinCurriculums"/> </strong><br/><br/><br/>
							</s:if>
							<s:else>
								<s:iterator value="%{#request.curriculums}" var="curriculum" status="contadorC">
									<s:url var="urlDescargarCurriculum" action="descargarCurriculum">
										<s:param name="curriculumId" value="#curriculum.key.id"/>
									</s:url>
									<s:url var="urlEliminarCurriculum" action="eliminarCurriculum">
										<s:param name="curriculumId" value="#curriculum.key.id"/>
									</s:url>
									<s:property value="#curriculum.idioma"/>&nbsp;
									<i><s:date name="%{#curriculum.fechainsercion}" format="%{getText('global.formatoFecha')}"/></i>&nbsp;
									<s:a href="%{#urlDescargarCurriculum}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Descargar</s:a>
									<s:a href="%{#urlEliminarCurriculum}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Eliminar</s:a>
									<br/>
								</s:iterator>
							</s:else>
							<sj:a  id="botonSubirCurriculum" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"> Añadir curriculum</sj:a>
							<sj:div id="capaSubirCurriculum" bindOn="botonSubirCurriculum" cssStyle="display:none">
								<br/>
								<i><s:text name="global.mensaje.formatoCurriculum"/></i>
								<br/><br/>
								<s:form id="subirCurriculum" method="post" action="subirCurriculum" enctype="multipart/form-data">
									<s:set var="listaIdiomas" value="{'Español','Inglés','Francés','Alemán','Italiano','Portugues'}"/>
									<s:select label="Idioma" name="idiomaCurriculum" required="true" requiredposition="left" cssClass="styled"  
										list="#listaIdiomas"  headerValue="Seleccione un idioma" headerKey="-1"/>
									<s:file label="Fichero" name="fichero" required="true" requiredposition="left"/>
									<s:submit value="Enviar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"/>
								</s:form>
							</sj:div>
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
						<h3><s:text name="candidato.fotografia"/></h3>
						<s:if test="#request.candidato.foto==null"> 
							<strong><s:text name="candidato.sinFoto"/> </strong><br/><br/><br/>
							<sj:a  id="botonSubirFoto" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"> Añadir fotografía</sj:a>
							<sj:div id="capaSubirFoto" bindOn="botonSubirFoto" cssStyle="display:none">
							<br/>
							<i><s:text name="global.mensaje.formatoFoto"/></i>
							<br/><br/>
								<s:form id="subirFoto" method="post" action="subirFoto" enctype="multipart/form-data">
									<s:file label="Fichero" name="fichero" required="true" requiredposition="left"/>
									<s:submit value="Enviar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"/>
								</s:form>
							</sj:div> 
						</s:if>
						<s:else>
							<s:set var="urlFoto" value="request.candidato.foto"/>
							<s:url var="urlFotito" action="mostrarFoto"/>
						  
						  <s:url var="urlFoto" action="mostrarFoto">
						  	<s:param name="id" value="#candidato.key.id"/>
					  	  </s:url>
						<img src="<s:property value="#urlFoto"/>" width="350" />

						  <br/><br/>
						  <sj:a  id="botonModificarFoto" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"> Modificar fotografía</sj:a>
							<sj:div id="capaModificarFoto" bindOn="botonModificarFoto" cssStyle="display:none">
							<br/>
							<i><s:text name="global.mensaje.formatoFoto"/></i>
							<br/><br/>
								<s:form id="subirFoto" method="post" action="subirFoto" enctype="multipart/form-data">
									<s:file label="Fichero" name="fichero" required="true" requiredposition="left"/>
									<s:submit value="Enviar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"/>
								</s:form>
							</sj:div>
							&nbsp;
							<s:url var="urlEliminarFoto" action="eliminarFoto">
								<s:param name="idCurriculum" value="#curricula.idcurriculum"/>
							</s:url> 
						<s:a href="%{#urlEliminarFoto}" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover">Eliminar fotografía</s:a>
						</s:else>
					</div>
					<div class="bd4_bot">
						<div class="bd4_bot_content">&nbsp;</div>
					</div>
				</div>
				<div class="db3" style="" >
					<div class="bd3_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db3_content">
						<h3><s:text name="candidato.eliminarPerfil"/></h3>
						<sj:a id="botonEliminarPerfil" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"> Pulsa aqui</sj:a>
						<sj:div id="capaEliminarPerfil" bindOn="botonEliminarPerfil">
							<s:form id="eliminarPerfil" method="post" action="eliminarCandidato">
								<s:textfield label="Introduzca (ELIMINAR)" name="palabraClave" />
								<s:submit value="Confirmar baja" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"/>
							</s:form>
						</sj:div>
					</div>
					<div class="bd3_bot">
						<div class="bd3_bot_content">&nbsp;</div>
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
					
					<div class="db1" style="width:548px; float:left; margin-right:25px;">
						<div class="db1_title">
							<h3><s:text name="candidato.datos.titulo"/></h3>
						</div>					
						<div class="db1_content">
							<div class="db1_container">
							<br/>
							<sj:tabbedpanel id="panelInfo" collapsible="true" selectedTab="0">
      							<sj:tab id="tabPersonal" target="capaPersonal" label="%{getText('candidato.datosPersonales.titulo')}"/>
								<sj:tab id="tabFormacion" target="capaFormacion" label="%{getText('candidato.datosFormacion.titulo')}"/>
								<sj:tab id="tabExperiencia" target="capaExperiencia" label="%{getText('candidato.datosExperiencia.titulo')}"/>
							
								<div id="capaPersonal">
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
								</div>
								
								<div id="capaFormacion">
									
									 
									<table>
									<caption><s:text name="candidato.datosFormacion.titulo"/></caption> 
									<thead>
									<tr>
									<th scope="col"><s:text name="candidato.datosFormacion.nombre"/></th>
									<th scope="col"><s:text name="candidato.datosFormacion.tipo"/></th>
									<th scope="col"><s:text name="candidato.datosFormacion.centro"/></th>
									<th scope="col"><s:text name="candidato.datosFormacion.anoInicio"/></th>
									<th scope="col"><s:text name="candidato.datosFormacion.anoFin"/></th>
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
									<tbody>
									<s:if test="%{#request.candidato.formaciones.size()!=0}"> 
										<s:iterator value="#request.candidato.formaciones" var="formacion">
											<tr>
											<th scope="row"><s:property value="#formacion.cursos.curso"/></th>
											<td><s:property value="#formacion.cursos.tipo"/></td>
											<td><s:property value="#formacion.centro"/></td>
											<td><s:property value="#formacion.annoinicio"/></td>
											<td><s:property value="#formacion.annofin"/></td>
											<td><s:property value="#formacion.notamedia"/></td>
												<td><s:if test="#formacion.expediente!=null">
													<s:url var="urlDescargarExpediente" action="descargarExpediente">
														<s:param name="formacionId" value="#formacion.key.id"/>
													</s:url>
													<s:a href="%{#urlDescargarExpediente}" >Descargar Expediente</s:a>
												</s:if></td>
										</s:iterator>
									</s:if>
									</tbody>
									</table>
									<br/><br/>			
							 
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
										<td colspan="4"><s:property value="#request.candidato.idiomasEnCandidato.size()"/></td> 
									</tr> 
									</tfoot> 
									<tbody> 
									<s:if test="%{#request.candidato.idiomasEnCandidato.size()!=0}">
										<s:iterator value="#request.candidato.idiomasEnCandidato" var="idiomaC" status="contadorI">
										<s:if test="#contadorI.count%2==0"><tr></s:if>
										<s:else><tr class="odd"></s:else>
										<s:url var="urlVerOferta" action="verOferta"/>
										<th scope="row"><s:property value="#idiomaC.idioma.nombre"/></th>
										<td><s:property value="#idiomaC.escrito"/></td>
										<td><s:property value="#idiomaC.hablado"/></td>
										<td><s:property value="#idiomaC.traduccion"/></td>
										<td><s:property value="#idiomaC.tecnico"/></td>
										</tr>
										</s:iterator>
									</s:if>
									</tbody>
									</table>
									<br/><br/>
									
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
										<td colspan="2"><s:property value="#request.candidato.conocimientosEnCandidato.size()"/></td> 
									</tr> 
									</tfoot> 
									<tbody> 
									<s:if test="%{#request.candidato.conocimientosEnCandidato.size()!=0}"> 
										<s:iterator value="#request.candidato.conocimientosEnCandidato" var="conocimientoEnCandidato" status="contadorC">
										<s:if test="#contadorC.count%2==0"><tr></s:if>
										<s:else><tr class="odd"></s:else>
										<s:url var="urlVerOferta" action="verOferta"/>
										<th scope="row"><s:property value="#conocimientoEnCandidato.conocimiento.nombre"/></th>
										<td><s:property value="#conocimientoEnCandidato.nivel"/></td>
										</tr>
										</s:iterator>
									</s:if>
									</tbody>
									</table>
								</div>
								
								<div id="capaExperiencia">
									<s:if test="%{#request.candidato.experiencias.size()==0}"> 
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
										<s:iterator value="#request.candidato.experiencias" var="experiencia">
											<tr>
											<td><s:property value="#experiencia.tipo"/> <br/></td>
											<td><s:property value="#experiencia.puestotrabajo"/></td>
											<td><s:property value="#experiencia.empresa"/></td>
											<td><s:property value="#experiencia.departamento"/></td>
											<td><s:property value="#experiencia.annoinicio"/></td>
											<td><s:property value="#experiencia.annofin"/></td>
											<td><s:property value="#experiencia.duracion"/></td>
											</tr>
										</s:iterator>
										</table>
									</s:else>
								</div>
								</sj:tabbedpanel>
							</div>
						</div>
					</div>
					<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
					
					<br/><br/><br/><br/>
					 <p class="clear_left">&nbsp;</p>
		
						<p class="clear_left"></p>
						<p></p>

					
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

