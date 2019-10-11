package com.cv.cvconcept.listofcvsactivity.presentation

import com.cv.cvconcept.listofcvsactivity.domain.CvDomain

interface ListOfCvsActivityMVP {

    interface Presenter {

        fun attach(view: View)
        fun detach()
    }

    interface View {
        fun showCvList(list: List<CvDomain>)
        fun showEmptyInfo()
    }
}
