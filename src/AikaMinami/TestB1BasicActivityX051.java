package org.aplas.basicappx;

import android.view.View;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.lang.reflect.Modifier;

import androidx.appcompat.app.AlertDialog;

@RunWith(RobolectricTestRunner.class)
@Config(manifest=Config.NONE)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestB1BasicActivityX051 extends ViewTest {
    private MainActivity activity;

    @Before
    public void initTest() {
        /*
        activity = Robolectric.buildActivity(MyActivity.class)
                .create()
                .resume()
                .get();
                */

    }

    @Test
    public void check_01_onCreate() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        testItem(activity, activity,"Activity is null",6 );
        AlertDialog dialog = (AlertDialog) getField(activity,"startDialog");
        testItem(dialog,dialog,"Start Dialog must be null when activity created",5);

        String varName = "convertBtn";
        String rscName = "convertButton";
        View v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "inputTxt";
        rscName = "inputText";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "outputTxt";
        rscName = "outputText";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "unitOri";
        rscName = "oriList";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "unitConv";
        rscName = "convList";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "unitType";
        rscName = "radioGroup";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "roundBox";
        rscName = "chkRounded";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "formBox";
        rscName = "chkFormula";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

        varName = "imgView";
        rscName = "img";
        v = (View)getField(activity,varName);
        testItem(v,v,varName + " is not assigned yet",6);
        testItem(rscName,v.getContext().getResources().getResourceEntryName(v.getId()),varName + " must be assigned to " + rscName + " element",1);

    }

    @Test
    public void check_02_onStart() {
        activity = Robolectric.buildActivity(MainActivity.class).create().start().get();
        testField(activity,"startDialog", Modifier.PRIVATE, AlertDialog.class,false);
        AlertDialog dialog = (AlertDialog) getField(activity,"startDialog");
        testItem(dialog,dialog,"Start Dialog must be built when activity started",6);
        testItem(dialog, dialog.isShowing(),"Start Dialog is now showed",3);
        //dialog.get
    }
}
