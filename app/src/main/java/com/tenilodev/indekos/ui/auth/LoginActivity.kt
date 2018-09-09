package com.tenilodev.indekos.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tenilodev.indekos.R
import com.tenilodev.indekos.ui.auth.login.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow()
        }
    }

}
