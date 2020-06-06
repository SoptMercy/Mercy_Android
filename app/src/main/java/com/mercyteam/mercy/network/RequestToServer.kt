package com.mercyteam.mercy.network

import com.example.semina_3st.network.RequestInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer {
    private const val BASE_URL = ""
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    
    val service: RequestInterface = retrofit.create(RequestInterface::class.java)
    //val service: NetworkService = retrofit.create(NetworkService::class.java)
}