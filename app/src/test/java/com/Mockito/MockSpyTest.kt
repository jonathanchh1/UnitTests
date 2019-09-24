package com.Mockito

import com.emi.mockitos.Data
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MockSpyTest{


    @Mock
    var mock : Data?=null

    @Spy
    var spy : Data?=null


    @Test
    fun checkIsObjectInitialized(){
        assertNotNull(mock)
        assertNotNull(spy)
        mock?.text = "mock"
        spy?.text = "spy"
     //   assertEquals("mock", mock?.text)) will return null, spy is efficient with this type of initialization
        assertEquals("spy", spy?.text)
    }
}