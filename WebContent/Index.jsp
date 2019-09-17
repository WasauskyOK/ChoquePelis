<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%
    		if(session.getAttribute("SessionLive")==null){
    			response.sendRedirect("Login.jsp");
    			return;
    		}
    	%>
      <meta charset="ISO-8859-1">
        <title>WardTrailer</title>
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">  
<meta name="viewport" content="initial-scale=1, width=device-width,user-scalable=no">
           <script src="js/jquery-1.10.2.min.js"></script>
        
        <!-- <link rel='stylesheet' id='line-awesome-css'  href='//maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome-font-awesome.min.css?ver=1.0.4' type='text/css' media='all' /> -->
		<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Baloo+Da|Gloria+Hallelujah|Josefin+Sans|Quicksand&display=swap" rel="stylesheet">	       
        
       <link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"> 
        <link rel="stylesheet" href="css/estiloUsuarioMenu.css">
        <link rel="stylesheet" href="css/Loading.css">
       

        
        <link rel="stylesheet" href="css/indexestilo.css">
      	 
      	 
       <link rel="stylesheet" href="css/estiloMenuCategoria.css">
          <link rel="stylesheet" href="css/PeliculaSeleccionada2.css">
          <link rel="stylesheet" href="css/estilobanner.css">
        <!-- <script defer src="js/fontawesome.js"></script> <!--load all styles -->
      
       	  <link rel="stylesheet" href=css/estilologin.css>
    	<script>
    $(function(){
    	 $.ajax({
    			type:'POST',
    			url:'ListadoPeliculas',
    			data:{vacioIndex:'TraerFiltroCatAño'},
    			success:function(result){
    				$("#submenuCategory").html(result);
    			}
    	 });
    });
	$(function(){
			$('#ListaPeliculas').html('PROCESANDO INFORMACION');	
    		$.ajax({
				type:'POST',
				data:{vacioIndex:"TraerPeliculas"},
				url:'ListadoPeliculas',
				success:function(result){
					$("#ListaPeliculas").html(result);
					
				}
			});
    		
		});
    	</script> 
    </head>
    <body>
    	<div id="contenedorLoading">
           
         <div id="cargaLoading"></div>
        </div>
        <div class="contenedor">
         	         <div class="menu caja">
       
     		<div class="logo">
				<a href="Index.jsp">CHOQUE<span>PELIS</span></a>
			</div>
      			
        		 <ul class="menuCategoria">
            <li><a href="#">Categoria</a>
                <ul class="submenuCategoria" id="submenuCategory">
              				
                    
                </ul>
                
            </li>
        </ul>	
        	
       
        <div class="buscador">
        
            <input type="text" onkeyup="SearchConcidencias()" placeholder="Que deseas buscar?" id="busqueda">
                         <i class="fas fa-search iconoSearch"></i>
            
        </div>
        <div class="estrenosactual"></div>
        	<div class="usuario">
           			 <ul class="UsuarioMenu">
            <li><div class="flex-user"><div class="cuadroiconastronauta"><i class="fas fa-user-astronaut iconoUsuario"></i></div>
             <p class="UserActual">
             
				<% 
				
				HttpSession ses=request.getSession();
				String usuario=(String)ses.getAttribute("SessionLive");
				
				%>
             <%=usuario%>
             </p>
             
              <i class="fas fa-sort-down iconousuarioabajo"></i>
                </div>
                <ul class="UsuarioSubMenu">
                    <div class="MensajeGestion">
                       <div class="imagenMensajeGestion">
                           <img src="gif/gifcomodinuser.gif" alt="">
                       </div>
                       <div class="letterMensaje">
                           Gestionar tu cuenta de WardTrailer a tu preferencia . . . 
                        </div>
                    </div>
                    <li><i class="fas fa-sign-out-alt iconosLis"></i>
                    	<form action="option_all_user" method="POST">
            		<input type="hidden" name="vacioUsuario" value="CloseSesion">
            		<input type="submit" value="Cerrar Sesion"> 	
            		</form>
                    
                    </li>
                    
                    <li class="cambiopass"><i class="fas fa-key iconosLis"></i>Cambiar Contraseña</li>
                    <li><i class="fas fa-street-view iconosLis"></i>Ubicacion Actual</li>
                    <li class="AdministrarCuenta"><i class="fas fa-user-cog iconosLis"></i>Administrar Cuenta</li>
                    <li class="CloseVentana"><i class="far fa-window-close iconosLis"></i>Mi canal</li>
              
                </ul>
            </li>
           
        </ul>  
            	
        </div>
         </div>
        <div class="CuadroSearchResul" id="cuadroresultado">
            
            <div class="OpcionesSearch" id="OpcionesSearchContent">
            
            </div>
            
       
        
        </div>
       
           

                  <div class="cuerpobaner caja">
           
           <div class="contenedorBaner">
            <div class="cajaBaner">
                 <img src="imgbanner/banerjhonwick.jpg" alt="" class="imagenBaner"> 
                <div class="ContenedorContenidoBaner">
                    <div class="subimagenBaner">
                      <div class="subimagenBanerCaja">
                          <img src="imagenes/John_Wick_3.jpg" alt="" class="subimagenBanerCajaImage">
                      </div>
                    </div>
                    <div class="ContenedorDescripcion">
                        <div class="contenidoDescrip">
                            <p>JhonWick</p>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ex temporibus quasi ipsa, quis explicabo suscipit quae ducimus nostrum corporis ea facilis iusto impedit reprehenderit modi dicta nobis voluptates, natus! Cum?</p>
                            <div class="botonesBaner">
    <a href="SelectMovie?moviename=John%20wick%203:Parabellum&vacio_movie=search"><i class="far fa-play-circle"></i>Ver película</a>
     <a href="#"><i class="fab fa-youtube"></i>Trailer</a>
                            </div>
                        </div>
                    </div>
                </div>
                    
            
             </div>
              <div class="cajaBaner">
                   <img src="imgbanner/banerjhonwick.jpg" alt="" class="imagenBaner">
            </div>
            
             <div class="cajaBaner">
                <img src="imgbanner/jhonwick2.jpg" alt="" class="imagenBaner">   
            </div>
            
             <div class="cajaBaner">
                   <img src="imgbanner/banerjhonwick.jpg" alt="" class="imagenBaner">
            </div>
           </div> 
        </div>
          
            <div class="cuerpo caja" id="ListaPeliculas">
          				     
            		
                	
            </div>
            <div class="pie caja">
            <input type="button" value="boton1" onclick="GoInformacion()">
            <p id="GoInformacion">
            	
            </p>
                Pie
                
               <input type="button" value="ACTIVAR" id="addBot">
               <input type="button" value="QUITAR" id="quitBot">
               
            </div>
        </div>
         <div class="cuadropopup2">
           		 <i class="fas fa-window-close" id="opcionClosefooter2"></i>
           		 
					<p class="cargarbloquepopup">
					
               	
           	
           	</p>
           </div>
        	<script>
        	
        	function ModificarCuenta (){
        		
        		//var user=document.getElementById("regusuario").value;
        		//var pass=document.getElementById("regpassword").value;
        		var nom=document.getElementById("regnombre").value;
        		var ape=document.getElementById("regapellido").value;
        		var codpreg=document.getElementById("codSeguridadid").value;
        		var res=document.getElementById("regrespuesta").value;
        		var fec=document.getElementById("regfecha").value;
        		$.ajax({
          			type:'POST',
          			
          			data:{vacioIn:"UpdateUserActual",
          				nombre:nom,apellido:ape,codpregunta:codpreg,
          				respuesta:res,fecha:fec},
          			url:'CnInit',
          			success:function(result){
    					$("#msjcuenta").html(result);		
    				}
          		});	
        	}
        	$(function(){
        		$(".CloseVentana").click(function(){
        			window.location.href='Canal.jsp';
        		});
        	});
        	 $(function(){
                 $("#opcionClosefooter2").click(function(){
                   $(".cuadropopup2").hide(1000);  
                     //$(".contenedorLog").css("filter","blur(0px)");
                 	
                 });
               });
        	$(function(){
        		$(".AdministrarCuenta").click(function(){
        			
        			$(".cuadropopup2").removeClass("moverabajopopup2");
        			$(".cuadropopup2").show(1000);  
        			$(".cuadropopup2").addClass("moverabajopopup2");
        			   
        			$.ajax({
              			type:'POST',
              			
              			data:{vacioIndex:"BloqueActualizarUsuario"},
              			url:'ListadoPeliculas',
              			success:function(result){
        					$(".cargarbloquepopup").html(result);		
        				}
              		});	
        		});
        	});
        	
        	$(function(){
        		$(".cambiopass").click(function(){
        			$(".cuadropopup2").removeClass("moverabajopopup2");
        			$(".cuadropopup2").show(1000);			
        		$(".cuadropopup2").addClass("moverabajopopup2");
           	
        		$(".contenedorCajas").addClass("contenedorCajasGoRecovery");
           	
     	      		 /*
        			document.getElementById("contenedorcajasid").style.marginLeft="-200%";
                	document.getElementById("contenedorcajasid").style.transition="all 0.9s"; 
        			*/
                	
           		$.ajax({
          			type:'POST',
          			data:{vacioIndex:"BloqueRecuperarPassword"},
          			url:'ListadoPeliculas',
          			success:function(result){
    					$(".cargarbloquepopup").html(result);		
    				}
          		});	
        			
        			
        		});
        	});
        	
        	
        	
        	
              
        	</script>
          	<script type="text/javascript">
          		
          		function QuitarPelicula(codpel){
          			
          		$.ajax({
          			type:'POST',
          			
          			data:{vacioIndex:"QuitPel",codigopel:codpel},
          			url:'ListadoPeliculas',
          			success:function(result){
    					$("#ListaPeliculas").html(result);
    					
    				}
          		});
          			
          		}
          		function AgregarPel(codpel){
        			
              		$.ajax({
              			type:'POST',
              			
              			data:{vacioIndex:"AddPel",codigopel:codpel},
              			url:'ListadoPeliculas',
              			success:function(result){
        					$("#ListaPeliculas").html(result);
        					
        				}
              		});
          		}
          		
          		/*
          		function CerrarVentanaQuit(){
          			ventanaquitar.close();
          		}
          		
          		function AgregarPel(codpel){
          			
          			ventanaagregar=window.open("AgregarYQuitarPelicula?vacioAddQuit=AddPel&codpelicula="+codpel);
          			setTimeout(CerrarVentanaAdd,2000);
          		}
          			*/
          		
          		/*
          		function CerrarVentanaAdd(){
          			ventanaagregar.close();
          		}
				*/

       	</script>
       	
      <script type="text/javascript" src="js/searchConsulta.js"></script>
   
    </body>
 
   
         <script type="text/javascript">
 		window.onload=function(){
        
        var cont=document.getElementById("contenedorLoading");
        
        cont.style.opacity='0';
        /*
        cont.style.transform="translateX(100%)";
        cont.style.transition='all 6s';
        */
        cont.style.transition='all 456ms';
        cont.style.display="none";
        
    }
 		
 		  $(function(){
 	           $(".UsuarioMenu li").mouseover(function(){
 	             $(".buscador").css({"z-index":"-1"});  
 	           });
 	        });
 		  $(function(){
	           $(".UsuarioMenu li").mouseout(function(){
	             $(".buscador").css({"z-index":"500"});  
	           });
	        });  
		  $(function(){
	           $(".menuCategoria>li").mouseover(function(){
	             $(".buscador").css({"z-index":"-1"});  
	           });
	        });  
		  $(function(){
	           $(".menuCategoria>li").mouseout(function(){
	             $(".buscador").css({"z-index":"500"});  
	           });
	        }); 
 	
    </script>
</html>
