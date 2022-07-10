package com.lance.springbootjpa.service;

import com.lance.springbootjpa.data.entity.Employee;
import com.lance.springbootjpa.data.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class AdvocateService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }
    public String init() {
        try {
            long count = employeeRepository.count();
            if (count > 0) {
                String msg = "advocates already exist!";
                log.info(msg);
                return msg;
            }

        } catch (Exception e) {
            log.warn("error happened", e);
            log.warn("start initialization...");
        }

        Arrays.stream(new Employee[]{
                new Employee("Dalia", "Ada"),
                new Employee("John", "Adams"),
                new Employee("Tom", "Zk"),
                new Employee("Jack", "Kam"),
        }).forEach(employeeRepository::save);

        String msg = "advocates initialization done!";
        log.info(msg);
        return msg;
    }
}
