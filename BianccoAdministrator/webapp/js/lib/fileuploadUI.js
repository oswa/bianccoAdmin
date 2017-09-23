/*
 * jQuery File Upload UI Plugin | (c) RAPA Services | Requires jQuery & jQuery fileupload plugin, Bootstrap CSS
 *
 * Copyright 2017, Oswaldo Gutierrez <o.gutierrez@rapaservices.com>
 *
 * Licensed under the MIT license:
 * https://opensource.org/licenses/MIT
 */
(function ( $ ) {
	$.fn.fileuploadUI = function( options ) {
		// default options
		var settings = $.extend({
			// url
			url: undefined,
			// size in bytes (512 KB by default)
			maxFileSize: 512000,
			// accepted file types (gif, jp(e)g, png, pdf, doc(x), xls(x), txt are accepted by default)
			acceptFileTypes: /(\.|\/)(gif|jpe?g|png|pdf|docx?|xlsx?|txt)$/i,
			// multiple file selection
			multiple: true,
			// drop zone
			dropZone: true,
			// handler functions
			handlers: {
				// receives data result as parameter
				done: undefined,
				// receives data result as parameter
				fail: undefined,
				// receives data result as parameter
				complete: undefined
			},
			// error messages
			messages: {
	            maxNumberOfFiles: 'Se ha superado el número máximo de archivos',
	            acceptFileTypes: 'Tipo de archivo no permitido',
	            maxFileSize: 'El archivo es demasiado grande',
	            minFileSize: 'El archivo es demasiado pequeño'
	        },
	        // button title
	        buttonTitle : 'Cargar archivos...',
	        // debug
	        debug: false 
		}, options);
		// get parent form
		var form = this.parent('form').get(0);
		// validate drop zone
		var dropZoneOption = '';
		if (settings.dropZone) {
			dropZoneOption = ', dropZone: $("#dropzone")';
		}
		// configure jQuery fileupload plugin
		$('#_folderForm').append(
			$('<script type="text/javascript" />').text(
				'$(function () {' +
					'$("#_fileupload").fileupload({' +
						'dataType: "json",' +
				        'maxFileSize: ' + settings.maxFileSize + ',' +
				        'acceptFileTypes: ' + settings.acceptFileTypes + ',' +
				        'messages: {' +
				        	'maxNumberOfFiles: "' + settings.messages.maxNumberOfFiles + '",' +
				        	'acceptFileTypes: "' + settings.messages.acceptFileTypes + '",' +
				        	'maxFileSize: "' + settings.messages.maxFileSize + '",' +
				        	'minFileSize: "' + settings.messages.minFileSize + '",' +
				        '},' +
				        'start: function (e) {' +
				        	'startCallback(' + settings.debug + ');' +
				       	'},' +
				       	'done: function (e, data) {' +
				       		'doneCallback(data, ' + settings.debug + ');' +
				        	'if(typeof ' + settings.handlers.done + ' === "function") {' +
				        		settings.handlers.done + '(data);' +
				        	'}' +
				        '},' +
				        'progressall: function (e, data) {' +
				        	'progressallCallback(data, ' + settings.debug + ');' +
				   		'},' +
				   		'processalways: function (e, data) {' +
				        	'processalwaysCallback(data, ' + settings.debug + ');' +
					        'if(typeof ' + settings.handlers.complete + ' === "function") {' +
			   					settings.handlers.complete + '();' +
			   				'}' +
				        '},' +
				   		'fail: function (e, data) {' +
				   			'failCallback(data, ' + settings.debug + ');' +
				   			'if(typeof ' + settings.handlers.fail + ' === "function") {' +
				   				settings.handlers.fail + '(data);' +
			        		'}' +
				   		'}' +
						dropZoneOption +
					'});' +
				'});'
			)
		);
		// validate multiple attribute
		var multipleAttr = ''
		if (settings.multiple) {
			var multipleAttr = 'multiple'
		}
		// clean
		this.html('');
		// build component based on settings
		var ui = this.append(
					$('<span class="btn btn-success fileinput-button fileupload-button-ui" />')
					.append($('<i class="glyphicon glyphicon-plus" />'))
					.append($('<span/>').text(' ' + settings.buttonTitle))
					.append($('<input id="_fileupload" type="file" name="files[]" data-url="' + settings.url + '" ' + multipleAttr + '>'))
				);
		// validate drop zone
		if (settings.dropZone) {
			ui.append($('<div id="dropzone" class="well" />').html('Arrastra y suelta tus archivos aqu&iacute;'));
		}
		// add process status & progress bar
		ui.append(
			$('<div id="_status" style="align: right;" />')
		).append(
			$('<div id="progress" class="progress" />')
			.append($('<div class="progress-bar progress-bar-striped" style="width: 0%;" />'))
		);
		return ui;
	};
}( jQuery ));

/**
 * Start callback function.
 * @param _debug Debug flag.
 */
function startCallback(_debug) {
	if (_debug) {
		debug('start', undefined);
	}
	$("#progress .progress-bar").css("width", 0 + "%");
	$("#_status").html("");
}
/**
 * Done callback function.
 * @param _data Data result.
 * @param _debug Debug flag.
 */
function doneCallback(_data, _debug) {
	if (_debug) {
		debug('done::data', _data);
		debug('done::result', _data.result);
	}
	notify("success", "Archivo(s) guardado(s) correctamente");
}
/**
 * Progress callback function.
 * @param _data Data result.
 * @param _debug Debug flag.
 */
function progressallCallback(_data, _debug) {
	if (_debug) {
		debug('progressall (' + formatBytes(_data.loaded) + ' of ' + formatBytes(_data.total) + ')');
	}
    var progress = parseInt(_data.loaded / _data.total * 100, 10);
    $("#progress .progress-bar").css("width", progress + "%");
}
/**
 * Process Always (Complete) callback function.
 * @param _data Data result.
 * @param _debug Debug flag.
 */
function processalwaysCallback(_data, _debug) {
	if (_debug) {
		debug('complete', _data);
		var file = _data.files[_data.index];
	    if (file.error) {
	    	console.log("complete::error", file.error);
	    }		
	}
	var _error = "Error en carga de archivo(s)";
    var _errorExist = false;
    $.each(_data.files, function (index, file) {
    	if (file.error) {
    		_errorExist = true;
    		_error = _error.concat("<br>" + file.name + ": " + file.error);
    	}
    });
    if (_errorExist) {
    	notify("danger", _error);
    }
}
/**
 * Fail callback function.
 * @param _data Data result.
 * @param _debug Debug flag.
 */
function failCallback(_data, _debug) {
	if (_debug) {
		debug('fail', _data);
		debug('fail::response', _data.response());
	}
    var _error = "Error en carga de archivo(s)";
    notify("danger", _error);
}
/**
 * Prints object in console.
 * @param eventName Event name.
 * @param obj Object to print.
 */
function debug(eventName, obj) {
	if (window.console && window.console.log) {
		window.console.log(eventName, obj);
	}
}
/**
 * Create & show notification.
 * @param _type Alert type.
 * @param _message Message to show.
 */
function notify(_type, _message) {
	var _title = '';
	switch (_type) {
		case 'danger':
			_title = ':(';
			break;
		case 'success':
			_title = ':)';
			break;
		default: break;
	}
	var _divAlert = $('#_status');
	if (_divAlert.length) {
		var _alertTmpl = '<div class="alert alert-' + _type + ' alert-dismissible" role="alert">' +
			'<button type="button" class="close" data-dismiss="alert" aria-label="Close">' +
				'<span aria-hidden="true">&times;</span>' +
			'</button><strong>'+ _title +'</strong>&nbsp;' + _message + '</div>';
		_divAlert.hide();
		_divAlert.html('');
		_divAlert.html(_alertTmpl);
		_divAlert.show();
	} else {
		alert(object.message);
	}
}
/**
 * Format bytes to KB, MB or GB.
 * @param bytes Bytes to format.
 * @returns Bytes formatted.
 */
function formatBytes(bytes) {
    if(bytes < 1024) return bytes + " Bytes";
    else if(bytes < 1048576) return(bytes / 1024).toFixed(3) + " KB";
    else if(bytes < 1073741824) return(bytes / 1048576).toFixed(3) + " MB";
    else return(bytes / 1073741824).toFixed(3) + " GB";
}