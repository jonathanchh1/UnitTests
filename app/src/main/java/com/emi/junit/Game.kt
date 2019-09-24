package com.emi.junit



class Game {

    private var redTeam = mutableListOf<String>()
    private var blueTeam = mutableListOf<String>()
    private var blueGoal = 0
    private var redGoal = 0
    private var startedGame = false




    fun start(){
        if(!startedGame && teamSizeEquals()){
            startedGame = true
            blueGoal = 0
            redGoal = 0
        }
    }
    fun stop(){
       if(startedGame){
           startedGame = false
       }
    }


    fun clearTeams(){
        redTeam.clear()
        blueTeam.clear()
    }

    fun addPlayer(team: Team, player: String) : Boolean{
        if(allowToAddPlayer(player)){
            when(team){
                Team.BLUE -> blueTeam.add(player)
                Team.RED -> redTeam.add(player)
            }
            return true
        }
        return false
    }

    fun removePlayer(player: String) : Boolean{
        if(allowToRemovePlayer(player)) {
            if (redTeam.contains(player)) redTeam.remove(player)
            else {
                blueTeam.remove(player)
            }
            return true
        }
        return false
    }


    fun goal(team : Team){
        when(team){
            Team.RED -> {redGoal++}
            Team.BLUE -> {blueGoal++}
        }
    }

    fun getScore() : String{
        return "RED $redGoal:$blueGoal BLUE"
    }

    fun getRedTeam() : List<String>{
        return redTeam
    }
   fun getBlueTeam() : List<String>{
       return blueTeam
    }

    fun hasStarted() : Boolean {
        return startedGame
    }

    private fun allowToAddPlayer(player: String) : Boolean {
        return !startedGame && (!redTeam.contains(player) && (!blueTeam.contains(player)))
    }

   private fun allowToRemovePlayer(player: String) : Boolean {
        return !startedGame && (!redTeam.remove(player) || (!blueTeam.remove(player)))
    }
   private fun teamSizeEquals() : Boolean {
        return redTeam.size != 0 && blueTeam.size != 0 && redTeam.size == blueTeam.size
    }

    enum class Team{
        RED,
        BLUE
    }

}