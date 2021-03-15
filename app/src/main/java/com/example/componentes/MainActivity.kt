package com.example.componentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, AdapterView.OnItemSelectedListener,
    SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_toast.setOnClickListener(this)
        button_snack.setOnClickListener(this)
        button_set_spinner.setOnClickListener(this)
        button_get_spinner.setOnClickListener(this)
        button_set_seekbar.setOnClickListener(this)
        button_get_seekbar.setOnClickListener(this)

        spinner_static.onItemSelectedListener = this
        seekbar.setOnSeekBarChangeListener(this)
        switch_on_off.setOnCheckedChangeListener(this)

        loadSpinner()
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

                //colocar evento de click na snackbar
                snack.setAction(getString(R.string.desfazer), View.OnClickListener {
                    toast(getString(R.string.desfeito))
                })
            }
            R.id.button_get_spinner ->{
                val selectedItem = spinner_static.selectedItem
                val selectedItemId = spinner_static.selectedItemId
                val selectedItemPosition = spinner_static.selectedItemPosition
                toast("Position: $selectedItemId: $selectedItem")
            }
            R.id.button_set_spinner ->{
                spinner_static.setSelection(2)
            }
            R.id.button_get_seekbar ->{
                toast("Seekbar: ${seekbar.progress}")
            }
            R.id.button_set_seekbar ->{
                seekbar.progress = 15
            }

        }
    }

    private fun loadSpinner(){
        val mList = listOf("Gramas", "Kg", "Arroba", "Tonelada")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, mList)
        spinner_dynamic.adapter = adapter
    }

    private fun toast(str:String){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        toast(getString(R.string.nada_selecionado))
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent?.id){
            R.id.spinner_static ->{
                val text = parent?.getItemAtPosition(position)
                toast(text.toString())
            }
        }
    }

    override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
        text_seekbar_value.text = "Valor seekbar: $progress"
    }

    override fun onStartTrackingTouch(seekbar: SeekBar?) {
        toast(getString(R.string.track_started))
    }

    override fun onStopTrackingTouch(seekbar: SeekBar?) {
        toast(getString(R.string.track_stoped))
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        when(buttonView.id){
            R.id.switch_on_off ->{
                toast("Switch ${if (isChecked) "Ligado" else "Desligado"}")
            }
        }
    }
}