package com.amanguru.retrofit

import com.google.gson.annotations.SerializedName

class ModelClass{

    var userId:Int=0;
    var id:Int=0
   var title:String = ""
    @SerializedName("body")
    var text:String=""

    constructor(userId: Int, id: Int, title: String, text: String) {
        this.userId = userId
        this.id = id
        this.title = title
        this.text = text
    }
    fun getuserId():Int=userId
    fun getid():Int=id
    fun title():String=title
    fun gettext():String=text


}