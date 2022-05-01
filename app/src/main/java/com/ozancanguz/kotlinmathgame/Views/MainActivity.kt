package com.ozancanguz.kotlinmathgame.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ozancanguz.kotlinmathgame.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var addition:Button
    lateinit var substraction:Button
    lateinit var multiplication:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition=buttonAdd
        substraction=buttonSub
        multiplication=ButtonMultip

        addition.setOnClickListener {
            var intent= Intent(this, AddActivity::class.java)
            startActivity(intent)


        }

        substraction.setOnClickListener {
            var intent= Intent(this, SubActivity::class.java)
            startActivity(intent)
        }

        multiplication.setOnClickListener {
            var intent= Intent(this, MultiActivity::class.java)
            startActivity(intent)
        }

    }
}