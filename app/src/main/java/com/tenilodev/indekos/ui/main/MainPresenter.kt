package com.tenilodev.indekos.ui.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.tenilodev.indekos.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainView>()  {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun testExecute(){
        println("on resume from lifecycle-aware")
        val disposable = Observable.just(listOf("satu","dua","tiga"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { Observable.fromIterable(it) }
                .subscribe({ getMvpView()?.onSuccess(it) },{getMvpView()?.onError(it)})

        compositeDisposable?.add(disposable)

    }



}