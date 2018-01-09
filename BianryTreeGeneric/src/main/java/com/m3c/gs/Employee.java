package com.m3c.gs;

/**
 * Created by alumniHawking23 on 17/08/2017.
 */
public class Employee implements Comparable<Employee> {
    private String employeeId;
    private String firstName;
    private String lastName;
    private int salary;



    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }



    //id
    public int compareTo(Employee o) {

        //1 is bigger then so left is bigger then the right
        //-1 is smaller so the left is smaller then the right
        // 0 is both are equal
         //System.out.println(   getEmployeeId().compareTo(o.getEmployeeId())   );

        int employeeId= Integer.parseInt(getEmployeeId());

        int IdOther = Integer.parseInt(o.getEmployeeId());

        if(employeeId > IdOther){
            return 1;
        }else if (employeeId < IdOther){
            return -1;
        }else{
            return 0;
        }
    }

//    //All Other, this
//    public int compareTo(Employee o) {
//
//        //1 is bigger then so left is bigger then the right
//        //-1 is smaller so the left is smaller then the right
//        // 0 is both are equal
//        //System.out.println(   getEmployeeId().compareTo(o.getEmployeeId())   );
//        String origin = getSalary() + "";
//        String Other = o.getSalary()+ "";
//        return origin.compareTo(Other);
//    }















}
