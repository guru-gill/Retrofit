package com.amanguru.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        var retrofit:Retrofit=Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
         var api:Api=retrofit.create(Api::class.java)
        var call:Call<List<ModelClass>> = api.getData()
        call.enqueue(object : Callback<List<ModelClass>>{

            override fun onFailure(call: Call<List<ModelClass>>, t: Throwable) {
                
                Toast.makeText(applicationContext,t.message,Toast.LENGTH_LONG).show()

            }

            override fun onResponse(call: Call<List<ModelClass>>, response: Response<List<ModelClass>>) {


                var data: List<ModelClass>? = response.body()
                if (data != null) {
                    for(k  in data) {
                        Toast.makeText(applicationContext,k.title.toString(),Toast.LENGTH_LONG).show()
                    }
                }

            }

        })


    }
}
