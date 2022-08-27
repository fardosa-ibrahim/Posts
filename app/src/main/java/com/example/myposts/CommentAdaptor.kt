package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.CommentlistitemBinding

class CommentAdapter(var commentList: List<Comment>) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding=CommentlistitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  CommentViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CommentViewHolder,position: Int) {
        var currentComment = commentList.get(position)
        holder.binding.tvPostId.text= currentComment.postId.toString()
        holder.binding.tvid.text = currentComment.Id.toString()
        holder.binding.tvEmail.text = currentComment.email
        holder.binding.tvName.text = currentComment.name
        holder.binding.tvBodyy.text=currentComment.body
        val context=holder.itemView.context
        holder.binding.cvComment.setOnClickListener {
            val intent= Intent(context,CommentActivity::class.java)
            intent.putExtra("COMMENT_ID",currentComment.Id)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return commentList.size
    }

}

class CommentViewHolder(val binding: CommentlistitemBinding): RecyclerView.ViewHolder(binding.root)