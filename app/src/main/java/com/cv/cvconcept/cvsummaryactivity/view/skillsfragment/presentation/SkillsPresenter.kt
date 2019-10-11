package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation

import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.SkillsProvider
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.domain.SkillsCvDomainModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SkillsPresenter
@Inject constructor(@SkillsProvider private val skillsProviderObservable: Observable<SkillsCvDomainModel>) : SkillsFragmentMVP.Presenter {

    private var view: SkillsFragmentMVP.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: SkillsFragmentMVP.View) {
        this.view = view

        subscribeToSkillsProviderObservable()
    }

    private fun subscribeToSkillsProviderObservable() {
        compositeDisposable.add(skillsProviderObservable.subscribe {
            view?.showList(it.skills)
        })
    }

    override fun detach() {
        view = null
        compositeDisposable.clear()
    }
}