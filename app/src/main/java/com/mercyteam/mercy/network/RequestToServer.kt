package com.mercyteam.mercy.network

import com.example.semina_3st.network.RequestInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RequestToServer{
    var retrofit = Retrofit.Builder()
        .baseUrl("http://15.165.172.114:3000") //건물의 주소.
        .addConverterFactory(GsonConverterFactory.create()) //retrofit으로 받아온 json데이터를 데이터 클래스로 변환하기 쉽게 해줌
        .build()

    var service: RequestInterface = retrofit.create(RequestInterface::class.java) //retrofit.create호출해 interface클래스 타입을 넘겨 실제 구현체를 만들어준다.
}