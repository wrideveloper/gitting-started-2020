package org.aplas.basicappx;

import android.view.ViewGroup;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ViewTest {
    public static final String layoutName = "mainLayout";
    public static final String appName  = "BasicAppX";

    protected void testCompletion(int prevElement, List<Class> elements, ViewGroup layout){
        //Error message
        String compNumberMsg = "Element(s) was missing";
        String itemCompMsg = " is not suitable";

        //JUnit Test
        int expected = prevElement+elements.size();
        int actual = layout.getChildCount();
        assertTrue(expected-actual + " " + compNumberMsg,expected<=actual);

        if (prevElement+elements.size()<=layout.getChildCount()) {
            for (int idx=prevElement; idx<=elements.size()+prevElement-1; idx++) {
                assertEquals("Element "+idx+itemCompMsg,elements.get(idx-prevElement),layout.getChildAt(idx).getClass());
            }
        }
    }

    public void testItem(Object expectVal, Object actualVal, String msg, int type) {
        switch (type) {
            case 1:  assertEquals(msg,expectVal,actualVal);
                break;
            case 2:  assertNotEquals(msg,expectVal,actualVal);
                break;
            case 3:  assertTrue(msg,(boolean)actualVal);
                break;
            case 4:  assertFalse(msg,(boolean)actualVal);
                break;
            case 5:  assertNull(msg,actualVal);
                break;
            case 6:  assertNotNull(msg,actualVal);
                break;
        }
    }

    public List<String> getMethodsName(Method[] methods) {
        List<String> list = new ArrayList<>();
        for (int i=0; i<methods.length; i++) {
            list.add(methods[i].getName());
        }
        return list;
    }

    public double getRandomDouble(int min, int max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public int getRandomInteger(int min, int max) {
        Random r = new Random();
        return min + r.nextInt(max - min + 1);
    }

    public Object getFieldValue(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field f = obj.getClass().getDeclaredField(fieldName);
        f.setAccessible(true);
        return f.get(obj);
    }

    public String getAccessName(int access) {
        if (access==Modifier.PUBLIC) {
            return "Public";
        } else if (access==Modifier.PRIVATE) {
            return "Private";
        } else {
            return "Protected";
        }
    }

    public void testField(Object obj,String fieldName, int access, Class<?> type, boolean isNull) {
        Class<?> activityClass = obj.getClass();
        Field f;
        try {
            f = activityClass.getDeclaredField(fieldName);
            assertEquals("Access to field \'"+fieldName+"\' must be "+getAccessName(access),f.getModifiers(),access);
            assertEquals("Type of field \'"+fieldName+"\' must be "+type.getSimpleName(), f.getType(), type);
            f.setAccessible(true);
            if (isNull) {
                assertNull("Field \'"+fieldName+"\' must be Null", f.get(obj));
            } else  {
                assertNotNull("Field \'"+fieldName+"\' must be Constructed", f.get(obj));
            }
        } catch(Exception e) {
            assertTrue("Field "+fieldName+" is not declared!!",false);
        }
    }

    public void testMethod(Object obj,String methodName, int access, Class[] params, Class<?> returnType) {
        Class<?> activityClass = obj.getClass();
        Method m;
        try {
            m = activityClass.getDeclaredMethod(methodName,params);
            assertEquals("Access to field \'"+methodName+"\' must be "+getAccessName(access),m.getModifiers(),access);
            assertEquals("Type of return field \'"+methodName+"\' must be "+returnType.getSimpleName(), m.getReturnType(), returnType);
        } catch(Exception e) {
            assertTrue("Field "+methodName+" is not declared or parameters is wrong!!",false);
        }
    }

    public String listToString(List x) {
        String res = "";
        for (int i=0; i<x.size(); i++){
            res += x.get(i)+";";
        }
        return res;
    }

    public String arrayToString(Object[] x) {
        String res = "";
        for (int i=0; i<x.length; i++){
            res += x[i]+";";
        }
        return res;
    }

    public Object getField(Object obj,String fieldName) {
        Class<?> activityClass = obj.getClass();
        Field f;
        try {
            f = activityClass.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.get(obj);
        } catch(Exception e) {
            return null;
        }
    }
}
