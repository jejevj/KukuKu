package com.capstoneproject.kukuku.ui.screen.home;

import androidx.lifecycle.ViewModel;
import com.capstoneproject.kukuku.data.DessertRepository;
import com.capstoneproject.kukuku.model.DessertList;
import com.capstoneproject.kukuku.ui.common.UiState;
import kotlinx.coroutines.flow.StateFlow;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fR \u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/capstoneproject/kukuku/ui/screen/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/capstoneproject/kukuku/data/DessertRepository;", "(Lcom/capstoneproject/kukuku/data/DessertRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/capstoneproject/kukuku/ui/common/UiState;", "", "Lcom/capstoneproject/kukuku/model/DessertList;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "getAllData", "", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.capstoneproject.kukuku.data.DessertRepository repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.capstoneproject.kukuku.ui.common.UiState<java.util.List<com.capstoneproject.kukuku.model.DessertList>>> _uiState = null;
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.capstoneproject.kukuku.data.DessertRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.capstoneproject.kukuku.ui.common.UiState<java.util.List<com.capstoneproject.kukuku.model.DessertList>>> getUiState() {
        return null;
    }
    
    public final void getAllData() {
    }
}