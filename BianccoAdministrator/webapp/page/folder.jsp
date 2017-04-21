<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-header">
	<table width="100%">
		<tr>
			<td width="30%"><h3>Documentos</h3></td>
            <td width="70%" align="right">
            	<!-- 
				<button class="btn btn-default btn-block" id="loginButton" onclick="showAlert()" style="width: 130px;">
        			<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>Documentos
        		</button>
        		 --> 
            </td>
		</tr>
	</table>
</div>
<div class="row">
	<div class="col-md-6" role="main">
		<div>
			<div id="folderTreeview"></div>
		</div>
	</div>
	<div class="col-md-6" id="uploadPanel" role="complementary">
		<form id="uploadForm" action="//jquery-file-upload.appspot.com/" method="POST" enctype="multipart/form-data">
        <!-- Redirect browsers with JavaScript disabled to the origin page -->
        <noscript><input type="hidden" name="redirect" value="https://blueimp.github.io/jQuery-File-Upload/"></noscript>
        <!-- The fileupload-buttonbar contains buttons to add/delete files and start/cancel the upload -->
        <div class="row fileupload-buttonbar">
            <div class="col-lg-7">
                <!-- The fileinput-button span is used to style the file input field as button -->
                <span class="btn btn-success fileinput-button">
                    <i class="glyphicon glyphicon-plus"></i>
                    <span>Agregar archivos...</span>
                    <input type="file" name="files[]" multiple>
                </span>
                <button type="submit" class="btn btn-primary start">
                    <i class="glyphicon glyphicon-upload"></i>
                    <span>Subir</span>
                </button>
                <button type="reset" class="btn btn-warning cancel">
                    <i class="glyphicon glyphicon-ban-circle"></i>
                    <span>Cancelar</span>
                </button>
                <button type="button" class="btn btn-danger delete">
                    <i class="glyphicon glyphicon-trash"></i>
                    <span>Borrar</span>
                </button>
                <input type="checkbox" class="toggle">
                <!-- The global file processing state -->
                <span class="fileupload-process"></span>
            </div>
            <!-- The global progress state -->
            <div class="col-lg-5 fileupload-progress fade">
                <!-- The global progress bar -->
                <div class="progress progress-striped active" role="progressbar" aria-valuemin="0" aria-valuemax="100">
                    <div class="progress-bar progress-bar-success" style="width:0%;"></div>
                </div>
                <!-- The extended global progress state -->
                <div class="progress-extended">&nbsp;</div>
            </div>
        </div>
        <!-- The table listing the files available for upload/download -->
        <table role="presentation" class="table table-striped"><tbody class="files"></tbody></table>
    </form>
	</div>
</div>
<button class="btn btn-default" id="backButton" onclick="backTo(1)">
	<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	Regresar
</button>
				
<script type="text/javascript">
	var _data = '[' + decodeURIComponent('<c:out value="${model.folderAsJSON}"/>'.replace(/\+/g, '%20')) + ']';
	var $tree = $('#folderTreeview').treeview({
		showTags: true,
		data: _data
	});
</script>