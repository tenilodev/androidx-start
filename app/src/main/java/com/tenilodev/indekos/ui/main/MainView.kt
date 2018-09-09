package com.tenilodev.indekos.ui.main

import com.tenilodev.indekos.ui.base.ViewCallback

interface MainView : ViewCallback {
    fun onSuccess(string: String)
}