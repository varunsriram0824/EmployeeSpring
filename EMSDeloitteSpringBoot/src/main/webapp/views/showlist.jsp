<%@ include file="header.jsp" %>
<div class="container">
<h3>All Employees!</h3>
</div>
<div class="container">
<table class="highlight">
<thead>
          <tr>
              <th>Employee Id</th>
              <th>Employee Name</th>
              <th>Date of Birth</th>
              <th>Salary</th>
          </tr>
        </thead>
<c:forEach items="${empList}" var="item">
    <tr>
    <td><c:out value="${item.empId}"/></td>
     <td><c:out value="${item.empName}"/></td>
      <td><c:out value="${item.dob}"/></td>
       <td><c:out value="${item.basicSalary}"/></td>
</c:forEach>
</table>
</div>

<%@ include file="footer.jsp" %>