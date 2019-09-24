package com.Mockito.init

import com.emi.mockitos.Data
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.mock

class InitMockMethodTest {

    @Test
    fun checkIsObjectIntialized(){
        val obj = mock(Data::class.java)
        assertNotNull(obj)
    }
}