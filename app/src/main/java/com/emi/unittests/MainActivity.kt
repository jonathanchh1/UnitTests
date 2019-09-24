package com.emi.unittests

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.ContextMenu
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListAdapter
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object{
        const val NAME = "name"
        const val sms_body = "this is a test message"
        const val phonenumber = "646 468 3333"
        const val Demo = "demo"

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if(headline.text.isNotEmpty()){
            headline.text = getString(R.string.demo)
        }

        if(edit_tester.text.isNotEmpty()){
            edit_tester.setOnClickListener {
                it.show(this, "${edit_tester.text}", Toast.LENGTH_SHORT)
            }
        }

        initListView()
        onClick(constraint)
    }


     fun onClick(view : View){

        sign_in.setOnClickListener {

            it.show(this, "you smacked the sign in button", Toast.LENGTH_SHORT)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("test", Demo)
            startActivity(intent)
        }

        sign_out.setOnClickListener {

            it.show(this, "you smacked the sign out button", Toast.LENGTH_SHORT)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("sms:")
            intent.putExtra("number", phonenumber)
            intent.putExtra("sms_body", sms_body)
            startActivity(intent)

        }
    }
    private fun initListView(){
        val list : List<String> = listOf("Nigeria", "Kenya", "Rwanda", "Cameroon", "Mali", "Ivory Coast", "Haiti")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        data_list.adapter = adapter
        data_list.setOnItemClickListener { adapterView, view, position, id ->  headline.text = adapter.getItem(position) }

    }
    fun View.show(context: Context, msg : CharSequence, length: Int){
        return showToast(context, msg, length) {}
    }

     inline fun View.showToast(
        context : Context,
        msg : CharSequence,
        length : Int,
        show : (Int?) -> Unit){
       return Toast.makeText(context, msg, length).show()
    }
}
