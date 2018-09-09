package com.tenilodev.indekos.ui.base

interface Presenter<T : ViewCallback> {
    fun attachView(viewCallback : T)
    fun detachView()
}