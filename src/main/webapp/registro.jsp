<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css"/>
	<link rel="stylesheet" type="text/css" href="css/estiloRadioButton.css"/>
	<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
	<script src="javascript/scriptRadioButton.js" type="text/javascript"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><s:text name="global.title"/></title>
	<s:head theme="xhtml"/>
	<sj:head compressed="false" jqueryui="true" defaultIndicator="indicadorEspera" jquerytheme="ui-lightness" locale="es" loadFromGoogle="false"/>
	<script language="javascript" src="${pageContext.request.contextPath}/struts/utils.js" type="text/javascript"></script>
	<script language="javascript" src="${pageContext.request.contextPath}/struts/xhtml/validation.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/prototype.js"></script>
	<script src="javascript/jquery.validate.js"></script>
	<script src="javascript/jquery.form.js"></script>
	<script language="javascript">
	$(document).ready(function()
	{
		var mostrarCandidato =<%=request.getParameter("registroCandidatoError")%>;
		var mostrarResponsable =<%=request.getParameter("registroResponsableError")%>;
		var mostrarEmpresa =<%=request.getParameter("registroEmpresaError")%>;

		if(mostrarCandidato==true)
		{
			$('#capaSeleccion').hide();
			$('#candidato').show('slow');
			$('#indicacionesResponsable').hide();
			$('#indicacionesCandidato').show('slow');
		}
		if(mostrarResponsable==true)
		{
			$('#capaSeleccion').hide();
			$('#responsable').show('slow');
			$('#candidato').hide();
			$('#empresa').hide();
			$('#indicacionesCandidato').hide();
			$('#indicacionesResponsable').show('slow');
		}
		if(mostrarEmpresa==true)
		{
			$('#capaSeleccion').hide();
			$('#empresa').show('slow');
			$('#indicacionesResponsable').hide();
			$('#indicacionesCandidato').hide();
		}

		$('#roles').bind('click',function()
		{
			// var variable = $("input[id=roles]:checked").val();
            var variable = $("input[name='primerPaso']:checked").val();
            console.log("variable: " + variable);
			$('#capaSeleccion').hide();
			$('#indicaciones').show('slow');
			if (variable=='Candidate')
			{
				$('#candidato').show('slow');
				$('#indicacionesCandidato').show('slow');
				$('#responsable').hide();
				$('#indicacionesResponsable').hide();

			}
			if (variable=='HR Manager')
			{
				$('#responsable').show('slow');
				$('#indicacionesResponsable').show('slow');
				$('#candidato').hide();
				$('#indicacionesCandidato').hide();

			}
			if (variable=='Company')
			{
				$('#empresa').show('slow');
				$('#indicacionesResponsable').hide();
				$('#candidato').hide();
				$('#indicacionesCandidato').hide();
			}

		});

		$('#formCandidato').validate({
			rules : {
				email : {
					equalTo : "#candidato_email"
				},
				pass : {
					equalTo : "#candidato_password"
				}
			}
		});

		$('#formResponsable').validate({
			rules : {
				email : {
					equalTo : "#responsable_email"
				},
				pass : {
					equalTo : "#responsable_password"
				}
			}
		})

	});
	</script>
</head>
<body>
<s:property value="url"/>
<div id="container">
	<!-- header block START -->
	<div id="header">
		<div id="logo"><span>logo text hidden</span></div>
		<div id="primary_menu">
			<div id="pm_main">
				<s:url var="urlAyuda" action="mostrarAyuda"/>
			</div>
			<div id="pm_sub">
				<ul>
					<li><a href="<s:property value="#urlVolver"/>"><s:text name="global.volver"/></a></li>
				</ul>
			</div>


		</div>
	</div>
	<!-- header block End -->
	<!-- content block START -->
	<div id="conent">
		<div class="right_col">
				<sj:div id="indicaciones" indicator="indicadorEspera" cssStyle="display:none;font:9pt verdana;">
					<div class="db3" style="" >
						<div class="bd3_top">
							<div class="bd3_top_content">&nbsp;</div>
						</div>
						<div class="db3_content">
							<h3><s:text name="global.indicaciones"/></h3>
							</br></br>
							<sj:div id="indicacionesCandidato" indicator="indicadorEspera" bindOn="roles" cssStyle="display:none">
								<u><i>Example:</i></u><br/>

								<br/><strong>ID:</strong> 123456789A
								<br/><strong>Name:</strong> John
								<br/><strong>Last Name:</strong> Doe
								<br/><strong>Email:</strong> john@gmail.com
								<br/><strong>Confirm email:</strong> john@gmail.com
								<br/><strong>Password:</strong> 12AB56CD
								<br/><strong>Confirm Password:</strong> 12AB56CD
								<br/><strong>Date of birth:</strong> 05/04/82
								<br/><strong>Address:</strong>
								<br/><strong>Phone number:</strong> 912345678
								<br/><strong>Movil number:</strong> 612345678
								<br/><strong>Fax:</strong> 913456789
								<br/><strong>Nationality:</strong>
								<br/><strong>Marital status:</strong> Married
								<br/><strong>Driver License:</strong> Yes
								<br/><strong>Own Vehicle:</strong> Yes
								<br/><strong>Currently employed:</strong> No
								<br/><strong>Willingness to travel:</strong> International
								<br/><strong>Aditional interests:</strong> I'm a truly worker and compromissed with my job.
								<br/><br/><i>Nota:<s:text name="global.mensaje.formatoFoto"/></i>
							</sj:div>
							<sj:div id="indicacionesResponsable" indicator="indicadorEspera" bindOn="roles" cssStyle="display:none">
								 	<u><i>Example:</i></u><br/>

								 	<br/><strong>VAT Number:</strong> 0000000G
								 	<br/><strong>Key word:</strong> 1582ABC234 <i>(Esta palabra se la suministrará el sistema en el registro de la empresa)</i>
								 	<br/><strong>ID:</strong> 123456789A
								 	<br/><strong>Name:</strong> Juan
									<br/><strong>Last name:</strong> García Sancho
									<br/><strong>Telephone number:</strong> 912345678
									<br/><strong>Movil number:</strong> 612345678
									<br/><strong>Fax:</strong> 913456789
									<br/><strong>Email:</strong> juan@gmail.com
									<br/><strong>Confirm email:</strong> juan@gmail.com
									<br/><strong>Password</strong> 12AB56CD
									<br/><strong>Confirm Password:</strong> 12AB56CD
								 	<br/><br/><strong>Register now</strong><br/>
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
							<h3><s:text name="global.formularioRegistro"/></h3>
						</div>
						<div class="db1_content">
							<div class="db1_container">
							<div class="db3" style="width: 502px; margin:10px; font:9pt verdana; color:#3F598B;">
								<sj:div id="capaSeleccion" indicator="indicadorEspera" bindOn="roles">
									<br/><br/><br/><br/>
									<s:label value="%{getText('registro.seleccionarOpcion')}"/><br/><br/><br/>
									<sj:radio id="roles" list="{'Candidate','HR Manager','Company'}" name="primerPaso"/>
           						</sj:div>
           							<br/><br/><br/>


								<sj:div id="candidato" indicator="indicadorEspera" bindOn="roles" cssStyle="display:none">
									<s:form id="formCandidato" action="registrarCandidato" method="post" theme="xhtml" cssStyle="font:9pT verdana; color:#3F598B;">
										<s:actionerror/>
										<s:set var="listaMovilidades" value="{'Local','Provincial','Interprovincial','Internacional','Transoceanica'}"/>
										<s:set var="listaNacionalidades" value="{'Afganistá'n','Albania'}"/>
										<s:set var="listaSiNo" value="#{'true':'Si','false':'No'}"/>
										<s:textfield label="%{getText('registro.datosPersonales.dni')}" name="candidato.dni" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.nombre')}" name="candidato.nombre" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.apellidos')}" name="candidato.apellidos" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.email')}" name="candidato.email" id="candidato_email" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.repetirEmail')}" name="email" id="email" required="true" />
										<s:password label="%{getText('registro.datosPersonales.password')}" name="candidato.password" id="candidato_password" required="true"/>
										<s:password label="%{getText('registro.datosPersonales.repetirPassword')}" name="pass" id="pass" required="true" />
										<sj:datepicker name="candidato.fechaNacimiento" label="%{getText('registro.datosPersonales.fechaNacimiento')}" yearRange="1900:today" changeMonth="true" changeYear="true" showButtonPanel="true"/>
										<sj:radio label="%{getText('registro.datosPersonales.genero')}" list="{'Masculino','Femenino'}" name="candidato.genero"/>
										<s:textfield label="%{getText('registro.datosPersonales.direccion')}" name="candidato.direccion"/>
										<s:textfield label="%{getText('registro.datosPersonales.fijo')}" name="candidato.fijo"/>
										<s:textfield label="%{getText('registro.datosPersonales.movil')}" name="candidato.movil"/>
										<s:textfield label="%{getText('registro.datosPersonales.fax')}" name="candidato.fax"/>
										<s:select label="%{getText('registro.datosPersonales.nacionalidad')}" list="{'Española','Rumana'}" name="candidato.nacionalidad" cssClass="styled"/>
										<s:select label="%{getText('registro.datosPersonales.estadoCivil')}" list="{'Soltero','Casado','Viudo'}" name="candidato.estadocivil" cssClass="styled"/>
										<sj:radio label="%{getText('registro.datosPersonales.carnet')}" list="#listaSiNo" name="candidato.carnetconducir"/>
										<sj:radio label="%{getText('registro.datosPersonales.vehiculo')}" list="#listaSiNo" name="candidato.vehiculopropio"/>
										<sj:radio label="%{getText('registro.datosPersonales.trabaja')}" list="#listaSiNo" name="candidato.trabajaactualmente"/>
										<s:select label="%{getText('registro.datosPersonales.movilidad')}" list="#listaMovilidades" name="candidato.movilidad" cssClass="styled"/>
										<s:textarea label="%{getText('registro.datosPersonales.otrosDatos')}" name="candidato.otrosdatos"/>
										<s:file label="%{getText('registro.datosPersonales.foto')}" name="candidato.foto"/>
										<s:submit id="registrarCand" value="Registrarme" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
									</s:form>
								</sj:div>

								<sj:div id="responsable" indicator="indicadorEspera" bindOn="roles" cssStyle="display:none">
									<s:form id="formResponsable" action="registrarResponsable" method="post" theme="xhtml" cssStyle="font:9pt verdana; color:#3F598B;">
										<s:actionerror/>
										<s:textfield label="%{getText('registro.cifEmpresa')}" name="cif" required="true"/>
										<s:textfield label="%{getText('registro.codigoEmpresa')}" name="codigo" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.dni')}" name="responsable.dni" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.nombre')}" name="responsable.nombre" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.apellidos')}" name="responsable.apellidos" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.fijo')}" name="responsable.fijo"/>
										<s:textfield label="%{getText('registro.datosPersonales.movil')}" name="responsable.movil"/>
										<s:textfield label="%{getText('registro.datosPersonales.fax')}" name="responsable.fax"/>
										<s:textfield label="%{getText('registro.datosPersonales.email')}" name="email" id="email" required="true"/>
										<s:textfield label="%{getText('registro.datosPersonales.repetirEmail')}" name="responsable.email" id="responsable_email" required="true"/>
										<s:password label="%{getText('registro.datosPersonales.password')}" name="pass" id="pass" required="true"/>
										<s:password label="%{getText('registro.datosPersonales.repetirPassword')}" name="responsable.password" id="responsable_password" required="true"/>
										<s:submit id="registrarResp" value="Registrarme" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
									</s:form>
								</sj:div>

								<sj:div id="empresa" indicator="indicadorEspera" bindOn="roles" cssStyle="display:none">
									<s:form id="formEmpresa" action="registrarEmpresa" method="post" theme="xhtml" cssStyle="font:9pt verdana; color:3F598B;">
										<s:actionerror/>
										<s:textfield label="%{getText('registro.datosCorporativos.cif')}" name="empresa.cif" required="true"/>
										<s:textfield label="%{getText('registro.datosCorporativos.nombre')}" name="empresa.nombre" required="true"></s:textfield>
										<s:textfield label="%{getText('registro.datosCorporativos.tiposociedad')}" name="empresa.tipoSociedad"></s:textfield>
										<s:textfield label="%{getText('registro.datosCorporativos.domicilio')}"></s:textfield>
										<!--s:textfield label="%{getText('registro.datosCorporativos.logo')}" name="empresa.logo"--><!--/s:textfield-->
										<s:textfield label="%{getText('registro.datosCorporativos.numTrabajadores')}" name="empresa.numTrabajadores"></s:textfield>
										<s:textfield label="%{getText('registro.datosCorporativos.web')}" name="empresa.web"></s:textfield>
										<s:textfield label="%{getText('registro.datosCorporativos.codigo')}" name="empresa.codigo"></s:textfield>
										<s:submit id="registrarEmpr" value="Registrar" cssClass="ui-button ui-widget ui-state-default ui-button-text-only ui-corner-left ui-state-hover"/>
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

