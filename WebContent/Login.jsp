<%@page import="Models.models_Pregunta_Seguridad,java.util.*,Entidades.PreguntaSeguridad"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
   <script src="js/jquery-1.10.2.min.js"></script>
<script src="js/alertify.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">
<link rel="stylesheet" href=css/alertify.core.css>
<link rel="stylesheet" href=css/alertify.default.css>


<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">  
<meta name="viewport" content="initial-scale=1, width=device-width,user-scalable=no">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"> 
   <!--
    <meta name="viewport" content="width=500, initial-scale=1">
    --> 
       
       <link href="https://fonts.googleapis.com/css?family=Pacifico&display=swap" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Baloo+Da|Gloria+Hallelujah|Josefin+Sans|Quicksand&display=swap" rel="stylesheet">	       
        
       <link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">
       
       
       <link rel="stylesheet" href=css/estilologin.css>

       

<title>Insert title here</title>


	    
	
</head>
<body>
			
				
            <div class="contenedorGlobal">
                <div class="contenedorCentral">
                    <div class="contenedorLogCentral">
          <div class="contenedorCajas" id="contenedorcajasid">
                            <div class="contenedorLog">
                               <div class="contenedorLog2">
                                <div class="LogTitle">
                <a href="#">Choque<span>Pelis</span></a>
                                </div>
                 
       		<form action="CnInit?vacioIn=GoSession" class="formularioSession" method="POST" id="form_log"  autocomplete="off">
       		
       <div class="LogUser">
    <input type="text" placeholder="Usuario" id="user" name="user">
                               
                                </div>
                                <div class="LogPassword">
     <input type="password" placeholder="Contraseña" id="passw" name="passw">
        <div class="mostrarUquitarpass">
         <span class="mostrarpass" onclick="mostrarpassword()">Mostrar</span>
     </div>
                                </div>
                                <div class="logButtonSession">
            <input type="submit" value="Iniciar Sesion">                        
                                </div>
                           </form>     
                                
                                               
                                <div class="logRecuperar">
<a href="#" title="Recupera tu cuenta" id="recuperar">¿Olvidaste tu contraseña?</a>
                                </div>
                               
                           </div> 
                           <div class="contenedorLog3">
                                  <div class="logRegistrate">
¿No tienes cuenta?<span title="Crea una cuenta , es super sencillo" id="spanRegister">Regístrate</span>                                         </div>
                           </div>
                            </div>
                            <div class="contenedorRegister">
                            
                            
         <!-- REGISTRAR CUENTA  -->                   
                            
     <div class="LogTitle">
    <a href="#">Choque<span>Pelis</span></a>
    </div>                        
    <div class="registerusuario">
        <input type="text" name="regusuario" id="regusuario" placeholder="Usuario o apodo" onkeyup="ValidaCreacionUsuario()">
  		   <div class="validarUserCreate" id="validarUserCreateid">
     

     </div>
    </div>
    <div class="registercontra">
        <input type="password" name="regpassword" id="regpassword" placeholder="Crea una contraseña">
    </div>
    <div class="registernombre">
        <input type="text" name="regnombre" id="regnombre" placeholder="Nombres">
    </div>                   <div class="registerapellido">
        <input type="text" name="regapellido" id="regapellido" placeholder="Apellidos">
    </div>
         
    <div class="registercod" id="registercodidbloque">
       <!-- CARGAR SELECT  -->
      <select name="codSeguridad" id="codSeguridadid">
			<option  disabled="disabled" selected="selected" >Selecciona pregunta de seguridad</option>
       		<option value="pre01">¿Cual es tu plato favorito?</option>
       		<option value="pre02">¿Cual es tu lugar favorito?</option>
       		<option value="pre03">¿Cual es el nombre de tu mascota?</option>
       		<option value="pre04">¿En que lugar haz nacido?</option>
       		<option value="pre05">¿Cual es tu apodo?</option>
    </select>
    </div> 
    <div class="registerrespuesta">
        <input type="text" name="regrespuesta" id="regrespuesta" placeholder="Respuesta de seguridad">
    </div>                 
    <div class="registerfecha">
        <input type="date" name="regfecha" id="regfecha">
    </div>    
      <div class="registerregistrar">
         
          <input type="button" value="Registrarse" class="registraruser" id="RegistrarUnaCuenta" onclick="CrearUnaCuenta()">
      
      </div>
      
     <!-- TERMINA BLOQUE DE CREACION DE CUENTA -->
      
      <p id="msjcuenta"></p>  
    <div class="YatengoCuenta">
        <p>¿Tienes una cuenta? <span class="RetornarInicio">Iniciar Sesión</span></p>
    </div>                                   
                            </div>
                            <div class="contenedorRecovery">
  <div class="LogTitle">
<a href="#">Choque<span>Pelis</span></a>
</div>
<div class="recoveryUsuario">
    <input type="text" name="recovuser" id="recovuser" placeholder="Ingresar tu usuario">
    <input type="button" onclick="EncontrarPreguntaSeguridad()" class="pregs" value="Buscar usuario"></input>
</div>
<div class="recoverypregunta" id="recoverypreguntaid">
    
        
        
    
</div>
<div class="recoveryrespuesta" id="recoveryrespuesta">
        
        
        
      
</div>
<div class="YatengoCuenta">
        <p id="resultadoalterpass"></p>
        <p>¿Tienes una cuenta? <span class="RetornarInicio">Iniciar Sesión</span></p>
    </div>                                                          
                        </div>
                       </div> 
                    </div>
                </div>
                
            
                	
                <div class="contenedorSecundario">
                  <p>"Tu tiempo es limitado, así que no lo desperdicies viviendo la vida de alguien más"</p>
                  
                <p>¿Preguntas? Llama al <a href="#">924741683</a></p>
                <p>
                <span onclick="Informacion(varparameter='GoTerminos')">Terminos de uso</span>
                <span onclick="Informacion(varparameter='GoMapa')">Mapa web</span>
                <span onclick="Informacion(varparameter='GoPrivacidad')">Privacidad</span>
                <span onclick="Informacion(varparameter='GoContacto')">Contacto Soporte</span>
                <span onclick="GoRedesSociales()">Redes Sociales</span>        
                </p>
                </div>
            </div>
            
            
            
             <div class="cuadropopup">
              
               <i class="fas fa-window-close" id="opcionClosefooter"></i>
                
              <p id="contentpopup">
                 </p>
           </div>
          
            
</body>


<script>


function GoRedesSociales(){
	
	window.location.href="https://www.facebook.com/ChoquePelis-918458235160924/";
}
function Informacion(varparameter){
 	
	
	$.ajax({
			type:'POST',
			data:{vacioIn:"pieOpciones",parameter:varparameter},
			url:'CnInit',
			success:function(result){
			$("#contentpopup").html(result);
			
		}
		});	
	
	
	$(".contenedorLog").css("filter","blur(2px)");
    $(".cuadropopup").addClass("moverabajopopup");
    $(".cuadropopup").show(1000);  
}  
	function EncontrarPreguntaSeguridad(){
			var usuario=$("#recovuser").val();
  		$.ajax({
  			type:'POST',
  			data:{vacioIn:"SearchPregSeguridad",userid:usuario},
  			url:'CnInit',
  			success:function(result){
				$("#recoverypreguntaid").html(result);
				
			}
  		});		
		}
	
function ValidarPregunta(){
	var usuario=$("#recovuser").val();
	var respuesta=$("#respuestapregunta").val();
	$.ajax({
			type:'POST',
			data:{vacioIn:"encodpassresseg",resp:respuesta,userid:usuario},
			url:'CnInit',
			success:function(result){
			$("#recoveryrespuesta").html(result);
			
		}
		});	
}
function releasePassword(){
	var usuario=$("#recovuser").val();
	var respuesta=$("#respuestapregunta").val();
	var passw=$("#passwordrepite").val();
	$.ajax({
			type:'POST',
			data:{vacioIn:"updatePassw",pass:passw,resp:respuesta,userid:usuario},
			url:'CnInit',
			success:function(result){
			$("#resultadoalterpass").html(result);
			
		}
		});	
}
	
	
	function CrearUnaCuenta(){
		
		var user=document.getElementById("regusuario").value;
		var pass=document.getElementById("regpassword").value;
		var nom=document.getElementById("regnombre").value;
		var ape=document.getElementById("regapellido").value;
		var preg=document.getElementById("codSeguridadid").value;
		var res=document.getElementById("regrespuesta").value;
		var fec=document.getElementById("regfecha").value;
			
    		$.ajax({
				type:'POST',
				data:{vacioIn:"RegistrarCuenta",use:user,passw:pass,nomb:nom,apelli:ape,pregu:preg,resp:res,fech:fec},
				url:'CnInit',
				success:function(result){
					$("#msjcuenta").html(result);
				
					
				
				}
			});
    		

			document.getElementById("regusuario").value="";
			document.getElementById("regpassword").value="";
			document.getElementById("regnombre").value="";
			document.getElementById("regapellido").value="";
			document.getElementById("codSeguridadid").value="Selecciona pregunta de seguridad";
			document.getElementById("regrespuesta").value="";
			document.getElementById("regfecha").value="";
			
			document.getElementById("validarUserCreateid").innerHTML="";
		
	}

	
	
	
    document.getElementById("recuperar").addEventListener("click",recoverys);
    document.getElementById("spanRegister").addEventListener("click",registers);
        function registers(){
            document.getElementById("contenedorcajasid").style.marginLeft="-100%";
			document.getElementById("contenedorcajasid").style.transition="456ms ease";  

		
		
			

        }
        function recoverys(e){
            e.preventDefault();
document.getElementById("contenedorcajasid").style.marginLeft="-200%";
document.getElementById("contenedorcajasid").style.transition="all 0.9s";            
        }
    $(function(){
      $("#opcionClosefooter").click(function(){
        $(".cuadropopup").hide(1000);  
          $(".contenedorLog").css("filter","blur(0px)");
      });
    });   
   
          
   $(function(){
     $("#passw").keyup(function(){
    
           if($(this).val().length>0){
    $(".mostrarUquitarpass").css("visibility","visible");
              
           }
    if($(this).val().length<1){
 $(".mostrarUquitarpass").css("visibility","hidden");
              
       }     
           
     }); 
   });
    function mostrarpassword(){
        $("#passw").attr("type","text");
        $(".mostrarUquitarpass").html("<span class='taparpass' onclick='taparpassword()'>Ocultar</span>");
    }
     function taparpassword(){
        $("#passw").attr("type","password");
         $(".mostrarUquitarpass").html("<span class='mostrarpass' onclick='mostrarpassword()'>Mostrar</span>");
    }      
    $(function(){
        $(".RetornarInicio").click(function(){
     document.getElementById("contenedorcajasid").style.marginLeft="1%";
document.getElementById("contenedorcajasid").style.transition="all 456ms ease";          
        });
    });
       function TextoNuevaContra(){
    if($("#passwordnuevo").val().length>0){
    $(".verificacionkey").addClass("mostrarchecknuevo");   
        
    }
           else{
               $(".verificacionkey").removeClass("mostrarchecknuevo");
           }
       }; 
function TextoRepiteContra(){
    var nuevo=$("#passwordrepite").val();
    var antiguo=$("#passwordnuevo").val();
    
    if($("#passwordrepite").val().length>0){
        
        if(nuevo!==antiguo){
                  $(".verificacioncancel").html("<i class='fas fa-times cancela'></i>")
        $(".verificacioncancel").addClass("mostrarequisrepite");
        $(".guardarcambios").css("visibility","hidden");    
               }
        else{
           $(".verificacioncancel").html("<i class='fas fa-check okey'></i>")
       
            $(".verificacioncancel").addClass("mostrarequisrepite");
           $(".guardarcambios").css("visibility","visible");
        
        }
       }
               else{
               $(".verificacioncancel").removeClass("mostrarequisrepite");
               }
}
/*
     <i class="fas fa-check okey"></i>   
       <i class="fas fa-times cancela"></i>
*/
/*
 verificacioncancel
            .mostrarequisrepite
*/
        
    //mostrarchecknuevo
//passwordnuevo       
        /*taparpass*/
    
        /*<span class="taparpass" onclick="mostrarpassword()">Ocultar</span>*/
    </script>
    

    
    <script>
		
		<%
				
			String cadena=(String)request.getAttribute("msjerror");
			if(cadena!=null){
				
			
			
		%>
		window.onload=function(){
			
			alertify.alert(<%="'"+cadena+"'"%>);
			
		}
		
		
		<%
			}
		%>
		
		
		
		function ValidaCreacionUsuario(){
			
			var contenido=document.getElementById("regusuario").value;
			
			if(contenido.length==0){
				validarUserCreateid.innerHTML="";
				}
			
			  if(contenido.length>0){
			var xhr=new XMLHttpRequest();
		    
		    xhr.onreadystatechange=function(){
		    	
		        if(xhr.status==200 && xhr.readyState==4){
		        	if(this.responseText.length>0){
		        	validarUserCreateid.innerHTML=this.responseText;	
		        	}
		        	//veropciones.innerHTML+=this.statusText;
					if(this.responseText=="<span class=\"RepeatUserCreate\" id=\"valorspanval\">Usuario,ya existe</span>"){
						document.getElementById("RegistrarUnaCuenta").removeAttribute("enabled","enabled");
						document.getElementById("RegistrarUnaCuenta").setAttribute("disabled","disabled");		
						
					}
					if(this.responseText=="<span class=\"OkeyUserCreate\" id=\"valorspanval\">Usuario Correcto</span>"){
						document.getElementById("RegistrarUnaCuenta").removeAttribute("disabled","disabled");
						document.getElementById("RegistrarUnaCuenta").setAttribute("enabled","enabled");		
					}
		        }
		        
		         
		}
		   
		    
		xhr.open('POST','CnInit',true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.send("vacioIn=valUserNew&parameter="+contenido);
		
		
			
			  }
			}
		
		</script>


</html>