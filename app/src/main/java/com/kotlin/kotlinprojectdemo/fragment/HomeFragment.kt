package com.kotlin.kotlinprojectdemo.fragment

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.AndroidViewModel

import com.kotlin.kotlinprojectdemo.R
import com.kotlin.kotlinprojectdemo.application.MyAndroidViewModel
import com.kotlin.kotlinprojectdemo.base.BaseFragment

class HomeFragment() : BaseFragment<MyAndroidViewModel>() {
    private val TAG: String = "HomeFragment"

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun getRootLayoutId(): Int {
        Log.d(TAG, "getRootLayoutId")
        return R.layout.fragment_home2
    }

    override fun getViewModel(): Class<MyAndroidViewModel> {
        return MyAndroidViewModel::class.java
    }

    override fun setupUI(view: View) {
        Log.d(TAG, "setupUI")
        showLoadingDialog()
    }


}
