package com.emi.mockitos

class Manager(val data : Data){

    fun fetchData() : String{
        return data.getInfo()
    }

    fun fetchDataWithMessage(msg : String) : String{
        return data.getInfo(msg)
    }

}