package com.example.timer

import android.widget.SeekBar
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @BindingAdapter("seekBarChangeListener")
    @JvmStatic
    fun setSeekBarChangeListener(seekBar: SeekBar, listener: SeekBar.OnSeekBarChangeListener?) {
        listener?.let {
            seekBar.setOnSeekBarChangeListener(it)
        }
    }
}