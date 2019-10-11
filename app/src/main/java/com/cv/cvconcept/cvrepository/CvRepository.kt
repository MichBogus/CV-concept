package com.cv.cvconcept.cvrepository

import com.cv.cvconcept.cvrepository.model.CVs

interface CvRepository {

    fun getCVs(): CVs
}