package com.example.kotlinpractice.retrofit

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinpractice.R
import com.facebook.drawee.view.SimpleDraweeView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Context, val userList: List<MyDataItem>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    companion object {
        private const val TAG = "MyAdapter"
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userId: TextView
        var albumId: TextView
        var title: TextView
        var url: ImageView
        var thumbnailUrl: ImageView

        init {
            userId = itemView.findViewById(R.id.ID)
            albumId = itemView.findViewById(R.id.albumID)
            title = itemView.findViewById(R.id.titleID)
            url = itemView.findViewById(R.id.urlImage)
            thumbnailUrl = itemView.findViewById(R.id.thumbnailUrlImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.row_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userId.text = userList[position].id.toString()
        holder.albumId.text = userList[position].albumId.toString()
        holder.title.text = userList[position].title
        //holder.url.setImageURI(userList[position].url.toUri())
        Log.d(TAG,"onBindViewHolder: url ${userList[position].url}")
        holder.url.setImageURI(userList[position].url.toUri())
//       Glide.with(holder.url.context)
//            .load("https://upload.wikimedia.org/wikipedia/commons/8/8a/Angelo-moriondo-portrait-espresso-machine-inventor.jpg")
//            //Error aa rha h
//            .error(ContextCompat.getDrawable(holder.url.context, R.drawable.ic_launcher_background))
//            .placeholder(ContextCompat.getDrawable(holder.url.context,
//                R.drawable.ic_launcher_foreground)).into(holder.url)
        holder.thumbnailUrl.setImageURI(userList[position].thumbnailUrl.toUri())
//        Picasso.with(holder.thumbnailUrl.context)
//            .load("https://upload.wikimedia.org/wikipedia/commons/8/8a/Angelo-moriondo-portrait-espresso-machine-inventor.jpg")
//            //Error aa rha h
//            .error(ContextCompat.getDrawable(holder.thumbnailUrl.context, R.drawable.ic_launcher_background))
//            .placeholder(ContextCompat.getDrawable(holder.thumbnailUrl.context,
//                R.drawable.ic_launcher_foreground)).into(holder.thumbnailUrl)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}