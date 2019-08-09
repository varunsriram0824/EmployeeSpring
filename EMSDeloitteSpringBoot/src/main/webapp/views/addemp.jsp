<%@ include file="header.jsp" %>


<div class="container">
<h3>Enter the employee details</h3>
<form action="addemployee" method="post">
 <div class="row">
        <div class="input-field col s12">
<label for="name">Name </label> <input type="text" name="empName">
        </div>
</div>
<div class="row">
        <div class="input-field col s12">
<label for="dob"> Date of Birth(DD/MM/YYYY)</label> 
<input type="date" name="dob">
        </div>
</div>
<div class="row">
        <div class="input-field col s12">
<label for="Base_Salary">Base Salary</label> <input type="text" name="basicSalary"><br>
</div>
</div>

<input class="btn waves-effect waves-light red lighten-2" type="submit" value="Register">

</form>
</div>
<%@ include file="footer.jsp" %>