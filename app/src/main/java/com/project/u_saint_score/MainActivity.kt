package com.project.u_saint_score

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val verticalSpaceItemDecoration = VerticalSpaceItemDecoration()
        recyclerView.addItemDecoration(verticalSpaceItemDecoration)


        val datas = arrayListOf<RecyclerData>(
            RecyclerData("CHAPEL", "P"),
            RecyclerData("앱프로그래밍기초및실습", "A0"),
            RecyclerData("알고리즘", "A-"),
            RecyclerData("오픈소스기반기초설계", "A0"),
            RecyclerData("컴퓨터구조", "B0"),
            RecyclerData("컴퓨터네트워크", "A-")
        )

        recyclerAdapter = RecyclerAdapter(this, datas)
        recyclerView.adapter = recyclerAdapter

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }


    inner class VerticalSpaceItemDecoration(): RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)

            if(parent.getChildAdapterPosition(view) == 0) {
                outRect.top = 10
            }
        }
    }
}