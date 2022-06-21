package com.example.marvelapp.framework.di

import com.example.core.usecase.GetCharactersUseCase
import com.example.core.usecase.GetCharactersUseCaseImpl
import com.example.core.usecase.GetComicUseCase
import com.example.core.usecase.GetComicsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindGetCharacterUseCase( useCase: GetCharactersUseCaseImpl) : GetCharactersUseCase

    @Binds
    fun bindGetComicUseCase(useCaseImpl: GetComicsUseCaseImpl) : GetComicUseCase
}