package org.aplas.basicappx;

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

public class TestB1BasicActivityX061 extends ViewTest {
    private MainActivity activity;
    ResourceTest rsc;

    @Before
    public void initTest() {
        activity = Robolectric.buildActivity(MainActivity.class).create().get();
        rsc = new ResourceTest(activity.getResources());
    }

    @Test
    public void check_01_StringArray_Distance() {
        String[] expected = "Mtr,Inc,Mil,Ft".split("\\,");
        rsc.testStringArrayResource("distList",expected);
    }

    @Test
    public void check_02_StringArray_Weight() {
        String[] expected = "Grm,Onc,Pnd".split("\\,");
        rsc.testStringArrayResource("weightList",expected);
    }

    @Test
    public void check_03_Image_Resources() {
        rsc.testImgResource("distance");
        rsc.testImgResource("weight");
    }
}
