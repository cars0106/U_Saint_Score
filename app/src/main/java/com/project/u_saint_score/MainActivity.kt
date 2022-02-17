package com.project.u_saint_score

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        val verticalSpaceItemDecoration = VerticalSpaceItemDecoration()
        recyclerView.addItemDecoration(verticalSpaceItemDecoration)


        val datas = arrayListOf<RecyclerData>(
            RecyclerData("황선홍", "CHAPEL", "P"),
            RecyclerData("최지웅","앱프로그래밍기초및실습", "A0"),
            RecyclerData("최지웅","알고리즘", "A-"),
            RecyclerData("김익수","오픈소스기반기초설계", "A0"),
            RecyclerData("김병기","컴퓨터구조", "B0"),
            RecyclerData("신용태","컴퓨터네트워크", "A-")
        )

        recyclerAdapter = RecyclerAdapter(this, datas)
        recyclerView.adapter = recyclerAdapter

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        btnRefresh.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
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