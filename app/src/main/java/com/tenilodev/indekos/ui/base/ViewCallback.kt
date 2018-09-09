package com.tenilodev.indekos.ui.base

interface ViewCallback {
    fun onError(throwable: Throwable)
    fun onProgress(isProgress : Boolean)
}