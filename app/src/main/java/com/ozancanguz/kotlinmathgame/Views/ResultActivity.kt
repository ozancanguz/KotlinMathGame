package com.ozancanguz.kotlinmathgame.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ozancanguz.kotlinmathgame.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    lateinit var TextScoreText:TextView
    lateinit var congrats:TextView
    lateinit var playagainButton:Button
    lateinit var exitbutton:Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score=intent.getIntExtra("Score",0)
        TextScoreText.text="$score"



        TextScoreText=TextScore
        congrats=textView2
        playagainButton=playagainbutton
        exitbutton=exitButton

        playagainButton.setOnClickListener {

            var intent= Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()

        }

        exitbutton.setOnClickListener {

            val intent=Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }




    }
}