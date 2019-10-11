package com.cv.cvconcept.cvrepository.model

import com.google.gson.annotations.SerializedName

data class CVs(@SerializedName("cvs") val listOfCvs: List<CV>)