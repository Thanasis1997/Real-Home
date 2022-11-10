package com.example.myrealestate
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(val conteext: Context, val userlist: ResponseData): RecyclerView.Adapter<MyAdapter.ViewHolder> {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var perioxh: TextView
        var tm: TextView
        var timh: TextView
        var thermansh: TextView

        init {
            perioxh = itemView.findViewById(R.id.text2)
            tm = itemView.findViewById(R.id.text10)
            timh = itemView.findViewById(R.id.text11)
            thermansh = itemView.findViewById(R.id.text12)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var itemView = LayoutInflater.from(conteext).inflate(R.layout.item_detailed, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {

    }
}