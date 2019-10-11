package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation

import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel

interface MainDetailsFragmentMVP {

    interface Presenter {
        fun attach(view: View)
        fun detach()
    }

    interface View {
        fun showView(model: MainDetailsCvDomainModel)
    }
}