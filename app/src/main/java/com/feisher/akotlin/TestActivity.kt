package com.feisher.akotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.feisher.akotlin.event.Test
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_test.*

@Route(path = "/ak/TestActivity")
class TestActivity : AppCompatActivity() {
    @Autowired
    @JvmField var name: String? = null
    @Autowired
    @JvmField var test: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val single = Gson().fromJson<Test>(test)
        textView.text = "传递:$name" +"$test"+
                "对象姓名：" +single.name+
                "年龄"+single.age
        textView.setOnClickListener { finish() }
    }

}

