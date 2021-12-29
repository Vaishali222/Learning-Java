package com.knoldus.learning.controller;

import com.knoldus.learning.entity.Employee;
import com.knoldus.learning.service.*;

import java.io.FileNotFoundException;
import java.util.List;

public class EmployeeController {

    public static void main(String[] a) throws FileNotFoundException {
        ValidateEmployeeService validateEmployeeService = new ValidateEmployeeServiceImpl();
        SaveEmployeeService saveEmployeeService = new SaveEnployeeServiceImpl();

        ReadEmployeeData readEmployeeData = new ReadEmployeeDataImpl();


        List<Employee> emplList = readEmployeeData.readDataFromDatabaseFile();

        System.out.println("Total number of employees :  "+emplList.size());

        for (Employee e : emplList) {
            if(validateEmployeeService.validateEmployee(e))
                saveEmployeeService.saveEmployee(e);
        }

        System.out.println("Saved Number of employees : "+saveEmployeeService.getEmployeeCount());
        System.out.println("Invalid number of Employees : " + (emplList.size() - saveEmployeeService.getEmployeeCount()));
    }
}
