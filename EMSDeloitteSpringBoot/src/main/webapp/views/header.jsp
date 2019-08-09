<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<style>
body{
display:flex;
min-height:100vh;
flex-direction: column;
}
main{
flex: 1 0 auto;
}
</style>
</head>
<body>
<main>
<nav>
    <div class="nav-wrapper red lighten-2">
      <a href="index.jsp" class="brand-logo">Deloitte</a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="addemp.jsp">Add</a></li>
		<li><a href="updateemp.jsp">Update</a></li>
		<li><a href="deleteemp.jsp">Delete</a></li>
		<li><a href="getemp.jsp">Get Employee</a></li>
		<li><a href="showall">View All</a></li>
      </ul>
    </div>
  </nav>
