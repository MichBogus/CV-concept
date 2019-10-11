package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation

import com.cv.cvconcept.cvrepository.model.CvProject

interface ProjectsFragmentMVP {

    interface Presenter {
        fun attach(view: View)
        fun detach()
    }

    interface View {
        fun showProjectList(list: List<CvProject>)
    }
}