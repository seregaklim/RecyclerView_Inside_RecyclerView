package com.seregaklim.recyclerviewwithinarecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool


class ParentItemAdapter internal constructor(private val itemList: List<ParentItem>) :
    RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder>() {

    private val viewPool = RecycledViewPool()
    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int,
    ): ParentViewHolder {

        val view: View = LayoutInflater
            .from(viewGroup.context)
            .inflate(
                R.layout.parent_item,
                viewGroup, false
            )
        return ParentViewHolder(view)
    }

    override fun onBindViewHolder(
        parentViewHolder: ParentViewHolder,
        position: Int,
    ) {

        val parentItem = itemList[position]

        parentViewHolder.ParentItemTitle.text = parentItem.parentItemTitle

        val layoutManager = LinearLayoutManager(
            parentViewHolder.ChildRecyclerView
                .context,
            LinearLayoutManager.HORIZONTAL,
            false
        )


        layoutManager.initialPrefetchItemCount = parentItem
            .childItemList
            .size


        val childItemAdapter = ChildItemAdapter(
            parentItem
                .childItemList
        )
        parentViewHolder.ChildRecyclerView.layoutManager = layoutManager
        parentViewHolder.ChildRecyclerView.adapter = childItemAdapter
        parentViewHolder.ChildRecyclerView
            .setRecycledViewPool(viewPool)
    }


    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ParentViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val ParentItemTitle: TextView
        val ChildRecyclerView: RecyclerView

        init {
            ParentItemTitle = itemView
                .findViewById<TextView>(
                    R.id.parent_item_title
                )
            ChildRecyclerView = itemView
                .findViewById<RecyclerView>(
                    R.id.child_recyclerview
                )
        }
    }
}