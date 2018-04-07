package com.feisher.akotlin

import com.google.gson.Gson

/**
 *
 * Created by Administrator on 2018/4/7 0007.
 */
inline fun <reified T : Any> Gson.fromJson(json: String?): T {
    return Gson().fromJson(json, T::class.java)
}
