package org.aplas.basicappx;

import android.content.res.Resources;

public class ResourceTest extends ViewTest {
    private Resources resource;

    public ResourceTest(Resources rsc) {
        resource =rsc;
    }

    public void testStringResource(String name,String expected) {
        int resId = resource.getIdentifier(name, "string", getClass().getPackage().getName());
        testItem(0,resId,"String "+name+" id is not exist",2);
        testItem(expected,resource.getString(resId),"String "+name+" value is not valid",1);
    }

    public void testStringArrayResource(String name,String[] expected) {
        int resId = resource.getIdentifier(name, "array", getClass().getPackage().getName());
        testItem(0,resId,"String array "+name+" id is not exist",2);
        String[] str = resource.getStringArray(resId);
        testItem(arrayToString(expected),arrayToString(str),"String array "+name+" value is not valid",1);
        /*
        String[] str = resource.getStringArray(resId);
        boolean found=false;
        int i=0;
        while (!found && i<expected.length) {
            found = (expected[i]!=str[i]);
            i++;
            testItem(expected[i],str[i],"String array "+name+" value is not valid",1);
        }
        testItem(!found,!found,"String array "+name+" value is not valid",4);
        */
    }

    public void testColorResource(String name,int expected) {
        int resId = resource.getIdentifier(name, "color", getClass().getPackage().getName());
        testItem(0,resId,"Color "+name+" id is not exist",2);
        testItem(expected,resource.getColor(resId),"Color "+name+" value is not valid",1);
    }

    public void testFontResource(String name,String expected) {
        //int resId = R.font.cambria;
        //Typeface font = Typeface.createFromAsset(resource.getAssets(),name);
        int resId = resource.getIdentifier(name, "font", getClass().getPackage().getName());
        testItem(0,resId,"Font "+name+" id is not exist",2);
        testItem(expected,resource.getResourceEntryName(resId),"Font "+name+" value is not valid",1);
    }

    public void testImgResource(String name) {
        int resId = resource.getIdentifier(name, "drawable", getClass().getPackage().getName());
        testItem(0,resId,"Image "+name+" id is not exist",2);
        //testItem(expected,resource.getString(resId),"String "+expected+" value is not valid",1);
    }

    public void testDrawableResource(String name, String expected) {
        int resId = resource.getIdentifier(name, "drawable", getClass().getPackage().getName());
        testItem(0,resId,"Drawable "+name+" id is not exist",2);
        //testItem(expected,resource.getDrawable(resId).,"Drawable "+expected+" value is not valid",1);
    }
}
