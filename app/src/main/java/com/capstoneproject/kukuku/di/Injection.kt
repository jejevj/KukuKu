package com.capstoneproject.kukuku.di

import com.capstoneproject.kukuku.data.ArticleRepository

object Injection {
    fun provideRepository(): ArticleRepository {
        return ArticleRepository.getInstance()
    }
}