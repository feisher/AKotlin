package com.feisher.akotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.feisher.akotlin.event.KTest
import com.feisher.akotlin.event.KTest2
import com.feisher.akotlin.event.Test
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_test.*

@Route(path = "/ak/TestActivity")
class TestActivity : AppCompatActivity() {

    //注意此处注解，必须
    @Autowired @JvmField var name: String? = null
    @Autowired @JvmField var test: String? = null
    @Autowired @JvmField var t1: Test? = null
    @Autowired @JvmField var t2: KTest? = null
    @Autowired @JvmField var kt2: KTest2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //注册，必须
        ARouter.getInstance().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val single = Gson().fromJson<Test>(test)
        textView.text = "传递:$name" +"$test"+
                "\n对象姓名：" +single.name+
                "\n年龄"+single.age+
                "\n直接传递对象结果:"+ t1!!.name+ t1!!.age+
                "\nkotlin对象："+intent.extras.get("t2")+
                "\nkotlin对象姓名："+ t2!!.name+
                "\nkotlin对象姓名："+ kt2!!.name

        textView.setOnClickListener { finish() }
    }

}

