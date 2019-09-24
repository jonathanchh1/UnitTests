package com.emi.junit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emi.unittests.R

class GameActivity : AppCompatActivity() {

    private val game = Game()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }

    fun startGame(){
        game.start()
    }

    fun stopGame(){
        game.stop()
    }

    fun initDefaultGame(){
        game.addPlayer(Game.Team.RED, "Johnnie")
        game.addPlayer(Game.Team.RED, "William")
        game.addPlayer(Game.Team.BLUE, "Jack")
        game.addPlayer(Game.Team.BLUE, "Jim")
    }

    fun isGameRunning() : Boolean{
        return game.hasStarted()
    }

    fun clearGame(){
        game.clearTeams()
    }

}
