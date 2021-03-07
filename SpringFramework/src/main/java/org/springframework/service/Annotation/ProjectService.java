package org.springframework.service.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.models.Department;
import org.springframework.models.Employee;

public class ProjectService {

    private Department department;

    private Employee employee;


    @Autowired
    public ProjectService(Department department) {
        this.department = department;
    }

    @Autowired
    public ProjectService(Employee employee) {
        this.employee = employee;
    }
}
