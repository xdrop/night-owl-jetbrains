package me.xdrop.nightowl.utils

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.nio.charset.Charset

@Throws(IOException::class)
fun rewriteStreamTo(input: InputStream, output: OutputStream) {
    val reader = input.reader(Charset.forName("UTF-8"))
    val writer = output.bufferedWriter()

    reader.use {
        writer.use {
            reader.forEachLine {
                writer.write(it)
                writer.newLine()
            }
        }
    }
}

