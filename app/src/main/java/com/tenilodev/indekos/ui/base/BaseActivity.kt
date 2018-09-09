package com.tenilodev.indekos.ui.base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleRegistry
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    private val lifecycleRegistry = LifecycleRegistry(this)

    fun setBaseFragment(@IdRes containerViewId : Int, newFragment : Fragment, tag : String?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId,newFragment,tag)
        fragmentTransaction.commit()
    }

    fun setContentFragment(@IdRes containerViewId : Int, newFragment : Fragment, tag : String?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerViewId,newFragment,tag)
        fragmentTransaction.addToBackStack("home")
        fragmentTransaction.commit()
    }

    override fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }




}