package com.robotest

import android.os.Build.VERSION_CODES.*
import com.emi.unittests.MainActivity
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_robo.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [27])
class ConfigurationTest {

    lateinit var activity : MainActivity

    @Before
    fun init(){
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        activity = controller.create().get()
    }

    @Test
    fun checkViewValuesOnLollipopAbove(){
        assertEquals("title", activity.title_view.text)
        assertEquals("action", activity.robo_button.text)
    }

    @Config(minSdk = KITKAT, maxSdk = LOLLIPOP)
    @Test
    fun checkViewValuesonMinSdkAndMax(){
        assertEquals("title", activity.title_view.text)
        assertEquals("action", activity.robo_button.text)
    }

    @Config(sdk = [0, O_MR1, P])
    @Test
    fun checkViewsValuesOreoAndPie(){
        assertEquals("title", activity.title_view.text)
        assertEquals("action", activity.robo_button.text)
    }

}
