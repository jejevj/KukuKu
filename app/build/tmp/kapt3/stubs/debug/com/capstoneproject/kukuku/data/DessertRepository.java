package com.capstoneproject.kukuku.data;

import com.capstoneproject.kukuku.model.DessertData;
import com.capstoneproject.kukuku.model.DessertList;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/capstoneproject/kukuku/data/DessertRepository;", "", "()V", "dessert", "", "Lcom/capstoneproject/kukuku/model/DessertList;", "getAllData", "Lkotlinx/coroutines/flow/Flow;", "", "getById", "id", "", "Companion", "app_debug"})
public final class DessertRepository {
    private final java.util.List<com.capstoneproject.kukuku.model.DessertList> dessert = null;
    @org.jetbrains.annotations.NotNull
    public static final com.capstoneproject.kukuku.data.DessertRepository.Companion Companion = null;
    @kotlin.jvm.Volatile
    private static volatile com.capstoneproject.kukuku.data.DessertRepository instance;
    
    public DessertRepository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.capstoneproject.kukuku.model.DessertList>> getAllData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.capstoneproject.kukuku.model.DessertList getById(long id) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/capstoneproject/kukuku/data/DessertRepository$Companion;", "", "()V", "instance", "Lcom/capstoneproject/kukuku/data/DessertRepository;", "getInstance", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.capstoneproject.kukuku.data.DessertRepository getInstance() {
            return null;
        }
    }
}