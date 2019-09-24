package com.emi.roboelectric

import android.app.Service
import android.content.Intent
import android.os.IBinder

class BoundsServices : Service(){

    var bound = false
    override fun onBind(p0: Intent?): IBinder? {
        bound = true
        return null
    }

    override fun onUnbind(intent: Intent?): Boolean {
        bound = false
        return super.onUnbind(intent)
    }
}