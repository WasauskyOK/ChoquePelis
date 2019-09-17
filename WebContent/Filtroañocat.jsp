<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidades.Pelicula" %>
<!DOCTYPE html>
<html>
<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Baloo+Da|Gloria+Hallelujah|Josefin+Sans|Quicksand&display=swap" rel="stylesheet">	       
        
       <link href="https://fonts.googleapis.com/css?family=Fredoka+One&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"> 
   <link rel="stylesheet" href="css/filtroañocat.css"> 
    <link rel="stylesheet" href="css/estiloUsuarioMenu.css">    
    <link rel="stylesheet" href="css/cuerpofiltros.css">  
    <link rel="stylesheet" href="css/Loading.css">    
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">  
<meta name="viewport" content="initial-scale=1, width=device-width,user-scalable=no">
  <link rel="stylesheet" href=css/estilologinalternativo.css>
<title>Insert title here</title>

   <script>
         
         $(function(){
        	 $.ajax({
        			type:'POST',
        			url:'ListadoPeliculas',
        			data:{vacioIndex:'TraerBotonesFiltrosCatAño'},
        			success:function(result){
        			$("#groupbuttoncategory").html(result);
        			}
        	 });
        });
         
         </script>
        
        
        
          <!-- BLOQUE  A HREF FILTRO CATEGORIA -->	
        
        
        <%
        	
        		
        	if(request.getAttribute("LinkFiltroCategorias")!=null){
        		String filtrocateg2=(String)request.getAttribute("LinkFiltroCategorias");	
        
        	//nomcat
        		String nombcategoria=request.getParameter("nomcat");
        %>
        
        <script>
        	var nombcateg=<%="'"+nombcategoria+"'"%>;
        	var categ2=<%="'"+filtrocateg2+"'"%>;
        	if(categ2!=null){
        		//alert("codigo categoria: "+categ2);
        		
            		$.ajax({
            			type:'GET',
            			url:'ListadoPeliculas',
            			data:{vacioIndex:'filtercategory',catg:categ2},
            			async: true,
            			success:function(result){
            			$("#ListaPeliculas").html(result);
            			}
            			});
            		
            		window.onload=function(){
            			
            		
            		
            		
            		$(".menuCategoria>li a").html("Filtro: "+nombcateg);
            		}
        	}
        	
        </script>

<%
        	}
%>        
        
      <!-- BLOQUE  A HREF FILTRO FECHA -->	
        <%
        	
        		
        	if(request.getAttribute("LinkFiltroAño")!=null){
        		String fechas=(String)request.getAttribute("LinkFiltroAño");	
        
        	
        		
        %>
        
        <script>
        	
        	var fecha=<%=fechas%>
        	if(fecha!=null){
        		$("#ListaPeliculas").html("<div class='PrincipalLoading'></div>");
        		$.ajax({
        			type:'GET',
        			url:'ListadoPeliculas',
        			data:{vacioIndex:'filterfecha',catg:fecha},
        			async: true,
        			success:function(result){
        			$("#ListaPeliculas").html(result);
        			}
        			});
        		
        		
        		window.onload=function(){
        			
        		
        		$(".menuCategoria>li a").html("Filtro: "+fecha);
        		}
        	}
        	
        </script>

<%
        	}
%>        
</head>
<body>
	   <div class="cuadropopup2">
           		 <i class="fas fa-window-close" id="opcionClosefooter2"></i>
           		 
					<p class="cargarbloquepopup">
					
               	
           	
           	</p>
           </div>
	<div class="container">
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
          <ul class="t2">
            <li>Despliega Filtros
                <ul>
                  
                  <div class="filtrocataño" id="groupbuttoncategory">
  	  <!-- 
				<div class="filtrocategoria" id="vas">
    <p class="pero">Listado de Categorias</p>	
    <div class="grupobotones">
    <button value="Religiion" class="EnvioFiltroCat botoncat">Religioso</button>
     <button value="Ciencia" class="EnvioFiltroCat botoncat">Ficcion</button>
      <button value="Ciencia" class="EnvioFiltroCat botoncat">Mamut</button>
     
    </div>       
                </div>
				<div class="filtroaño">
				<p>Año de estrenos</p>
				<div class="grupobotones2">
				<button value="Ciencia" class="EnvioFiltroCat botoncat">Mamut</button>
                <button value="Ciencia" class="EnvioFiltroCat botoncat">Mamut</button><button value="Ciencia" class="EnvioFiltroCat botoncat">Mamut</button>
                				
				        </div>
				</div>
				
				 -->
				
				
			</div> 
                </ul>
                
            </li>
	          
				
			
			</ul>
        <div class="CuadroSearchResul" id="cuadroresultado">
            
            <div class="OpcionesSearch" id="OpcionesSearchContent">
            
            </div>
            
       
        
        </div>
     
            
			
			<div class="cuerpo" id="ListaPeliculas">
				
			</div>
			
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
	 <script>
	   $(function(){
           $(".UsuarioMenu li").mouseover(function(){
             $(".t2>li").css({"z-index":"-1"}); 
             $(".buscador").css({"z-index":"-1"});
           });
        });
	   $(function(){
           $(".UsuarioMenu li").mouseout(function(){
             $(".t2>li").css({"z-index":"1"});  
             $(".buscador").css({"z-index":"1"});
           });
        });
	   
	   
	   $(function(){
           $(".menuCategoria li").mouseover(function(){
             $(".t2>li").css({"z-index":"-1"});  
             
           });
        });
	   
	   $(function(){
           $(".t2>li").mouseover(function(){
             $(this).css({"z-index":"2000"});  
             
           });
        });
	   
	   $(function(){
           $(".menuCategoria li").mouseout(function(){
             $(".t2>li").css({"z-index":"1"});  
           });
        });
	   
	   
	   
		/*data:{vacioIndex:'filtercategory',catg:categ2},
		data:{vacioIndex:'filterfecha',catg:fecha},
		*/
		function QuitarPelicula(codpel){
  			
      		$.ajax({
      			type:'POST',
      			
      			data:{vacioIndex:"FiltroQuitPel",codigopel:codpel},
      			url:'ListadoPeliculas',
      			success:function(result){
					$("#ListaPeliculas").html(result);
					
				}
      		});
      			
      		}
      		function AgregarPel(codpel){
    			
          		$.ajax({
          			type:'POST',
          			
          			data:{vacioIndex:"FiltroAddPel",codigopel:codpel},
          			url:'ListadoPeliculas',
          			success:function(result){
    					$("#ListaPeliculas").html(result);
    					
    				}
          		});
      		}
	   
      		
      		
      		/*
	   window.onload=function(){
		   $(function(){
				  $(".EnvioFiltroCat").click(function(){
				   $(".EnvioFiltroCat").removeClass("cambioColorBotonCat");   
				   $(this).addClass("cambioColorBotonCat");
				  //  alert($(this).val());
				  });
				});
		   
		   
			$(function(){
				$(".EnvioFiltroCat").click(function(){
					var parameter=$(this).val();
					$.ajax({
						type:'GET',
	        			url:'ListadoPeliculas',
	        			data:{vacioIndex:'filtercategory',catg:parameter},
	        			async: true,
	        			success:function(result){
	        			$("#ListaPeliculas").html(result);
	        			}
	        			});
					
					//alert($(this).val());
				
				
				});
			});	 
		   
			$(function(){
				$(".EnvioFiltroFecha").click(function(){
					var parameter=$(this).val();
					$.ajax({
						type:'GET',
	        			url:'ListadoPeliculas',
	        			data:{vacioIndex:'filterfecha',catg:parameter},
	        			async: true,
	        			success:function(result){
	        			$("#ListaPeliculas").html(result);
	        			}
	        			});
					
					//alert($(this).val());
				
				
				});
			});	 
			
		   
		   
		   
	   }
	*/
	   function BusquedaXFecha(parameter){
		$.ajax({
			type:'GET',
			url:'ListadoPeliculas',
			data:{vacioIndex:'filterfecha',catg:parameter},
			async: true,
			success:function(result){
			$("#ListaPeliculas").html(result);
			}
			});
		
		$(".menuCategoria>li a").html("Filtro: "+parameter);
   }
   function BusquedaXCategoria(parameter,nomcateg){
		$.ajax({
			type:'GET',
			url:'ListadoPeliculas',
			data:{vacioIndex:'filtercategory',catg:parameter},
			async: true,
			success:function(result){
			$("#ListaPeliculas").html(result);
			}
			});
		$(".menuCategoria>li a").html("Filtro: "+nomcateg);
   }
   
		
		
	 </script>
</body>
</html>