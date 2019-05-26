<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloRadioButton.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<script src="javascript/scriptRadioButton.js" type="text/javascript"></script>
<title><s:text name="global.title"/></title>
<%--<sx:head/>--%>
<s:head theme="xhtml"/>
<sj:head compressed="false" jqueryui="true" defaultIndicator="indicadorEspera" jquerytheme="ui-lightness" locale="es" loadFromGoogle="false"/>
<script language="javascript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
<script language="javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
<script language="javascript">
$(document).ready(function()
{

	$( ".selector" ).datepicker({ altFormat: 'dd/mm/yy' });

	//var mostrarDatosGenericos =<%=request.getAttribute("registroCandidatoError")%>;
	//var mostrarResponsable =<%=request.getAttribute("registroResponsableError")%>;

	/*if(mostrarCandidato==true)
	{
		$('#capaSeleccion').hide();
		$('#candidato').show('slow');
		$('#indicacionesCandidato').show('slow');
	}
	if(mostrarResponsable==true)
	{
		$('#capaSeleccion').hide();
		$('#responsable').show('slow');
		$('#indicacionesResponsable').show('slow');
	}

	$('#roles').bind('click',function()
	{
		var variable = $("input[@name=roles]:checked").val();
		$('#capaSeleccion').hide();
		$('#indicaciones').show('slow');
		if (variable=='Candidato')
		{
	  		$('#candidato').show('slow');
	  		$('#indicacionesCandidato').show('slow');
	  		$('#responsable').hide();
	  		$('#indicacionesResponsable').hide();

	  	}
	 	if (variable=='Responsable de RR.HH.')
	 	{
	  		$('#responsable').show('slow');
	  		$('#indicacionesResponsable').show('slow');
	  		$('#candidato').hide();
	  		$('#indicacionesCandidato').hide();

	  	}
	});*/
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

								<br/><strong>Tipo de oferta:</strong> Pública
								<br/><strong>Tipo de contrato:</strong> Empleo
								<br/><strong>Nombre:</strong> Representante de ventas.
								<br/><strong>Descripción:</strong> Se requiere representante de ventas con experiencia.
								<br/><strong>Fecha de inicio:</strong> 01/11/10
								<br/><strong>Fecha de finalización:</strong> 21/12/10
								<br/><strong>Duración:</strong> Indefinida
								<br/><strong>Jornada laboral:</strong> Completa
								<br/><strong>Población:</strong> Madrid
								<br/><strong>País:</strong> España
								<br/><strong>Remuneración mínima:</strong> 6000
								<br/><strong>Remuneración máxima:</strong> 10000
								<br/><strong>Otras retribuciones:</strong> Coche y dietas
								<br/><strong>Experiencia mínima:</strong> 6
								<br/><strong>Experiencia máxima:</strong> 15
								<br/><strong>Edad mínima:</strong> 30
								<br/><strong>Edad máxima:</strong> 70
								<br/><strong>Carnet de conducir:</strong> Sí
								<br/><strong>Vehículo propio:</strong> Sí
								<br/><strong>Trabaja actualmente:</strong> No
								<br/><strong>Movilidad geográfica:</strong> Internacional
								<br/><strong>Otros datos de interés:</strong> Se requiere una persona trabajadora y comprometida con su trabajo.
								<br/><br/><i>A continuación podrá continuar añadiendo el perfil de la oferta de trabajo.</i>
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
							<h3><s:text name="global.crearOferta"/></h3>
						</div>
						<div class="db1_content">
							<div class="db1_container">
							<div class="db3" style="width: 502px; margin:10px; font:9pt verdana; color:#3F598B;">
								<sj:div id="capaFormulario">
									<s:form id="formOferta" action="crearActualizarOferta" namespace="/"  method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;" validate="true">
										<s:actionerror/>
										<s:set var="listaPaises" value="{'España','Alemania','Bélgica','Italia','Portugal','Inglaterra','Escocia','Francia','Luxemburgo'}"/>
										<s:set var="listaSiNo" value="#{'true':'Si','false':'No'}"/>
										<s:set var="listaMovilidades" value="{'Local','Provincial','Interprovincial','Internacional','Transoceanica'}"/>
										<sj:radio label="%{getText('registroOferta.datosGenericos.tipoOferta')}" list="{'Pública','Privada'}" name="oferta.tipoOferta" required="true"/>
										<sj:radio label="%{getText('registroOferta.datosGenericos.tipoContrato')}" list="{'Empleo','Beca'}" name="oferta.tipoContrato" required="true"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.nombre')}" name="oferta.nombre" required="true"/>
										<s:select label="%{getText('oferta.estado')}" list="@com.thrm.domain.Oferta$Estados@values()" name="oferta.estado"/>
<%--										<s:text name="registroOferta.datosGenericos.descripcion"/>--%>
<%--										<s:property value="getText('registroOferta.datosGenericos.descripcion')" escapeHtml="false"/>--%>
										<s:textarea label="%{getText('registroOferta.datosGenericos.descripcion')}" name="oferta.descripcion" cols="25" />
										<sj:datepicker name="oferta.fechaInicio" label="%{getText('registroOferta.datosGenericos.fechaInicio')}" displayFormat="dd/mm/yy" numberOfMonths="[2,3]" showButtonPanel="true" minDate="+0d" required="true"/>
										<sj:datepicker name="oferta.fechaFin" label="%{getText('registroOferta.datosGenericos.fechaFin')}" displayFormat="dd/mm/yy" numberOfMonths="[2,3]" showButtonPanel="true" minDate="+1d" required="true"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.duracion')}" name="oferta.duracion" required="true"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.jornada')}" name="oferta.jornada" required="true"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.poblacion')}" name="oferta.poblacion"/>
										<s:select label="%{getText('registroOferta.datosGenericos.pais')}" list="#listaPaises" name="oferta.pais" cssClass="styled" headerKey="null" headerValue="-"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.remunMin')} (EUR)" name="oferta.remuneracionminima"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.remunMax')} (EUR)" name="oferta.remuneracionmaxima"/>
										<s:textfield label="%{getText('registroOferta.datosGenericos.otrasRetribuciones')}" name="oferta.otrasretribuciones"/>
										<s:textfield label="%{getText('registroOferta.requisitos.experienciaMin')} (años)" name="oferta.experienciaminima"/>
										<s:textfield label="%{getText('registroOferta.requisitos.experienciaMax')} (años)" name="oferta.experienciaMaxima"/>
										<s:textfield label="%{getText('registroOferta.requisitos.edadMin')} (años)" name="oferta.edadMinima"/>
										<s:textfield label="%{getText('registroOferta.requisitos.edadMax')} (años)" name="oferta.edadMaxima"/>
										<sj:radio label="%{getText('registroOferta.requisitos.carne')}" list="#listaSiNo" name="oferta.carnetconducir"/>
										<sj:radio label="%{getText('registroOferta.requisitos.vehiculo')}" list="#listaSiNo" name="oferta.vehiculopropio"/>
										<sj:radio label="%{getText('registroOferta.requisitos.trabaja')}" list="#listaSiNo" name="oferta.trabajaactualmente"/>
										<s:select label="%{getText('registroOferta.requisitos.movilidad')}" list="#listaMovilidades" name="oferta.movilidad" cssClass="styled" headerValue="-"/>
										<s:textarea label="%{getText('registroOferta.datosGenericos.otrosDatos')}" name="oferta.otrosdatos" cols="25"/>
										<!--s:hidden name="oferta.empresas.idempresa" value="%{#request.responsable.empresas.idempresa}"/-->
										<!--s:hidden name="oferta.empresas.idempresa" value="%{#session.empresa.idempresa}"/-->

										<!-- This hidden is for the update -->
										<s:hidden name="id" value="%{#request.oferta.key.id}"></s:hidden>

										<s:if test="oferta == null">
											<s:submit value="Crear oferta" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
										</s:if>
										<s:else>
											<s:submit value="Actualizar oferta" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
										</s:else>
									</s:form>
								</sj:div>
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

