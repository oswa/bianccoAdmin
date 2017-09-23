<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="_folderForm">
	<c:choose>
		<c:when test="${not empty model.fields}">
			<c:forEach items="${model.fields}" var="item" varStatus="loop">
				<c:choose>
					<c:when test="${item.date}">
						<div class="form-group">
							<label for="date_${loop.index}">${item.field}</label>
							<div class="input-group date form_date col-md-5" data-date="" data-date-format="yyyy-mm-dd" data-link-field="date_${loop.index}"
								data-link-format="yyyy-mm-dd">
								<input class="form-control" size="16" type="text" value="${item.value}" readonly ${(item.required) ? 'required' : ''}>
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-remove"></span>
								</span>
								<span class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</span>
							</div>
							<input type="hidden" id="date_${loop.index}" name="_field_${item.idFolderField}_${item.idFolderValue}" value="${item.value}" />
						</div>
					</c:when>
					<c:when test="${not empty item.catalog}">
						<div class="form-group">
							<label for="_field_${item.idFolderField}_${item.idFolderValue}">${item.field}</label>
							<select class="form-control" id="_field_${item.idFolderField}_${item.idFolderValue}" 
							name="_field_${item.idFolderField}_${item.idFolderValue}" ${(item.required) ? 'required' : ''}>
								<option value="0">Seleccione una opci&oacute;n</option>
								<c:forEach items="${item.catalogValues}" var="_item" varStatus="_loop">
									<option value="${_item.name}" ${(_item.name eq item.value) ? 'selected' : ''}>${_item.value}</option>
								</c:forEach>
							</select>
						</div>
					</c:when>
					<c:otherwise>
						<div class="form-group">
							<label for="_field_${item.idFolderField}_${item.idFolderValue}">${item.field}</label>
							<input type="text" class="form-control" id="_field_${item.idFolderField}_${item.idFolderValue}" 
							name="_field_${item.idFolderField}_${item.idFolderValue}" 
							value="${item.value}" ${(item.required) ? 'required' : ''}>
						</div>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<script type="text/javascript">
				var _formDate = $('.form_date');
				if (_formDate.length) {
					_formDate.datetimepicker({
				        weekStart: 1,
				        todayBtn:  1,
						autoclose: 1,
						todayHighlight: 1,
						startView: 2,
						minView: 2,
						forceParse: 0
				    });
			    }
			</script>
		</c:when>
		<c:otherwise>
			
		</c:otherwise>
	</c:choose>
</form>
<c:if test="${model.pType.type eq 'M'}">
	<div align="right">
		<button class="btn btn-primary" id="saveButton" onclick="saveFolderDetail()">
			<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
				Guardar
		</button>
	</div>

	<form id="_folderUploadForm">
		<input type="hidden" id="folderId" name="folderId" value="${model.folderId}" />
		<input type="hidden" id="folderType" name="folderType" value="${model.folderType}" />
		<input type="hidden" id="ownerModuleId" name="ownerModuleId" value="${model.ownerModuleId}" />
		<input type="hidden" id="path" name="path" value="" />
		<input type="hidden" id="child" name="child" value="" />
		<div id="_folderUploadFiles"></div>
	</form>
	<script type="text/javascript">
		$('#_folderUploadFiles').fileuploadUI({
			url: currentURL() + '/app/folder/upload',
			maxFileSize: 4194304, // 4mb
			acceptFileTypes: /(\.|\/)(gif|png|jpe?g|pdf|docx?|xlsx?|txt)$/i,
			multiple: false, // multiple selection
			dropZone: true, // drop zone
			handlers: {
				done: 'refreshFolder',
				fail: 'handleFileUploadError' 
			},
			debug: false
		});
	</script>

</c:if>