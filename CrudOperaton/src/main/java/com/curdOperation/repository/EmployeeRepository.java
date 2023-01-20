package com.curdOperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curdOperation.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
