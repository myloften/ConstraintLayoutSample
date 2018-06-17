package com.loften.constraintlayoutsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

//首页
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        bt_layout1.setOnClickListener {
            //实现RelativeLayout
            startActivity(Intent(this, Main2Activity::class.java))
        }
        bt_layout2.setOnClickListener{
            //实现LinearLayout
            startActivity(Intent(this, Main3Activity::class.java))
        }
        bt_layout3.setOnClickListener {
            //guideline辅助线
            startActivity(Intent(this, Main4Activity::class.java))
        }
        bt_layout4.setOnClickListener{
            //layout_constraintDimensionRatio
            startActivity(Intent(this, Main5Activity::class.java))
        }
        bt_layout5.setOnClickListener{
            //gone
            startActivity(Intent(this, Main6Activity::class.java))
        }
        bt_layout6.setOnClickListener{
            //百分比布局
            startActivity(Intent(this, Main7Activity::class.java))
        }
        bt_layout7.setOnClickListener{
            //圆形定位
            startActivity(Intent(this, Main8Activity::class.java))
        }
        bt_layout8.setOnClickListener{
            //Barrier辅助线及Group
            startActivity(Intent(this, Main9Activity::class.java))
        }
        bt_layout9.setOnClickListener{
            //Placeholder
            startActivity(Intent(this, Main10Activity::class.java))
        }
        bt_layout10.setOnClickListener{
            //动画
            startActivity(Intent(this, Main11Activity::class.java))
        }
    }

}
