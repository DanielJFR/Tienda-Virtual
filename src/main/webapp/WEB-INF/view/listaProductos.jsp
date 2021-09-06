<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListaProductos</title>
</head>
<body>
  <h1>Lista de productos</h1>
  
 <table>
   <tr>
     <th>Nombre</th>
     <th>Descripcion</th>
     <th>Precio</th>
     <th></th>
     <th></th>
  </tr>
   <c:forEach var="productoVar" items="${productos}">
     <c:url var="linkActualizar" value="/producto/actualizaFormulario">
       <c:param name="id" value="${productoVar.id}"/>
     </c:url>
     <c:url var="linkEliminar" value="/producto/eliminar">
       <c:param name="id" value="${productoVar.id}"/>
     </c:url>
         <tr>
              <td>${productoVar.nombre}</td> 
              <td>${productoVar.descripcion}</td>
              <td>${productoVar.precio}</td>  
              <td><a href="${linkActualizar}">
                  Actualizar   
              </a></td>
              <td><a href="${linkEliminar}">
                  Eliminar
              </a></td>
         </tr>
   </c:forEach>

 </table>
 <br/>
 <input type="button" value="agregar producto" onclick="window.location.href='producto/altaFormulario';return false;"/>
</body>
</html>