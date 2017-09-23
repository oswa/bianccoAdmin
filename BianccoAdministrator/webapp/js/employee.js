/**
 * Employee module functions. 
 */
/**
 * Shows add employee view.
 */
function addEmployee() {
	jQuery.ajax({
		url: currentURL() + '/app/employee/add',
		data: '',
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando informaci&oacute;n...');
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
 * Shows employee detail.
 * @param _emp Employee.
 */
function editEmployee(_emp) {
	jQuery.ajax({
		url: currentURL() + '/app/employee/edit',
		data: {'_emp' : _emp},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando informaci&oacute;n...');
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
 * Saves an employee.
 */
function saveEmployee() {
	jQuery.ajax({
		url: currentURL() + '/app/employee/save',
		data: {'_detail' : $('#empDetailForm').serialize(), '_role' : $('#idRole').val()},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Guardando...');
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
 * Save employee handler.
 */
/*$('#loginForm').submit(function(event) {
    event.preventDefault();
    showWaitDialog('Autenticando...');
    this.submit();
    $.ajax({
        url: currentURL() + '/app/login/signin',
        data: $('#loginForm').serialize(),
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
        beforeSend: function(req) {
        	showWaitDialog('Autenticando...');
        },
        error: function(xhr){
        	checkError(xhr);
        }
    });
});*/

/**
 * Updates an employee.
 */
function updateEmployee() {
	jQuery.ajax({
		url: currentURL() + '/app/employee/update',
		data: {'_detail' : $('#empDetailForm').serialize(), '_role' : $('#idRole').val(), '_emp' : $('#idEmployee').val()},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Guardando...');
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
 * Disable/Enable an employee.
 * @param _id Employee identifier.
 * @param _checked Employee flag.
 */
function disableEmployee(_id, _checked) {
	jQuery.ajax({
		url: currentURL() + '/app/employee/enable',
		data: {'_id' : _id, '_enable' : _checked},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Actualizando...');
		},
		success: function(response) {
			// notify
			console.log('disableEmployee', response);
			showAlert('success', 'messageAlert', 'Empleado actualizado.');
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
		complete: function() {
			hideWaitDialog();
		}
	});
}