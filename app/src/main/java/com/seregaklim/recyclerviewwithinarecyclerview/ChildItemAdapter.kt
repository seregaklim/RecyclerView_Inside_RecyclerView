package com.seregaklim.recyclerviewwithinarecyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ChildItemAdapter
internal constructor(private val ChildItemList: List<ChildItem>) :
    RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder>() {
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int,
    ): ChildViewHolder {

        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.child_item,
                viewGroup, false
            )
        return ChildViewHolder(view)
    }

    override fun onBindViewHolder(
        childViewHolder: ChildViewHolder,
        position: Int,
    ) {

        val childItem = ChildItemList[position]

        childViewHolder.ChildItemTitle.text = childItem.childItemTitle
    }

    override fun getItemCount(): Int {
        return ChildItemList.size
    }

    inner class ChildViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var ChildItemTitle: TextView

        init {
            ChildItemTitle = itemView.findViewById<TextView>(
                R.id.child_item_title
            )
        }
    }
}