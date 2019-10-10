package com.cv.cvconcept.listofcvsactivity.presentation

import javax.inject.Inject

class ListOfCvsPresenter
@Inject constructor() : ListOfCvsActivityMVP.Presenter {

    private var view: ListOfCvsActivityMVP.View? = null

    override fun attach(view: ListOfCvsActivityMVP.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}