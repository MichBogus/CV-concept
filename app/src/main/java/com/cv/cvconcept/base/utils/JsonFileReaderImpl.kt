package com.cv.cvconcept.base.utils

import android.content.Context
import java.io.*
import javax.inject.Inject

class JsonFileReaderImpl
@Inject constructor(val context: Context) : JsonFileReader {

    override fun read(jsonFileId: Int): String {
        return readTextFile(context.resources.openRawResource(jsonFileId))
    }

    private fun readTextFile(inputStream: InputStream): String {
        val outputStream = ByteArrayOutputStream()

        val buffer = ByteArray(1024)
        var lenght = 0
        try {
            while (lenght != -1) {
                lenght = inputStream.read(buffer)
                outputStream.write(buffer, 0, lenght)
            }
            outputStream.close()
            inputStream.close()
        } catch (e: IOException) {

        }
        return outputStream.toString()
    }
}