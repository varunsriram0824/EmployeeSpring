package com.deloitte.ems.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.ems.dao.EmployeeDao;
import com.deloitte.ems.model.Employee;
import com.deloitte.ems.util.InvalidDateException;
import com.deloitte.ems.util.InvalidLengthException;
import com.deloitte.ems.util.InvalidSalaryException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao ed;
	
	@Override
	public boolean validateEmployee(Employee emp) throws Exception {
		
		if(emp.getEmpName().length() < 4 || emp.getEmpName().length() > 15)
			throw new InvalidLengthException("Invalid length");
		
		if(emp.getDob().isAfter(LocalDate.of(1995, 12, 31)) || emp.getDob().isBefore(LocalDate.of(1900, 01, 01)))
			throw new InvalidDateException("Invalid Date");
		
		if(emp.getBasicSalary() < 20000 || emp.getBasicSalary() > 80000)
			throw new InvalidSalaryException("Invalid Salary");
		
		return true;
	}
	
	@Override
	public String generateId(String empName) {
		Random rand = new Random();
		return empName.substring(0, 2).toUpperCase() + String.format("%04d", rand.nextInt(10000));
	}
	
	@Override
	public Employee addEmployee(Employee emp) throws Exception {
		if(validateEmployee(emp)) {
			emp.setEmpId(generateId(emp.getEmpName()));
			return ed.save(emp);
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee emp) throws Exception {
		Employee e = ed.findByEmpId(emp.getEmpId());
		System.out.println(emp);
		if(e != null) {
			//emp.setId(e.getId());
			e.setBasicSalary(emp.getBasicSalary());
			
			System.out.println(e);
			if (validateEmployee(e))
				return ed.save(e);
		}
		return null;
	}

	@Override
	public boolean deleteEmployee(String empId) {
		Employee e = ed.findByEmpId(empId);
		if (e != null) {
			ed.delete(e);
			return true;
		}
		return false;
	}

	@Override
	public Employee getEmployee(String empId) {
		Employee e = ed.findByEmpId(empId);
		if (e != null)
			return e;
		return null;
	}

	@Override
	public List<Employee> showAllEmployee() {
		return ed.findAll();
	}

}
