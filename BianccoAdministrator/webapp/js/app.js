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
 * @param _module The module.
 * @param _id The module.
 */
function showFolder(_module, _id) {
	jQuery.ajax({
		url: currentURL() + '/app/' + _module + '/folder',
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