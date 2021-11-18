package com.example.timer

import android.widget.SeekBar
import androidx.activity.viewModels
import com.example.timer.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel : MainViewModel by viewModels()
    override fun getLayoutResourceId() = R.layout.activity_main

    override fun initDataBinding() {
        mBinding.vm = viewModel
    }

    override fun initView() {
        bindViews()
    }

    private fun bindViews() {
        mBinding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

        })
    }
}