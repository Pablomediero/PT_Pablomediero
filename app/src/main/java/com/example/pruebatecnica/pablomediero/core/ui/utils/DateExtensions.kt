package com.example.pruebatecnica.pablomediero.core.ui.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun String.toFormattedDate(): String {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    val instant = Instant.parse(this)
    return formatter.format(instant.atZone(ZoneId.systemDefault()))
}