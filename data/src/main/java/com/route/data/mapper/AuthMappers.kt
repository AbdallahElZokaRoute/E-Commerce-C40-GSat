package com.route.data.mapper

import com.route.data.dataSource.online.api.request.LoginRequestModel
import com.route.data.dataSource.online.api.request.RegisterRequest
import com.route.domain.request.LoginRequestEntity
import com.route.domain.request.RegisterRequestEntity

fun LoginRequestEntity.toModel(): LoginRequestModel {
    return LoginRequestModel(password, email)
}
fun RegisterRequestEntity.toModel():RegisterRequest{
    return RegisterRequest(password, phone, rePassword, name, email)
}
