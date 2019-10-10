package com.cv.cvconcept.cvrepository

import com.cv.cvconcept.R
import com.cv.cvconcept.base.utils.JsonFileReader
import com.cv.cvconcept.cvrepository.model.CV
import com.google.gson.Gson
import javax.inject.Inject

class CvRepositoryImpl
@Inject constructor(private val jsonFileReader: JsonFileReader) : CvRepository {

    override fun mapJsonToModels(): List<CV> = Gson().fromJson(jsonFileReader.read(R.raw.cvs), listOf<CV>()::class.java)
}
