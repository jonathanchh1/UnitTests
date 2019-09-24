package com.emi.unittests.Espresso

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.runner.AndroidJUnit4
import com.emi.unittests.MainActivity
import com.emi.unittests.MainActivity.Companion.Demo
import com.emi.unittests.MainActivity.Companion.sms_body
import com.emi.unittests.R
import org.hamcrest.CoreMatchers.allOf
import org.jetbrains.annotations.TestOnly
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActionViewTest{

    @get:Rule
    val intentRule : IntentsTestRule<MainActivity> = IntentsTestRule(MainActivity::class.java)
    @Test
    fun verifyNavigationToSecondActivity(){
        onView(withId(R.id.headline))
            .check(matches(withText("This is our favorite demo!")))

        onView(withId(R.id.sign_in)).perform(click())
        intended(allOf(
            hasComponent(hasShortClassName(".SecondActivity")),
            toPackage("com.emi.unittests"),
            hasExtra("test", Demo)
        ))

    }

    @TestOnly
    fun verifySmsTest(){
        onView(withId(R.id.sign_out)).perform(click())
        intended(allOf(
            hasAction(Intent.ACTION_VIEW),
           hasData(Uri.parse("sms:")),
            hasExtra("sms_body", sms_body)
        ))
    }

}