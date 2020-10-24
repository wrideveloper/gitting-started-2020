package org.aplas.basicappx;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB1BasicActivityX062 extends ViewTest {
    private MainActivity activity;

    @Before
    public void initTest() {
        startActivity();
    }

    private void startActivity() throws NullPointerException, ClassCastException {
        /****** initiation of Test ******/
        //Robolectric Pack
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void check_01_RadioGroupChange() { //Check Layout Specification
        RadioGroup unitType = (RadioGroup) activity.findViewById(R.id.radioGroup);
        ElementTest oriComp = new ElementTest((Spinner)activity.findViewById(R.id.oriList));
        ElementTest convComp = new ElementTest((Spinner)activity.findViewById(R.id.convList));
        ElementTest imgComp = new ElementTest((ImageView)activity.findViewById(R.id.img));

        EditText inputText = (EditText)activity.findViewById(R.id.inputText);
        EditText outputText = (EditText)activity.findViewById(R.id.outputText);

        inputText.setText("100");
        outputText.setText("200");
        ((RadioButton)unitType.getChildAt(1)).setChecked(true);
        imgComp.testImageSrc("distance");
        String distList = "Mtr,Inc,Mil,Ft";
        oriComp.testSpinnerContent(distList);
        convComp.testSpinnerContent(distList);
        testItem("0",inputText.getText().toString(),"Input text should be 0",1);
        testItem("0",outputText.getText().toString(),"Output text should be 0",1);

        inputText.setText("100");
        outputText.setText("200");
        ((RadioButton)unitType.getChildAt(2)).setChecked(true);
        imgComp.testImageSrc("weight");
        distList = "Grm,Onc,Pnd";
        oriComp.testSpinnerContent(distList);
        convComp.testSpinnerContent(distList);
        testItem("0",inputText.getText().toString(),"Input text should be 0",1);
        testItem("0",outputText.getText().toString(),"Output text should be 0",1);

        inputText.setText("100");
        outputText.setText("200");
        ((RadioButton)unitType.getChildAt(0)).setChecked(true);
        imgComp.testImageSrc("temperature");
        distList = "°C,°F,K";
        oriComp.testSpinnerContent(distList);
        convComp.testSpinnerContent(distList);
        testItem("0",inputText.getText().toString(),"Input text should be 0",1);
        testItem("0",outputText.getText().toString(),"Output text should be 0",1);
    }

}
