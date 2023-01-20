package com.curdOperation.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curdOperation.dto.EmployeeDto;
import com.curdOperation.entity.Employee;
import com.curdOperation.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	/** ---------- Insert Data in Table ------- */
	public EmployeeDto employeeSave(EmployeeDto employeedto) {
		employeeRepository.save(EmployeeDtoToEmployee(employeedto));
		return employeedto;
	}
	
	
	/**---------- Get All Data in Table ------------ */
	public List<EmployeeDto> getAllEmployee() {
		List<EmployeeDto> employeeList = new ArrayList<EmployeeDto>();
		employeeRepository.findAll().forEach(li -> employeeList.add(EmployeeToEmployeeDto(li)));
		return employeeList;
	}
	
	
	/**-------- Get Data in Table through Particular Id -------------*/
	public EmployeeDto getEmployeeById(int empid) {
		Employee employee = employeeRepository.findById(empid).get();
		return EmployeeToEmployeeDto(employee);
		
		
		//Employee employee = this.employeeRepository.findById(empId).get();
//        // Optional<Employee> byId = employeeReposatory.findById(employeeId);
//      //  return this.employeeToEmployeeDto(employee).orElseThrow(()-> new NoSuchException("No DataBase Present With ID =" +employeeId));
//        return Optional.employee;
	}
	
	
	/**------- Delete data in Table By Id ---------*/
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}
	
	
	/** -------- Update data in Table By Id -------------- */
	public EmployeeDto updateEmployeeById(EmployeeDto employeedto, int id) {
		employeedto.setId(id);
		employeeRepository.save(EmployeeDtoToEmployee(employeedto));
		return employeedto;
		
//		Employee employee = employeeRepository.findById(id).get();
//		employee.setName(employeedto.getName());
//		employee.setEmail(employeedto.getEmail());
//		employee.setPhoneno(employeedto.getPhoneno());
//		employee.setSalary(employeedto.getSalary());
//		employee.setDate(employeedto.getDate());
//		
//		employeeRepository.save(employee);
//		return EmployeeToEmployeeDto(employee);
//		
	}
	
/**==================================================================================================*/
	
	/** ----- Using DTO Class in EmployeeDtoToEmployee ----- */

	public Employee EmployeeDtoToEmployee(EmployeeDto employeedto) {
		Employee employee = this.modelMapper.map(employeedto, Employee.class);

		return employee;
	}

	/**----- Using DTO Class in EmployeeToEmployeeDto -------*/

	public EmployeeDto EmployeeToEmployeeDto(Employee employee) {
		EmployeeDto employeedto = this.modelMapper.map(employee, EmployeeDto.class);

		return employeedto;

	}

}
