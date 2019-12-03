package tech.twentytwobits.recyclerviewexample

import android.view.View

interface ClickListener {
    fun onClick(view: View, index: Int)
}