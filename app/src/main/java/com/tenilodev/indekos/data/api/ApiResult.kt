package com.tenilodev.indekos.data.api

class ApiResult<T>(var code:Int, var data: T, var message: String) {
}