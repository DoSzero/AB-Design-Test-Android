package com.dos.ua.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dos.ua.R
import com.dos.ua.utiles.DialogUtiles
import com.dos.ua.utiles.getProgressDrawable
import com.dos.ua.utiles.loadImage
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_itemmenu.*


class ItemMenuActivity : AppCompatActivity(), DialogUtiles.ExampleDialogListener {

    private lateinit var mDataBase: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_itemmenu)

        /**get Data*/
        val designInfoIntent = intent

        val designNameA = designInfoIntent.getStringExtra("nameA")
        val designInfoA = designInfoIntent.getStringExtra("infoA")
        val designImgA = designInfoIntent.getStringExtra("imgA")

        val designNameB = designInfoIntent.getStringExtra("nameB")
        val designInfoB = designInfoIntent.getStringExtra("infoB")
        val designImgB = designInfoIntent.getStringExtra("imgB")

        //all text and images
        nameA.text = designNameA
        infoA.text = designInfoA
        imgA.loadImage(designImgA, getProgressDrawable(this))

        nameB.text = designNameB
        infoB.text = designInfoB
        imgB.loadImage(designImgB, getProgressDrawable(this))

        btnBack.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

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
    }

    private fun openDialog() {
        val dialog = DialogUtiles()
        dialog.show(supportFragmentManager, "Dialog")
    }

    override fun onYesClicked() {
    }

}