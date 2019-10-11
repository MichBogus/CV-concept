package com.cv.cvconcept.cvrepository.model

import com.google.gson.annotations.SerializedName

data class CvProject(
    @SerializedName("name") val name: String,
    @SerializedName("googleplaylink") val link: String,
    @SerializedName("description") val description: String)
