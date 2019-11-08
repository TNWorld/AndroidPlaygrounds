package com.example.databinding_module

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.BindingAdapter

class ViewModel(val a : ThingA, val b : ThingB, val clipboard : ClipboardManager) {
    fun doNot (view: View){
        val myTextView = view as TextView
        val clip: ClipData = ClipData.newPlainText("accountNum",myTextView.text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(myTextView.context,"This has been copied",Toast.LENGTH_SHORT).show()
        Toast.makeText(myTextView.context,clipboard.primaryClip?.getItemAt(0)?.text,Toast.LENGTH_SHORT).show()
    }

    companion object{
        @JvmStatic
        @BindingAdapter(value = ["onOcpyClick","showCopyToast"], requireAll = false)
        fun copyToast(textView: TextView, showCopyToast: Boolean, copyOnClick: Boolean){
            textView.setOnClickListener{
                if (showCopyToast){
                    showToast(textView)
                }
                if (copyOnClick){
                    copyOnClick(textView)
                }
            }
        }
        @JvmStatic
        fun showToast(textView: TextView){
            val toast: Toast? = Toast.makeText(textView.getContext(), "copied to clipboard", Toast.LENGTH_SHORT)
            toast?.show()
        }
        @JvmStatic
        fun copyOnClick(textView: TextView){
            val clipboardManager = textView.getContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textView.getText())
            clipboardManager.setPrimaryClip(clipData)
        }
    }
}
class ThingA
class ThingB
