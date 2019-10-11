package com.cv.cvconcept.listofcvsactivity.presentation

import com.cv.cvconcept.basedi.module.SchedulerModule.SchedulerUI
import com.cv.cvconcept.listofcvsactivity.domain.CvInteractor
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListOfCvsPresenter
@Inject constructor(private val interactor: CvInteractor,
                    @SchedulerUI private val schedulerUI: Scheduler) : ListOfCvsActivityMVP.Presenter {

    private var view: ListOfCvsActivityMVP.View? = null
    private val compositeDisposable = CompositeDisposable()

    override fun attach(view: ListOfCvsActivityMVP.View) {
        this.view = view

        getAvailableCvs()
    }

    private fun getAvailableCvs() {
        compositeDisposable.add(interactor.getAvailableCvs()
                                        .subscribeOn(schedulerUI)
                                        .subscribe({
                                                       if (it.isEmpty()) {
                                                           view?.showEmptyInfo()
                                                       } else {
                                                           view?.showCvList(it)
                                                       }
                                                   }, {
                                                       view?.showEmptyInfo()
                                                   }))
    }

    override fun detach() {
        view = null
        compositeDisposable.clear()
    }
}