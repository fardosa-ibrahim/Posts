package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityCommentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()
        fetchComment()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPostById(){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPostById(postId)

        request.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful){
                    var post = response.body()
                    binding.tvTitle.text=post?.tittle
                    binding.textViewBody.text=post?.body
                }
            }
            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }

        })

    }
    fun fetchComment(){
        var apiClient=ApiClient.buildApiClient((ApiInterface::class.java))
        var request=apiClient.getComments()

        with(request) {

            enqueue(object:Callback<List<Comment>>{
                override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
                    if (response.isSuccessful){
                        var comments=response.body()
                        Toast.makeText(baseContext,"fetched ${comments!!.size} posts",Toast.LENGTH_LONG)
                            .show()
                        var CommentsRvAdapter=CommentAdapter(comments)
                        binding.rvComment.layoutManager= LinearLayoutManager(baseContext)
                        binding.rvComment.adapter=CommentsRvAdapter
                    }
                }
                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                }
            })
        }
    }

}