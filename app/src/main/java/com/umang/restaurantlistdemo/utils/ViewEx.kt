package com.umang.restaurantlistdemo.utils

import android.app.Service
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

/**
 * Show keyboard :To open keyboard on Search screen launch
 *
 */
fun EditText.showKeyboard() {
    this.requestFocus()
    val imm: InputMethodManager =
        this.context.getSystemService(Service.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, 0)
}
