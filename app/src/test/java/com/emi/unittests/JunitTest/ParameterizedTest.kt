package com.emi.unittests.JunitTest

import com.emi.junit.Game
import junit.framework.Assert.assertEquals
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParameterizedTest(val redGoals : Int, val blueGoals : Int, val scores : String){


    companion object {
        val game = Game()

        @BeforeClass
        @JvmStatic
        fun initTeams() {
            game.addPlayer(Game.Team.BLUE, "Jim")
            game.addPlayer(Game.Team.BLUE, "William")
            game.addPlayer(Game.Team.RED, "Jack")
            game.addPlayer(Game.Team.RED, "Johnnie")
        }

        @AfterClass
        @JvmStatic
        fun uninitTeam() {
            game.clearTeams()
        }

        @Parameterized.Parameters
        @JvmStatic
        fun createData(): Collection<Array<Any>> {
            return listOf(
                arrayOf(0, 2, "RED 0:2 BLUE"),
                arrayOf(10, 5, "RED 10:5 BLUE"),
                arrayOf(3, 3, "RED 3:3 BLUE")
            )
        }
    }

        @Test
        fun scoreAndCheckResultWithParameterized(){
            game.start()
            repeat(redGoals){
                game.goal(Game.Team.RED)
            }
            repeat(blueGoals){
                game.goal(Game.Team.BLUE)
            }
            assertEquals(scores, game.getScore())
            game.stop()
        }

    @Test
    fun scoreAndCheckResultNorma(){
        game.start()
        repeat(2){
            game.goal(Game.Team.BLUE)
        }
        assertEquals("RED 0:2 BLUE", game.getScore())
        game.stop()

        game.start()
        repeat(10){
            game.goal(Game.Team.RED)
        }
        repeat(5){
            game.goal(Game.Team.BLUE)
        }
        assertEquals("RED 10:5 BLUE", game.getScore())
        game.stop()

        game.start()
        repeat(3){
            game.goal(Game.Team.RED)
        }
        repeat(3){
            game.goal(Game.Team.BLUE)
        }
        assertEquals("RED 3:3 BLUE", game.getScore())
        game.stop()
    }

}