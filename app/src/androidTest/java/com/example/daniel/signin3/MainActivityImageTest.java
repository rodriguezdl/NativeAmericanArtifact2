package com.example.daniel.signin3;

import android.support.test.espresso.Espresso;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityImageTest {

    @Rule
    public ActivityRule<MainActivityImage> mActivityRule = new ActivityRule(MainActivityImage.class);
    public DrawableMatcher drawableMatcher = new DrawableMatcher(1);

    @Test
    public void listGoesOverTheFold() {
        Espresso.onView(withText("Main Activity Image")).check(matches(isDisplayed()));
    }

    @Test
    public void testButton1(){
        Espresso.onView(withId(R.id.selectimage))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed()));

    }

    public void testButton2(){
        Espresso.onView(withId(R.id.button2))            // withId(R.id.my_view) is a ViewMatcher
                .perform(click())               // click() is a ViewAction
                .check(matches(isDisplayed()));

    }

    




}
