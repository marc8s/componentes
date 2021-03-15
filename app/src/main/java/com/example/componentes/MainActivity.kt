package com.example.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
        button_snack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_toast ->{
                val toast = Toast.makeText(this, "TOAST", Toast.LENGTH_LONG)

                toast.show()
            }
            R.id.button_snack ->{
                val snack = Snackbar.make(linear_root, getString(R.string.snack), Snackbar.LENGTH_SHORT)
                snack.show()
            }
        }
    }

    private fun toast(str:String){
        Toast.makeText(this, "TOAST", Toast.LENGTH_LONG).show()
    }
}