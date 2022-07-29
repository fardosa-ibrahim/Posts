package com.example.myposts

data class Post(
    var userId:Int,
    var Id:Int,
    var tittle:String,
    var body:String
)

data class Comment(
    var postId:Int,
    var Id:Int,
    var name:String,
    var email:String,
    var body:String
)
