<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/work.js"></script>
<c:choose>
	<c:when test="${empty model.company}">
		<div class="page-header">
        	<table width="100%">
          		<tr>
            		<td width="30%"><h3>Nueva Empresa</h3></td>
            		<td width="70%" align="right">
            			<c:if test="${model.pType.type eq 'M'}">
							<button class="btn btn-primary" id="saveButton" onclick="saveCompany()">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
								Guardar
							</button>
						</c:if>
            		</td>
            	</tr>
            </table>
		</div>
		<!-- 
		<div class="page-header">
			<h3>Nuevo</h3>
		</div>
		 
		<c:if test="${model.pType.type eq 'M'}">
			<table width="100%">
				<td align="right">
					<button class="btn btn-primary" id="addButton" onclick="saveCompany()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</table>
		</c:if>
		-->
		<div id="_companyMessage"></div>
		
		<form id="companyForm">
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre" required autofocus>
			</div>
			<div class="form-group">
				<label for="representante">Representante legal</label> <input type="text"
					class="form-control" id="representante" name="representante" placeholder="Nombre de Representante legal" required autofocus>
			</div>
		</form>
		<table width="100%">
			<td align="left">
				<button class="btn btn-default" id="backButton" onclick="backTo(1)">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					Regresar
				</button>
			</td>
			<c:if test="${model.pType.type eq 'M'}">
				<td align="right">
					<button class="btn btn-primary" id="saveButton" onclick="saveCompany()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</c:if>
		</table>
	</c:when>
	<c:otherwise>
		<div class="page-header">
        	<table width="100%">
          		<tr>
            		<td width="30%"><h3>Editar <c:out value="${model.company.name}"/></h3></td>
            		<td width="70%" align="right">
              			<button class="btn btn-default" id="showDocumentsButton" onclick="showFolder('company', ${model.company.idCompany})">
        					<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
        					Documentos
        				</button>
              			<button class="btn btn-default" id="showDocumentsButton" onclick="goToViewWork('work');">
        					<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
							<c:choose>
								<c:when test="${not empty model.company.works}">
									Obras(<c:out value="${model.company.works.size()}"/>)
								</c:when>
								<c:otherwise>
        							Obras(0)
								</c:otherwise>
							</c:choose>
        				</button>
        				<c:if test="${model.pType.type eq 'M'}">
	        				<button class="btn btn-primary" id="updateButton" onclick="updateCompany()">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
								Guardar
							</button>
						</c:if>
            		</td>
          		</tr>
        	</table>
      	</div>
		<div id="messageAlert"></div>
		<div id="_companyMessage"></div>

<!-- =============================================================================== -->

<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#_data">Datos</a></li>
  <li><a data-toggle="tab" href="#_power">Poder General</a></li>
</ul>


<div class="tab-content">

<!-- =============================================================================== -->


  <div id="_data" class="tab-pane fade in active">
  			<br>
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre"
					value="${model.company.name}" required autofocus>
			</div>
			<div class="form-group">
				<label for="representante">Representante legal</label> <input type="text"
					class="form-control" id="representante" name="representante" placeholder="Nombre de Representante Legal"
					value="${model.company.representante}" required autofocus>
			</div>
<!-- 
<form id="_folderForm">
	<input type="hidden" id="companyId" name="companyId" value="${model.company.idCompany}" />
<%-- 	<input type="hidden" id="folderId" name="folderId" value="${model.folderId}" /> --%>
<%-- 	<input type="hidden" id="folderType" name="folderType" value="${model.folderType}" /> --%>
<%-- 	<input type="hidden" id="ownerModuleId" name="ownerModuleId" value="${model.ownerModuleId}" /> --%>
	<input type="hidden" id="path" name="path" value="" />
	<input type="hidden" id="child" name="child" value="" />
	<div id="_folderUploadFiles"></div>
</form>

<script type="text/javascript">
	$('#_folderUploadFiles').fileuploadUI({
		url: currentURL() + '/app/company/upload',
		maxFileSize: 4194304, // 4mb
		acceptFileTypes: /(\.|\/)(gif|png|jpe?g|pdf|docx?|xlsx?|txt)$/i,
		multiple: false, // multiple selection
		dropZone: true, // drop zone
/*		handlers: {
			done: 'refreshLogo',
			fail: 'handleFileUploadError' 
		},*/
		debug: true
	});
</script>
 -->
  </div>


<!-- =============================================================================== -->


  <div id="_power" class="tab-pane fade">
  			<br>
			<div class="form-group">
				<label for="power">Apoderado</label> <input type="text"
					class="form-control" id="power" name="power" placeholder="Nombre de la persona a quien se le otorga el poder"
					value="${model.company.power.power}" required autofocus>
			</div>
			<div class="form-group">
				<label for="notary">Notario Público</label> <input type="text"
					class="form-control" id="notary" name="notary" placeholder="Nombre del Notario Público"
					value="${model.company.power.notary}" required autofocus>
			</div>
			<div class="form-group">
				<label for="district">Cirscunscripción territorial</label> <input type="text"
					class="form-control" id="district" name="district" placeholder="Circunscripción territorial del Notario Público"
					value="${model.company.power.district}" required autofocus>
			</div>
			<div class="form-group">
				<label for="notaryNum">Número del Notario Público</label> <input type="text"
					class="form-control" id="notaryNum" name="notaryNum" placeholder="Número del Notario Público"
					value="${model.company.power.notaryNum}" required autofocus>
			</div>
  </div>

</div>

<!-- =============================================================================== -->


		<input type="hidden" id="idCompany" name="idCompany" value="${model.company.idCompany}">
		<table width="100%">
			<td align="left">
				<button class="btn btn-default" id="backButton" onclick="backTo(1)">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					Regresar
				</button>
			</td>
			<c:if test="${model.pType.type eq 'M'}">
				<td align="right">
					<button class="btn btn-primary" id="updateButton" onclick="updateCompany()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</c:if>
		</table>
	</c:otherwise>
</c:choose>
