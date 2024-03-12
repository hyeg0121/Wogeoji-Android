package com.example.wogeoji.util

import android.content.Context
import android.widget.Toast
import java.time.Duration

class ToastHelper {
    companion object {
        fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, duration).show()
        }
    }
}