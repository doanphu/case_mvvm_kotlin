package com.kotlin.kotlinprojectdemo.base

import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kotlin.kotlinprojectdemo.R

abstract class BaseFragment<M : ViewModel> : Fragment() {
    lateinit var myViewModel: M
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getRootLayoutId(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (getViewModel() != null) {
            myViewModel = ViewModelProvider(this).get(getViewModel())
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI(view)
    }

    abstract fun getRootLayoutId(): Int
    abstract fun getViewModel(): Class<M>
    abstract fun setupUI(view: View)

    private lateinit var mProgressDialog: Dialog

    fun showLoadingDialog() {
        if (!isVisible) {
            if (!this::mProgressDialog.isInitialized) {
                mProgressDialog = Dialog(this!!.context!!)
                mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                mProgressDialog.setCancelable(false)
                mProgressDialog.setContentView(R.layout.custom_progress_loading)
                if (mProgressDialog.window != null && !requireActivity().isFinishing) {
                    mProgressDialog.window!!.setBackgroundDrawableResource(android.R.color.transparent)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val lp = WindowManager.LayoutParams()
                        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
                        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
                        lp.gravity = Gravity.CENTER
                        mProgressDialog.window!!.attributes = lp
                    } else {
                        mProgressDialog.window!!.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
                    }
                    if (!mProgressDialog.isShowing) {
                        mProgressDialog.show()
                        Log.i("DoanPhu", "setProgress: success")
                    }
                }
            }
            activity?.let {
                if (!requireActivity().isFinishing && this::mProgressDialog.isInitialized && !mProgressDialog.isShowing) {
                    try {
                        mProgressDialog.show()
                        Log.i("DoanPhu", "setProgress: success")
                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }

                }
            }
        }
    }

    private fun hideLoadingDialog() {
        if (this::mProgressDialog.isInitialized && mProgressDialog.isShowing) {
            mProgressDialog.dismiss()
        }
    }
}