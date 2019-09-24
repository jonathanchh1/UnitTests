package com.Mockito

import com.emi.mockitos.Data
import com.emi.mockitos.Manager
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AnswerTest {


    @Test
    fun checkFetchDataObjectAndReturnValue(){
        val spy = spy(Data::class.java)
        val manager = Manager(spy)

        assertEquals(" 0", manager.fetchData())
        assertEquals("message 0", manager.fetchDataWithMessage("message"))

        doAnswer {
            spy.number++
            spy.text = it.arguments[0] as String
            return@doAnswer spy.getInfo()
        }.`when`(spy).getInfo(ArgumentMatchers.anyString())

        assertEquals("message 1", manager.fetchDataWithMessage("message"))
        assertEquals("message 1", manager.fetchData())
    }

}