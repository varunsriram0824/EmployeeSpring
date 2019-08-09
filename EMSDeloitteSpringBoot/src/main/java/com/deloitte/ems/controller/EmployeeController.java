package com.deloitte.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deloitte.ems.model.Employee;
import com.deloitte.ems.service.EmployeeService;

@Controller
public class EmployeeController implements ErrorController{
	@Autowired
	EmployeeService es;
	
	@PostMapping("/views/addemployee")
	public String addEmployee(@ModelAttribute Employee emp, Model m) {
		Employee e = null;
		String title = "Failed";
		String msg = "Couldn't save employee";
		try {
			e = es.addEmployee(emp);
		} catch (Exception e1) {
			msg = e1.getMessage();
			title = "Error";
			m.addAttribute("msg", msg);
			m.addAttribute("title", title);
			return "/views/showerror";
		}
		
		if (e != null) {
			title = "Successful";
			msg = "Employee Successfully added";
			m.addAttribute("emp", e);
		} else {
			m.addAttribute("emp", emp);
		}
		m.addAttribute("msg", msg);
		m.addAttribute("title", title);
		return "/views/show";
	}
	
	@PostMapping("/views/updateemployee")
	public String updateEmployee(@ModelAttribute Employee emp, Model m) {
		Employee e = null;
		String title = "Failed";
		String msg = "Couldn't update employee";
		try {
			e = es.updateEmployee(emp);
		} catch (Exception e1) {
			msg = e1.getMessage();
			title = "Error";
			m.addAttribute("msg", msg);
			m.addAttribute("title", title);
			return "/views/showerror";
		}
		if (e != null) {
			title = "Successful";
			msg = "Employee data update successfully";
			m.addAttribute("emp", e);
		} else {
			m.addAttribute("emp", emp);
		}
		m.addAttribute("msg", msg);
		m.addAttribute("title", title);
		return "/views/show";
	}
	
	@GetMapping("/views/getemployee")
	public String getEmployee(@RequestParam("empId") String empId, Model m) {
		Employee e = es.getEmployee(empId);
		String title = "Failed";
		String msg = "Couldn't retrieve employee";
		if (e != null) {
			title = "Successful";
			msg = "Employee Successfully found";
			m.addAttribute("emp", e);
		} else {
			m.addAttribute("emp", e);
		}
		m.addAttribute("msg", msg);
		m.addAttribute("title", title);
		return "/views/show";
	}
	
	@PostMapping("/views/deleteemployee")
	public String deleteEmployee(@RequestParam("empId")String empId, Model m) {
		String title = "Failed";
		String msg = "Couldn't delete employee, Invalid Employee ID";
		if(es.deleteEmployee(empId)) {
			title = "Successful";
			msg = "Employee Successfully deleted";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("title", title);
		return "/views/show";
	}
	
	@GetMapping("/views/showall")
	public String showAllEmployees(Model m) {
		List<Employee> empList = es.showAllEmployee();
		String title = "Failed";
		String msg = "No employees present";
		if (!empList.isEmpty()) {
			title = "Successful";
			msg = "Employee Retrieved succesfully";
		}
		m.addAttribute("msg", msg);
		m.addAttribute("title", title);
		m.addAttribute("empList", empList);
		return "/views/showlist";
	}

	@Override
	@RequestMapping("/error")
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/views/showerror";
	}
}
