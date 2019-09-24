package com.emi.unittests.JunitSetUp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.emi.junit.GameActivity
import com.emi.unittests.R
import junit.framework.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InstrumentedTest {

    @Rule @JvmField
    val activityRule : ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)

    @Test
    fun checkStringResourceFromContext(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("UnitTests", appContext.getString(R.string.app_name))
    }

    @Test
    fun startAndGameFromActivity(){
        activityRule.activity.initDefaultGame()
        activityRule.activity.startGame()
        assertTrue(activityRule.activity.isGameRunning())
        activityRule.activity.stopGame()
        assertFalse(activityRule.activity.isGameRunning())
        activityRule.activity.clearGame()
    }



}
