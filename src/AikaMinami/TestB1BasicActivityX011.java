package org.aplas.basicappx;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

//Test temperature class
public class TestB1BasicActivityX011 extends ViewTest {
   private Temperature unit;

   @Before
   public void startTest() {
       unit = new Temperature();
   }

        @Test
        public void check_01_Structure() { //Check Layout Specification
            Class c = unit.getClass();
            List<String> methods = getMethodsName(c.getDeclaredMethods());
            assertEquals("Method number is wrong",7,methods.size());

            String[] names = new String[]{"setCelcius", "setFahrenheit", "setKelvins", "getCelcius","getFahrenheit", "getKelvins", "convert"};
            for (int i=0; i<names.length; i++) {
                String msg = "Method " + names[i] + " not available";
                testItem(null,methods.contains(names[i]),msg,3);
            }
        }

        @Test
        public void check_02_Methods() throws NoSuchFieldException, IllegalAccessException {
            double value = getRandomDouble(0,5000);
            //Check based on celcius
            unit.setCelcius(value);
            assertEquals("Wrong setCelcius Method",(double)getFieldValue(unit,"celcius"),value,0.01);
            assertEquals("Wrong getCelcius Method",unit.getCelcius(),value,0.01);
            assertEquals("Wrong getFahrenheit Method",unit.getFahrenheit(),value*9/5+32,0.01);
            assertEquals("Wrong getKelvins Method",unit.getKelvins(),value+273.15,0.01);
            assertEquals("Wrong convert Method",unit.convert("°C", "°C", value),unit.getCelcius(),0.01);
            assertEquals("Wrong convert Method",unit.convert("°C", "°F", value),unit.getFahrenheit(),0.01);
            assertEquals("Wrong convert Method",unit.convert("°C", "K", value),unit.getKelvins(),0.01);
            unit.setFahrenheit(value);
            assertEquals("Wrong setFahrenheit Method",(double)getFieldValue(unit,"celcius"),(value-32)/9*5,0.01);
            assertEquals("Wrong convert Method",unit.convert("°F", "°C", value),unit.getCelcius(),0.01);
            assertEquals("Wrong convert Method",unit.convert("°F", "°F", value),unit.getFahrenheit(),0.01);
            assertEquals("Wrong convert Method",unit.convert("°F", "K", value),unit.getKelvins(),0.01);
            unit.setKelvins(value);
            assertEquals("Wrong setKelvins Method",(double)getFieldValue(unit,"celcius"),value-273.15,0.01);
            assertEquals("Wrong convert Method",unit.convert("K", "°C", value),unit.getCelcius(),0.01);
            assertEquals("Wrong convert Method",unit.convert("K", "°F", value),unit.getFahrenheit(),0.01);
            assertEquals("Wrong convert Method",unit.convert("K", "K", value),unit.getKelvins(),0.01);

        }


}
