<%@ include file="header.jsp" %>
<div class="container">
<h3>${msg}</h3><br>
</div>
<div class="container">
 <table class="striped">
 <thead>
          <tr>
              <th>Employee Id</th>
              <th>Employee Name</th>
              <th>Date of Birth</th>
              <th>Salary</th>
          </tr>
        </thead>
 <tr>
 <td><c:out value="${emp.empId}"/></td>
     <td><c:out value="${emp.empName}"/></td>
      <td><c:out value="${emp.dob}"/></td>
       <td><c:out value="${emp.basicSalary}"/></td>
 </table>
 </div>

<%@ include file="footer.jsp" %>
