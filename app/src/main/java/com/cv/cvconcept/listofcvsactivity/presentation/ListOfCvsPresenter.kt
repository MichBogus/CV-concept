package com.cv.cvconcept.listofcvsactivity.presentation

import com.cv.cvconcept.listofcvsactivity.domain.CvInteractor
import javax.inject.Inject

class ListOfCvsPresenter
@Inject constructor(private val interactor: CvInteractor) : ListOfCvsActivityMVP.Presenter {

    private var view: ListOfCvsActivityMVP.View? = null

    override fun attach(view: ListOfCvsActivityMVP.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}