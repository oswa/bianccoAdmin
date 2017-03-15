/**
 * Employee module functions. 
 */
/**
 * Shows add employee view.
 */
function addEmployee() {
	jQuery.ajax({
		url: currentURL() + '/app/employee/add',
		data: $('#user').val(),
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando m&oacute;dulo...');
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

/**
 * Shows employee detail.
 * @param _emp Employee.
 */
function editEmployee(_emp) {
	//
}

/**
 * Saves employee.
 */
function saveEmployee() {
	//
}