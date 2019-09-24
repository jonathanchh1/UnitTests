package com.emi.unittests.JunitSetUp

import androidx.test.filters.MediumTest
import androidx.test.filters.RequiresDevice
import androidx.test.filters.SdkSuppress
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.emi.unittests.R
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilterInstrumentedTest{

    @MediumTest @SdkSuppress(minSdkVersion = 21) @RequiresDevice
    @Test
    fun checkAppTitle(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("Game", appContext.getString(R.string.app_name))
    }

    @SmallTest @SdkSuppress(maxSdkVersion = 20) @RequiresDevice
    @Test
    fun checkOldAppTitle(){
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("Game Old", appContext.getString(R.string.app_name) )
    }
}