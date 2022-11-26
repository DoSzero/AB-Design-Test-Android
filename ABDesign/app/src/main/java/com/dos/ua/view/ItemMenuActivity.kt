package com.dos.ua.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dos.ua.R
import com.dos.ua.uitel.getProgressDrawable
import com.dos.ua.uitel.loadImage
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_itemmenu.*


class ItemMenuActivity : AppCompatActivity() {

    private lateinit var mDataBase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemmenu)

        /**get Data*/
        val designInfoIntent = intent

        val designName = designInfoIntent.getStringExtra("name")
        val designInfo = designInfoIntent.getStringExtra("info")
        val designImg = designInfoIntent.getStringExtra("img")

        /**call text and images*/
        name.text = designName
        info.text = designInfo
        img.loadImage(designImg, getProgressDrawable(this))

//        btn_yes.setOnClickListener {
//            val mRootRef = FirebaseDatabase.getInstance().getReference("Design")
//            val mCounterRef = mRootRef.child("like")
//
//            mCounterRef.addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    dataSnapshot.child("Design")
//                    var count =  dataSnapshot.child("Design").value as Long
//                    mCounterRef.child("like").setValue(++count)
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//                    throw databaseError.toException()
//                }
//            })
//        }

            // TODO ++ --- // Working but different path
//        btn_yes.setOnClickListener {
//            val mRootRef = FirebaseDatabase.getInstance().getReference("Design")
//            val mCounterRef = mRootRef.child("like")
//
//            mCounterRef.addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    var count =  dataSnapshot.child("Design").value as Long
//                    mCounterRef.child("like").setValue(++count)
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//                    throw databaseError.toException()
//                }
//            })
//        }

        //TODO dislike
//        btn_no.setOnClickListener {
//            val mRootRef = FirebaseDatabase.getInstance().reference
//            val mCounterRef = mRootRef.child("Design")
//
//            mCounterRef.addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    var count = dataSnapshot.child("/Design/01/dislike").value as Long
//                    mCounterRef.child("/Design/01/dislike").setValue(--count)
//                }
//
//                override fun onCancelled(databaseError: DatabaseError) {
//                    throw databaseError.toException()
//                }
//            })
//        }


    }
    /**ok now run it */
}