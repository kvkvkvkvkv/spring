package com.java.java8;

import com.java.java8.model.Employee;
import com.java.java8.model.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Java8Application {

	public static List<Employee> employees = new ArrayList();

	public static List<Project> projects = new ArrayList();

	public static void main(String[] args) {
		SpringApplication.run(Java8Application.class, args);
	}

	@PostConstruct
	public void init(){
		LocalDate startDate1 = LocalDate.of(2000,9,12);
		LocalDate startDate2 = LocalDate.of(2005,6,12);
		LocalDate startDate3 = LocalDate.of(2020,3,12);

		Project project1 = new Project("Project 1", startDate1, Period.between(startDate1,LocalDate.now()), 10);
		Project project2 = new Project("Project 2", startDate2, Period.between(startDate2,LocalDate.now()), 15);
		Project project3 = new Project("Project 3", startDate3, Period.between(startDate3,LocalDate.now()), 8);

		LocalDate empStartDate1 = LocalDate.of(2000,10,18);
		employees.add(new Employee("Sonia", (long) 1000,"HR",20,"F",empStartDate1, project1));

		LocalDate empStartDate2 = LocalDate.of(2005,7,20);
		employees.add(new Employee("Rob", (long) 2000,"Dev",22,"M",empStartDate2,project2));

		empStartDate1 = LocalDate.of(2016,4,12);
		employees.add(new Employee("Dom", (long) 1500,"Support",30,"M",empStartDate1, project1));

		empStartDate1 = LocalDate.of(2019,8,28);
		employees.add(new Employee("Rash", (long) 3000,"Dev",20,"F",empStartDate1, project1));

		empStartDate2 = LocalDate.of(2015,9,2);
		employees.add(new Employee("Ankita", (long) 1200,"HR",26,"F",empStartDate2, project2));

		LocalDate empStartDate3 = LocalDate.of(2020,3,12);
		employees.add(new Employee("Deeps", (long) 2000,"HR",29,"F",empStartDate3, project3));

		empStartDate3 = LocalDate.of(2020,9,20);
		employees.add(new Employee("Praj", (long) 1800,"Support",27,"F",empStartDate3, project3));

		empStartDate2 = LocalDate.of(2018,4,25);
		employees.add(new Employee("Sheldon", (long) 3500,"Dev",30,"M",empStartDate2, project2));

		projects.add(project1);
		projects.add(project2);
		projects.add(project3);
	}
}
