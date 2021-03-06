<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<script type="text/javascript" src="javascript/ajaxTable/sortableTable/sortableTable.js"></script>
<%--<sx:head/>--%>
<sj:head compressed="false" jqueryui="true"/>
</head>
<body>
<div id="container">
	<!-- header block START -->
	<div id="header">
		<div id="top_menu">
			<div id="topmenu_container">
				<s:if test="#session.logueado=true"> 
				<s:text name="global.usuario"/> <s:property value="#session.usuario" />
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
				<li class="active"><a href="<s:property value="#urlOfertas"/>"><b><s:text name="candidato.ofertas"/></b></a></li>
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
				<div class="db2" style="margin-top:0px" >
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<div class="db2_content_container">
							<h3><s:text name="oferta.buscador"/></h3>
							<s:form id="buscador" action="buscarOfertas" method="post" theme="xhtml">
								<s:set var="listaPaises" value="{'España','Alemania','Bélgica','Italia','Portugal','Inglaterra','Escocia','Francia','Luxemburgo'}"/>
								<s:set var="listaSiNo" value="#{'true':'Si','false':'No'}"/>
								<s:set var="listaMovilidades" value="{'Local','Provincial','Interprovincial','Internacional','Transoceanica'}"/>
								
								<s:textfield label="Nombre" name="oferta.nombre" />
								<s:textfield label="Empresa" name="oferta.empresa.nombre" />
								<sj:radio label="%{getText('oferta.datosGenericos.tipoContrato')}" list="{'Empleo','Beca'}" name="oferta.tipoContrato"/>
								<s:select label="%{getText('oferta.estado')}" list="@com.thrm.domain.Oferta$Estados@values()" name="oferta.estado" cssClass="styled"/>
								<s:textfield label="Duración" name="oferta.duracion" />
								<s:textfield label="%{getText('oferta.datosGenericos.jornada')}" name="oferta.jornada"/>
								<s:textfield label="Población" name="oferta.poblacion"/>
								<s:select label="País" list="#listaPaises" name="oferta.pais" cssClass="styled"/>
								<s:textfield label="Remuneración mínima (EUR)" name="oferta.remuneracionminima"/>
								<s:textfield label="Remuneración máxima (EUR)" name="oferta.remuneracionmaxima"/>
								<s:textfield label="%{getText('oferta.datosGenericos.otrasRetribuciones')}" name="oferta.otrasretribuciones"/>
								<s:textfield label="Experiencia mínima (años)" name="oferta.experienciaminima"/>
								<s:textfield label="Experiencia máxima (años)" name="oferta.experienciaMaxima"/>
								<s:textfield label="Edad  mínima (años)" name="oferta.edadMinima"/>
								<s:textfield label="Edad máxima (años)" name="oferta.edadMaxima"/>
								<sj:radio label="%{getText('oferta.requisitos.carne')}" list="#listaSiNo" name="oferta.carnetconducir"/>
								<sj:radio label="Vehículo propio" list="#listaSiNo" name="oferta.vehiculopropio"/>
								<sj:radio label="%{getText('oferta.requisitos.trabaja')}" list="#listaSiNo" name="oferta.trabajaactualmente"/>
								<s:select label="Movilidad geográfica" list="#listaMovilidades" name="oferta.movilidad" cssClass="styled"/>

    						<s:submit id="submitFormAutocomplete" value="Buscar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-state-hover" />
							</s:form> 
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
						<h3><s:text name="oferta.ofertasRecomendadas"/></h3>
						 <s:iterator value="#request.ofertasRecomendadas" status="contadorOR" var="ofertaRecomendada">
								<a href="<s:property value="#urlVerOfertas"/>"><s:property value="%{#contadorOR.count}"/>-<s:property value="%{#ofertaRecomendada.nombre}"/></a><br/>
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
						<h3><s:text name="oferta.ultimasOfertas"/></h3>
						 <s:iterator value="#request.ultimasOfertas" status="contadorUO" var="ultimaOferta">
								<s:url var="urlVerOferta" action="verOferta">
									<s:param name="id">
										<s:property value="%{#ultimaOferta.idoferta}"/>
									</s:param>
								</s:url>
								<a href="<s:property value="#urlVerOferta"/>"><s:property value="%{#contadorUO.count}"/>-<s:property value="%{#ultimaOferta.nombre}"/></a><br/>
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
					<h3></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
						<table>
						<caption><s:text name="oferta.titulo"/></caption> 
						<thead>
						<tr>
						<th scope="col"><s:text name="oferta.nombre"/></th>
						<th scope="col"> <s:text name="oferta.tipoContrato"/></th>
						<th scope="col"> <s:text name="oferta.duracion"/></th>
						<th scope="col"> <s:text name="oferta.jornada"/></th>
						<th scope="col"> <s:text name="oferta.fechaInicio"/></th>
						<th scope="col"> <s:text name="oferta.fechaFin"/></th>
						<th scope="col"> <s:text name="oferta.estado"/></th>
						<th scope="col"></th>
						</tr>
						</thead>
						<tfoot> 
						<tr> 
							<th scope="row"><s:text name="global.total"/></th> 
							<td colspan="7"><s:property value=""/></td> 
						</tr> 
						</tfoot> 
						<tbody> 
							<s:iterator value="#request.ofertas" var="oferta" status="contadorO">
							<s:if test="#contadorO.count%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
							<s:url var="urlVerOferta" action="verOferta" escapeAmp="false">
								<s:param name="id" value="#oferta.key.id"></s:param>
								<s:param name="idEmpresa" value="#oferta.empresa.key.id"></s:param>
							</s:url>
							<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#oferta.nombre"/> <s:property value="#empresa.tiposociedad"/></a></th>
							<td><s:property value="#oferta.tipoContrato"/></td>	
							<td><s:property value="#oferta.duracion"/></td>
							<td><s:property value="#oferta.jornada"/></td>		
							<td><s:date name="%{#oferta.fechainicio}" format="dd/MM/yyyy"/></td>
							<td><s:date name="%{#oferta.fechafin}" format="dd/MM/yyyy"/></td>
							<td><s:property value="#oferta.estado"/></td>		
							<td><a href="<s:property value="#urlVerOferta"/>"><s:text name="oferta.ver"/></a></td>
							</tr>
							</s:iterator>
						</tbody>
						</table>
					<!--/s:else-->
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
