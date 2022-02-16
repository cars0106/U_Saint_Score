package com.project.u_saint_score

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val context: Context, private val datas: ArrayList<RecyclerData>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textProfessor: TextView = itemView.findViewById(R.id.recycler_item_professor_text)
        private val textSubject: TextView = itemView.findViewById(R.id.recycler_item_subject_text)
        private val textGrade: TextView = itemView.findViewById(R.id.recycler_item_grade_text)

        fun bind(item: RecyclerData) {
            textProfessor.text = item.professor
            textSubject.text = item.subject
            textGrade.text = item.grade
        }
    }
}