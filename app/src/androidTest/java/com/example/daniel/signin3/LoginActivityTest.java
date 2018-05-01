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

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void checkButtonClick() {
        Espresso.onView(withId(R.id.Email)).perform(typeText("rodriguezdl@mymail.vcu.edu"), closeSoftKeyboard());
        Espresso.onView(withId(R.id.Password)).perform(typeText("Brasi1eiro"));
        Espresso.onView(withId(R.id.Login)).perform(click());
    }//Should provide authenticated imput and go to home screen

    @Test
    public void checkForgotPassword() {
        Espresso.onView(withId(R.id.forgot)).perform(click());
    }//Should lead to forgot pass word age (should pass)

    @Test
    public void checkButtonRegister() {
        Espresso.onView(withId(R.id.newMem)).perform(click());
    }//TestPass

    @Test
    public void wrongCred() {
        try{
        Espresso.onView(withId(R.id.Email)).perform(typeText("Rodriguezdl@gmail.com"));
        Espresso.onView(withId(R.id.Password)).perform(typeText("wrongpass"));
        Espresso.onView(withId(R.id.Login)).perform(click());
        fail("Not allowed");}
        catch (IllegalArgumentException e){

        }
    }//Test should fail due to wrong credentials

    @Test
    public void allNumCred() {
        try {
            Espresso.onView(withId(R.id.Email)).perform(typeText("1234567"));
            Espresso.onView(withId(R.id.Password)).perform(typeText("56789"));
            Espresso.onView(withId(R.id.Login)).perform(click());
            fail("Should not be allowed");
        } catch (IllegalArgumentException e){
        }
    }

    }//Test should fail due to invaild credentials










