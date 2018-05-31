package com.yjw.shirly.model.bean

class Response<T> {
    var code: Int = 0
    var msg: String? = null
    var data: T? = null
}
