package com.dos.ua.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dos.ua.R
import com.google.firebase.database.*
import com.dos.ua.adapter.DesignAdapter
import com.dos.ua.model.DesignData
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    private lateinit var mDataBase:DatabaseReference
    private lateinit var designList:ArrayList<DesignData>
    private lateinit var mAdapter: DesignAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        designList = ArrayList()
        mAdapter = DesignAdapter(this,designList)
        recyclerDesign.layoutManager = LinearLayoutManager(this)
        recyclerDesign.setHasFixedSize(true)

        getDesignData()

    }

    private fun getDesignData() {
        mDataBase = FirebaseDatabase.getInstance().getReference("Design")
        mDataBase.addValueEventListener(object :ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()){
                   for (designSnapshot in snapshot.children){
                       val design = designSnapshot.getValue(DesignData::class.java)
                       designList.add(design!!)

                   }
                   recyclerDesign.adapter = mAdapter
               }
            }

            override fun onCancelled(error: DatabaseError) {
               Toast.makeText(this@MenuActivity, error.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

}