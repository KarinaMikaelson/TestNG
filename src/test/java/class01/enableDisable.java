package class01;

import org.testng.annotations.Test;

public class enableDisable {

    @Test
    public void Atest(){
        System.out.println("i am A test");
    }
    //@Test(enabled = false) temporarily disables a test method without removing it from the codebase
    @Test(enabled = false)
    public void Btest(){
        System.out.println("i am B test");
    }
}
