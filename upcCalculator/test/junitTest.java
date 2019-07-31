import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class junitTest {

    @Before
    public void setUp() {
    }


    @Test
    public void testCalconst(){
        double result = Main.calconst();
        assertEquals(result,2.2955871493899918);
    }

    @Test
    public void testCaladd(){


        double result = testClass.caladd(2,2);
        assertEquals(result,4.0);
    }

   @Test
    public void testCalSubstract(){

        double result = testClass.calsubstract(2,2);
                assertEquals(result,0.0);


    }
    @Test
    public void testCalDivide(){

        double result = testClass.caldivide(4,2);
        assertEquals(result,2.0);


    }

    @Test
    public void testCalMultiply(){

        double result = testClass.calmultiply(2,2);
        assertEquals(result,4.0);


    }

    @Test
    public void testCaldistance(){

        double result = testClass.caldistance(2);
        assertEquals(result,1.1477935746949959);


    }


}
