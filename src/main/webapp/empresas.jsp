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
<script language="javascript">
$(document).ready(function()
{
	var clave =<%=request.getParameter("claveId")%>;
	if(clave==null)
	{
		$('#capaOfertas').hide();
	}
	$('a[href*=#]').click(function() 
	{
		$('#capaOfertas').hide();
		$('#capaOfertas').show('slow');
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
				<li class="active"><a href="<s:property value=""/>"><b><s:text name="candidato.empresas"/></b></a></li>
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
							<h3><s:text name="empresa.buscador"/></h3>
							<s:form id="buscador" action="buscarEmpresas" method="post" theme="xhtml">
								<sj:autocompleter label="Nombre" id="autoEmpresas" name="palabraClave" list="%{#request.listadoEmpresas}"/>
    						<s:submit id="submitFormAutocomplete" value="Buscar" cssClass="ui-button ui-widget ui-state-default ui-corner-all ui-state-hover"/>
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
						<h3><s:text name="empresa.ultimasEmpresas"/></h3>
						 <s:iterator value="#request.ultimasEmpresas" status="contadorE" var="ultimaEmpresa">
								<s:url var="urlVerEmpresa" action="buscarEmpresas">
									<s:param name="palabraClave">
										<s:property value="%{#ultimaEmpresa.nombre}"/>
									</s:param>
								</s:url>
								<a href="<s:property value="#urlVerEmpresa"/>"><s:property value="%{#contadorE.count}"/>-<s:property value="%{#ultimaEmpresa.nombre}"/></a><br/>
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
					<h3></h3>
				</div>					
				<div class="db1_content">
					<div class="db1_container">
					<sj:div id="capaEmpresas">
					<s:if test="%{#request.empresas.size()==0}"> 
						<strong> <s:text name="empresa.noHayEmpresas"/> </strong>
					</s:if>
					<s:else>
						<table>
						<caption><s:text name="empresa.titulo"/></caption> 
						<thead>
						<tr>
						<th scope="col"><s:text name="empresa.key"/></th>
						<th scope="col"><s:text name="empresa.nombre"/></th>
						<th scope="col"> <s:text name="empresa.sectores"/></th>
						<th scope="col"> <s:text name="empresa.trabajadores"/></th>
						<th scope="col"> <s:text name="empresa.web"/></th>
						<th scope="col"><s:text name="empresa.cif"/></th>
						<th scope="col"></th>
						</tr>
						</thead>
						<tfoot> 
						<tr>
							<th scope="row"><s:text name="global.total"/></th>
							<td colspan="4"><s:property value="#request.empresas.size()"/></td>
						</tr>
						</tfoot> 
						<tbody> 
							<s:iterator value="#request.empresas" var="empresa" status="contadorE">
								<s:if test="#contadorE.count%2==0"><tr></s:if>
								<s:else><tr class="odd"></s:else>
								<s:url var="urlVerEmpresa" action="verEmpresa"/>
								<td><s:property value="#empresa.key"/></td>
								<td><s:property value="#empresa.nombre"/></td>
								<th scope="row">
								<s:property value="#empresa.tiposociedad"/></th>
								<td><s:property value="#empresa.numtrabajadores"/></td>
								<td><s:property value="#empresa.web"/></td>
								<td><s:property value="#empresa.cif"/></td>
								<s:url var="urlVerOferta" action="verOfertasPorEmpresa" >
									<s:param name="idEmpresa">
										<s:property value="%{#empresa.key.id}"/>
									</s:param>
								</s:url>
								<td>
									<s:if test="#empresa.ofertas.size()==0"></s:if>
									<s:else> <a href="<s:property value="#urlVerOferta"/>"><s:text name="empresa.verOfertas"/></a> </s:else>
								</td>				
								</tr>
							</s:iterator>
						</tbody>
						</table>

					
					</s:else>
					<br/><br/><br/>
					</sj:div>
					<sj:div id="capaOfertas">
							<table>
							<caption><s:text name="empresa.ofertas"/> <s:property value="empresa.nombre"/> <s:property value="empresa.tiposociedad"/></caption> 
							<thead>
							<tr>
							<th scope="col"><s:text name="oferta.nombre"/></th>
							<th scope="col"> <s:text name="oferta.tipoContrato"/></th>
							<th scope="col"> <s:text name="oferta.duracion"/></th>
							<th scope="col"> <s:text name="oferta.jornada"/></th>
							<th scope="col"> <s:text name="oferta.fechaInicio"/></th>
							<th scope="col"> <s:text name="oferta.fechaFin"/></th>
							<th scope="col"></th>
							</tr>
							</thead>
							<tfoot> 
							</tfoot> 
							<tbody>
								<s:iterator value="#request.ofertasEmpresa" var="oferta" status="contadorO">
									<s:if test="#contadorO.count%2==0"><tr></s:if>
									<s:else><tr class="odd"></s:else>
									<s:url var="urlVerOferta" action="verOferta">
										<s:param name="id" value="#oferta.idoferta"/>
									</s:url>
									<th scope="row"><a href="<s:property value="#urlVerOferta"/>"><s:property value="#oferta.nombre"/></a></th>
									<td><s:property value="#oferta.tipoContrato"/></td>	
									<td><s:property value="#oferta.duracion"/></td>
									<td><s:property value="#oferta.jornada"/></td>		
									<td><s:date name="%{#oferta.fechafin}" format="%{getText('global.formatoFecha')}"/></td>
									<td><s:date name="%{#oferta.fechainicio}" format="%{getText('global.formatoFecha')}"/></td>
									<td><a href="<s:property value="#urlVerOferta"/>"><s:text name="oferta.ver"/></a></td>
									</tr>
								</s:iterator>
							</tbody>
							</table>
					</sj:div>
					
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
