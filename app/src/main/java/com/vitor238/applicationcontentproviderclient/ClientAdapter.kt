package com.vitor238.applicationcontentproviderclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClientAdapter(private val mCursor: Cursor) : RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        return ClientViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.client_item, parent, false))
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.clientTitle.text = mCursor.getString(mCursor.getColumnIndex("title"))
        holder.clientDescription.text = mCursor.getString(mCursor.getColumnIndex("description"))
    }

    override fun getItemCount() = mCursor.count


    class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val clientTitle: TextView = itemView.findViewById(R.id.client_item_title)
        val clientDescription: TextView = itemView.findViewById(R.id.client_item_description)
    }


}