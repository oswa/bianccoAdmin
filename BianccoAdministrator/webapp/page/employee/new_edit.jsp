<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty model.employee}">
		<div class="page-header">
			<h3>Nuevo</h3>
		</div>
		<c:if test="${model.pType.type eq 'M'}">
			<table width="100%">
				<td align="right">
					<button class="btn btn-primary btn-block" id="addButton"
						style="width: 110px;" onclick="saveEmployee()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</table>
		</c:if>
		
		<div id="messageAlert"></div>
		
		<form id="empDetailForm">
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre" required autofocus>
			</div>
			<div class="form-group">
				<label for="last_name">Apellidos</label> <input type="text"
					class="form-control" id="lastName" name="lastName"
					placeholder="apellidos" required>
			</div>
			<div class="form-group">
				<label for="date_born">Fecha de nacimiento</label>
				<div class="input-group date form_date col-md-5" data-date=""
					data-date-format="yyyy-mm-dd" data-link-field="date_born"
					data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text" value="" readonly required>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<input type="hidden" id="date_born" name="date_born" value="" />
			</div>
			<div class="form-group">
				<label for="address">Direcci&oacute;n</label> <input type="text"
					class="form-control" id="address" name="address"
					placeholder="dirección" required>
			</div>
			<div class="form-group">
				<label for="phone">Telefono</label> <input type="text"
					class="form-control" id="phone" name="phone" placeholder="telefono" required>
			</div>
			<div class="form-group">
				<label for="mail">Correo electr&oacute;nico</label> <input type="email"
					class="form-control" id="mail" name="mail" placeholder="e-mail" required>
			</div>
		</form>
		<form id="empRoleForm">
			<div class="form-group">
				<label for="position">Puesto</label>
				<select class="form-control" id="idRole" name="idRole" required>
					<option value="0" selected="selected">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.roles}" var="item" varStatus="loop">
						<option value="${item.id}"><c:out value="${item.name}"/></option>
					</c:forEach>
				</select>
			</div>
		</form>
		<c:if test="${model.pType.type eq 'M'}">
			<table width="100%">
				<td align="right">
					<button class="btn btn-primary btn-block" id="addButton"
						style="width: 110px;" onclick="saveEmployee()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</table>
		</c:if>
	</c:when>
	<c:otherwise>
		<div class="page-header">
        	<table width="100%">
          		<tr>
            		<td width="30%"><h3>Editar</h3></td>
            		<td width="70%" align="right">
              			<button class="btn btn-default btn-block" id="showDocumentsButton" onclick="showFolder('employee', ${model.employee.idEmployee})" style="width:130px;">
        					<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>Documentos
        				</button> 
            		</td>
          		</tr>
        	</table>
      	</div>
      	<!-- 
		<div class="page-header">
			<h1>Editar</h1>
		</div>
		 -->
		<c:if test="${model.pType.type eq 'M'}">
			<table width="100%">
				<td align="right">
					<button class="btn btn-primary btn-block" id="addButton"
						style="width: 110px;" onclick="saveEmployee()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</table>
		</c:if>
		
		<div id="messageAlert"></div>
		
		<form id="addEmployeeForm">
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre"
					value="${model.employee.employeeDetail.name}" required autofocus>
			</div>
			<div class="form-group">
				<label for="last_name">Apellidos</label> <input type="text"
					class="form-control" id="lastName" name="lastName"
					placeholder="apellidos" value="${model.employee.employeeDetail.lastName}" required>
			</div>
			<div class="form-group">
				<label for="date_born">Fecha de nacimiento</label>
				<div class="input-group date form_date col-md-5" data-date=""
					data-date-format="dd-mm-yyyy" data-link-field="date_born"
					data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text"
						value="${model.employee.employeeDetail.dateBornWithFormat}"
						readonly required> <span class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<input type="hidden" id="date_born" name="date_born" value="${model.employee.employeeDetail.dateBornWithFormat}" />
			</div>
			<div class="form-group">
				<label for="address">Direcci&oacute;n</label> <input type="text"
					class="form-control" id="address" name="address"
					placeholder="dirección" value="${model.employee.employeeDetail.address}" required>
			</div>
			<div class="form-group">
				<label for="phone">Telefono</label> <input type="text"
					class="form-control" id="phone" name="phone" placeholder="telefono" value="${model.employee.employeeDetail.phone}" required>
			</div>
			<div class="form-group">
				<label for="mail">Correo electr&oacute;nico</label> <input type="email"
					class="form-control" id="mail" name="mail" placeholder="e-mail" value="${model.employee.employeeDetail.phone}" required>
			</div>
		</form>
		<form id="empRoleForm">
			<div class="form-group">
				<label for="position">Puesto</label>
				<select class="form-control" id="idRole" name="idRole" required>
					<option value="0">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.roles}" var="item" varStatus="loop">
						<option value="${item.id}" ${(model.employee.role.name eq item.name) ? 'selected' : ''}><c:out value="${item.name}"/></option>
					</c:forEach>
				</select>
			</div>
		</form>
		<c:if test="${model.pType.type eq 'M'}">
			<table width="100%">
				<td align="right">
					<button class="btn btn-primary btn-block" id="addButton"
						style="width: 110px;" onclick="saveEmployee()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</table>
		</c:if>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	$('.form_date').datetimepicker({
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });
</script>