/**
 * Application functions.
 */
/**
 * Goes to main page by module.
 * @param _module The module.
 */
function goToView(_module) {
	jQuery.ajax({
		url: currentURL() + '/app/' + _module,
		data: ''/*$('#user').val()*/,
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando m&oacute;dulo...');
		},
		success: function(response) {
			// clean tmp files
			$('.form_date').datetimepicker('remove');
			
			$('#content').hide();
			$('#content').html('');
			$('#content').html(response);
			$('#content').show();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}
/**
 * Goes to folder page by module.
 * @param _folderType Flder type.
 * @param _id The module.
 */
function showFolder(_folderType, _id) {
	jQuery.ajax({
		url: currentURL() + '/app/folder/' + _folderType,
		data: {'_id' : _id},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando documentos...');
		},
		success: function(response) {
			// clean tmp files
			$('.form_date').datetimepicker('remove');
			
			$('#content').hide();
			$('#content').html('');
			$('#content').html(response);
			$('#content').show();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}
/**
 * Back to specific view.
 * @param _view View to go.
 * @returns page.
 */
function backTo(_view) {
	jQuery.ajax({
		url: currentURL() + '/app/back',
		data: {'_view' : _view},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando...');
		},
		success: function(response) {
			// clean tmp files
			$('.form_date').datetimepicker('remove');
			
			$('#content').hide();
			$('#content').html('');
			$('#content').html(response);
			$('#content').show();
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}
/**
 * Gets the fields by folder.
 * @param _folder Folder.
 * @returns Folder fields.
 */
function getFolderFields(_folder) {
	jQuery.ajax({
		url: currentURL() + '/app/folder/fields',
		data: JSON.stringify(_folder),
        cache: false,
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando informaci&oacute;n...');
		},
		success: function(response) {
			// clean tmp files
			$('.form_date').datetimepicker('remove');
			// set title
			$('#_folderName').hide();
			$('#_folderName').html('');
			$('#_folderName').html('<p><b>Carpeta:</b> ' + _folder.pathChild + '</p>');
			$('#_folderName').show();
			// clean msg
			$('#_folderMessage').html('');
			// set content
			$('#_folderFields').hide();
			$('#_folderFields').html('');
			$('#_folderFields').html(response);
			$('#_folderFields').show();
			// set path
			$('#path').val(_folder.pathRoot);
			$('#child').val(_folder.pathChild);
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}

/**
 * Saves the folder detail.
 * @param _folder Folder.
 */
function saveFolderDetail() {
	var _folder = $('#folderTreeview').treeview('getSelected')[0].detail;
	var _data = getDataFromFolderDetail();
	jQuery.ajax({
		url: currentURL() + '/app/folder/fields/save',
		data: JSON.stringify(_data),
        cache: false,
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Guardando informaci&oacute;n...');
		},
		success: function(response) {
			// clean tmp files
			$('.form_date').datetimepicker('remove');
			// clean msg
			$('#_folderMessage').html('');
			// update detail
			$('#_folderFields').hide();
			$('#_folderFields').html('');
			$('#_folderFields').html(response);
			$('#_folderFields').show();
			// set path
			$('#path').val(_folder.pathRoot);
			$('#child').val(_folder.pathChild);
			// show success alert			
			showAlert('success', '_folderMessage', 'Infomaci&oacute;n guardada.');
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr, '_folderMessage');
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}

/**
 * Parse fields to array.
 * @returns Fields data.
 */
function getDataFromFolderDetail() {
	// get fields
	var _div = $('#_folderFields');
	var _folderType = $('#folderType').val();
	var _ownerModuleId = $('#ownerModuleId').val();
	var _folderId = $('#folderId').val();
	var _fields = new Array();
	_div.find('input:text, input:hidden, select').each(function() {
		if (this.name.indexOf('_field') === 0) {
			var _ids = this.name.split('_');
			var _idVal = _ids[3];
			if (_idVal == 0) {
			    _idVal = null;
			}
			var ff = {
					idFolderValue: _idVal,
					field: {
						idFolderField: _ids[2]
					},
					ownerModuleId: _ownerModuleId,
					ownerFolderType: _folderType,
					value: $(this).val(),
					idFolder: _folderId
				};
			_fields.push(ff);
		}
	});
	return _fields;
}
/**
 * Refresh the folder content.
 */
function refreshFolder(_data) {
	var _folderType = $('#folderType').val();
	var _id = $('#ownerModuleId').val();
	jQuery.ajax({
		url: currentURL() + '/app/folder/refresh',
		data: {'_id' : _id, '_type' : _folderType},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        dataType: 'text',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Actualizando documentos...');
		},
		success: function(response) {
			// clean folder
			$('#folderTreeview').treeview('remove');
			// update
			var _data = '[' + decodeURIComponent(response.replace(/\+/g, '%20')) + ']';
			console.log('data updated', _data);
			$('#folderTreeview').treeview({
				showTags: true,
				data: _data,
				onNodeSelected: function(event, node) {
					// get fields
					if (node.folder && node.nodeId != 0) {
						getFolderFields(node.detail);
					} else if (!node.folder && node.nodeId != 0) {
						// get file detail
						//getFileDetail(node.detail);
					}
		        }
			});
			//initTreeView(response);
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}
/**
 * Handles file upload error.
 * @param _data Data result.
 */
function handleFileUploadError(_data) {
	checkError(_data.response().jqXHR, '_folderMessage');
}
/**
 * Initializes folder tree view.
 * @param _dataEncoded Data encoded.
 * @returns Folder as tree view.
 */
function initTreeView(_dataEncoded) {
	var _data = '[' + decodeURIComponent(new String(_dataEncoded).replace(/\+/g, '%20')) + ']';
	$('#folderTreeview').treeview({
		showTags: true,
		data: _data,
		onNodeSelected: function(event, node) {
			// get fields
			if (node.folder && node.nodeId != 0) {
				getFolderFields(node.detail);
			} else if (!node.folder && node.nodeId != 0) {
				// get file detail
				//getFileDetail(node.detail);
			}
        }
	});
}