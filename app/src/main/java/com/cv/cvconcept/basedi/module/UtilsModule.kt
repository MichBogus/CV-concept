package com.cv.cvconcept.basedi.module

import com.cv.cvconcept.base.utils.JsonFileReader
import com.cv.cvconcept.base.utils.JsonFileReaderImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UtilsModule {

    @Binds
    abstract fun bindsJsonFileReader(reader: JsonFileReaderImpl): JsonFileReader
}