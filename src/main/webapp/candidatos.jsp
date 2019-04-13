<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>--%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
		<!-- design box 2 start -->
				<div class="db2" style="margin-top:0px" >
					<div class="bd2_top">
						<div class="bd2_top_content">&nbsp;</div>
					</div>
					<div class="db2_content">
						<div class="db2_content_container">
							<h3><s:text name="candidato.buscador"/></h3>
							<s:form id="buscador" action="buscarCandidato" method="post" theme="xhtml">
								<sj:autocompleter id="autoCandidatos" name="palabraClave" list="%{#request.listadoCandidatos}"/>
    						<sj:submit id="submitFormAutocomplete" targets="result" button="true" validate="true" value="Buscar" />
							</s:form> 
						</div>
					</div>
					<div class="bd2_bot">
						<div class="bd2_bot_content">&nbsp;</div>
					</div>
				</div>
				<!-- design box 2 end -->
				<br/>
				<div class="db3" style="" >
					<div class="bd3_top">
						<div class="bd3_top_content">&nbsp;</div>
					</div>
					<div class="db3_content">
						<h3><s:text name="candidato.ultimosCandidatos"/></h3>
						 <s:iterator value="#request.ultimosCandidatos" status="contadorUC" var="ultimoCandidato">
								<s:url var="urlVerCandidato" action="verCandidato">
									<s:param name="id">
										<s:property value="%{#ultimoCandidato.idcandidato}"/>
									</s:param>
								</s:url>
								<a href="<s:property value="#urlVerCandidato"/>"><s:property value="%{#contadorUC.count}"/>-<s:property value="%{#ultimoCandidato.nombre}"/> <s:property value="%{#ultimoCandidato.apellidos}"/></a><br/>
						</s:iterator>
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
					<h3><s:text name="global.listadoCandidatos"/></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
						<table>
						<caption><s:text name="global.candidatos"/></caption> 
						<thead>
						<tr>
						<th scope="col"><s:text name="candidato.datosPersonales.dni"/></th>
						<th scope="col"><s:text name="candidato.datosPersonales.nombre"/></th>
						<th scope="col"> <s:text name="candidato.datosPersonales.apellidos"/></th>
						<th scope="col"> <s:text name="candidato.datosPersonales.email"/></th>
						<th scope="col"> <s:text name="candidato.datosPersonales.movil"/></th>
						<th scope="col"></th>
						</tr>
						</thead>
						<tfoot> 
						<tr> 
							<th scope="row"><s:text name="global.total"/></th> 
							<td colspan="5"><s:property value="#request.candidatos.size()"/></td> 
						</tr> 
						</tfoot> 
						<tbody> 
							<s:iterator value="#request.candidatos" var="candidato" status="contadorCa">
							<s:if test="#contadorCa.count%2==0"><tr></s:if>
							<s:else><tr class="odd"></s:else>
							<s:url var="urlVerCandidato" action="verCandidato"/>
							<th scope="row"><s:property value="#candidato.dni"/> <s:property value="#empresa.tiposociedad"/></th>
							<td><s:property value="#candidato.nombre"/></td>	
							<td><s:property value="#candidato.apellidos"/></td>	
							<td><s:property value="#candidato.email"/></td>
							<td><s:property value="#candidato.movil"/></td>
							<s:if test="#request.idOferta==null">
								<s:url var="urlVerCandidato" action="verCandidato">
									<s:param name="id" value="#candidato.key.id"/>
								</s:url>
								<td><a href="<s:property value="#urlVerCandidato"/>"><s:text name="candidato.ver"/></a></td>
							</s:if>
							<s:else>
								<td><a href="verCandidatoOferta?idCandidato=<s:property value="#candidato.idcandidato"/>&idOferta=<s:property value="#request.idOferta"/>"><s:text name="candidato.ver"/></a></td>
							</s:else>
							</tr>
							</s:iterator>
						</tbody>
						</table>
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
