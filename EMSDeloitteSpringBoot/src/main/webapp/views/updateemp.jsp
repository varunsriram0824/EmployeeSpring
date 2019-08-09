<%@ include file="header.jsp" %>


<form action="updateemployee" method="post">
<h3>Enter the employee details</h3>
<div class="row">
        <div class="row">
        <div class="input-field col s6">
<label for="id">Enter Employee ID</label> 
<input type="text" name="empId">
</div></div></div>


<div class="row">
        <div class="row">
        <div class="input-field col s6">
<label for="salary">Enter New Salary</label> 
<input type="text" name="basicSalary"><br>
</div></div></div>
<input class="btn waves-effect waves-light red lighten-2" type="submit" value="Click Here to Update the Record">
</form>
</body>
</html>