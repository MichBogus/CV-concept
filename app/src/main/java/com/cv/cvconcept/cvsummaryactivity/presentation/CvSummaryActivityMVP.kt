package com.cv.cvconcept.cvsummaryactivity.presentation

interface CvSummaryActivityMVP {

    interface Presenter {
        fun attach(view: View, cvId: Long)
        fun detach()
    }

    interface View {

    }
}