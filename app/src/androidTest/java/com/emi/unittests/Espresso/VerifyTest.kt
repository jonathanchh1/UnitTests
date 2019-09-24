package com.emi.unittests.Espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.emi.unittests.MainActivity
import com.emi.unittests.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VerifyTest {

    @get:Rule
    var activityRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun verifyHideTextViewHideTextTyped(){
        onView(withId(R.id.edit_tester)).perform(typeText("yes sms"))
    }
}