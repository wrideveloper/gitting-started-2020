package org.aplas.basicappx;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//Test temperature class
public class TestB1BasicActivityX031 extends ViewTest {
   private Weight unit;

   @Before
   public void startTest() {
       unit = new Weight();
   }

        @Test
        public void check_01_Structure() { //Check Layout Specification
            Class c = unit.getClass();
            List<String> methods = getMethodsName(c.getDeclaredMethods());
            assertEquals("Method number is wrong",7,methods.size());

            String[] names = new String[]{"setGram", "setOunce", "setPound", "getGram", "getOunce", "getPound", "convert"};
            for (int i=0; i<names.length; i++) {
                String msg = "Method " + names[i] + " not available";
                testItem(null,methods.contains(names[i]),msg,3);
            }
        }

        @Test
        public void check_02_Methods() throws NoSuchFieldException,IllegalAccessException {
            double value = getRandomDouble(0,5000);
            //Check based on celcius
            unit.setGram(value);
            assertEquals("Wrong setGram Method",(double)getFieldValue(unit,"gram"),value,0.01);
            assertEquals("Wrong getGram Method",unit.getGram(),value,0.01);
            assertEquals("Wrong getOunce Method",unit.getOunce(),value/28.3495231,0.01);
            assertEquals("Wrong getPound Method",unit.getPound(), value/453.59237,0.01);
            assertEquals("Wrong convert Method",unit.convert("Grm", "Grm", value),unit.getGram(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Grm", "Onc", value),unit.getOunce(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Grm", "Pnd", value),unit.getPound(),0.01);

            unit.setOunce(value);
            assertEquals("Wrong setOunce Method",(double)getFieldValue(unit,"gram"),value*28.3495231,0.01);
            assertEquals("Wrong convert Method",unit.convert("Onc", "Grm", value),unit.getGram(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Onc", "Onc", value),unit.getOunce(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Onc", "Pnd", value),unit.getPound(),0.01);

            unit.setPound(value);
            assertEquals("Wrong setPound Method",(double)getFieldValue(unit,"gram"),value*453.59237,0.01);
            assertEquals("Wrong convert Method",unit.convert("Pnd", "Grm", value),unit.getGram(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Pnd", "Onc", value),unit.getOunce(),0.01);
            assertEquals("Wrong convert Method",unit.convert("Pnd", "Pnd", value),unit.getPound(),0.01);
        }


}
