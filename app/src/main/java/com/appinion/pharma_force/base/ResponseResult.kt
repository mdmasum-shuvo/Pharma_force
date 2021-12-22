package com.appinion.pharma_force.base

sealed class ResponseResult<T>(val data:T?=null, val message:String?=null){
    class Success<T>(data: T?) : ResponseResult<T>(data)
    class Error<T>(message: String?,data: T?=null) : ResponseResult<T>(data,message)
    class UnAuthorized<T>(message: String?,data: T?=null) : ResponseResult<T>(data,message)
    class Loading<T>(): ResponseResult<T>()
}
