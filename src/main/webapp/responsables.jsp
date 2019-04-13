<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><s:text name="global.title"/></title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/estiloTabla.css"/>
<script type="text/javascript" src="javascript/ajaxTable/sortableTable/sortableTable.js"></script>
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
				<li><a href="<s:property value="#urlOfertas"/>"><b><s:text name="candidato.ofertas"/></b></a></li>
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
		
		</div>
		<!-- left column start-->
		<div class="left_col">
			<div class="db1">
				<div class="db1_title">
					<h3><s:text name="global.listadoResponsables"/>  <s:property value="#request.empresa.nombre"/> <s:property value="#request.empresa.tiposociedad"/> </h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
					<s:if test="%{#request.responsablesEmpresa.size()==0}"> 
						<strong> No hay responsables con esa tipologia... </strong>
					</s:if>
					<s:else> 
						<table>
						<caption><s:text name="global.responsables"/> <s:property value="#request.empresa.nombre"/></caption>
						<thead>
						<tr>
						<th scope="col"><s:text name="responsable.datosPersonales.nombre"/></th>
						<th scope="col"> <s:text name="responsable.datosPersonales.apellidos"/></th>
						<th scope="col"> <s:text name="responsable.datosPersonales.fijo"/></th>
						<th scope="col"> <s:text name="responsable.datosPersonales.movil"/></th>
						<th scope="col"> <s:text name="responsable.datosPersonales.fax"/></th>
						<th scope="col"> <s:text name="responsable.datosPersonales.email"/></th>
						</tr>
						</thead>
						<tfoot> 
						<tr> 
							<th scope="row"><s:text name="global.total"/></th> 
							<td colspan="5"><s:property value="#request.responsablesEmpresa.size()"/></td> 
						</tr> 
						</tfoot> 
						<tbody> 
							<s:iterator value="#request.responsablesEmpresa" var="responsable" status="contadorR">
							<s:if test="#contadorRcount%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
								<th scope="row"><s:property value="#responsable.nombre"/></th>
								<td><s:property value="#responsable.apellidos"/></td>
								<td><s:property value="#responsable.fijo"/></td>
								<td><s:property value="#responsable.movil"/></td>
								<td><s:property value="#responsable.fax"/></td>	
								<td><s:property value="#responsable.email"/></td>	
								</tr>
							</s:iterator>
						</tbody>
						</table>
					</s:else>

					
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
