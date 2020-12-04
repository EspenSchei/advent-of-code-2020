package me.espenschei

import java.io.File

object Resources {
    fun readFileAsList(name: String): List<String> =
        File(Resources.javaClass.classLoader.getResource(name)!!.toURI()).readLines()

    fun readFileAsIntList(name: String): List<Int> =
        readFileAsList(name).map { it.toInt() }

    fun readFileAsText(name: String): String =
        File(Resources.javaClass.classLoader.getResource(name)!!.toURI()).readText()
}
