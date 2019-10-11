package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation

import com.cv.cvconcept.basedi.module.SchedulerModule.SchedulerUI
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule.MainDetailsProvider
import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainDetailsPresenter
@Inject constructor(@SchedulerUI private val schedulerUI: Scheduler,
                    @MainDetailsProvider private val mainDetailsProviderObservable: Observable<MainDetailsCvDomainModel>) : MainDetailsFragmentMVP.Presenter {

    private var view: MainDetailsFragmentMVP.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: MainDetailsFragmentMVP.View) {
        this.view = view
        subscribeToMainDetailsProvider()
    }

    private fun subscribeToMainDetailsProvider() {
        compositeDisposable.add(mainDetailsProviderObservable.observeOn(schedulerUI).subscribe {
            view?.showView(it)
        })
    }

    override fun detach() {
        view = null
        compositeDisposable.clear()
    }
}