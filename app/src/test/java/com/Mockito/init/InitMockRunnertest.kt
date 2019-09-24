package com.Mockito.init

import com.emi.mockitos.Data
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InitMockRunnertest {

    @Mock
    var obj : Data?=null

    @Test
    fun checkisObjectInitialized(){
        assertNotNull(obj)
    }
}