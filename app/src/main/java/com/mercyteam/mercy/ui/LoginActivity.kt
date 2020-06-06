package com.mercyteam.mercy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.semina_3st.data.RequestLogin
import com.example.semina_3st.network.customEnqueue
import com.mercyteam.mercy.R
import com.mercyteam.mercy.network.RequestToServer
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    val requestToServer = RequestToServer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener {
            //아이디나 비밀번호가 빈칸인 경우
            if (et_id.text.isNullOrBlank() || et_pwd.text.isNullOrBlank())
                Toast.makeText(this,"아이디와 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            //빈칸이 아닌 경우 통신함
            else {
                requestToServer.service.requestLogin( //이 함수의 반환 타입은 Call<ResponseLogin>
                    RequestLogin(
                        id = et_id.text.toString(),
                        password = et_pwd.text.toString()
                    ) //로그인 정보를 전달
                ).customEnqueue(
                    onError = { Toast.makeText(this,"올바르지 못한 요청입니다", Toast.LENGTH_SHORT).show() },
                    onSuccess = {
                        if (it.success) { //body()가 null이 아니고, success가 true -> 로그인
                            val intent = Intent(this@LoginActivity, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else { //body()가 null이 아니지만 success가 아닌경우
                            Toast.makeText(this,"아이디/비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show()
                        }
                    }
                )

            }
        }

    }
}