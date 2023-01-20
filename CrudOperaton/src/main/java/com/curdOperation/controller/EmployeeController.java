package com.curdOperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curdOperation.dto.EmployeeDto;
import com.curdOperation.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/** ---------- Insert Data in Table ------- */
	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> emplSave(@RequestBody EmployeeDto employeedto)
	{
		 employeeService.employeeSave(employeedto);
		 return new ResponseEntity<>(employeedto ,HttpStatus.CREATED);
	}
	
	/**---------- Get All Data in Table ------------ */
	@GetMapping("/fetch")
	public ResponseEntity<List<EmployeeDto>> employeeFetch() {
	
		List<EmployeeDto> employeeList = employeeService.getAllEmployee();
		return new ResponseEntity<>(employeeList ,HttpStatus.OK);
	}
	

	/**-------- Get Data in Table through Particular Id -------------*/
	@GetMapping("/fetch/{employeeId}")
	public ResponseEntity<EmployeeDto> emplfetchById(@PathVariable("employeeId") int empid)
	{
		EmployeeDto employeedto = employeeService.getEmployeeById(empid);
		 return new ResponseEntity<>(employeedto ,HttpStatus.OK);
	}


	/**------- Delete data in Table By Id ---------*/
	@DeleteMapping("/delete/{employeeId}")
	public void empldeleteById(@PathVariable("employeeId") int id) {
		employeeService.deleteEmployeeById(id);
	}
	

	/** -------- Update data in Table By Id -------------- */
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<EmployeeDto> emplUpdateById(@RequestBody EmployeeDto employeeDto ,@PathVariable("employeeId") int updateId) {
		 EmployeeDto employeedto = employeeService.updateEmployeeById(employeeDto , updateId);
		 return new ResponseEntity<>(employeedto ,HttpStatus.OK);

	}
}
