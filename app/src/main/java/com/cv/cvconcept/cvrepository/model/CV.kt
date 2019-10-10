package com.cv.cvconcept.cvrepository.model

import com.google.gson.annotations.SerializedName

data class CV(
    @SerializedName("name") val name: String,
    @SerializedName("surname") val surname: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: String,
    @SerializedName("zip-code") val zipCode: String,
    @SerializedName("city") val city: String,
    @SerializedName("quick-summary") val quickSummary: String,
    @SerializedName("education") val education: List<CvEducation>,
    @SerializedName("work-history") val workHistory: List<CvWorkHistory>,
    @SerializedName("skills") val skills: List<CvSkills>,
    @SerializedName("projects") val projects: List<CvProjects>)