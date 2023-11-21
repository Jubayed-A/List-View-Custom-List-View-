package com.example.listviewcustomapp

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
        val imaId = arrayOf(R.drawable.pic5, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4)

        userArrayList = ArrayList()

        for (eachIndex in name.indices){
            val user = Users(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNum[eachIndex],imaId[eachIndex])
            userArrayList.add(user)
        }

        // adapter part here
        listView.adapter = MyAdapter(this, userArrayList)

        // click on every item part here
        listView.setOnItemClickListener { parent, view, position, id ->

        }
    }
}