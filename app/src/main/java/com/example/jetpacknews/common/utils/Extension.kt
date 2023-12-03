package com.example.jetpacknews.common.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String.formatDateToHour(): Int? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    dateFormat.timeZone = TimeZone.getTimeZone("UTC")
    val date = dateFormat.parse(this)
    val now = Date()

    date?.let {
        val difference = now.time - it.time
        return (difference / (1000 * 60 * 60)).toInt()
    }

    return null

}