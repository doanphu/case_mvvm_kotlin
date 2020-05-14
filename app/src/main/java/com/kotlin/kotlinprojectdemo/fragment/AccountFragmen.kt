package com.kotlin.kotlinprojectdemo.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.kotlinprojectdemo.R
import com.kotlin.kotlinprojectdemo.application.MyAndroidViewModel
import com.kotlin.kotlinprojectdemo.base.BaseFragment


class AccountFragmen : BaseFragment<MyAndroidViewModel>() {
    private val TAG: String = "AccountFragmen"

    companion object {
        @JvmStatic
        fun newInstance() = AccountFragmen()
    }

    override fun getRootLayoutId(): Int {
        Log.d(TAG, "setupUI")
        return R.layout.fragment_account
    }

    override fun getViewModel(): Class<MyAndroidViewModel> {
        return MyAndroidViewModel::class.java
    }

    override fun setupUI(view: View) {
        Log.d(TAG, "setupUI")
    }

}
