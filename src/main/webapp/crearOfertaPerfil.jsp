<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloRadioButton.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<script src="javascript/scriptRadioButton.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:text name="global.title"/></title>
<%--<sx:head/>--%>
<s:head theme="xhtml"/>
<sj:head compressed="false" jqueryui="true" defaultIndicator="indicadorEspera" jquerytheme="ui-lightness" locale="es" loadFromGoogle="false"/>
<script language="javascript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
<script language="javascript">
$(document).ready(function()
{
	var mostrarDatosPersonales =<%=request.getParameter("modificarDatosPersonalesError")%>;
	var mostrarFormacion =<%=request.getParameter("modificarFormacionError")%>;
	var mostrarCambiarPassword =<%=request.getParameter("modificarPasswordError")%>;
	
	$('#indicaciones').hide();
	if(mostrarDatosPersonales==true)
	{
		$('#capaDatosPersonales').show('slow');
	}
	if(mostrarFormacion==true)
	{
		$('#capaFormacion').show('slow');
	}
	
	if(mostrarCambiarPassword==true)
	{
		$('#capaCambiarPassword').show('slow');
	}
	
	$('#botonDatosPersonales').click(function() 
	{
		$('#capaFormacion').hide();
		$('#capaCambiarPassword').hide();
  		$('#capaDatosPersonales').show('slow');
	});
	
	$('#botonFormacion').click(function() 
	{
		$('#capaDatosPersonales').hide();
		$('#capaCambiarPassword').hide();
  		$('#capaFormacion').show('slow');
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
				<!-- AQUÍ IRIA LO DE LA DERECHA-->
				<sj:div id="indicaciones" indicator="indicadorEspera" cssStyle="display:non;font:9pt verdana;">
					<div class="db3" style="" >
						<div class="bd3_top">
							<div class="bd3_top_content">&nbsp;</div>
						</div>
						<div class="db3_content">
							<h3><s:text name="global.indicaciones"/></h3>
							</br></br>
							<sj:div id="indicaciones" indicator="indicadorEspera">
								<u><i>Ejemplo:</i></u><br/>
								
								<br/><strong>DNI:</strong> 123456789A
								<br/><strong>Nombre:</strong> Juan
								<br/><strong>Apellidos:</strong> García Sancho
								<br/><strong>Email:</strong> juan@gmail.com
								<br/><strong>Confirmar email:</strong> juan@gmail.com
								<br/><strong>Contraseña:</strong> 12AB56CD
								<br/><strong>Confirmar contraseña:</strong> 12AB56CD
								<br/><strong>Fecha de nacimiento:</strong> 05/04/82
								<br/><strong>Dirección:</strong> C/Camino Real nº5 1 Centro Madrid CP:28001 
								<br/><strong>Teléfono fijo:</strong> 912345678
								<br/><strong>Teléfono móvil:</strong> 612345678
								<br/><strong>Fax:</strong> 913456789
								<br/><strong>Nacionalidad:</strong> Española
								<br/><strong>Estado civil:</strong> Casado 
								<br/><strong>Carnet de conducir:</strong> Sí 
								<br/><strong>Vehículo propio:</strong> Sí 
								<br/><strong>Trabaja actualmente:</strong> No
								<br/><strong>Movilidad geográfica:</strong> Internacional
								<br/><strong>Otros datos de interés:</strong> Soy una persona trabajadora y comprometida con mi trabajo.   
								<br/><br/><strong>Recibirá un correo electrónico para confirmar el registro. </strong>
							</sj:div>
						</div>
						<div class="bd3_bot">
							<div class="bd3_bot_content">&nbsp;</div>
						</div>
					</div>
				</sj:div>
		</div>
		<!-- left column start-->
		<div class="left_col">
			<div class="db1">
					<br/>
					<div class="db1" style="width:550px; float:left; margin-right:25px;">
						<div class="db1_title">
							<h3><s:text name="global.perfilOferta"/></h3>
						</div>					
						<div class="db1_content">
							<div class="db1_container">
							<div class="db3" style="width: 502px; margin:10px; font:9pt verdana; color:#3F598B;">
									<sj:a id="botonFormularioFormacion" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Formación</sj:a>
									<sj:a id="botonFormularioIdioma" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Idiomas</sj:a>
									<sj:a id="botonFormularioConocimiento" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-state-hover" button="false">Conocimientos informáticos</sj:a>
									<s:set var="listaNiveles" value="{'Muy bajo','Bajo','Medio-bajo','Medio','Medio-alto','Alto','Muy alto'}"/>
									
									<sj:div id="formularioFormacion" indicator="indicadorEspera" cssStyle="display:none">
										<s:form action="crearFormacionOferta" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true">
											<s:actionerror/>
											<s:doubleselect label="%{getText('registroOferta.formacion.nombre')}" name="cursoOferta.curso" doubleName="cursoOferta.tipo"
								 				headerValue="Seleccione" headerKey="-1" list="#request.listaCursos"  doubleList="#request.listaCursos.get(top.idcurso)" listValue="curso" doubleListValue="tipo" 
								 				listKey="curso" doubleListKey="tipo"
											/>
											<s:hidden name="idOferta" value="%{#request.oferta.idoferta}"/>
											<s:submit value="%{getText('global.Añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
										</s:form>
									</sj:div>
						
									<sj:div id="formularioIdioma" indicator="indicadorEspera" cssStyle="display:none">
										<s:form action="crearIdiomaOferta" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true">
											<s:actionerror/>
											<s:select label="%{getText('registroOferta.idiomas.nombre')}" list="#request.listaIdiomas.{nombre}" name="idiomaOferta.idiomas.nombre" cssClass="styled"/>
											<s:select label="%{getText('registroOferta.idiomas.nivelHablado')}" list="#listaNiveles" name="idiomaOferta.hablado" cssClass="styled"/>
											<s:select label="%{getText('registroOferta.idiomas.nivelEscrito')}" list="#listaNiveles" name="idiomaOferta.escrito" cssClass="styled"/>
											<s:select label="%{getText('registroOferta.idiomas.nivelTraduccion')}" list="#listaNiveles" name="idiomaOferta.traduccion" cssClass="styled"/>
											<s:select label="%{getText('registroOferta.idiomas.nivelTecnico')}" list="#listaNiveles" name="idiomaOferta.tecnico" cssClass="styled"/>
											<s:hidden name="idOferta" value="%{#request.oferta.idoferta}"/>
											<s:submit value="%{getText('global.Añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
										</s:form>
									</sj:div>
							
							
									<sj:div id="formularioConocimiento" indicator="indicadorEspera" cssStyle="display:none">
										<s:form action="crearConocimientoOferta" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true">
											<s:actionerror/>
											<s:select label="%{getText('registroOferta.conocimientos.nombre')}" list="#request.listaConocimientos.{nombre}" name="conocimientoOferta.conocimientos.nombre" cssClass="styled"/>
											<s:select label="%{getText('registroOferta.conocimientos.nivel')}" list="#listaNiveles" name="conocimientoOferta.nivel" cssClass="styled"/>
											<s:hidden name="idOferta" value="%{#request.oferta.idoferta}"/>
											<s:submit value="%{getText('global.Añadir')}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
										</s:form>
									</sj:div>
									
									<br/><br/><br/><br/>
									
									<sj:div id="capaFormacion" indicator="indicadorEspera" cssStyle="display:non">
					
										<table>
										<caption><s:text name="candidato.datosFormacion.titulo"/></caption> 
										<thead>
										<tr>
										<th scope="col"><s:text name="modificarPerfilCandidato.formacion.nombre"/></th>
										<th scope="col"><s:text name="modificarPerfilCandidato.formacion.tipo"/></th>
										<th scope="col"></th>
										</tr>
										</thead>
										<tfoot> 
										<tr> 
											<th scope="row"><s:text name="global.total"/></th> 
											<td colspan="2"><s:property value="#request.oferta.cursoses.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
										<s:if test="%{#request.oferta.cursoses.size()!=0}">
											<s:iterator value="#request.oferta.cursoses" var="cursoO" status="contadorF">
											<s:if test="#contadorF.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#cursoO.curso"/></a></th>
											<td><s:property value="#cursoO.tipo"/></td>
											<td><a href="eliminarFormacionOferta?id=<s:property value="#cursoO.idcurso"/>&idOferta=<s:property value="#request.oferta.idoferta"/>"><s:text name="global.eliminar"/></a></td>
											</tr>
											</s:iterator>
										</s:if>
										</tbody>
										</table>
									</sj:div>
									
									<br/><br/>
									
									<sj:div id="capaIdioma" indicator="indicadorEspera" cssStyle="display:non">
										 
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
											<td colspan="5"><s:property value="#request.oferta.idiomasenofertases.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
										<s:if test="%{#request.oferta.idiomasenofertases.size()!=0}"> 
											<s:iterator value="#request.oferta.idiomasenofertases" var="idiomaO" status="contadorI">
											<s:if test="#contadorI.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#idiomaO.idiomas.nombre"/></a></th>
											<td><s:property value="#idiomaO.escrito"/></td>
											<td><s:property value="#idiomaO.hablado"/></td>
											<td><s:property value="#idiomaO.traduccion"/></td>
											<td><s:property value="#idiomaO.tecnico"/></td>
											<td><a href="eliminarIdiomaOferta?id=<s:property value="#idiomaO.ididiomasenofertas"/>&idOferta=<s:property value="#request.oferta.idoferta"/>"><s:text name="global.eliminar"/></a></td>
											</tr>
											</s:iterator>
										</s:if>
										</tbody>
										</table>
										
									</sj:div>
									
									<br/><br/>
									
									<sj:div id="capaConocimiento" indicator="indicadorEspera" cssStyle="display:non">
												 
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
											<td colspan="2"><s:property value="#request.oferta.conocimientosEnOfertas.size()"/></td> 
										</tr> 
										</tfoot> 
										<tbody> 
										<s:if test="%{#request.oferta.conocimientosEnOfertas.size()!=0}"> 
											<s:iterator value="#request.oferta.conocimientosEnOfertas" var="conocimientoO" status="contadorC">
											<s:if test="#contadorC.count%2==0"><tr></s:if>
											<s:else><tr class="odd"></s:else>
											<s:url action="verOferta"/>
											<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#conocimientoO.conocimientos.nombre"/></a></th>
											<td><s:property value="#conocimientoO.nivel"/></td>
											<td><a href="eliminarConocimientoOferta?id=<s:property value="#conocimientoO.idconocimientosenofertas"/>&idOferta=<s:property value="#request.oferta.idoferta"/>"><s:text name="global.eliminar"/></a></td>
											</tr>
											</s:iterator>
										</s:if>
										</tbody>
										</table>
										
									</sj:div>
								
								<br/><br/>
								<s:url var="#urlFinalizar" action="verOfertaResponsable">
									<s:param name="id" value="#request.oferta.idoferta"/>
								</s:url> 
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<s:a href="%{#urlFinalizar}" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover">Finalizar </s:a>
						</div>

							</div>
						</div>
					</div>
					<br/><br/><br/><br/>
					
						<p class="clear_left"></p>					
			
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

