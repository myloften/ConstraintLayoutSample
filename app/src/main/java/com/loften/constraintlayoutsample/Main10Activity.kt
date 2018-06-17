package com.loften.constraintlayoutsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main10.*
import kotlinx.android.synthetic.main.template_1.*

class Main10Activity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View?) {
        template5.setContentId(view!!.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        init()
    }

    private fun init(){
        img1.setOnClickListener(this)
        bt1.setOnClickListener(this)
        bt2.setOnClickListener(this)
        bt3.setOnClickListener(this)
    }
}
