package com.seregaklim.recyclerviewwithinarecyclerview
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ParentRecyclerViewItem = findViewById<RecyclerView>(
            R.id.parent_recyclerview
        )

        // Initialise the Linear layout manager
        val layoutManager = LinearLayoutManager(
            this@MainActivity
        )

        val parentItemAdapter = ParentItemAdapter(
            ParentItemList()
        )

        ParentRecyclerViewItem.adapter = parentItemAdapter
        ParentRecyclerViewItem.layoutManager = layoutManager
    }

    private fun ParentItemList(): List<ParentItem> {
        val itemList: MutableList<ParentItem> = ArrayList()
        val item = ParentItem(
            "Title 1",
            ChildItemList()
        )
        itemList.add(item)
        val item1 = ParentItem(
            "Title 2",
            ChildItemList()
        )
        itemList.add(item1)
        val item2 = ParentItem(
            "Title 3",
            ChildItemList()
        )
        itemList.add(item2)
        val item3 = ParentItem(
            "Title 4",
            ChildItemList()
        )
        itemList.add(item3)
        return itemList
    }

    private fun ChildItemList(): List<ChildItem> {
        val ChildItemList: MutableList<ChildItem> = ArrayList()
        ChildItemList.add(ChildItem("Card 1"))
        ChildItemList.add(ChildItem("Card 2"))
        ChildItemList.add(ChildItem("Card 3"))
        ChildItemList.add(ChildItem("Card 4"))
        return ChildItemList
    }
}