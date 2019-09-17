<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <script src="js/jquery-1.10.2.min.js"></script>
<script src="js/alertify.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">  
<meta name="viewport" content="initial-scale=1, width=device-width,user-scalable=no">


     <link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Baloo+Da|Gloria+Hallelujah|Josefin+Sans|Quicksand&display=swap" rel="stylesheet">	       
        
       <link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">
       
       
   
       <link rel="stylesheet" href=css/estilorecoverycopia.css>
</head>
<body>
			
			<div class="contenedorRecuperar">
			
			<div class="contenedorRecovery">
  <div class="LogTitle">
<a href="#">Choque<span>Pelis</span></a>
</div>
<div class="recoveryUsuario">
    <input type="text" name="recovuser" id="recovuserid" placeholder="Ingresar tu usuario">
    <input type="button" onclick="EncontrarPreguntaSeguridad()" class="pregs" value="Buscar usuario"></input>
</div>
<div class="recoverypregunta" id="recoverypreguntaid">
    
        
        
    
</div>
<div class="recoveryrespuesta" id="recoveryrespuesta">
        
        <label for="">Antigua contraseña : </label><input type="password" class="inputrenew" readonly="readonly" disabled="disabled">
        <label for="">Nueva Contraseña : </label>
           
           <div class="cajapass">
         <input type="password" class="inputrenew nueva" onkeyup="TextoNuevaContra()" id="passwordnuevo">
        <div class="verificacionkey">
        <i class="fas fa-check okey"></i>
        </div>
        </div>
        
        <label for="">Repite Contraseña : </label>
        <div class="cajapass">
          <input type="password" class="inputrenew repiten" onkeyup="TextoRepiteContra()" id="passwordrepite" placeholder="Campo Obligatorio">
           <div class="verificacioncancel">
         
       <i class="fas fa-times cancela"></i>
        </div>    
        </div>
        <div class="botonGC">
         <input type="button" value="Guardar Cambios" class="guardarcambios" title="Importante validar datos">
        </div>
        
      
</div>

<div class="YatengoCuenta">
        <p>¿Tienes una cuenta? <span class="RetornarInicio">Iniciar Sesión</span></p>
    </div>                                                          
                        </div>
                        
                        </div>
</body>
<script>
function EncontrarPreguntaSeguridad(){
	var cajaususario=$("#recovuserid").val();
	
	$.ajax({
		type:'POST',
		data:{vacioIn:"searchPregSeg",consutauser:cajaususario},
		url:'CnInit',
		success:function(result){
		$("#recoverypreguntaid").html(result);
		
	}
	});		
}
</script>
</html>