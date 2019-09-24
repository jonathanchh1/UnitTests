package com.robotest

import com.emi.unittests.MainActivity
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.activity_robo.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadow.api.Shadow.extract

@RunWith(RobolectricTestRunner::class)
@Config(shadows = arrayOf(CustomShadowTextView::class))
class ShadowText{


    @Test
    fun shadowCustomClassImplicit(){
        val controller = Robolectric.buildActivity(MainActivity::class.java)
            .create().start().resume().visible().get()
        val view = controller.title_view
        view.isEnabled = false
        assertEquals(0.5F, view.alpha)
    }


    @Test
    fun shadowCustomClassExplicit(){
        val activity = Robolectric.buildActivity(MainActivity::class.java)
            .create().start().resume().visible().get()
        val view = extract(activity.title_view) as CustomShadowTextView
        view.setEnabled(false)
        assertEquals(0.5f, view.getAlpha())
    }
}