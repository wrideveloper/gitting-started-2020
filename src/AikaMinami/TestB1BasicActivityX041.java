package org.aplas.basicappx;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Modifier;
import java.text.DecimalFormat;

public class TestB1BasicActivityX041 extends ViewTest {
   private MainActivity layout;

   @Before
   public void startTest() {
       layout = new MainActivity();
   }

   @Test
   public void check_01_Fields_Availability() { //Check Layout Specification
       testField(layout,"dist", Modifier.PRIVATE, Distance.class,false);
       testField(layout,"weight", Modifier.PRIVATE, Weight.class, false);
       testField(layout,"temp", Modifier.PRIVATE, Temperature.class, false);
       testField(layout,"convertBtn", Modifier.PRIVATE, Button.class, true);
       testField(layout,"inputTxt", Modifier.PRIVATE, EditText.class, true);
       testField(layout,"outputTxt", Modifier.PRIVATE, EditText.class, true);
       testField(layout,"unitOri", Modifier.PRIVATE, Spinner.class,true);
       testField(layout,"unitConv", Modifier.PRIVATE, Spinner.class,true);
       testField(layout,"unitType", Modifier.PRIVATE, RadioGroup.class,true);
       testField(layout,"roundBox", Modifier.PRIVATE, CheckBox.class,true);
       testField(layout,"formBox", Modifier.PRIVATE, CheckBox.class,true);
       testField(layout,"imgView", Modifier.PRIVATE, ImageView.class,true);
   }

    @Test
    public void check_02_Methods_Availability() {
        Class[] params;
        params = new Class[4];
        params[0] = String.class;
        params[1] = String.class;
        params[2] = String.class;
        params[3] = double.class;
        testMethod(layout,"convertUnit",Modifier.PROTECTED,params,double.class);

        params = new Class[2];
        params[0] = double.class;
        params[1] = boolean.class;
        testMethod(layout,"strResult",Modifier.PROTECTED,params,String.class);
    }

    @Test
    public void check_03_convertUnit() {
        double value = getRandomDouble(0,5000);

        Temperature temp = new Temperature();
        testItem(layout.convertUnit("Temperature","°F", "K",value),temp.convert("°F", "K",value),"Test of converting temperature is failed!!",1);
        testItem(layout.convertUnit("Temperature","K", "°C",value),temp.convert("K", "°C",value),"Test of converting temperature is failed!!",1);

        Distance dist = new Distance();
        testItem(layout.convertUnit("Distance","Mtr", "Mil",value),dist.convert("Mtr", "Mil",value),"Test of converting distance is failed!!",1);
        testItem(layout.convertUnit("Distance","Mil", "Ft",value),dist.convert("Mil", "Ft",value),"Test of converting distance is failed!!",1);
        testItem(layout.convertUnit("Distance","Inc", "Mtr",value),dist.convert("Inc", "Mtr",value),"Test of converting distance is failed!!",1);

        Weight weight = new Weight();
        testItem(layout.convertUnit("Weight","Grm", "Pnd",value),weight.convert("Grm", "Pnd",value),"Test of converting weight is failed!!",1);
        testItem(layout.convertUnit("Weight","Pnd", "Onc",value),weight.convert("Pnd", "Onc",value),"Test of converting weight is failed!!",1);
    }

    @Test
    public void check_04_strResult() {
        double value = getRandomDouble(0,5000);
        DecimalFormat f = new DecimalFormat("#.##");
        testItem(layout.strResult(value,true), f.format(value),"Test of rounded string conversion is failed!!",1);
        //String x = layout.strResult(value,false);
        DecimalFormat f2 = new DecimalFormat("#.#####");
        testItem(layout.strResult(value,false), f2.format(value),"Test of double to string conversion is failed!!",1);
    }
}
