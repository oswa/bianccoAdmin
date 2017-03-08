/**
 * Application functions.
 */
/**
 * Goes to module main page.
 */
function goToView(_module) {
	jQuery.ajax({
		url: currentURL() + '/app/' + _module,
		data: $('#user').val(),
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando módulo...');
		},
		success: function(response) {
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