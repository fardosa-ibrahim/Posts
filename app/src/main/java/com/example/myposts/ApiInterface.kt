package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun  getPosts(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId") post:Int):Call<Post>
    @GET("/comments")
    fun  getComments(): Call<List<Post>>
    @GET("/comments/{commentId}")
    fun getCommentById(@Path("commentId") comment:Int):Call<Comment>

}