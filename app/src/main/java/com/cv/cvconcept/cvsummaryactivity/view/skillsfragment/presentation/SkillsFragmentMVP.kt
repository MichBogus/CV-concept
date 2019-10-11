package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation

import com.cv.cvconcept.cvrepository.model.CvSkill

interface SkillsFragmentMVP {

    interface Presenter {
        fun attach(view: View)
        fun detach()
    }

    interface View {
        fun showList(list: List<CvSkill>)
    }
}