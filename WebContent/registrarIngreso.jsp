<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="s"%>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css" type="text/css"/>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css" type="text/css"/>

<title>Ingreso</title>
<style>
	.modal-header, h4, .close {
		background-color: #286090;
		color: white !important;
		text-align: center;
		font-size: 20px;
	}
	.help-block{
	 background-color: red;
	 display: none;
	}
	.dataTables_length{
	 display: none;
	}
	.dataTables_filter{
		text-align: right;
	}
	.dataTables_info{
	 display: none;
	}
	.dataTables_paginate{
		cursor: pointer;
	}
	.ocultar{
		display:none;
	}
	
</style> 
</head>
<body>


<s:if test="${sessionScope.MENSAJE !=null}">
<div class="alert alert-warning alert-dismissible fade show" role="alert" id="success-alert">
  <strong>Sistema:</strong> ${sessionScope.MENSAJE}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</s:if>
<s:remove var="MENSAJE"/>



	<div class="container">
		<h3 align="center">	Registrar de Ingreso</h3>

	
	
<!-- INICIO DIV NUEVO -->
<div>
  <div>
				<!-- Modal content-->
				<div>
				<div class="modal-header" style="padding: 5px 20px">
					Registro de Orden de Ingreso<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          				
       				   </button>
				</div>
				<div class="modal-body" style="padding: 20px 20px;">
					<form id="idRegistra" accept-charset="UTF-8" action="saveIngreso" 
													class="form-horizontal" method="post" data-toggle="validator" role="form">						
		                   
		                                	<!-- Modal conten
		                                		
		                                		<div class="form-group">
			                                   	<label for="staticEmail">Estado</label>
												<input class="form-control" id="idEstado" name="ingreso.estado" placeholder="Ingrese el asunto"/>
			                                </div>
		                                	t-->
		                                	
		                                	<div class="form-group">
		                                        <label for="staticEmail">Estado</label>
													<select id="idEstado" name="ingreso.estado" class='form-control'>
							                                 <option value=" " >[SELECCIONE]</option>
							                                 <option value="habilitado" >habilitado</option>
							                                 <option value="inhabilitado" >inhabilitado</option>
							                         </select>
		                                    </div>
		                                
		                                	
		                                     <div class="form-group">
		                                        <label for="staticEmail">Colegio</label>
													<select id="idColegio" name="ingreso.codigocolegio" class='form-control'>
							                                 <option value=" " >[SELECCIONE]</option>
							                         </select>
		                                    </div>
		                                	 
		                                	<div class="form-group">
			                                   	<label for="staticEmail">Asunto</label>
												<input class="form-control" id="idAsunto" name="ingreso.asunto" placeholder="Ingrese el asunto"/>
			                                </div>
			                                <div class="form-row">
			                                    <div class="form-group col-md-6">
			                                        <label for="staticEmail">Fecha</label>
														<input class="form-control" id="idFecha" name="ingreso.fecha" placeholder="Ingrese fecha"/>
			                                    </div>
			                                 </div>     
		                                  
		                                  
		                                   
                             	                                    
                        				<div class="modal-footer">
									        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
									        <button type="submit" class="btn btn-primary">Guardar</button>
									    </div>

		            </form>      
				</div>
			</div>
		</div>
  </div>
  <!-- FIN DIV NUEVO -->
  
 
  <!-- FIN DIV EDITAR -->

  
  
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
	cargar();
});
</script>
<script>	
function cargar(){

	$.getJSON("listAllColegioscombo",{},function(data){
		//bucle
		$.each(data.listaColegios,function(index,item){
			$("#idColegio").append("<option value='"+item.cod+"'>"+item.nombre+"</option>");
		})
	})
	
}


</script>


<script type="text/javascript">    
    $(document).ready(function(){     
        $('#idRegistra').bootstrapValidator({      
        	 fields:{
        		 
        		 Nombre: {
     	    		selector:'#idNombre',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese nombre'    
                        },      
                        regexp: {    
                            regexp: /^[a-zA-Z\s]+$/,    
                            message: 'The username can only consist of alphabetical, number, dot and underscore'    
                        },    
                    }    
                },   
                Descripcion: {
     	    		selector:'#idDescripcion',       
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Descripción'    
                        }   
                    }    
                },    
                Stock: {
                	selector:'#idStock',      
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Stock'    
                        },       
                    }    
                },    
                Precio: {
     	    		selector:'#idPrecio',     
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Precio'    
                        },       
                    }    
                }, 
                Fecha: {
     	    		selector:'#idFecha',   
                    validators: {    
                        notEmpty: {    
                            message: 'Ingrese Fecha'    
                        },					
                    }    
                },   				
                Laboratorio: {
     	    		selector:'#idLaboratorio',   
                    validators: {    
                        notEmpty: {    
                            message: 'Seleccione Laboratorio'    
                        },					
                    }    
                } 
        	 }
        });   
			
    });   
</script>   


</body>
</html>












