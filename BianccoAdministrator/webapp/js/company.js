/**
 * Company module functions. 
 */
/**
 * Shows add companies view.
 */
function addCompany() {
	jQuery.ajax({
		url: currentURL() + '/app/company/add',
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
 * Shows company.
 * @param _comp Company.
 */
function editCompany(_comp) {
	jQuery.ajax({
		url: currentURL() + '/app/company/edit',
		data: {'_comp' : _comp},
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando informaci&oacute;n...');
		},
		success: function(response) {
			// clean tmp files
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
 * Saves a company.
 */
function saveCompany() {
	jQuery.ajax({
		url: currentURL() + '/app/company/save',
		data: {'_company' : $('#companyForm').serialize()},
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
 * Updates a company.
 */
function updateCompany() {
	var data = getDataFromTabs();
	jQuery.ajax({
		url: currentURL() + '/app/company/update',
		data: JSON.stringify(data),
        cache: false,
        contentType: 'application/json; charset=utf-8',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Guardando informaci&oacute;n...');
		},
		success: function(response) {
			// update detail
			$('.form_date').datetimepicker('remove');
			$('#content').hide();
			$('#content').html('');
			$('#content').html(response);
			$('#content').show();
			// show success alert
			showAlert('success', 'messageAlert', 'Infomación guardada.');
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
 * Shows add work view.
 */
function addWork() {
	jQuery.ajax({
		url: currentURL() + '/app/work/add',
		data: '',
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Cargando informaci&oacute;n...');
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
 * Parse fields to array.
 * @returns Fields data.
 */
function getDataFromTabs() {
	// get company data
	var comp = {
			idCompany: $('#idCompany').val(),
			name: $('#name').val(),
			representante: $('#representante').val(),
			power: {
				power: $('#power').val(),
				notary: $('#notary').val(),
				district: $('#district').val(),
				notaryNum: $('#notaryNum').val()
			}
		};
	return comp;
}

