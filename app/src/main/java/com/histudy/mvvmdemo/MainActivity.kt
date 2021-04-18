package com.histudy.mvvmdemo

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.os.Bundle
import android.util.Log
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by lingyu on  2021/3/25
 *
 * description:
 */
class MainActivity:AppCompatActivity() {



    lateinit var dashBoardView: DashBoardView

    lateinit var imageTextView: ImageTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dashBoardView = findViewById(R.id.dashBoardView)
        imageTextView = findViewById(R.id.image_textview)


        var animator = ObjectAnimator.ofObject(dashBoardView,"progress",IntTypeEvaluator(),0,100)
        animator.duration  = 3000
        animator.startDelay = 1000
        animator.start()
    }

    class IntTypeEvaluator:TypeEvaluator<Int>{
        private  val TAG = "MainActivity"
        override fun evaluate(fraction: Float, startValue: Int, endValue: Int): Int {
            var value = (startValue + (endValue - startValue) * fraction).toInt()
            Log.e(TAG, "evaluate: $value" )
            return value
        }

    }
}