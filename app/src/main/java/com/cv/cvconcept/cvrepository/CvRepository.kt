package com.cv.cvconcept.cvrepository

import com.cv.cvconcept.cvrepository.model.CV

interface CvRepository {

    fun mapJsonToModels(): List<CV>
}