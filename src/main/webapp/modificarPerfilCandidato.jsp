<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/estiloRadioButton.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<%--<sx:head/>--%>
<s:head theme="xhtml"/>
<sj:head compressed="false" jqueryui="true" defaultIndicator="indicadorEspera" jquerytheme="ui-lightness" locale="es"/>
<script language="javascript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
<script language="javascript">
$(document).ready(function()
{
	var mostrarDatosPersonales =<%=request.getParameter("modificarDatosPersonalesError")%>;
	var mostrarFormacion =<%=request.getParameter("modificarFormacionError")%>;
	var mostrarExperiencia =<%=request.getParameter("modificarExperienciaError")%>;
	var mostrarCambiarPassword =<%=request.getParameter("modificarPasswordError")%>;
 	
	if(mostrarDatosPersonales==true)
	{
		$('#capaDatosPersonales').show('slow');
	}
	if(mostrarFormacion==true)
	{
		$('#capaFormacion').show('slow');
	}
	if(mostrarExperiencia==true)
	{
		$('#capaExperiencia').show('slow');
	}
	
	if(mostrarCambiarPassword==true)
	{
		$('#capaCambiarPassword').show('slow');
	}
	
	$('#botonDatosPersonales').click(function() 
	{
		$('#capaFormacion').hide();
		$('#capaExperiencia').hide();
		$('#capaCambiarPassword').hide();
  		$('#capaDatosPersonales').show('slow');
	});
	
	$('#botonFormacion').click(function() 
	{
		$('#capaDatosPersonales').hide();
		$('#capaExperiencia').hide();
		$('#capaCambiarPassword').hide();
  		$('#capaFormacion').show('slow');
	});
	
	$('#botonExperiencia').click(function() 
	{
		$('#capaFormacion').hide();
		$('#capaDatosPersonales').hide();
		$('#capaCambiarPassword').hide();
  		$('#capaExperiencia').show('slow');
	});
	
	$('#botonCambiarPassword').bind('click',function() 
	{
		$('#capaFormacion').hide();
		$('#capaDatosPersonales').hide();
		$('#capaExperiencia').hide();
		$('#capaCambiarPassword').show('slow');
	});
	
	$('#botonFormularioFormacion').click(function() 
	{
		$('#formularioIdioma').hide();
		$('#formularioConocimiento').hide();
  		$('#formularioFormacion').show('slow');
	});
	
	$('#botonFormularioIdioma').click(function() 
	{
		$('#formularioFormacion').hide();
		$('#formularioConocimiento').hide();
  		$('#formularioIdioma').show('slow');
	});
	
	$('#botonFormularioConocimiento').click(function() 
	{
		$('#formularioFormacion').hide();
		$('#formularioIdioma').hide();
  		$('#formularioConocimiento').show('slow');
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
							<h3><s:text name="candidato.modificarDatosPersonales"/></h3>
							<sj:a id="botonDatosPersonales" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Pulsa aqui</sj:a>	
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
							<h3><s:text name="candidato.modificarFormacion"/></h3>
							<sj:a id="botonFormacion" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Pulsa aqui</sj:a>	
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
						<h3><s:text name="candidato.modificarExperiencia"/></h3>
							<sj:a id="botonExperiencia" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Pulsa aqui</sj:a>
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
							<h3><s:text name="candidato.cambiarContraseña"/></h3>
							<sj:a id="botonCambiarPassword" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"> Pulsa aqui</sj:a>	
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
					<h3><s:text name="candidato.modificarPerfil"/></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
					
					<sj:div id="capaDatosPersonales" indicator="indicadorEspera" cssStyle="display:none">
						<s:form id="formPersonales" action="modificarDatosPersonalesCandidato" namespace="/" method="post" enctype="multipart/form-data" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" >
							<s:actionerror/>
							<s:textfield label="%{getText('registro.datosPersonales.dni')}" name="candidato.dni" required="true" requiredposition="left"/>
							<s:textfield label="%{getText('registro.datosPersonales.nombre')}" name="candidato.nombre" required="true" requiredposition="left"/>
							<s:textfield label="%{getText('registro.datosPersonales.apellidos')}" name="candidato.apellidos" required="true" requiredposition="left"/>
							<s:textfield label="%{getText('registro.datosPersonales.email')}" name="email" required="true" requiredposition="left"/>
							<s:textfield label="%{getText('registro.datosPersonales.repetirEmail')}" name="candidato.email" required="true" requiredposition="left"/>
							<sj:datepicker name="candidato.fechaNacimiento" label="%{getText('registro.datosPersonales.fechaNacimiento')}" yearRange="1900:today" changeMonth="true" changeYear="true" showButtonPanel="true"/>
							<sj:radio label="%{getText('registro.datosPersonales.genero')}" list="{'Masculino','Femenino'}" name="candidato.genero"/>
							<s:textfield label="%{getText('registro.datosPersonales.direccion')}" name="candidato.direccion"/>
							<s:textfield label="%{getText('registro.datosPersonales.fijo')}" name="candidato.fijo"/>
							<s:textfield label="%{getText('registro.datosPersonales.movil')}" name="candidato.movil"/>
							<s:textfield label="%{getText('registro.datosPersonales.fax')}" name="candidato.fax"/>	
							<s:select label="%{getText('registro.datosPersonales.nacionalidad')}" list="{'Española','Rumana'}" name="candidato.nacionalidad" cssClass="styled"/>
							<s:select label="%{getText('registro.datosPersonales.estadoCivil')}" list="{'Soltero','Casado','Viudo'}" name="candidato.estadocivil" cssClass="styled"/>
							<sj:radio label="%{getText('registro.datosPersonales.carnet')}" list="#{'true':'Si','false':'No'}" name="candidato.carnetconducir"/>
							<sj:radio label="%{getText('registro.datosPersonales.vehiculo')}" list="#{'true':'Si','false':'No'}" name="candidato.vehiculopropio"/>
							<sj:radio label="%{getText('registro.datosPersonales.trabaja')}" list="#{'true':'Si','false':'No'}" name="candidato.trabajaactualmente"/>
							<s:select label="%{getText('registro.datosPersonales.movilidad')}" list="{'Local','Provincial','Interprovincial','Internacional','Transoceanica'}" name="candidato.movilidad" cssClass="styled"/>
							<s:textarea label="%{getText('registro.datosPersonales.otrosDatos')}" name="candidato.otrosdatos" cols="25"/>
							<s:file label="%{getText('registro.datosPersonales.foto')}" name="fichero"/>
							<s:submit value="%{getText('global.modificar')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
						</s:form>
					</sj:div> 
					
					<sj:div id="capaFormacion" indicator="indicadorEspera" cssStyle="display:none">
						
						<sj:a id="botonFormularioFormacion" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"><s:text name="candidato.datosFormacion.titulo"/></sj:a>
						<sj:a id="botonFormularioIdioma" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"><s:text name="registroOferta.idiomas.titulo"/></sj:a>
						<sj:a id="botonFormularioConocimiento" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false"><s:text name="registroOferta.conocimientos.titulo"/></sj:a>
						
						<sj:div id="formularioFormacion" indicator="indicadorEspera" cssStyle="display:none">
							<s:form action="crearFormacionCandidato" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true" enctype="multipart/form-data">
								<s:actionerror/>
								<!--s:doubleselect label="%{getText('modificarPerfilCandidato.formacion.tipo')}" name="formacion.curso.nombre" doubleName="formacion.curso.tipo"
								 headerValue="Seleccione" headerKey="-1" list="#request.listaCursos"  doubleList="#request.listaCursos.get(top.idcurso)" listValue="curso" doubleListValue="tipo" 
								 listKey="curso" doubleListKey="tipo" required="true"
	         					/-->
								<s:textfield label="%{getText('modificarPerfilCandidato.formacion.centro')}" name="formacion.centro"/>
								<s:textfield label="%{getText('modificarPerfilCandidato.formacion.anoInicio')}" name="formacion.annoinicio"/>
								<s:textfield label="%{getText('modificarPerfilCandidato.formacion.añoFin')}" name="formacion.annofin"/>
								<s:textfield label="%{getText('modificarPerfilCandidato.formacion.notaMedia')}" name="formacion.notamedia"/>
								<s:file label="%{getText('modificarPerfilCandidato.formacion.expediente')}" name="fichero"/>
								<s:submit value="%{getText('global.añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
							</s:form>
						</sj:div>
						
						<sj:div id="formularioIdioma" indicator="indicadorEspera" cssStyle="display:none">
							<s:form id="formIdioma" action="crearIdiomaCandidato" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true">
								<s:actionerror/>
								<s:set var="listaNiveles" value="{'Muy bajo','Bajo','Medio-bajo','Medio','Medio-alto','Alto','Muy alto'}"/>
								<s:select label="%{getText('modificarPerfilCandidato.idiomas.nombre')}" list="#request.listaIdiomas.{nombre}" name="idiomaEnCandidato.idioma.nombre" cssClass="styled"/>
								<s:select label="%{getText('modificarPerfilCandidato.idiomas.nivelHablado')}" list="#listaNiveles" name="idiomaEnCandidato.hablado" cssClass="styled"/>
								<s:select label="%{getText('modificarPerfilCandidato.idiomas.nivelEscrito')}" list="#listaNiveles" name="idiomaEnCandidato.escrito" cssClass="styled"/>
								<s:select label="%{getText('modificarPerfilCandidato.idiomas.nivelTraduccion')}" list="#listaNiveles" name="idiomaEnCandidato.traduccion" cssClass="styled"/>
								<s:select label="%{getText('modificarPerfilCandidato.idiomas.nivelTecnico')}" list="#listaNiveles" name="idiomaEnCandidato.tecnico" cssClass="styled"/>
								<s:submit value="%{getText('global.añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
							</s:form>
						</sj:div>
						
						
						<sj:div id="formularioConocimiento" indicator="indicadorEspera" cssStyle="display:none">
							<s:form id="formConocimiento" action="crearConocimientoCandidato" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true">
								<s:actionerror/>
								<s:select label="%{getText('modificarPerfilCandidato.conocimientos.nombre')}" list="#request.listaConocimientos.{nombre}" name="conocimientoEnCandidato.conocimiento.nombre" cssClass="styled"/>
								<s:select label="%{getText('modificarPerfilCandidato.conocimientos.nivel')}" list="#listaNiveles" name="conocimientoEnCandidato.nivel" cssClass="styled"/>
								<s:submit value="%{getText('global.añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
							</s:form>
						</sj:div>
						
						<br/><br/>
					 
						<table>
						<caption><s:text name="candidato.datosFormacion.titulo"/></caption> 
						<thead>
						<tr>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.nombre"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.tipo"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.centro"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.anoInicio"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.añoFin"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.notaMedia"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.formacion.expediente"/></th>
						<th scope="col"></th>
						</tr>
						</thead>
						<tfoot> 
						<tr> 
							<th scope="row"><s:text name="global.total"/></th> 
							<td colspan="8"><s:property value="#request.candidato.formaciones.size()"/></td> 
						</tr> 
						</tfoot> 
						<tbody> 
						<s:if test="%{#request.candidato.formaciones.size()!=0}">
							<s:iterator value="#request.candidato.formaciones" var="formacionC" status="contadorF">
							<s:if test="#contadorF.count%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
							<s:url var="urlVerOferta" action="verOferta"/>
							<th scope="row"><s:property value="#formacionC.curso.nombre"/></th>
							<td><s:property value="#formacionC.curso.tipo"/></td>
							<td><s:property value="#formacionC.centro"/></td>
							<td><s:property value="#formacionC.annoinicio"/></td>
							<td><s:property value="#formacionC.annofin"/></td>
							<td><s:property value="#formacionC.notamedia"/></td>
								<td><s:if test="#formacionC.expediente!=null">
									<s:url var="#eliminarExpediente" action="eliminarFormacionCandidato">
										<s:param name="id" value="#formacionC.idformacion"/>
									</s:url>
									<a href="<s:property value="#eliminarExpediente"/>"><s:text name="global.descargar"/></a>
								</s:if></td>
							<td><a href="eliminarFormacionCandidato?id=<s:property value="#formacionC.idformacion"/>"><s:text name="global.eliminar"/></a></td>
							</s:iterator>
						</s:if>
						</tbody>
						</table>
						
						<br/><br/>
						<table>
						<caption><s:text name="candidato.datosIdiomas.titulo"/></caption> 
						<thead>
						<tr>
						<th scope="col"><s:text name="modificarPerfilCandidato.idiomas.nombre"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.idiomas.nivelEscrito"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.idiomas.nivelHablado"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.idiomas.nivelTraduccion"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.idiomas.nivelTecnico"/></th>
						<th scope="col"></th>
						</tr>
						</thead>
						<tfoot> 
						<tr> 
							<th scope="row"><s:text name="global.total"/></th> 
							<td colspan="5"><s:property value="#request.candidato.idiomasEnCandidato.size()"/></td> 
						</tr> 
						</tfoot> 
						<tbody> 
						<s:if test="%{#request.candidato.idiomasEnCandidato.size()!=0}">
							<s:iterator value="#request.candidato.idiomasEnCandidato" var="idiomaEnCandidato" status="contadorI">
									<s:url var="urlEliminarIdiomaEnCandidato" action="eliminarIdiomaEnCandidato">
										<s:param name="idiomaEnCandidatoId" value="#idiomaEnCandidato.key.id"/>
									</s:url>
							<s:if test="#contadorI.count%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
							<s:url var="urlVerOferta" action="verOferta"/>
							<th scope="row"><s:property value="#idiomaEnCandidato.idioma.nombre"/></th>
							<td><s:property value="#idiomaEnCandidato.escrito"/></td>
							<td><s:property value="#idiomaEnCandidato.hablado"/></td>
							<td><s:property value="#idiomaEnCandidato.traduccion"/></td>
							<td><s:property value="#idiomaEnCandidato.tecnico"/></td>
							<td>
								<s:a href="%{#urlEliminarIdiomaEnCandidato}"><s:text name="global.eliminar"/></s:a>
							</td>
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
						<th scope="col"><s:text name="modificarPerfilCandidato.conocimientos.nombre"/></th>
						<th scope="col"><s:text name="modificarPerfilCandidato.conocimientos.nivel"/></th>
						<th scope="col"></th>
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
									<s:url var="urlEliminarConocimientoEnCandidato" action="eliminarConocimientoEnCandidato">
										<s:param name="conocimientoEnCandidatoId">
												<s:property value="%{#conocimientoEnCandidato.key.id}"/>
										</s:param>
									</s:url>
							<s:if test="#contadorC.count%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
							<s:url var="urlVerOferta" action="verOferta"/>
							<th scope="row"><s:property value="#conocimientoEnCandidato.conocimiento.nombre"/></th>
							<td><s:property value="#conocimientoEnCandidato.nivel"/></td>
							<td>
								<s:a href="%{#urlEliminarConocimientoEnCandidato}"><s:text name="global.eliminar"/></s:a></td>
							</tr>
							</s:iterator>
						</s:if>
						</tbody>
						</table>
						
						
					</sj:div>
					
					<sj:div id="capaExperiencia" indicator="indicadorEspera" cssStyle="display:none">
						<s:form  action="crearExperienciaCandidato" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;">
							<s:actionerror/>
						
							<sj:radio label="%{getText('modificarPerfilCandidato.experiencia.tipo')}" list="{'Beca','Empleo'}" name="experiencia.tipo" required="true"/>
							<s:textfield label="%{getText('modificarPerfilCandidato.experiencia.puestoTrabajo')}" name="experiencia.puestotrabajo" required="true"/>
							<s:textfield label="%{getText('modificarPerfilCandidato.experiencia.empresa')}" name="experiencia.empresa"/>
							<s:select label="%{getText('modificarPerfilCandidato.experiencia.departamento')}" 
								list="{'Financiero','Informático','Dirección','Producción','Marketing','Comercial','Logístico'}" name="experiencia.departamento" cssClass="styled"
							/>
							<s:textfield label="%{getText('modificarPerfilCandidato.experiencia.añoInicio')}" name="experiencia.annoinicio" required="true"/>
							<s:textfield label="%{getText('modificarPerfilCandidato.experiencia.añoFin')}" name="experiencia.annofin" required="true"/>
							<s:textfield label="%{getText('modificarPerfilCandidato.experiencia.duracion')}" name="experiencia.duracion" required="true"/>
							<s:submit value="%{getText('global.añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
						</s:form>
						<br/><br/>
						<s:if test="%{#request.candidato.experiencias.size()==0}"> 
							<strong> <s:text name="candidato.datosExperiencia.sinExperiencia"/> </strong>
						</s:if>
						<s:else> 
							<table>
							<caption><s:text name="candidato.datosExperiencia.titulo"/></caption> 
							<thead>
							<tr>
							<th scope="col"><s:text name="modificarPerfilCandidato.experiencia.tipo"/></th>
							<th scope="col"> <s:text name="modificarPerfilCandidato.experiencia.puestoTrabajo"/></th>
							<th scope="col"> <s:text name="modificarPerfilCandidato.experiencia.empresa"/></th>
							<th scope="col"> <s:text name="modificarPerfilCandidato.experiencia.departamento"/></th>
							<th scope="col"> <s:text name="modificarPerfilCandidato.experiencia.añoInicio"/></th>
							<th scope="col"> <s:text name="modificarPerfilCandidato.experiencia.añoFin"/></th>
							<th scope="col"> <s:text name="modificarPerfilCandidato.experiencia.duracion"/></th>
							<th scope="col"></th>
							</tr>
							</thead>
							<tfoot> 
							<tr> 
								<th scope="row"><s:text name="global.total"/></th> 
								<td colspan="7"><s:property value="#request.candidato.experiencias.size()"/></td> 
							</tr> 
							</tfoot> 
							<tbody> 
								<s:iterator value="#request.candidato.experiencias" var="experiencia" status="contadorE">
									<s:url var="urlEliminarExperiencia" action="eliminarExperiencia">
										<s:param name="experienciaId" value="#experiencia.key.id"/>
									</s:url>
								<s:if test="#contadorE.count%2==0"><tr></s:if>
								<s:else><tr class="odd"></s:else>
								<s:url var="urlVerOferta" action="verOferta"/>
								<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#experiencia.tipo"/></a></th>
								<td><s:property value="#experiencia.puestotrabajo"/></td>	
								<td><s:property value="#experiencia.empresa"/></td>
								<td><s:property value="#experiencia.departamento"/></td>
								<td><s:property value="#experiencia.añoinicio"/></td>		
								<td><s:property value="#experiencia.añofin"/></td>
								<td><s:property value="#experiencia.duracion"/></td>						
								<td><s:a href="%{#urlEliminarExperiencia}"><s:text name="global.eliminar"/></s:a></td>
								</tr>
								</s:iterator>
							</tbody>
							</table>
						</s:else>
					</sj:div>  
					
					
					<sj:div id="capaCambiarPassword" bindOn="botonCambiarPassword" cssStyle="display:none">
						<s:form id="cambiarPass" method="post" action="cambiarPassword">
							<s:password label="%{getText('modificarPerfilCandidato.datosPersonales.passwordAntigua')}" name="passwordAntigua" required="true"/>
							<s:password label="%{getText('modificarPerfilCandidato.datosPersonales.passwordNueva')}" name="passwordNueva" required="true"/>
							<s:password label="%{getText('modificarPerfilCandidato.datosPersonales.repetirPassword')}" name="password" required="true"/>
							<s:submit value="Cambiar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover"/>
						</s:form>
					</sj:div>
					
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

