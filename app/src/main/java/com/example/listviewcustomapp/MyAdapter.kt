package com.example.listviewcustomapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter (private val context : Activity, private val arrayList: ArrayList<Users>) :
    ArrayAdapter<Users>(context, R.layout.customised_list_view, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.customised_list_view,null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tvName)
        val lastMsg = view.findViewById<TextView>(R.id.tvLastMsg)
        val lastMsgTime = view.findViewById<TextView>(R.id.tvTime)

        name.text = arrayList[position].name
        lastMsg.text = arrayList[position].lastMsg
        lastMsgTime.text = arrayList[position].lastMsgTime
        image.setImageResource(arrayList[position].imgId)

        return view
    }

}