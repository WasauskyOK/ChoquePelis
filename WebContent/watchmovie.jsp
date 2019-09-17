<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidades.Pelicula,Models.models_usuario"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>


<%
    		if(session.getAttribute("SessionLive")==null){
    			response.sendRedirect("Login.jsp");
    			return;
    		}
    	%>
<%
	Pelicula pel=(Pelicula)request.getAttribute("ObjetoPelicula");
%>
<title>Ver: <%=pel.getNompelicula()%> </title>
<meta name="viewport" content="initial-scale=1, width=device-width,user-scalable=no">
<script src="js/jquery-1.10.2.min.js"></script>
 <link rel="stylesheet" href="css/PeliculaSeleccionada.css">
 <link rel="stylesheet" href="css/estiloMenuCategoria.css"> 
  	<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Baloo+Da|Gloria+Hallelujah|Josefin+Sans|Quicksand&display=swap" rel="stylesheet">	       
        
       <link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"> 
        <link rel="stylesheet" href="css/bloque3PeliculaElegida.css">
          <link rel="stylesheet" href=css/estilologinalternativo.css>
          
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
         </script>
</head>
<body>
	
		<input type="hidden" value="<%=pel.getNombCategoria()%>" id="categorias" name="categorias_nombre">
	  <script type="text/javascript">
        $(function(){
        	var categoria=$("#categorias").val();
        $("#pelicularelacionada").html("<h1>ESPERE UN MOMENTO , MIENTRAS NOSOTROS PROCESAMOS LA  INFORMACION  . . .</h1>");
        $.ajax({
        	type:'POST',	
        	data:{nombrecategoria:categoria,vacio_movie:"CargarBloque3Relacion"},
        	url:'SelectMovie',
        	success:function(result){
        		$("#pelicularelacionada").html(result);
        	}
        	});
        });
        
        
        </script>
         <div class="cuadropopup2">
           		 <i class="fas fa-window-close" id="opcionClosefooter2"></i>
           		 
					<p class="cargarbloquepopup">
					
               	
           	
           	</p>
           </div>
    <div class="bloque1">
        
        <div class="menu">
        	 
			<div class="logo">
				<a href="Index.jsp">PELIS<span>FAST</span></a>
			</div>
         <ul class="menuCategoria">
            <li><a href="#">Categorias</a>
                <ul class="submenuCategoria"  id="submenuCategory">
                   
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
    
        
    			<div class="fullbotonesopciones">
    					  <div class="fullbotonesopcionescaja1">
    					  
    					  			<div class="bloqueimageutilitarios1" id="AjaxBotonCambios">
        			<!-- BLOQUE PARA PONER LOS BOTONOS AGREGAR O QUITAR CARGAR -->
        			<%
        			HttpSession sesion=request.getSession();
        		
        			String user=(String)sesion.getAttribute("SessionLive");
        			String estadoPeliculaActual=new models_usuario().ValidacionEstadoPelicula(user, pel.getNompelicula());
        		
        			
        				if(estadoPeliculaActual.equals("Agregado")){
        					%>
        					<button id="EnviarInformacion" class="boton_quitar" onclick="QuitarPelboton(codpelicula=<%="'"+pel.getCodpelicula()+"'"%>)">Click para Quitar<i class="fas fa-minus-circle"></i></button>	
        				<% 
        				}
        				else{
        			
        			%>
        				
        			<button id="EnviarInformacion"  class="boton_agregar" onclick="AgregarPelboton(codpelicula=<%="'"+pel.getCodpelicula()+"'"%>)">Click para Añadir<i class="fas fa-plus-square"></i></button>
        			<%
        				}
        				
        			%>
        			</div>
    					  </div>
    		
    					  <div class="fullbotonesopcionescaja2">
    					  		<a href="imagenes/<%=pel.getNombimagen() %>.jpg" download="<%=pel.getNombimagen()%>" class="optionAlternative"></i><span class="spanOption">Descargar img</span><div class="t2"><i class="fas fa-cloud-download-alt iconoption"></i></div></a>
        		
    					  </div>
    					  <div class="fullbotonesopcionescaja3">
    					  			<button onclick="MoverTrailer()" class="optionAlternative"><span class="spanOption">Ver Trailer</span><div class="t2"><i class="fab fa-youtube"></i></div></button>
			  
    					  </div>
    					  <div class="fullbotonesopcionescaja4">
    					  	   <button onclick="MoverPelicula()" class="optionAlternative"><span class="spanOption">Ver Pelicula</span><div class="t2"><i class="fas fa-video iconoption"></i></div></button>
        		
    					  </div>
    					
    			</div>
         <div class="CuadroSearchResul" id="cuadroresultado">
            
            <div class="OpcionesSearch" id="OpcionesSearchContent">
            
            </div>
            
       
        
        </div>
       
        <div class="bloqueimage">
        	<div class="bloqueimageImagen">
     
        			<img src="imagenes/<%=pel.getNombimagen() %>.jpg"  class="bloqueimageImagenImage" >
        	</div>
    		<!-- BLOQUE UTILITARIOS BOTONES -->
        </div>
        
        <div class="contenido">
        	<div class="contenido_content">
        		<div class="contenido_content_bloque1">
        		<h2 class="title"><%=pel.getNompelicula() %></h2><h4 class="puntuacion"><%=pel.getValoracion() %></h4><i class="fas fa-star iconpuntuacion"></i><br>
        		</div>
        			
        			<p class="textoAlter">Título original: <span class="titulo"><%=pel.getNompelicula() %>- </span>  Puntuacion :<span class="puntuacion"><%=pel.getValoracion() %></span> de 10 - Calidad disponible: Alta - Categoria :<span class="categoria"><%=pel.getNombCategoria() %></span></p>
        			<p class="texto"><%=pel.getDescripcion() %></p>
        			
        			
        	</div>
        	<%
        	String embedLinkServer=pel.getLinkServer();
        	%>
        	<div class="contenido_video" id="contenido_VIDEO">
        	<div class="cuadro_contenido_video" id="cuadro_contenido_videos">
        <div class="caja1_cuadro">	
        <iframe  class='videoStreaming' width='100%' height='100%' src="https://www.youtube.com/embed/<%=pel.getLinkpel()%>" frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>
   	</div>
   	<div class="caja2_cuadro">
    	<iframe  class='videoStreaming' width='100%' height='100%' src="https://oload.stream/embed/<%=embedLinkServer%>" frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>
        </div>	
        	</div>			
        	</div>
        </div>
         </div>
         <div class="bloque2">
         xdddddddddddd
        <div class="destacadas"></div>
        <div class="comentarios"></div>
        </div>
     
               <div class="bloque3" id="pelicularelacionada">
                	
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
                   	
                		//$(".contenedorCajas").addClass("contenedorCajasGoRecovery");
                   	
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
 <script type="text/javascript" src="js/searchConsulta.js"></script>
<script type"text/javascript">

function  AgregarPelboton(codpelicula){
	$.ajax({
			type:'POST',
			
			data:{vacio_movie:"AgregarxBOTONAZUL",codigo:codpelicula},
			url:'SelectMovie',
			success:function(result){
			$("#AjaxBotonCambios").html(result);
			
		}
		});
};
function QuitarPelboton(codpelicula){
	
	$.ajax({
		type:'POST',
		data:{vacio_movie:"QuitarxBOTONROJO",codigo:codpelicula},
		url:'SelectMovie',
		success:function(result){
		$("#AjaxBotonCambios").html(result);
		
	}
	});
};
</script>
 <script type="text/javascript">
 
 

	function QuitarPeliculaActual(codpel,nomcat){
			
  		$.ajax({
  			type:'POST',
  			
  			data:{vacio_movie:"QuitPel",codigopel:codpel,nomcategor:nomcat},
  			url:'SelectMovie',
  			success:function(result){
				$("#pelicularelacionada").html(result);
				
			}
  		});
  			
  		};
  		function AgregarPeliculaActual(codpel,nomcat){
			
      		$.ajax({
      			type:'POST',
      			data:{vacio_movie:"AddPel",codigopel:codpel,nomcategor:nomcat},
      			url:'SelectMovie',
      			success:function(result){
      				$("#pelicularelacionada").html(result);
      			}
      		});
  		};
 		
 </script>
 
 <script type="text/javascript">
 	function MoverTrailer(){
 		  document.getElementById('cuadro_contenido_videos').style.transition="all 1s";
          document.getElementById('cuadro_contenido_videos').style.marginLeft="0%";
 	};
	function MoverPelicula(){
		  document.getElementById('cuadro_contenido_videos').style.transition="all 1s";
          document.getElementById('cuadro_contenido_videos').style.marginLeft="-100%";
 	};
 	
 </script>
</body>
</html>