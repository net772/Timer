package com.example.timer

import android.os.CountDownTimer
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val remainMinutesTextView = ObservableField<String>("00")
    val remainSecondsTextView = ObservableField<String>("00")
    val progress = ObservableField<Int>()
    private var currentCountDownTimer: CountDownTimer? = null


    /** MediaSeekBar */
    val seekBarChangeListener = object: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            if(fromUser)
                updateRemainTimes(progress * 60 * 1000L)
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            currentCountDownTimer?.cancel()
            currentCountDownTimer = null
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            seekBar?.let {
                currentCountDownTimer = createCountDownTimer(seekBar.progress * 60 * 1000L)
                currentCountDownTimer?.start()
            }
        }
    }

    private fun createCountDownTimer(initialMillis: Long) =
        object: CountDownTimer(initialMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                updateRemainTimes(millisUntilFinished)
                updateSeekBar(millisUntilFinished)
            }

            override fun onFinish() {
                updateRemainTimes(0)
                updateSeekBar(0)
            }

        }

    private fun updateRemainTimes(remainMillis: Long) {
        val remainSeconds = remainMillis / 1000

        remainMinutesTextView.set("%02d".format(remainSeconds / 60))
        remainSecondsTextView.set("%02d".format(remainSeconds % 60))
    }

    private fun updateSeekBar(remainMillis: Long) {
        progress.set((remainMillis / 1000 / 60).toInt())
    }
}