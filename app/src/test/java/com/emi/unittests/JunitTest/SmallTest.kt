package com.emi.unittests.JunitTest

import com.emi.junit.Game
import junit.framework.Assert.assertFalse
import org.junit.Test

class SmallTest{

    @Test
    fun startGameWithDifferentTeamsSize(){
        val game = Game()
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Dannie")
        game.start()
        assertFalse(game.hasStarted())
    }
}