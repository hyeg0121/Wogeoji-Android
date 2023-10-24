package com.example.wogeoji.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wogeoji.R
import com.example.wogeoji.domain.Group

class MyGroupAdapter (val data: List<Group>)
    :RecyclerView.Adapter<MyGroupAdapter.ItemViewHolder>() {
        class ItemViewHolder(val view: View): RecyclerView.ViewHolder(view){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.group_item, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var view = holder.view
        var group = data[position]
        val groupNameTextView = view.findViewById<TextView>(R.id.group_name_textview)
        val groupDescriptionTextView = view.findViewById<TextView>(R.id.group_description_textview)
        val groupMemberTextView = view.findViewById<TextView>(R.id.group_member_textview);

        groupNameTextView.text = group.name
        groupDescriptionTextView.text = group.description
        groupMemberTextView.text = "1/" + group.headcountLimit
    }


}