package com.robotest


import com.emi.roboelectric.BoundsServices
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ServiceTest {


    @Test
    fun checkSomeServicesProperBind(){
        val services = Robolectric.buildService(BoundsServices::class.java).get()
        assertTrue(services.bound)
        services.onUnbind(null)
        assertFalse(services.bound)
    }
}