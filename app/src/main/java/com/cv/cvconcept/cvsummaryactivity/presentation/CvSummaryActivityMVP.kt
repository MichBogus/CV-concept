package com.cv.cvconcept.cvsummaryactivity.presentation

interface CvSummaryActivityMVP {

    interface Presenter {
        fun attach(view: View)
        fun detach()
    }

    interface View {

    }
}