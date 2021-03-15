package com.example.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_toast ->{
                val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_LONG)
                toast.show()
            }
        }
    }

    private fun toast(str:String){
        Toast.makeText(this, "TOAST", Toast.LENGTH_LONG).show()
    }
}