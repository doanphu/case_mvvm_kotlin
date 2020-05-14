package com.kotlin.mvvm_coroutines_retrofit.base

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getRootLayoutId())
        setUpView(savedInstanceState)
    }

    abstract fun getRootLayoutId(): Int
    abstract fun setUpView(savedInstanceState: Bundle?)
}