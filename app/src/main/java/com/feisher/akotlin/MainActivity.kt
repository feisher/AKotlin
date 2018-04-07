package com.feisher.akotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
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

            ARouter.getInstance()
                    .build("/ak/TestActivity")
                    .withString("name","传递数据点击返回")
                    .withString("test", Gson().toJson(test) )
                    .navigation()
        }

    }
}
