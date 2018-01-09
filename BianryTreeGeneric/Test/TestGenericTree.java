/**
 * Created by alumniHawking23 on 18/08/2017.
 */

import com.m3c.gs.BinaryTreeEngine;
import com.m3c.gs.Employee;
import com.m3c.gs.Node;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;


import java.util.List;

import static org.junit.Assert.*;

public class TestGenericTree {

    private Employee[] sequence = new Employee [5];
    BinaryTreeEngine binaryTreeEngine =  new BinaryTreeEngine();

    @Before
    public void setUp(){

        //intialising the employees objects
        String[] randomSet = {"3","7","1","0","36"};

        for(int i=0; i<sequence.length; i++){
            Employee employee = new Employee();
            employee.setEmployeeId(randomSet[i]+"");
            employee.setSalary(i*1000);
            employee.setFirstName("A "+i);
            employee.setLastName("L "+i);
            sequence[i] = employee;
        }

        binaryTreeEngine.settingNodes(sequence);
    }


    @Test
    public void getLength(){
        int actualLength = binaryTreeEngine.getNumberOfNodes();
        int expectedLength= sequence.length;
        assertEquals(actualLength,expectedLength);

    }

    @Test
    public void getFirstEmployee(){
        Employee actualEmployee = ((Employee) binaryTreeEngine.getRootNode().getData());
        Employee expected = sequence[0];
        assertEquals(actualEmployee,expected);

    }



    @Test
    public void findEmployee(){
        //string comparison
        Employee employeeActual = new Employee();
        String actualString = "3";
        employeeActual.setEmployeeId(actualString);


        String employeeExpectedString = ((Employee) (binaryTreeEngine.findNode(employeeActual)).getData() ).getEmployeeId();
        assertEquals(actualString,employeeExpectedString);

    }


    @Test
    public void sortASC(){

        List<Node> listNode = binaryTreeEngine.getSortedTreeAsc();
        Employee actualEmployee = sequence[3];
        Employee expectedEmployee = (Employee) listNode.get(0).getData();
        assertEquals(actualEmployee,expectedEmployee);
    }

    @Test
    public void sortDES(){
        List<Node> listNode = binaryTreeEngine.getSortedTreeDesc();
        Employee actualEmployee = sequence[4];
        Employee expectedEmployee = (Employee) listNode.get(0).getData();
        assertEquals(actualEmployee,expectedEmployee);
    }





//
//    @After
//    public void tearDown(){
//
//
//    }

}
