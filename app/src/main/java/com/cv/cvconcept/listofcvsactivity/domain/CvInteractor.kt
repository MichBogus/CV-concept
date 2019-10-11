package com.cv.cvconcept.listofcvsactivity.domain

import io.reactivex.Single

interface CvInteractor {

    fun getAvailableCvs(): Single<List<CvDomain>>
}