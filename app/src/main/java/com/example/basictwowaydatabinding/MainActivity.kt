package com.example.basictwowaydatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.basictwowaydatabinding.databinding.ActivityMainBindingImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initiate viewmodelProvider
        val mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        //initiate databinding and viewmodel
        DataBindingUtil.setContentView<ActivityMainBindingImpl>(this,R.layout.activity_main)
            .apply {
                this.setLifecycleOwner(this@MainActivity)
                this.viewmodel = mViewModel
            }

        mViewModel.editTextContent.observe(this, Observer {
            Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
        })
    }
}