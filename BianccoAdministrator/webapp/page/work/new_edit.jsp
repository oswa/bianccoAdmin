<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${empty model.work}">
		<div class="page-header">
        	<table width="100%">
          		<tr>
            		<td width="30%"><h3>Nueva Obra</h3></td>
            		<td width="70%" align="right">
            			<c:if test="${model.pType.type eq 'M'}">
							<button class="btn btn-primary" id="saveButton" onclick="saveWork()">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
								Guardar
							</button>
						</c:if>
            		</td>
            	</tr>
            </table>
		</div>
		<div id="messageAlert"></div>
		
		<form id="workForm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre" required autofocus>
			</div>
			<div class="form-group">
				<label for="workDate">Fecha de obra</label>
				<div class="input-group date form_date col-md-5" data-date=""
					data-date-format="yyyy-mm-dd" data-link-field="workDate"
					data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text" value="" readonly required>
					<span class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<input type="hidden" id="workDate" name="workDate" value="" />
			</div>
			<div class="form-group">
				<label for="contractNum">Número de contrato</label> <input type="text"
					class="form-control" id="contractNum" name="contractNum" placeholder="Número de contrato" required autofocus>
			</div>
			<div class="form-group">
				<label for="location">Ubicación</label> <input type="text"
					class="form-control" id="location" name="location" placeholder="Ubicación" autofocus>
			</div>
			<!--
			<div class="form-group">
				<label for="locationMap">Mapa</label> <input type="text"
					class="form-control" id="locationMap" name="locationMap" placeholder="Mapa de ubicación" autofocus>
			</div>
			-->
			<div class="form-group">
				<label for="residente">Residente</label>
				<select class="form-control" id="residente" name="residente">
					<option value="0" selected="selected">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.residentes}" var="item" varStatus="loop">
						<option value="${item.id}">${item.name}&nbsp;${item.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="superintendente">Superintendente</label>
				<select class="form-control" id="superintendente" name="superintendente">
					<option value="0" selected="selected">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.supers}" var="item" varStatus="loop">
						<option value="${item.id}">${item.name}&nbsp;${item.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="supervisor">Supervisor</label>
				<input type="text" class="form-control" id="supervisor" name="supervisor" placeholder="Nombre del supervisor">
			</div>
		</form>
		<table width="100%">
			<td align="left">
				<button class="btn btn-default" id="backButton" onclick="backTo(1)">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					Regresar
				</button>
			</td>
			<c:if test="${model.pType.type eq 'M'}">
				<td align="right">
					<button class="btn btn-primary" id="saveButton" onclick="saveWork()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</c:if>
		</table>
	</c:when>
	<c:otherwise>
		<div class="page-header">
        	<table width="100%">
          		<tr>
            		<td width="30%"><h3>Editar Obra <c:out value="${model.work.name}"/></h3></td>
            		<td width="70%" align="right">
              			<button class="btn btn-default" id="showDocumentsButton" onclick="showFolder('work_project', ${model.work.idWork})">
        					<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
        					Proyecto
        				</button>
              			<button class="btn btn-default" id="showDocumentsButton" onclick="showFolder('work_admin', ${model.work.idWork})">
        					<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
        					Administración
        				</button>
              			<button class="btn btn-default" id="showDocumentsButton" onclick="showFolder('work_budget', ${model.work.idWork})">
        					<span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span>
        					Estimaciones
        				</button>
            			<c:if test="${model.pType.type eq 'M'}">
							<button class="btn btn-primary" id="saveButton" onclick="updateWork()">
								<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
								Guardar
							</button>
						</c:if>
            		</td>
            	</tr>
            </table>
		</div>
		<div id="_workMessage"></div>

<!-- =============================================================================== -->

<ul class="nav nav-tabs">
  <li class="active"><a data-toggle="tab" href="#_data">Datos</a></li>
  <li><a data-toggle="tab" href="#_budget">Presupuesto</a></li>
</ul>


<div class="tab-content">

<!-- =============================================================================== -->

  <div id="_data" class="tab-pane fade in active">
  		<br>
		<form id="workForm" enctype="multipart/form-data">
			<div class="form-group">
				<label for="name">Nombre</label> <input type="text"
					class="form-control" id="name" name="name" placeholder="nombre"
					value="${model.work.name}" required autofocus>
			</div>
			<div class="form-group">
				<label for="date_born">Fecha de obra</label>
				<div class="input-group date form_date col-md-5" data-date=""
					data-date-format="yyyy-mm-dd" data-link-field="workDate"
					data-link-format="yyyy-mm-dd">
					<input class="form-control" size="16" type="text"
						value="${model.work.workDateWithFormat}"
						readonly required> <span class="input-group-addon"><span
						class="glyphicon glyphicon-remove"></span></span> <span
						class="input-group-addon"><span
						class="glyphicon glyphicon-calendar"></span></span>
				</div>
				<input type="hidden" id="workDate" name="workDate" value="${model.work.workDateWithFormat}" />
			</div>
			<div class="form-group">
				<label for="contractNum">Número de contrato</label> <input type="text"
					class="form-control" id="contractNum" name="contractNum" placeholder="Número de contrato" 
					value="${model.work.contractNum}" required autofocus>
			</div>
			<div class="form-group">
				<label for="location">Ubicación</label> <input type="text"
					class="form-control" id="location" name="location" placeholder="Ubicación" 
					value="${model.work.location}" required autofocus>
			</div>
			<!--
			<div class="form-group">
				<label for="locationMap">Mapa</label> <input type="text"
					class="form-control" id="locationMap" name="locationMap" placeholder="Mapa de ubicación" 
					value="${model.work.locationMap}" required autofocus>
			</div>
			-->
			<div class="form-group">
				<label for="residente">Residente</label>
				<select class="form-control" id="residente" name="residente">
					<option value="0" selected="selected">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.residentes}" var="item" varStatus="loop">
						<option value="${item.id}" ${(model.work.residente eq item.id) ? 'selected' : ''}>${item.name}&nbsp;${item.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="superintendente">Superintendente</label>
				<select class="form-control" id="superintendente" name="superintendente">
					<option value="0" selected="selected">Seleccione una opci&oacute;n</option>
					<c:forEach items="${model.supers}" var="item" varStatus="loop">
						<option value="${item.id}" ${(model.work.superintendente eq item.id) ? 'selected' : ''}>${item.name}&nbsp;${item.lastName}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="supervisor">Supervisor</label>
				<input type="text" class="form-control" id="supervisor" name="supervisor" placeholder="Nombre del supervisor" 
				value="${model.work.supervisor}">
			</div>
		</form>
  </div>

<!-- =============================================================================== -->

  <div id="_budget" class="tab-pane fade">
  			<br>
			<div class="form-group">
				<label for="power">Presupuesto de obra completo</label> <input type="text"
					class="form-control" id="budget" name="budget" placeholder="Monto del presupuesto de obra completo"
					value="${model.work.workAmount.budget}" required autofocus>
			</div>
			<div class="form-group">
				<label for="power">Presupuesto de obra a costo directo</label> <input type="text"
					class="form-control" id="directCost" name="directCost" placeholder="Monto de presupuesto de obra a costo directo"
					value="${model.work.workAmount.directCost}" required autofocus>
			</div>
			<div class="form-group">
				<label for="power">Presupuesto de mano de obra</label> <input type="text"
					class="form-control" id="workforce" name="workforce" placeholder="Monto de presupuesto de mano de obra"
					value="${model.work.workAmount.workforce}" required autofocus>
			</div>
			<div class="form-group">
				<label for="power">Presupuesto de materiales</label> <input type="text"
					class="form-control" id="material" name="material" placeholder="Monto de presupuesto de materiales"
					value="${model.work.workAmount.material}" required autofocus>
			</div>
			<div class="form-group">
				<label for="power">Presupuesto de equipo y herramienta</label> <input type="text"
					class="form-control" id="equipmentTools" name="equipmentTools" placeholder="Monto de presupuesto de equipo y herramienta"
					value="${model.work.workAmount.equipmentTools}" required autofocus>
			</div>
  </div>

<!-- =============================================================================== -->

</div>

		<table width="100%">
			<td align="left">
				<button class="btn btn-default" id="backButton" onclick="backTo(1)">
					<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					Regresar
				</button>
			</td>
			<c:if test="${model.pType.type eq 'M'}">
				<td align="right">
				
					<button class="btn btn-primary" id="saveButton" onclick="updateWork()">
						<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
						Guardar
					</button>
				</td>
			</c:if>
		</table>
	</c:otherwise>
</c:choose>
<input type="hidden" id="idCompany" name="idCompany" value="${model.company.idCompany}">
<input type="hidden" id="idWork" name="idWork" value="${model.work.idWork}">
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