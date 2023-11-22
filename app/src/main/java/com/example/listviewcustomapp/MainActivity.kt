package com.example.listviewcustomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<Users>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // variable or id declared
        val listView = findViewById<ListView>(R.id.listView)

        // data assign part
        val name = arrayOf("Saumya", "Prastuti", "Ankit", "Pradeep", "Aman")
        val lastMsg = arrayOf("Hey How are You", "I am good", "Thanks", "Good Bye", "See you later")
        val lastMsgTime = arrayOf("4 : 45 PM", "4 : 45 PM", "4 : 45 PM", "4 : 45 PM", "4 : 45 PM")
        val phoneNum = arrayOf("01758974531", "01758974531", "01758974531", "01758974531", "01758974531")
        val imgId = arrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4)

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = Users(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNum[eachIndex],imgId[eachIndex])
            userArrayList.add(user)
        }

        // adapter part here
        listView.adapter = MyAdapter(this, userArrayList)

        // click on every item part here
        listView.setOnItemClickListener { parent, view, position, id ->
            // open new activity

            val userName = name[position]
            val userPhone = phoneNum[position]
            val imageId = imgId[position]

            val intent = Intent(this, UsersActivity::class.java)

            intent.putExtra("name", userName)
            intent.putExtra("phone", userPhone)
            intent.putExtra("imageId", imageId)
            startActivity(intent)

        }
    }
}