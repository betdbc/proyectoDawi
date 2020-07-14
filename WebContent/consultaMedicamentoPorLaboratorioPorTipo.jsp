<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" type="text/css"/>

</head>
<body>
		<div class="container">
			<form>
			  <div class="row">
			    <div class="col">
					     <select id="idLaboratorio" class='form-control'>
							<option value=" " >[SELECCIONE]</option>
						</select>
			    </div>
			    <div class="col">
					     <select id="idTipo" class='form-control'>
						     <option value="-1" >[SELECCIONE]</option>
						 </select>
			    </div>
			    <div class="col">
			      <button type="button" class="btn btn-primary">Consultar</button>
			    </div>
			  </div>
			</form>
		
		
					<table id="idTable" class="table table-striped table-bordered" style="width:100%">
												<thead>
														<tr>
															<th>Codigo</th>
															<th>Nombre</th>
															<th>Descripción</th>
															<th>Stock</th>
															<th>Precio</th>
															<th>Fecha</th>
															<th>Laboratorio</th>
															<th>Tipo</th>
														</tr>
												</thead>
												<tbody>
												</tbody>
					</table>	
		
		</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script   src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
		
		<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
		
		
		<script>
		$(document).ready(function() {
			cargarComboLaboratorio();
		});
		</script>
		
		
		<script>
			$(".btn-primary").click(function(){
				var idL,idT;
				idL=$("#idLaboratorio").val();
				idT=$("#idTipo").val();
				//alert(idL+"----"+idT);
				$("#idTable tbody").empty();
				$.getJSON("listAllMedicamentosPorLaboratorioPorTipo",{codigoLab:idL,codigoTip:idT},function(data){
					//bucle
					$.each(data.listaMedicamentos,function(index,item){	
						$("#idTable").append("<tr><td>"+item.idMedicamento+"</td><td>"+item.nombre+"</td><td>"+
														item.descripcion+"</td><td>"+item.stock+"</td><td>"+
														item.precio+"</td><td>"+item.fechaFabricacion+"</td><td>"+
														item.nomLaboratorio+"</td><td>"+item.nomTipo+"</td></tr>");
					})
					//formato para la tabla
					$("#idTable").DataTable();
				})
			})
			
			function cargarComboLaboratorio(){
				$.getJSON("listAllLaboratorios",{},function(data){
					//bucle
					$.each(data.listaLaboratorios,function(index,item){
						$("#idLaboratorio").append("<option value='"+item.idLaboratorio+"'>"+item.nombre+"</option>");
					})
				})
			}
			//asignar el evento change al select "idLaboratorio"
			$("#idLaboratorio").change(function(){
				//obtener el codigo del laboratorio seleccionado
				var cod;
				cod=$(this).val();
				$.getJSON("listAllTipoAtLaboratorio",{codigoLaboratorio:cod},function(data){
					//limpiar idTipo
					$("#idTipo").empty().append("<option value='-1'>[Seleccionar Tipo Medicamento]</option>");
					//bucle
					$.each(data.listaTipoMedicamentos,function(index,item){
						$("#idTipo").append("<option value='"+item.codigo+"'>"+item.nombre+"</option>");
					})
				})
				
			})
		
		</script>
</body>
</html>