
		window.addEventListener('load',CargarSearch);
        function CargarSearch(){
            SearchConcidencias();
    
        }
        function SearchConcidencias(){
        	var contenido=document.getElementById('busqueda').value;
        	//var varsearch=document.getElementById('busqueda').value;		
               if(contenido.length==0){
            
               	document.getElementById('cuadroresultado').classList.remove('animacionSearch');
               	}
               if(contenido.length>0){
            		
            		document.getElementById('cuadroresultado').classList.add('animacionSearch');
               }
            var veropciones=document.getElementById('OpcionesSearchContent');
           //veropciones.innerHTML=null;
            var xhr=new XMLHttpRequest();
            
            xhr.onreadystatechange=function(){
            	
                if(xhr.status==200 && xhr.readyState==4){
                	if(this.responseText==""){
                    	veropciones.innerHTML="No hay resultado";
                    }
                	if(this.responseText.length>0){
                		veropciones.innerHTML=this.responseText;	

                	}
                	  
                    //veropciones.innerHTML+=this.statusText;
                    
                }
                
                if(xhr.status==404){
                	veropciones.innerHTML="No hay conexion con el Servidor , pongase en contacto con el Administrador";
                	veropciones.innerHTML+=this.statusText;
                }
                
        }
        xhr.open('POST','SearchPelicula',true);
        xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");

        xhr.send("vacioSearch=busqueda&parametroPelicula="+contenido);
        }
        
        
 
        
        