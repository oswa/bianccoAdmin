<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="_fileUpload">
	<span class="btn btn-default fileinput-button">
		<i class="glyphicon glyphicon-plus"></i>
		<span>Subir archivos...</span>
		<input id="fileupload" type="file" name="files[]" data-url="rest/controller/upload" multiple>
	</span>
	<br><br>
	<div id="dropzone"><p>Arrastra y suelta tus archivos aqu&iacute;</p></div>
	<div id="progress">
		<div style="width: 0%;"></div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/js/fileupload.js"></script>