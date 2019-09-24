package com.Mockito

import com.emi.mockitos.Data
import com.emi.mockitos.Manager
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import java.lang.IllegalArgumentException

@RunWith(MockitoJUnitRunner::class)
class ConfigurationTest {


    @Mock
    lateinit var mock : Data

    @Spy
    lateinit var spy : Data

    lateinit var manager : Manager

    @Before
    fun init(){
        manager = Manager(mock)
    }

    @Test
    fun checkFetchDataReturnsMockValue(){
        assertNull(manager.fetchData())
        `when`(mock.getInfo()).thenReturn("mock")
      //  assertNull(manager.fetchData()) it will fail if you call it before it will return mock when null is expected
        assertEquals("mock", manager.fetchData())
    }

    @Test
    fun checkFetchDataReturnsMultipleValues(){
        assertNull(manager.fetchData())
        `when`(mock.getInfo()).thenReturn("mock1", "mock2", "mock3")
        // assertNull(manager.fetchData()) will fail because data is already added
        assertEquals("mock1", manager.fetchData())
        assertEquals("mock2", manager.fetchData())
        assertEquals("mock3", manager.fetchData())
    }

    @Test
    fun checkFetchDataTakesMultipleReturnValues(){
        manager = Manager(spy)
        doReturn("spy with arg").`when`(spy).getInfo("args1")
        doReturn("spy with arg").`when`(spy).getInfo("args2")
        assertEquals("spy with arg", manager.fetchDataWithMessage("args1"))
        assertEquals("spy with arg", manager.fetchDataWithMessage("args2"))
    }

    @Test
    fun checkInfoForWrappersReturnedValue(){
        val data = Data()
        val spyData = Mockito.spy(data)
        manager = Manager(spyData)
        doReturn("wrapper data").`when`(spyData).getInfo()
        assertEquals("wrapper data", manager.fetchData())
    }

    @Test
    fun checkFetchDataWithArgsReturnedMockValues(){
        Mockito.`when`(mock.getInfo("args")).thenReturn("mock with args", "mock with args2")

        assertEquals("mock with args", manager.fetchDataWithMessage("args"))
        assertEquals("mock with args2", manager.fetchDataWithMessage("args"))
        Mockito.`when`(mock.getInfo(ArgumentMatchers.anyString())).thenReturn("mock with args")
        assertEquals("mock with args", manager.fetchDataWithMessage("args"))

    }

   @Test(expected = IllegalArgumentException::class)
   fun checkFetchDataThrowExceptionForSpecialArgs(){
       `when`(mock.getInfo("@")).thenThrow(IllegalArgumentException())
       manager.fetchDataWithMessage("@")
   }
}