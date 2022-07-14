package com.lance.springbootjpa.api;

import com.lance.springbootjpa.data.entity.Employee;
import com.lance.springbootjpa.service.AdvocateService;
import io.vavr.collection.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/advocate")
@CrossOrigin("*")
public class AdvocateController {
    @Autowired
    private AdvocateService advocateService;

    @RequestMapping("/init")
    public String init() {
        return advocateService.init();
    }
    @RequestMapping("/list")
    public List<Employee> list() {
        return Stream.ofAll(advocateService.list()).toJavaList();
    }
}
