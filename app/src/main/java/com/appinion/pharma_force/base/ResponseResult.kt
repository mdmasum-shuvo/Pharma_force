package com.appinion.pharma_force.base


/**
 * @author MD. Masum Talukder
 * @param data  passing any type object in type T
 * @param message get the error message from restful api
 *
 * @property Success hold the api response  state
 * @property Error hold the api error response state
 * @property Loading show loading in UI level
 * @property UnAuthorized hold the unauthorized state
 *
 * @constructor are private by default
 */

sealed class ResponseResult<T>(val data:T?=null, val message:String?=null){
    class Success<T>(data: T?) : ResponseResult<T>(data)
    class Error<T>(message: String?,data: T?=null) : ResponseResult<T>(data,message)
    class UnAuthorized<T>(message: String?,data: T?=null) : ResponseResult<T>(data,message)
    class Loading<T>(): ResponseResult<T>()
}
