package com.chisw.rxjavakasilovtasks.ui.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewAnimationUtils
import com.chisw.rxjavakasilovtasks.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val cx = it.width / 2
                val cy = it.height / 2
                val radius = it.width
                val anim = ViewAnimationUtils
                        .createCircularReveal(it, cx, cy, radius.toFloat(), 0f)
                anim.addListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        it.visibility = View.INVISIBLE
                        startTaskOneActivity()
                        Handler().postDelayed({
                            button.visibility = View.VISIBLE
                        }, 2_000)
                    }
                })
                anim.start()
            }

        }

    }

    private fun startTaskOneActivity() {
        startActivity(TaskActivity.newInstance(this))
    }

}
