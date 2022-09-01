package com.example.quizzapp

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var progressBar: ProgressBar? = null
    private var tvQuestion: TextView? = null
    private var tvOption1: TextView? = null
    private var tvOption2: TextView? = null
    private var tvOption3: TextView? = null
    private var tvOption4: TextView? = null
    private var btnSubmit: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progress_bar)
        tvQuestion = findViewById(R.id.tv_question)
        tvOption1 = findViewById(R.id.option_1)
        tvOption2 = findViewById(R.id.option_2)
        tvOption3 = findViewById(R.id.option_3)
        tvOption4 = findViewById(R.id.option_4)
        btnSubmit = findViewById(R.id.btn_submit)

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuestionsList = Constants.getQuestions()

        setQuestion()
        defaultOptionView()
    }
    @SuppressLint("SetTextI18n")
    private fun setQuestion(){
        defaultOptionView()
        val question: Question= mQuestionsList!![mCurrentPosition -1]
        progressBar?.progress = mCurrentPosition
        tvQuestion?.text = question.question
        tvOption1?.text = question.option_1
        tvOption2?.text = question.option_2
        tvOption3?.text = question.option_3
        tvOption4?.text = question.option_4
        if(mCurrentPosition == mQuestionsList!!.size){
            btnSubmit?.text = "FINISH"
        }
        else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOption1?.let{
            options.add(0, it)
        }
        tvOption2?.let{
            options.add(1, it)
        }
        tvOption3?.let{
            options.add(2, it)
        }
        tvOption4?.let{
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD_ITALIC)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_1 -> {
                tvOption1?.let{
                    selectedOptionView(it, 1)
                }
            }
            R.id.option_2 -> {
                tvOption2?.let{
                    selectedOptionView(it, 2)
                }
            }
            R.id.option_3 -> {
                tvOption3?.let{
                    selectedOptionView(it, 3)
                }
            }
            R.id.option_4 -> {
                tvOption4?.let{
                    selectedOptionView(it, 4)
                }
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correct != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        answerView(mSelectedOptionPosition, R.drawable.correct_option_border_bg)
                    }

                    if(mCurrentPosition == mQuestionsList!!.size){
                        btnSubmit?.text = "FINISH"
                    }else{
                        btnSubmit?.text = "NEXT"
                    }
                    mSelectedOptionPosition =0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                tvOption1?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tvOption2?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tvOption3?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tvOption4?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
}