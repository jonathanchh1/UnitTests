package com.emi.unittests.JunitTest

import com.emi.junit.Game
import com.emi.unittests.JunitTest.PrintTestRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class RuleTest {

    @Rule @JvmField
    val rule = PrintTestRule()

    val game = Game()

    @Test
    fun addPlayerWithSameNameToTheSameTeam(){
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.RED, "Jack")
        game.addPlayer(Game.Team.RED, "William")
        assertEquals(3, game.getRedTeam().size)
    }

    @Test
    fun addPlayerwithSameNameTotheSameTeam(){
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "William")
        assertEquals(1, game.getBlueTeam().size)
    }
}