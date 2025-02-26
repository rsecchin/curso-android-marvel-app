package com.example.marvelapp.framework.di

import com.example.usecase.GetCharactersUseCase
import com.example.usecase.GetCharactersUseCaseImpl
import com.example.usecase.GetCharacterCategoriesUseCase
import com.example.usecase.GetCharacterCategoriesUseCaseImpl
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
    fun bindGetComicUseCase(
        useCaseImpl: GetCharacterCategoriesUseCaseImpl
    ) : GetCharacterCategoriesUseCase
}