package com.ezreal.wanandroid.model.entities

enum class Status {
    SUCCESS,
    ERROR,
    LOADING,
}


data class Resource<out T>(val status: Status, val data:T?, val message:String?) {

    // 工厂模式生成Resource
    companion object {
        fun <T> success(data:T): Resource<T> =  Resource(Status.SUCCESS,data,null)

        fun <T> error(message: String): Resource<T> = Resource(Status.ERROR,null,message)

        fun <T> loading(): Resource<T> = Resource(Status.LOADING,null,null)
    }

}