<div class="page-header">
	<h1>Nuevo</h1>
</div>
<table width="100%">
	<td align="right">
		<button class="btn btn-primary btn-block" id="addButton"
			style="width: 110px;">
			<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
			Guardar
		</button>
	</td>
</table>
<form>
	<div class="form-group">
		<label for="name">Nombre</label> <input type="text"
			class="form-control" id="name" name="name" placeholder="nombre">
	</div>
	<div class="form-group">
		<label for="last_name">Apellidos</label> <input type="text"
			class="form-control" id="last_name" name="last_name"
			placeholder="apellidos">
	</div>
	<div class="form-group">
		<label for="date_born">Fecha de nacimiento</label>
		<div class="input-group date form_date col-md-5" data-date=""
			data-date-format="dd MM yyyy" data-link-field="date_born"
			data-link-format="yyyy-mm-dd">
			<input class="form-control" size="16" type="text" value="" readonly>
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
			placeholder="dirección">
	</div>
	<div class="form-group">
		<label for="phone">Telefono</label> <input type="text"
			class="form-control" id="phone" name="phone" placeholder="telefono">
	</div>
	<div class="form-group">
		<label for="mail">Correo electr&oacute;nico</label> <input type="email"
			class="form-control" id="mail" name="mail" placeholder="e-mail">
	</div>
	<div class="form-group">
		<label for="position">Puesto</label> <select class="form-control">
			<option selected>choose..</option>
		</select>
	</div>
</form>
<table width="100%">
	<td align="right">
		<button class="btn btn-primary btn-block" id="addButton"
			style="width: 110px;">
			<span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
			Guardar
		</button>
	</td>
</table>