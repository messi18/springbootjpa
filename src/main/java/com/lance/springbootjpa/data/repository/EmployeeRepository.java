package com.lance.springbootjpa.data.repository;

import com.lance.springbootjpa.data.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
