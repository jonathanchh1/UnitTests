package com.robotest

import android.app.Application
import android.content.Intent
import com.emi.unittests.MainActivity
import com.emi.unittests.SecondActivity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.android.synthetic.main.activity_robo.*
import org.junit.Before
import org.junit.Test
import org.robolectric.Robolectric
import org.robolectric.Shadows.shadowOf

class SimpleTest {

    lateinit var activity : MainActivity

    @Before
    fun init(){
        activity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun checkViewValues(){
        assertEquals("title", activity.title_view.text)
        assertEquals("action", activity.robo_button.text)
    }


    @Test
    fun clickTextViewChangedTest(){
        activity.title_view.performClick()
        assertEquals("clicked", activity.title_view.text)
    }


    @Test
    fun clickingButtonNavSecondActivity(){
        activity.robo_button.performClick()
        val expectIntent = Intent(activity, SecondActivity::class.java)
        val actual = shadowOf(activity.applicationContext as Application).nextStartedActivity
        assertNotNull(actual)
        assertEquals(expectIntent.component, actual.component)

    }
}