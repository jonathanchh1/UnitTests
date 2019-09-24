package com.emi.unittests.Espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.emi.unittests.MainActivity
import com.emi.unittests.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EspressoTest{

    @get:Rule
    var activityRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun changeTextInFromEditTest(){
        onView(withId(R.id.edit_tester)).perform(typeText("reader"))
        onView(withId(R.id.headline)).check(matches(withText("This is our favorite demo!")))
            .check(matches(isDisplayed()))
        onView(withId(R.id.sign_in)).perform(click())

    }

}