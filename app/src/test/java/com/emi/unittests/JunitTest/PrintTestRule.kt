package com.emi.unittests.JunitTest

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class PrintTestRule : TestRule{

    private lateinit var base : Statement
    private lateinit var desc : Description

    override fun apply(base: Statement, description: Description): Statement {
        this.base = base
        this.desc = description
        return PrintTestStatement(base)
    }

   class PrintTestStatement(private val base : Statement) : Statement(){
       override fun evaluate() {
           println("Log before test action")
           base.evaluate()
           println("Log after test action")
       }
    }
}