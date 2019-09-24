package com.emi.roboelectric

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.emi.unittests.R
import com.emi.unittests.SecondActivity
import kotlinx.android.synthetic.main.activity_robo.*

class RoboActivity : AppCompatActivity() {

    companion object{

        const val TITLE_KEY = "title"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_robo)

        robo_button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        title_view.text = getString(R.string.sample)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.let {
            if(!it.containsKey(TITLE_KEY)){
                it.putString(TITLE_KEY, getString(R.string.sample))
            }
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.let {
            if(it.containsKey(TITLE_KEY)){
                title_view.text = it.getString(TITLE_KEY)
            }
        }
    }
}
