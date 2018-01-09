package com.m3c.gs;


import java.util.List;

public class BinaryTreeManager {

    //allows the array to passed as objects
    public void build(){



        Employee[] sequence = new Employee[5];

        String[] randomSet = {"3","7","1","0","36"};

        //intialising the employees
        for(int i=0; i<sequence.length; i++){
            Employee employee = new Employee();
            employee.setEmployeeId(randomSet[i]+"");
            employee.setSalary(i*1000);
            employee.setFirstName("A "+i);
            employee.setLastName("L "+i);
            sequence[i] = employee;
        }

        passValuesToTree(sequence);


    }

    public void passValuesToTree(Employee[] values){
        BinaryTreeEngine binaryTreeEngine =  new BinaryTreeEngine();
        binaryTreeEngine.settingNodes(values);

        Operations_m(binaryTreeEngine);

    }







    public void Operations_m(BinaryTreeEngine binaryTreeEngine){

        PrintOutValues printOutValues = new PrintOutValues();

        //using the employee id for comparison
        Employee employee = new Employee();
        employee.setEmployeeId("3");

        Node node = binaryTreeEngine.findNode(employee);

        binaryTreeEngine.getNumberOfNodes();


    }


}
