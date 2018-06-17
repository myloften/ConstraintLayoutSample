package com.loften.constraintlayoutsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.constraint.solver.widgets.ConstraintWidget
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main11.*

class Main11Activity : AppCompatActivity() {

    private val applyConstraintSet = ConstraintSet()
    private val resetConstraintSet = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)
        applyConstraintSet.clone(constraint_layout)
        resetConstraintSet.clone(constraint_layout)
        init()
    }

    private fun init(){
        bt1.setOnClickListener{
            //切换layout
            startActivity(Intent(this, KeyFrameActivity::class.java))
        }

        bt2.setOnClickListener {
            //让bt2填充整个屏幕，并且隐藏其它视图
            TransitionManager.beginDelayedTransition(constraint_layout)
            //隐藏视图
            applyConstraintSet.setVisibility(R.id.bt1, View.GONE)
            applyConstraintSet.setVisibility(R.id.bt3, View.GONE)
            applyConstraintSet.setVisibility(R.id.bt4, View.GONE)
            applyConstraintSet.setVisibility(R.id.bt5, View.GONE)
            applyConstraintSet.setVisibility(R.id.tv1, View.GONE)
            //清除约束
            applyConstraintSet.clear(R.id.bt2)
            //添加约束
            applyConstraintSet.connect(R.id.bt2, ConstraintSet.LEFT, R.id.constraint_layout, ConstraintSet.LEFT, 0)
            applyConstraintSet.connect(R.id.bt2, ConstraintSet.RIGHT, R.id.constraint_layout, ConstraintSet.RIGHT, 0)
            applyConstraintSet.connect(R.id.bt2, ConstraintSet.TOP, R.id.constraint_layout, ConstraintSet.TOP, 0)
            applyConstraintSet.connect(R.id.bt2, ConstraintSet.BOTTOM, R.id.constraint_layout, ConstraintSet.BOTTOM, 0)
            //应用
            applyConstraintSet.applyTo(constraint_layout)
        }

        bt3.setOnClickListener {
            //实现chain
            TransitionManager.beginDelayedTransition(constraint_layout)
            //清除控件约束
            applyConstraintSet.clear(R.id.bt2)
            applyConstraintSet.clear(R.id.bt3)
            applyConstraintSet.clear(R.id.bt4)
            //设置bt3约束
            applyConstraintSet.centerVertically(R.id.bt3, R.id.constraint_layout)
            applyConstraintSet.centerHorizontally(R.id.bt3, R.id.constraint_layout)
            applyConstraintSet.connect(R.id.bt3, ConstraintSet.LEFT, R.id.bt2, ConstraintSet.RIGHT, 0)
            applyConstraintSet.connect(R.id.bt3, ConstraintSet.RIGHT, R.id.bt4, ConstraintSet.LEFT, 0)
            //设置bt2约束
            applyConstraintSet.centerVertically(R.id.bt2, R.id.constraint_layout)
            applyConstraintSet.connect(R.id.bt2, ConstraintSet.LEFT, R.id.constraint_layout, ConstraintSet.LEFT, 0)
            applyConstraintSet.connect(R.id.bt2, ConstraintSet.RIGHT, R.id.bt3, ConstraintSet.LEFT, 0)
            //设置bt4约束
            applyConstraintSet.centerVertically(R.id.bt4, R.id.constraint_layout)
            applyConstraintSet.connect(R.id.bt4, ConstraintSet.RIGHT, R.id.constraint_layout, ConstraintSet.RIGHT, 0)
            applyConstraintSet.connect(R.id.bt4, ConstraintSet.LEFT, R.id.bt3, ConstraintSet.RIGHT, 0)
            //设置chain
            applyConstraintSet.createHorizontalChain(ConstraintSet.PARENT_ID, ConstraintSet.LEFT,
                    ConstraintSet.PARENT_ID, ConstraintSet.RIGHT,
                    intArrayOf(R.id.bt2, R.id.bt3, R.id.bt4), null, ConstraintWidget.CHAIN_PACKED)
            //设置bt2，bt3，bt4的宽高
            applyConstraintSet.constrainWidth(R.id.bt2, ConstraintSet.WRAP_CONTENT)
            applyConstraintSet.constrainWidth(R.id.bt3, ConstraintSet.WRAP_CONTENT)
            applyConstraintSet.constrainWidth(R.id.bt4, ConstraintSet.WRAP_CONTENT)
            applyConstraintSet.constrainHeight(R.id.bt2, ConstraintSet.WRAP_CONTENT)
            applyConstraintSet.constrainHeight(R.id.bt3, ConstraintSet.WRAP_CONTENT)
            applyConstraintSet.constrainHeight(R.id.bt4, ConstraintSet.WRAP_CONTENT)
            //应用
            applyConstraintSet.applyTo(constraint_layout)
        }

        bt4.setOnClickListener {
            //设置旋转、透明度、拉伸
            TransitionManager.beginDelayedTransition(constraint_layout)
            applyConstraintSet.setRotation(R.id.bt4, 45f)
            applyConstraintSet.setAlpha(R.id.bt4, 0.5f)
            applyConstraintSet.setScaleX(R.id.bt4, 2f)
            applyConstraintSet.applyTo(constraint_layout)
        }

        bt5.setOnClickListener{
            //改变属性
            TransitionManager.beginDelayedTransition(constraint_layout)
            applyConstraintSet.setMargin(R.id.tv1, ConstraintSet.LEFT, 100)//设置tv1的左边距为100px
            applyConstraintSet.setMargin(R.id.bt2, ConstraintSet.START, 100)//设置bt2的左边距为100px
            applyConstraintSet.setMargin(R.id.bt3, ConstraintSet.END, 0)//将bt3的右边距设置为0，不然使用centerHorizontally不能居中
            applyConstraintSet.centerHorizontally(R.id.bt3, R.id.constraint_layout)//将bt3移到水平居中的位置
            applyConstraintSet.constrainWidth(R.id.bt4, 300)//将bt4的宽度设置为600px
            applyConstraintSet.applyTo(constraint_layout)
        }

        bt6.setOnClickListener {
            //重置applyConstrainSet
            applyConstraintSet.clone(resetConstraintSet)
            //恢复原始样式
            TransitionManager.beginDelayedTransition(constraint_layout)
            resetConstraintSet.applyTo(constraint_layout)
        }
    }
}
