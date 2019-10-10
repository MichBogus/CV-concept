package com.cv.cvconcept.cvrepository.model

import com.google.gson.annotations.SerializedName

data class CvEducation(
    @SerializedName("name") val name: String,
    @SerializedName("specialisation") val specialisation: String,
    @SerializedName("date-from") val dateFrom: String,
    @SerializedName("date-to") val dateTo: String)