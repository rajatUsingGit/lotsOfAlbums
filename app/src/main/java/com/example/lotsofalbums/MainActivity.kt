package com.example.lotsofalbums

import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
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
        mBinding.button.setOnClickListener {
            mViewModel.refreshData()
            getSystemService(Vibrator::class.java)
                .vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE))
        }
        renderDataToUI()
    }

    private fun renderDataToUI() {

        lifecycleScope.launch() {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.albums.collect {
                    Log.d("test_log", it.toString())
                }
            }
        }

        lifecycleScope.launch() {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mViewModel.photos.collect {
                    Log.d("test_log", it.toString())
                }
            }
        }

    }

}