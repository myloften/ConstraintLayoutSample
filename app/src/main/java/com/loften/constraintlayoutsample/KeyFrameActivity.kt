package com.loften.constraintlayoutsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.Fade
import android.support.transition.TransitionManager
import android.view.View

class KeyFrameActivity : AppCompatActivity() {

    private lateinit var constraintLayout: ConstraintLayout
    private val constraintSet1 = ConstraintSet()
    private val constraintSet2 = ConstraintSet()
    private var mOld = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.keyframe1)
        constraintLayout = findViewById(R.id.constraint_layout)
        constraintSet1.clone(constraintLayout)
        constraintSet2.clone(this, R.layout.keyframe2)
    }

    public fun onApplyClick(view: View){
        TransitionManager.beginDelayedTransition(constraintLayout)
        if (!mOld){
            constraintSet1.applyTo(constraintLayout)
        }else {
            constraintSet2.applyTo(constraintLayout)
        }
        mOld = !mOld
    }

}
