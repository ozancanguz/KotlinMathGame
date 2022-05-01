package com.ozancanguz.kotlinmathgame.Views

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.ozancanguz.kotlinmathgame.R
import kotlinx.android.synthetic.main.activity_add.*
import java.util.*
import kotlin.random.Random

class AddActivity : AppCompatActivity() {

         lateinit var textScore:TextView
         lateinit var textLife:TextView
         lateinit var textTime:TextView

         lateinit var textQuestion:TextView
          lateinit var editTextAnswers:EditText

          lateinit var buttonOk:Button
          lateinit var buttonNext:Button
          var correctAnswer=0
            var  userLife=3
            var userscore=0

    lateinit var timer:CountDownTimer
    private val startTimerInMillis:Long=20000
    var timeLeftInMillis:Long=startTimerInMillis


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        textScore = textViewscore
        textLife = textViewlife
        textTime = textViewtime

        textQuestion = textViewquestion
        editTextAnswers = editTextAnswer

        buttonOk = okeyButton
        buttonNext = NextButton

        gameContinue()

        buttonOk.setOnClickListener {

            var input=editTextAnswers.text.toString()

            if(input==" "){
                Toast.makeText(applicationContext," Sayi giriniz !",Toast.LENGTH_LONG)
                    .show()
            }
            else{

                pauseTimer()

                 var userAnswer=input.toInt()

                if(userAnswer==correctAnswer){
                   userscore=userscore+10
                    textQuestion.text=" Tebrikler doğru bildiniz"
                    textView5.text=  userscore.toString()

                }
                else{
                    userLife--

                    textQuestion.text="Opps yanlış cevap"
                   textView3.text=userLife.toString()

                }





            }

        }

        buttonNext.setOnClickListener {

            pauseTimer()
            resetTimer()
            gameContinue()
            editTextAnswers.setText("")

            if(userLife==0){

                Toast.makeText(this,"Oyun bitti ",Toast.LENGTH_SHORT)
                    .show()
               val intent=Intent(this@AddActivity, ResultActivity::class.java)
                 intent.putExtra("Score",userscore)
                startActivity(intent)
                finish()

            }else{

                gameContinue()



            }

        }
    }

    @SuppressLint("SetTextI18n")
    fun gameContinue(){

        var number1= Random.nextInt(0,40)
        var number2= Random.nextInt(0,40)

        textQuestion.text="$number1 + $number2"

        correctAnswer=number1+number2

        startTimer()

    }

     fun startTimer(){

         timer=object :CountDownTimer(timeLeftInMillis,1000){
             override fun onTick(millisUntilFinished:Long) {

                 timeLeftInMillis=millisUntilFinished
                 updateText()


             }



             override fun onFinish() {
                  pauseTimer()
                   resetTimer()
                 updateText()

                 userLife--
                 textLife.text=userLife.toString()
                 textQuestion.text="Zaman bitti "


             }



         }.start()

     }
    private fun resetTimer() {

        timeLeftInMillis=startTimerInMillis
    }

    private fun pauseTimer() {

        timer.cancel()

    }
    private fun updateText() {
        val remainingTime:Int=(timeLeftInMillis/1000).toInt()
        textView.text=String.format(Locale.getDefault(),"%02d",remainingTime)

    }


}