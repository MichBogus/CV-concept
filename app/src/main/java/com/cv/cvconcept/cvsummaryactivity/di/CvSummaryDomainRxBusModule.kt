package com.cv.cvconcept.cvsummaryactivity.di

import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.domain.ProjectsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.domain.SkillsCvDomainModel
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.domain.WorkHistoryCvDomainModel
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.subjects.AsyncSubject
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import javax.inject.Qualifier

@Module
class CvSummaryDomainRxBusModule {

    private val mainDetailsProviderSubject: Subject<MainDetailsCvDomainModel> = AsyncSubject.create()
    private val projectsProviderSubject: Subject<ProjectsCvDomainModel> = AsyncSubject.create()
    private val skillsProviderSubject: Subject<SkillsCvDomainModel> = AsyncSubject.create()
    private val workHistoryProviderSubject: Subject<WorkHistoryCvDomainModel> = AsyncSubject.create()

    @Provides
    @MainDetailsProvider
    fun mainDetailsProviderObserver(): Subject<MainDetailsCvDomainModel> = mainDetailsProviderSubject

    @Provides
    @MainDetailsProvider
    fun mainDetailsProviderObservable(): Observable<MainDetailsCvDomainModel> = mainDetailsProviderSubject.hide()

    @Qualifier
    annotation class MainDetailsProvider

    @Provides
    @ProjectsProvider
    fun projectsProviderObserver(): Subject<ProjectsCvDomainModel> = projectsProviderSubject

    @Provides
    @ProjectsProvider
    fun projectsProviderObservable(): Observable<ProjectsCvDomainModel> = projectsProviderSubject.hide()

    @Qualifier
    annotation class ProjectsProvider

    @Provides
    @SkillsProvider
    fun skillsProviderObserver(): Subject<SkillsCvDomainModel> = skillsProviderSubject

    @Provides
    @SkillsProvider
    fun skillsProviderObservable(): Observable<SkillsCvDomainModel> = skillsProviderSubject.hide()

    @Qualifier
    annotation class SkillsProvider

    @Provides
    @WorkHistoryProvider
    fun workHistoryProviderObserver(): Subject<WorkHistoryCvDomainModel> = workHistoryProviderSubject

    @Provides
    @WorkHistoryProvider
    fun workHistoryProviderSObservable(): Observable<WorkHistoryCvDomainModel> = workHistoryProviderSubject.hide()

    @Qualifier
    annotation class WorkHistoryProvider
}