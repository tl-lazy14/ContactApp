package com.example.contactapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class Adapter(private val user: List<User>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    private var clickedUser: User? = null

    class MyViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        val user: TextView = row.findViewById(R.id.user)
        val userLetter: TextView = row.findViewById(R.id.userLetter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(
            R.layout.contact_item,
            parent, false)
        return MyViewHolder(layout)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.user.text = user[position].getUserName()
        holder.userLetter.text = user[position].getUserName().substring(0, 1).uppercase(Locale.ROOT)

        holder.itemView.setOnClickListener {
            clickedUser = user[position]
            if (clickedUser != null) {
                val intent = Intent(it.context, DetailInfo::class.java)
                intent.putExtra("user", clickedUser)
                it.context.startActivity(intent)
            }
        }

        holder.itemView.setOnCreateContextMenuListener { menu, _, _ ->
            clickedUser = user[position]
            menu.add(0, R.id.action_call, 0, "Call")
            menu.add(0, R.id.action_send_message, 0, "Send message")
            menu.add(0, R.id.action_send_email, 0, "Send email")
        }
    }

    override fun getItemCount(): Int = user.size

    fun getClickedUser(): User? = clickedUser
}