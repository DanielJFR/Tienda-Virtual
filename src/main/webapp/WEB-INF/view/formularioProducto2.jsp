<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
</head>
<body>
<h1>formulario de producto</h1>
 <form:form action="insertarProducto" modelAttribute="producto" method="POST">
     <form:hidden path="id" />
     <table>
        <tr>
           <td>Nombre:</td>
           <td><form:input path="nombre"/></td> 
        </tr>
        <tr>
           <td>Descripcion:</td>
           <td><form:input path="descripcion"/></td> 
        </tr>
        <tr>
           <td>Precio:</td>
           <td><form:input path="precio"/></td> 
        </tr>
        <tr>
          <td colspan=2><input type="submit" value="actualizar"></td>
        </tr>
     </table>
  </form:form>
</body>
</html>