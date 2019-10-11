package com.cv.cvconcept.cvsummaryactivity.presentation

class CvSummaryPresenter: CvSummaryActivityMVP.Presenter {

    private var view: CvSummaryActivityMVP.View? = null

    override fun attach(view: CvSummaryActivityMVP.View) {
        this.view = view
    }

    override fun detach() {
        view = null
    }
}