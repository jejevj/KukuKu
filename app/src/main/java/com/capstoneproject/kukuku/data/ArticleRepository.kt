package com.capstoneproject.kukuku.data

import com.capstoneproject.kukuku.model.ArticleList
import com.capstoneproject.kukuku.model.ArticletData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepository {

    private val dessert = mutableListOf<ArticleList>()

    init {
        if (dessert.isEmpty()) {
            ArticletData.articles.forEach {
                dessert.add(ArticleList(it, 0))
            }
        }
    }

    fun getAllData(): Flow<List<ArticleList>> {
        return flowOf(dessert)
    }

    fun getById(id: Long): ArticleList {
        return dessert.first {
            it.article.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: ArticleRepository? = null

        fun getInstance(): ArticleRepository =
            instance ?: synchronized(this) {
                ArticleRepository().apply {
                    instance = this
                }
            }
    }
}