package com.Mockito

import com.emi.mockitos.Data
import com.emi.mockitos.Manager
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InjectMockTest{


    @Mock
    var mock : Data?=null

    //constructor requires Data args
    @InjectMocks
    var manager : Manager?=null

    @Test
    fun checkIsManagerInitialized(){
        assertNotNull(mock)
        assertNotNull(manager)
    }


    @Test
    fun checkIsManager2Intialized(){
        val manager2 = Manager(mock!!)
        assertNotNull(mock)
        assertNotNull(manager2)
    }
}