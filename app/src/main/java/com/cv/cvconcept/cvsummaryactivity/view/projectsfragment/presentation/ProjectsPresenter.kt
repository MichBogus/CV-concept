package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation

import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.ProjectsProvider
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.domain.ProjectsCvDomainModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ProjectsPresenter
@Inject constructor(@ProjectsProvider private val projectsProviderObservable: Observable<ProjectsCvDomainModel>) : ProjectsFragmentMVP.Presenter {

    private var view: ProjectsFragmentMVP.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: ProjectsFragmentMVP.View) {
        this.view = view

        subscribeToProjectsProviderObservable()
    }

    private fun subscribeToProjectsProviderObservable() {
        compositeDisposable.add(projectsProviderObservable.subscribe {
            view?.showProjectList(it.projects)
        })
    }

    override fun detach() {
        view = null
        compositeDisposable.clear()
    }
}