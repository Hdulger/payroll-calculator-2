package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class PayrollCalculator2 {
    public static void main(String[] args) {
        String fileName = "src/main/resources/employees.csv";
        ArrayList<String> lines = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            line= bufferedReader.readLine();
            while(line != null){
                Employee employee=parsEmployee(line);
                System.out.printf("%d   %s   %f \n", employee.getEmployeeId(), employee.getName(), employee.calculateGrossPay());
                line= bufferedReader.readLine();
            }


        } catch (FileNotFoundException e) {
            System.out.println("File is not found " + e.getMessage());
        } catch (IOException e) {
            System.out.println("There is Input or Output problem");
        }



        }

        public static Employee parsEmployee(String employeeCsv){
            String[] lineParts= employeeCsv.split(Pattern.quote("|"));

            int id=Integer.parseInt(lineParts[0]);
            String name=lineParts[1];
            double hoursWorked=Double.parseDouble(lineParts[2]);
            double payRate= Double.parseDouble(lineParts[2]);

            return new Employee(id, name, hoursWorked, payRate);


        }



}
