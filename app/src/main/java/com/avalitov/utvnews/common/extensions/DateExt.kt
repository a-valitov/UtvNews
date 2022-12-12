package com.avalitov.utvnews.common.extensions

import java.text.SimpleDateFormat
import java.util.*

const val DATE_PATTERN_DEFAULT = "dd MMM yyyy"
const val DATE_PATTERN_WITH_TIME_DEFAULT = "dd MMM yyyy, HH:mm"

fun Date.asString(pattern : String = DATE_PATTERN_DEFAULT) : String {
    return SimpleDateFormat(pattern, Locale.getDefault()).format(this)
}