package com.example.contactapp

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

val userList = listOf(
    User(1, "Lâm", "123-456-789011", "katie@gmail.com"),
    User(2, "Nguyễn Văn A", "123-456-789012", "leo@gmail.com"),
    User(3, "Mia", "123-456-789013", "mia@gmail.com"),
    User(4, "Erling", "123-456-789014", "noah@gmail.com"),
    User(5, "Bernardo", "123-456-789015", "olivia@gmail.com"),
    User(6, "Phil", "123-456-789016", "peter@gmail.com"),
    User(7, "Jeremy", "123-456-789017", "quinn@gmail.com"),
    User(8, "Mateo", "123-456-789018", "ryan@gmail.com"),
    User(9, "John", "123-456-789019", "sara@gmail.com"),
    User(10, "Jack", "123-456-789020", "tom@gmail.com")
)

class MainActivity : ComponentActivity() {

    private lateinit var myAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        myAdapter = Adapter(userList)
        rv.adapter = myAdapter
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val clickedUser = myAdapter.getClickedUser()
        Log.d("TAG", clickedUser.toString())
        return when (item.itemId) {
            R.id.action_call -> {
                Log.d("TAG", "Call " + clickedUser?.getUserPhone())
                Toast.makeText(this@MainActivity, "Call " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_message -> {
                Log.v("TAG", "Send message to " + clickedUser?.getUserPhone())
                Toast.makeText(this, "Send message to " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_email -> {
                Log.v("TAG", "Send email to " + clickedUser?.getUserEmail())
                Toast.makeText(this, "Send email to " + clickedUser?.getUserEmail(), Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}