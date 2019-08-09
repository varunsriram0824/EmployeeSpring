<%@ include file="header.jsp" %>
<body>

<form action="getemployee" method="get">
<h3>Enter the employee details</h3>
<div class="row">
        <div class="row">
        <div class="input-field col s6">
<label for="id">Enter Employee ID</label> 
<input type="text" name="empId">
</div></div></div>
<input class="btn waves-effect waves-light red lighten-2" type="submit" value="Find">
</form>
<%@ include file="footer.jsp" %>