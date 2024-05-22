package class01;

import org.testng.annotations.Test;

public class priority {
    @Test(priority = 3)
    public void ATestCase(){
        System.out.println("i am test case A");
    }
    @Test(priority = 2)
    public  void BTestCase(){
        System.out.println("i am test case B");
    }
    @Test(priority = 1)
    public  void CTestCase(){
        System.out.println("i am test case C");
    }
    // Priority is an attribute that tells TestNG which order the tests need to follow.
    // Starts from index = 0
    @Test
    public  void DTestCase(){
        System.out.println("i am test case D");
    }
}
