package com.example.daniel.signin3;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.notification.Failure;

import android.support.test.espresso.Espresso;

import android.support.test.rule.ActivityTestRule;
//import android.support.test.runner.AndroidUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.fail;

public class RegisterTest {
    @Rule
    public ActivityTestRule<Register> mActivityRule = new ActivityTestRule<>(Register.class);

    @Test
    public void emailReg(){
        Espresso.onView(withId(R.id.emailReg)).perform(typeText("daniellago123@gmail.com"));
        Espresso.onView(withId(R.id.PassReg)).perform(typeText("HiMyNameIsDaniel"));
        Espresso.onView(withId(R.id.Register)).perform(click());
}//Should allow for registration (test should pass)

    @Test
    public void regExistantEmail(){
        try{
            Espresso.onView(withId(R.id.emailReg)).perform(typeText("rodriguezdl@mymail.vcu.edu"));
            Espresso.onView(withId(R.id.PassReg)).perform(typeText("yada yada"));
            Espresso.onView(withId(R.id.Register)).perform(click());
            fail("Not allowed");
        }catch (IllegalArgumentException e){

        }
    }//Should not allow for registration because email is already registered





}
