package com.example.lotsofalbums

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.lotsofalbums.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val mViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.textBox.setOnClickListener {
            mViewModel.refreshAlbumsList()
        }
        lifecycleScope.launch() {
            mViewModel.albums.collect {
                Log.d("test_log", it.toString())
        }
        }
    }

}