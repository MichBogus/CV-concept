package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation

import com.cv.cvconcept.cvrepository.model.CvWorkHistory

interface WorkHistoryFragmentMVP {

    interface Presenter {
        fun attach(view: View)
        fun detach()
    }

    interface View {
        fun showWorkHistoryList(list: List<CvWorkHistory>)
    }
}