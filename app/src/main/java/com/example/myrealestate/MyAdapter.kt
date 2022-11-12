package com.example.myrealestate
import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(val context: Context, val userlist: List<ResponseData.Home>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener): RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

        var perioxh: TextView = itemView.findViewById(R.id.text2)
        var tm: TextView = itemView.findViewById(R.id.text10)
        var timh: TextView = itemView.findViewById(R.id.text11)
        var thermansh: TextView = itemView.findViewById(R.id.text12)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_detailed, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val home = userlist[position]
        holder.perioxh.text = home.city
        holder.tm.text = home.squaremeters.toString()
        holder.timh.text = home.price.toString()
        // holder.thermansh.text = ??
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}