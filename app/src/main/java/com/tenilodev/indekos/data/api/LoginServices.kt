package com.tenilodev.indekos.data.api

import com.tenilodev.indekos.data.model.LoginData
import com.tenilodev.indekos.data.model.User
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginServices {

    @POST("auth")
    fun login(@Body loginData: LoginData) : Flowable<ApiResult<User>>

}