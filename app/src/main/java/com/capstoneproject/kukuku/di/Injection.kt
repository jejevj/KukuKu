package com.capstoneproject.kukuku.di

import com.capstoneproject.kukuku.data.DessertRepository

object Injection {
    fun provideRepository(): DessertRepository {
        return DessertRepository.getInstance()
    }
}