package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val initialTextViewTranslationY = textView_progress.translationY

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //テキストビューにはprogressをString型にキャストしたものを代入
                textView_progress.text = progress.toString()

                val translationDistance = (initialTextViewTranslationY + progress * resources.getDimension(R.dimen.text_anim_step) * -1)
                //テキストビューにアニメーションをつける
                textView_progress.animate().translationY(translationDistance)
                if (!fromUser)
                //360度回転する
                    textView_progress.animate().setDuration(500).rotationBy(360f).translationY(initialTextViewTranslationY)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        //リセットボタンを押す
        button_reset.setOnClickListener{v ->
            //数値が０になる
            seekBar.progress = 0

        }
    }
}