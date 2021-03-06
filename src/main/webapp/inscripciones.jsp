<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
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
				<li><a href="<s:property value="#urlOfertas"/>"><b><s:text name="candidato.ofertas"/></b></a></li>
				<li><a href="<s:property value="#urlEmpresas"/>"><b><s:text name="candidato.empresas"/></b></a></li>
				<li><a href="<s:property value=""/>"><b><s:text name="candidato.inscripciones"/></b></a></li>
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
				<!-- design box 2 end -->
		</div>
		<!-- left column start-->
		<div class="left_col">
			<div class="db1">
				<div class="db1_title">
					<h3></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
					<s:if test="%{#request.inscripciones.size()==0}"> 
					<strong> <s:text name="inscripcion.noHayInscripciones"/> </strong>
					</s:if>
					<s:else> 
						<table>
						<caption><s:text name="inscripcion.titulo"/></caption> 
						<thead>
						<tr>
						<th scope="col"><s:text name="inscripcion.nombreOferta"/></th>
						<th scope="col"> <s:text name="inscripcion.fechaFinalizacion"/></th>
						<th scope="col"><s:text name="inscripcion.estado"/></th>
						<th scope="col"><s:text name="inscripcion.eliminar"/></th>
						</tr>
						</thead>
						<tfoot> 
						<tr> 
							<th scope="row"><s:text name="global.total"/></th> 
							<td colspan="4"><s:property value="#request.inscripciones.size()"/></td> 
						</tr> 
						</tfoot> 
						<tbody> 
							<s:iterator value="#request.inscripciones" var="inscripcion" status="contadorI">
							<s:if test="#contadorI.count%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
							<s:url var="urlVerOferta" action="verOferta" escapeAmp="false">
								<s:param name="id" value="#inscripcion.oferta.key.id"></s:param>
								<s:param name="idEmpresa" value="#inscripcion.oferta.empresa.key.id"></s:param>
							</s:url>
							<th scope="row">
							<a href="<s:property value="#urlVerOferta"/>"><s:property value="#inscripcion.oferta.nombre"/><s:property value="#empresa.tiposociedad"/></a>
							</th>
							<td><s:date name="%{#inscripcion.oferta.fechafin}" format="dd/MM/yyyy"/></td>
							<td><s:property value="#inscripcion.estado"/></td>
							<td>
							<s:url var="urlEliminarInscripcion" action="eliminarInscripcion" escapeAmp="false">
								<s:param name="id" value="#inscripcion.oferta.key.id"></s:param>
								<s:param name="idEmpresa" value="#inscripcion.oferta.empresa.key.id"></s:param>							
							</s:url>
							<a href="<s:property value="#urlEliminarInscripcion"/>"><s:text name="global.eliminar"/></a></td>
							<s:else>
								<td></td>
							</s:else>		
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
