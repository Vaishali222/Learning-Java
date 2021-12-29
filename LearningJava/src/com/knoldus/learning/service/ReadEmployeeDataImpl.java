package com.knoldus.learning.service;

import com.knoldus.learning.entity.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadEmployeeDataImpl implements ReadEmployeeData {
        @Override
        public List<Employee> readDataFromDatabaseFile() throws FileNotFoundException {

                String readLine = "";
                String splitLine = ",";

                List<Employee> employeeList = new ArrayList<>();

                try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("/home/knoldus/Desktop/Assignments/learningJava_Assignment-main/LearningJava/Employee.csv"));
                        while ((readLine = bufferedReader.readLine()) != null) {

                                String[] employeeDataFile = readLine.split(splitLine);
                                Employee addEmployee = new Employee(Integer.parseInt(employeeDataFile[0]) , employeeDataFile[1]);
                                employeeList.add(addEmployee);

                        }
                }
                catch (Exception e) {
                        e.printStackTrace();
                }

                return employeeList;
        }
}
