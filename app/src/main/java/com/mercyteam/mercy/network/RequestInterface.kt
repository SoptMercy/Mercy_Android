package com.example.semina_3st.network

import com.example.semina_3st.data.RequestLogin
import com.example.semina_3st.data.ResponseLogin
import com.mercyteam.mercy.data.RequestRecommend
import com.mercyteam.mercy.data.ResponseRecommend
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestInterface {
    //post방식으로 이용을 할거다
    @POST("/login")
    fun requestLogin(@Body body : RequestLogin) : Call<ResponseLogin>

    @POST("/symptom")
    fun requestRecommend(@Body body : RequestRecommend) : Call<ResponseRecommend>
}