package com.amanguru.retrofit

import retrofit2.http.GET
import retrofit2.Call

interface Api {

  @GET("posts")
 fun getData():Call<List<ModelClass>>

}