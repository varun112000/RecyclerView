package com.example.recyclerviewexample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = ArrayList<Employee>()
        add.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Employee Details")
            builder1.setView(dialogView)
            builder1.setPositiveButton("Add",{ dialogInterface: DialogInterface, i: Int ->
                var id: String = dialogView.enterId.text.toString()
                var name: String = dialogView.enterName.text.toString()
                var item = Employee(R.drawable.ic_baseline_account_circle_24, id, name)
                list.add(item)
            })
            builder1.show()
        }
        recyclerview.adapter = SimpleAdapter(list)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
    }


    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are You Sure You Want To Exit")
        builder.setMessage("Confirm To Exit")
        builder.setPositiveButton("Yes",{dialogInterface: DialogInterface, i: Int -> finish()})
        builder.setNegativeButton("No",{dialogInterface: DialogInterface, i: Int ->})
        builder.show()
    }
}