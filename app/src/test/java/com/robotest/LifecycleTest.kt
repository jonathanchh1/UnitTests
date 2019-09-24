package com.robotest

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import com.emi.roboelectric.RoboActivity.Companion.TITLE_KEY
import com.emi.unittests.MainActivity
import junit.framework.Assert.*
import kotlinx.android.synthetic.main.activity_robo.*
import org.apache.tools.ant.Main
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LifecycleTest{

    private lateinit var activity: MainActivity
    @Test
    fun checkMainActivityhasLifecycle(){
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        activity = controller.create().get()


        assertEquals(Lifecycle.State.CREATED, activity.lifecycle.currentState)

        controller.create()


        assertEquals(Lifecycle.State.STARTED, activity.lifecycle.currentState)
        controller.start()

        assertEquals(Lifecycle.State.RESUMED, activity.lifecycle.currentState)
        controller.resume()

        assertEquals(Lifecycle.State.DESTROYED, activity.lifecycle.currentState)
        controller.destroy()
    }

    @Test
    fun checkMainActivityWorkingLifecycle(){
        val controller = Robolectric.buildActivity(MainActivity::class.java)
        val activity = controller.create().start().resume().visible().get()
        //equivalent of variant val activity = Robolectric.setUpActivity(MainActivity::class.java)

        assertFalse(activity.isFinishing)
        activity.finish()
        assertTrue((activity.isFinishing))
    }


    @Test
    fun checkMainActivityHasWorkingRestoringState(){
        val saveInstanceState = Bundle()
        saveInstanceState.putString(TITLE_KEY, "title data")
        val activity = Robolectric.buildActivity(MainActivity::class.java).restoreInstanceState(saveInstanceState).get()
        assertEquals("title data", activity.title_view.text)

    }
}