package com.emi.unittests.JunitTest

import com.emi.junit.Game
import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

class FullTest {

    val game = Game()

    @Before
    fun init(){
        game.clearTeams()
    }

    @After
    fun uninit(){
        game.stop()
    }

    @Ignore
    fun startGameWithDifferentTeamsSize(){
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "Jack")
        game.addPlayer(Game.Team.BLUE, "Jim")
        game.start()
        assertFalse(game.hasStarted())
    }


    @Test(timeout = 1000) //if after 1000ms when the test couldn't finish. fail it
    fun startAndStopGame(){
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "Jim")
        game.start()
        assertTrue(game.hasStarted())
        game.stop()
        assertFalse(game.hasStarted())
    }

    @Test
    fun modifyTeamsAndStartGame(){
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.start()
        assertFalse(game.hasStarted())
        game.removePlayer("William")
        game.start()
        assertTrue(game.hasStarted())
    }
}