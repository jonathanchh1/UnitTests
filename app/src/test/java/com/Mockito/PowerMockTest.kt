package com.Mockito

import com.emi.mockitos.Data
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.times
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(Data::class, System::class)
class PowerMockTest{

    @Test
    fun checkMockStaticMethod(){
        PowerMockito.mockStatic(System::class.java)
        PowerMockito.`when`(System.currentTimeMillis()).thenReturn(100)
        assertEquals(100, System.currentTimeMillis())
    }

    @Test
    fun checkMockPrivateMethod(){
        val obj = Data()
        val spy : Data = PowerMockito.spy(obj)
        assertEquals("private return from public", spy.publicMethod())
        PowerMockito.doReturn("private mocked").`when`(spy, "privateMethod")
        assertEquals("private mocked", spy.publicMethod())
        PowerMockito.verifyPrivate(spy, times(4)).invoke("privateMethod")
    }

    @Test
    fun checkMockConstructor(){
        val obj = Data()
        assertEquals(0, obj.number)
        assertEquals("", obj.text)
        obj.number = 1
        obj.text = "demo"
        PowerMockito.whenNew(Data::class.java).withNoArguments().thenReturn(obj)
        val newObj = Data()
        assertEquals(1, newObj.number)
        assertEquals("demo", newObj.text)
    }
}