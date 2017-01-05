package com.example.dandancao.robotium;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.junit.Before;
import org.junit.Test;
/**
 * Created by Dandan.Cao on 2016/12/30.
 */
public class MyApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private static Solo solo=null;
    boolean tag = false;
    private static int run = 0;
    private static final int NUMBER_TOTAL_CASES = 2;
    public MyApplicationTest() {
        super(MainActivity.class);
    }
    @Before
    public void setUp() throws Exception {
        super.setUp();
        if (solo==null){
            MyApplicationTest.solo = new Solo(getInstrumentation(), getActivity());}
    }
    @Test
    public void testInputText() {
        if (tag) {
            for (int i = 0; i < 10; i++) {     //循环执行1条用例
                judgeText("This is EditTextActivity",1000);
                solo.clearEditText(0);  // 清空EditText表单 clearEditText(int index)
            }
        } else {
            judgeText("This is EditTextActivity",1000);
        }
    }

    @Test
    public void testInputText2() {
        judgeText("This is EditTextActivity2",1000);
    }

    private void judgeText( String text2, int time) {
        solo.clickOnButton(getActivity().getString(R.string.btn_change));
        assertTrue("test",solo.searchEditText(text2));//判定结果
        solo.sleep(time);
    }

    public void tearDown() throws Exception {
        //Check whether it's the last case executed.
        run += countTestCases();
        try {
            if(run >= NUMBER_TOTAL_CASES) {
                this.solo.finishOpenedActivities();}
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }
}

