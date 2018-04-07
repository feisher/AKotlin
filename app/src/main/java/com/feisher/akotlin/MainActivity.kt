package com.feisher.akotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.feisher.akotlin.event.KTest
import com.feisher.akotlin.event.KTest2
import com.feisher.akotlin.event.Test
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv.text = "首页，点击进入下一页"
        tv.setOnClickListener {
           var test =   Test("测试",12)
            //鉴于ARouter直接传递对象方法使用的是fastJson ,此处用withString（）方法传递json字符串
            ARouter.getInstance()
                    .build("/ak/TestActivity")
                    .withString("name","传递数据点击返回")
                    .withString("test", Gson().toJson(test) )
                    .withObject("t1", test )
                    .withObject("t2", KTest() )
                    .withObject("kt2", KTest2("kotlin原生类",213) )
                    .navigation()
        }

    }
}
