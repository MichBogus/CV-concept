package com.cv.cvconcept.base.utils

import android.content.Context
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject

class JsonFileReaderImpl
@Inject constructor(val context: Context) : JsonFileReader {

    override fun read(jsonFileId: Int): String {
        return getAssetJsonData(context.resources.openRawResource(jsonFileId))
    }

    private fun getAssetJsonData(inputStream: InputStream): String {
        var json = ""
        try {
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json

    }
}