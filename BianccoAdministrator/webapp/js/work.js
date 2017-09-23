/**
 * Work module functions. 
 */
/**
 * Goes to main page by module.
 * @param _module The module.
 */
function goToViewWork(_module) {
	idCompany = $('#idCompany').val();
	jQuery.ajax({
		url: currentURL() + '/app/' + _module,
		data: {'idCompany' : idCompany},
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
 * Saves a work.
 */
function saveWork() {
	jQuery.ajax({
		url: currentURL() + '/app/work/save',
		data: {'_work' : $('#workForm').serialize(), '_idCompany' : $('#idCompany').val()},
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
 * Edit a work.
 * @param _comp Company.
 */
function editWork(_work) {
	jQuery.ajax({
		url: currentURL() + '/app/work/edit',
		data: {'_work' : _work},
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
 * Updates a work.
 */
function updateWork() {
	var data = getWorkDataFromTabs();
	jQuery.ajax({
		url: currentURL() + '/app/work/update',
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
 * Parse fields to array.
 * @returns Fields data.
 */
function getWorkDataFromTabs() {
	// get work data
	var work = {
			idWork: $('#idWork').val(),
			name: $('#name').val(),
			workDate: $('#workDate').val(),
			contractNum: $('#contractNum').val(),
			location: $('#location').val(),
			locationMap: $('#locationMap').val(),
			residente: $('#residente').val(),
			superintendente: $('#superintendente').val(),
			supervisor: $('#supervisor').val(),
			company: {
				idCompany: $('#idCompany').val()
			},
			workAmount: {
				budget: $('#budget').val(),
				directCost: $('#directCost').val(),
				workforce: $('#workforce').val(),
				material: $('#material').val(),
				equipmentTools: $('#equipmentTools').val()
			}
		};
	return work;
}
