package com.cv.cvconcept.cvrepository.model

import com.google.gson.annotations.SerializedName

data class CvWorkHistory(
    @SerializedName("name") val name: String,
    @SerializedName("position") val position: String,
    @SerializedName("date-from") val dateFrom: String,
    @SerializedName("date-to") val dateTo: String,
    @SerializedName("description") val description: String)