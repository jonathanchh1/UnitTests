package com.emi.unittests.Espresso

import android.widget.TextView
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.emi.unittests.MainActivity
import com.emi.unittests.R
import junit.framework.Assert.assertEquals
import org.hamcrest.CoreMatchers.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AccessViewTest {

    @get:Rule
    var activityRule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)


    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().context
        assertEquals("com.emi.unittests.test", appContext.packageName)
    }
    @Test
    fun changeTextFromViewAccess(){


        onView(allOf((withId(R.id.headline)), instanceOf(TextView::class.java)))
            .check(matches(withText("This is our favorite demo!")))
        onView(withId(R.id.edit_tester)).perform(typeText("reader"))

    }
    @Test
    fun changeTextFromAdapterViewAccess(){
        onData(anything())
            .inAdapterView(withId(R.id.data_list))
            .atPosition(0)
            .perform(click())

        onView(withId(R.id.headline))
            .check(matches(withText("Nigeria")))
    }

    @Test
    fun clickButtonTest(){

        onView(withId(R.id.sign_in))
            .perform(click())

        onView(withId(R.id.sign_out))
            .perform(click())
    }
}