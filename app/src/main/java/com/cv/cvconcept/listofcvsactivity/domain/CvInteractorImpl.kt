package com.cv.cvconcept.listofcvsactivity.domain

import com.cv.cvconcept.cvrepository.CvRepository
import io.reactivex.Single
import javax.inject.Inject

class CvInteractorImpl
@Inject constructor(private val repository: CvRepository) : CvInteractor {

    override fun getAvailableCvs(): Single<List<CvDomain>> =
        Single.create { emitter ->
            emitter.onSuccess(repository.getCVs().listOfCvs.map {
                CvDomain(it.id, it.name, it.surname, it.phone, it.email)
            })
        }
}