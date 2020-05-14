package com.kotlin.kotlinprojectdemo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kotlin.kotlinprojectdemo.R
import com.kotlin.kotlinprojectdemo.custom.replaceFragmenty
import com.kotlin.kotlinprojectdemo.fragment.AccountFragmen
import com.kotlin.kotlinprojectdemo.fragment.HomeFragment
import com.kotlin.mvvm_coroutines_retrofit.base.BaseActivity
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : BaseActivity() {
    private lateinit var homeFragment: HomeFragment
    private lateinit var accountFragmen: AccountFragmen
    private lateinit var actionBar: ActionBar
    override fun getRootLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setUpView(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            setSupportActionBar(toolBar)
            actionBar = supportActionBar!!
            actionBar?.title = "Navigation Drawer"
            //
            val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_bottom)
            bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
            //
            homeFragment = HomeFragment.newInstance()
            replaceFragmenty(
                homeFragment, true,
                R.id.frm_layout
            )
        }
    }

    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        setSupportActionBar(toolBar)
//        actionBar = supportActionBar!!
//        actionBar?.title = "Navigation Drawer"
//        //
//        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_bottom)
//        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        //
//        homeFragment = HomeFragment.newInstance()
//        replaceFragmenty(
//            homeFragment, true,
//            R.id.frm_layout
//        )
//    }
//
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    actionBar?.title = "Navigation Drawer"
                    replaceFragmenty(
                        homeFragment, true,
                        R.id.frm_layout
                    )
                }
                R.id.accountFragment -> {
                    actionBar?.title = "Account Fragment"
                    accountFragmen = AccountFragmen.newInstance()
                    replaceFragmenty(
                        accountFragmen, true,
                        R.id.frm_layout
                    )
                }
            }
            true
        }

    //
    override fun onBackPressed() {

    }

}
