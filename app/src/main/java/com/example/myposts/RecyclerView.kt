package com.example.myposts

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
        holder.binding.tvId.text = currentPost.Id.toString()
        holder.binding.tvTittle.text = currentPost.tittle
        holder.binding.tvBody.text = currentPost.body

    }

    override fun getItemCount(): Int {
        return Post.size

    }
}
class PostViewHolder(val binding:PostlistitemBinding):
    RecyclerView.ViewHolder(binding.root){

}
