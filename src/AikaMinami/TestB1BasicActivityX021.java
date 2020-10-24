package org.aplas.basicappx;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//Test temperature class
public class TestB1BasicActivityX021 extends ViewTest {
   private Distance unit;

   @Before
   public void startTest() {
       unit = new Distance();
   }

        @Test
        public void check_01_Structure() { //Check Layout Specification
            Class c = unit.getClass();
            List<String> methods = getMethodsName(c.getDeclaredMethods());
            assertEquals("Method number is wrong",9,methods.size());

            String[] names = new String[]{"setMeter", "setInch", "setMile", "setFoot","getMeter", "getInch", "getMile", "getFoot", "convert"};
            for (int i=0; i<names.length; i++) {
                String msg = "Method " + names[i] + " not available";
                testItem(null,methods.contains(names[i]),msg,3);
            }
        }

        @Test
        public void check_02_Methods() throws NoSuchFieldException,IllegalAccessException {
            double value = getRandomDouble(0,5000);
            //Check based on celcius
            unit.setMeter(value);
            assertEquals("Wrong setMeter Method",(double)getFieldValue(unit,"meter"),value,0.01);
            assertEquals("Wrong getMeter Method",unit.getMeter(),value,0.01);
            assertEquals("Wrong getInch Method",unit.getInch(),value*39.3701,0.01);
            assertEquals("Wrong getMile Method",unit.getMile(), value*0.000621371,0.01);
            assertEquals("Wrong getFoot Method",unit.getFoot(),value*3.28084,0.01);
            assertEquals("Wrong convert Method",unit.convert("Mtr", "Mtr", value),unit.getMeter(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Mtr", "Inc", value),unit.getInch(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Mtr", "Mil", value),unit.getMile(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Mtr", "Ft", value),unit.getFoot(),0.01);
            unit.setInch(value);
            assertEquals("Wrong setInch Method",(double)getFieldValue(unit,"meter"),value/39.3701,0.01);
            assertEquals("Wrong convert Method",unit.convert("Inc", "Mtr", value),unit.getMeter(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Inc", "Inc", value),unit.getInch(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Inc", "Mil", value),unit.getMile(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Inc", "Ft", value),unit.getFoot(),0.01);
            unit.setMile(value);
            assertEquals("Wrong setMile Method",(double)getFieldValue(unit,"meter"),value/0.000621371,0.01);
            assertEquals("Wrong convert Method",unit.convert("Mil", "Mtr", value),unit.getMeter(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Mil", "Inc", value),unit.getInch(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Mil", "Mil", value),unit.getMile(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Mil", "Ft", value),unit.getFoot(),0.01);
            unit.setFoot(value);
            assertEquals("Wrong setFoot Method",(double)getFieldValue(unit,"meter"),value/3.28084,0.01);
            assertEquals("Wrong convert Method",unit.convert("Ft", "Mtr", value),unit.getMeter(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Ft", "Inc", value),unit.getInch(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Ft", "Mil", value),unit.getMile(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Ft", "Ft", value),unit.getFoot(),0.01);
        }


}
