package InterfaceForFlex;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestInterface {
    @Test
    public void checkNoArg() {
        NoArg noArg = () -> System.out.println("I dont know how this suposed to work");
    }

    @Test
    public void checkTwoSame() {
        Assert.assertEquals(TwoSame.twoSame(5, 5), 10);
    }

    @Test
    public void checkThreeDifferent() {
        Assert.assertEquals(ThreeDifferent.threeDifferent(30, true, 70), 40);
    }
}
