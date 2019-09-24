package com.Mockito.init

import com.emi.mockitos.Data
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations


class InitMockAnnotationTest {

    @Mock
    var obj : Data?=null

    @Test
    fun checkIsObjectInitialized(){
        MockitoAnnotations.initMocks(this)
        assertNotNull(obj)
    }


}