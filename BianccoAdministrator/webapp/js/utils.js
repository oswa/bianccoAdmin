/**
 * Utility functions.
 */

/**
 * Gets URL.
 * @returns {String} The URL.
 */
function currentURL() {
    return location.protocol+'//'+location.hostname+(location.port ? ':'+location.port: '')+'/BianccoAdministrator-0.0.1-SNAPSHOT';
}
/**
 * On load functions.
 */
$(function() {
	/**
	 * Login user.
	 */
    $('#loginForm').submit(function(event) {
        event.preventDefault();
        showWaitDialog('Autenticando...');
        this.submit();
        /*$.ajax({
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
        });*/
    });
    /**
	 * Logout user.
	 */
    $('#logoutForm').submit(function(event) {
        event.preventDefault();
        showWaitDialog('Saliendo...');
        this.submit();
    });
}); 
/**
 * Logout user.
 
function signin() {
	jQuery.ajax({
		url: currentURL() + '/app/login/signin',
		data: $('#user').val(),
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			//showWaitDialog('Autenticando...');
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		}
	});
}*/
/**
 * Logout user.
 */
function signoff() {
	jQuery.ajax({
		url: currentURL() + '/app/login/signoff',
        cache: false,
        contentType: 'application/x-www-form-urlencoded',
        type: 'POST',
		beforeSend: function(req) {
			showWaitDialog('Saliendo...');
		},
		error : function(xhr, ajaxOptions, thrownError) {
			checkError(xhr);
		},
	});
}
/**
 * Check error type.
 */
function checkError(xhr) {
	if(xhr.status == 401) {
		var url = currentURL() + '/error.jsp';
		window.location = url;
	} else {
		try {
			var object = JSON.parse(xhr.responseText);
			alert(object.messaje);
		} catch(e) {
			if (typeof console != "undefined") {
				console.log('error: ' + e.name + ': ' + e.message);
			}
			alert('Ha ocurrido un problema en la aplicación, contacte a un administrador.');
		}
	}
}
/**
 * Wait dialog.
 */
var _waitDialog;
/**
 * Shows a wait dialog.
 */
function showWaitDialog(_msg) {
    $('#pleaseWaitDialog').remove();
    _waitDialog = (function () {
    var pleaseWaitDiv = $('<div class="modal fade mask-dialog" tabindex="-1" role="dialog" aria-labelledby="modalLabel" ' +
                            'aria-hidden="true" data-keyboard="false" data-backdrop="static" id="pleaseWaitDialog">' +
                                '<div class="modal-dialog">' +
                                    '<div class="modal-content">' +
                                        '<div class="modal-header">' +
                                            '<h3>' + _msg + '</h3>' +
                                        '</div>' +
                                        '<div class="modal-body">' +
                                            '<div class="progress">' +
                                                '<div class="progress-bar progress-bar-striped progress-bar-animated active" ' +
                                                'role="progressbar" style="width: 100%"></div>' +
                                            '</div>' +
                                        '</div>' +
                                    '</div>' +
                                '</div>' +
                            '</div>');
    	return {
    	    showPleaseWait: function() {
    	        pleaseWaitDiv.modal();
    	    },
    	    hidePleaseWait: function () {
    	    	pleaseWaitDiv.removeClass('fade').modal('hide');
    	    },
    	};
    })();

    _waitDialog.showPleaseWait();
}
/**
 * Hides the wait dialog.
 */
function hideWaitDialog() {
	_waitDialog.hidePleaseWait();
	$('#pleaseWaitDialog').remove();
}
/**
 * Wait dialog.
 */
var _messageAlert;
/**
 * Shows a wait dialog.
 */
function showAlert(_type, _msg) {
    //$('#messageAlert').html(''); display:none
	var _title = '';
	switch (_type) {
		case 'danger':
			_title = 'Error!';
			break;
		case 'success':
			_title = 'Hecho!';
			break;
		case 'warning':
			_title = 'Alerta!';
			break;
		case 'info':
			_title = 'Nota!';
			break;
		default: break;
	}
    _messageAlert = (function () {
    var alertDiv = $('<div class="alert alert-' + _type + ' alert-demissable fade in" role="alert">' +
            			'<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>' +
            			'<strong>' + _title + '</strong> ' + _msg +
          			'</div>');
    	return {
    	    show: function() {
    	    	$('#messageAlert').html(alertDiv);
    	    	$('#messageAlert').show();    	    	
    	    },
    	    close: function () {
    	    	$('#messageAlert').html('');
    	    	$('#messageAlert').hide();
    	    },
    	};
    })();

    _messageAlert.show();
}
/**
 * Hides the wait dialog.
 */
function closeAlert() {
	_messageAlert.close();
}