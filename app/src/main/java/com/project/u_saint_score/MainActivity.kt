package com.project.u_saint_score

import android.content.Intent
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var getResultText: ActivityResultLauncher<Intent>
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

        getResultText = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val grade = result.data?.getStringExtra("grade")
                textviewGrade.setText(grade)
            }
        }

        btnRefresh.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", "https://saint.ssu.ac.kr/irj/portal?NavigationTarget=ROLES://portal_content/ac.ssu.pct.fd.SSU/ac.ssu.pct.fd.COMMON/ac.ssu.pct.fd.Role/ac.ssu.pct.fd.New_No_EntryPoint/ssu.ac.pct.r.Graduate/ssu.ac.pct.r.Graduate_CM/ac.ssu.pct.cm.ws.ws_cm002/ac.ssu.pct.cm.iv.cmS0006")
            getResultText.launch(intent)
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