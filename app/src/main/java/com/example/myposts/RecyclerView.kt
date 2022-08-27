package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostlistitemBinding

class RecyclerView(var Post:List<Post>):
    RecyclerView.Adapter<PostViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostlistitemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var currentPost = Post.get(position)
        currentPost.userId.toString().also { holder.binding.tvUserId.text = it }
        holder.binding.tvId.text = currentPost.id.toString()
        holder.binding.tvTittle.text = currentPost.tittle
        holder.binding.tvBody.text = currentPost.body
        val context=holder.itemView.context
        holder.binding.cvPost.setOnClickListener{
            val intent=Intent(context,CommentsActivity::class.java)
            intent.putExtra("POST_ID",currentPost.id)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return Post.size

    }
}
class PostViewHolder(val binding: PostlistitemBinding):
    RecyclerView.ViewHolder(binding.root){

}
