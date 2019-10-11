package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation

import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.WorkHistoryProvider
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.domain.WorkHistoryCvDomainModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class WorkHistoryPresenter
@Inject constructor(@WorkHistoryProvider private val workHistoryProviderObservable: Observable<WorkHistoryCvDomainModel>) : WorkHistoryFragmentMVP.Presenter {

    private var view: WorkHistoryFragmentMVP.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: WorkHistoryFragmentMVP.View) {
        this.view = view

        subscribeToWorkHistoryProviderObservable()
    }

    private fun subscribeToWorkHistoryProviderObservable() {
        compositeDisposable.add(workHistoryProviderObservable.subscribe {
            view?.showWorkHistoryList(it.workHistory)
        })
    }

    override fun detach() {
        view = null
        compositeDisposable.clear()
    }
}