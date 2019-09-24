package com.Mockito.init

import com.emi.mockitos.Data
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

class InitMockRuleTest {

    @Mock
    var obj : Data? =null

    @get:Rule
    var mockitoRule = MockitoJUnit.rule()

    @Test
    fun checkisObjectInitalized(){
        assertNotNull(obj)
    }
}