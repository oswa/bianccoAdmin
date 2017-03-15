<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty model.employee}">
		<div class="page-header">
			<h1>Nuevo</h1>
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
		<form id="addEmployeeForm">
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre" required autofocus>
			</div>
			<div class="form-group">
				<label for="last_name">Apellidos</label> <input type="text"
					class="form-control" id="last_name" name="last_name"
					placeholder="apellidos" required>
			</div>
			<div class="form-group">
				<label for="date_born">Fecha de nacimiento</label>
				<div class="input-group date form_date col-md-5" data-date=""
					data-date-format="dd MM yyyy" data-link-field="date_born"
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
			<div class="form-group">
				<label for="position">Puesto</label>
				<select class="form-control" id="position" required>
					<option value="0" selected="selected">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.roles}" var="item" varStatus="loop">
						<option value="${item.idRole}"><c:out value="${item.name}"/></option>
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
	<c:otherwise></c:otherwise>
</c:choose>