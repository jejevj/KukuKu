package com.capstoneproject.kukuku.ui.navigation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0007\b\t\n\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/capstoneproject/kukuku/ui/navigation/Screen;", "", "route", "", "(Ljava/lang/String;)V", "getRoute", "()Ljava/lang/String;", "Detail", "Home", "Profile", "Result", "Splash", "Lcom/capstoneproject/kukuku/ui/navigation/Screen$Detail;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen$Home;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen$Profile;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen$Result;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen$Splash;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    
    private Screen(java.lang.String route) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/capstoneproject/kukuku/ui/navigation/Screen$Splash;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Splash extends com.capstoneproject.kukuku.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.capstoneproject.kukuku.ui.navigation.Screen.Splash INSTANCE = null;
        
        private Splash() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/capstoneproject/kukuku/ui/navigation/Screen$Home;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Home extends com.capstoneproject.kukuku.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.capstoneproject.kukuku.ui.navigation.Screen.Home INSTANCE = null;
        
        private Home() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/capstoneproject/kukuku/ui/navigation/Screen$Profile;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Profile extends com.capstoneproject.kukuku.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.capstoneproject.kukuku.ui.navigation.Screen.Profile INSTANCE = null;
        
        private Profile() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/capstoneproject/kukuku/ui/navigation/Screen$Result;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen;", "()V", "app_debug"})
    public static final class Result extends com.capstoneproject.kukuku.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.capstoneproject.kukuku.ui.navigation.Screen.Result INSTANCE = null;
        
        private Result() {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/capstoneproject/kukuku/ui/navigation/Screen$Detail;", "Lcom/capstoneproject/kukuku/ui/navigation/Screen;", "()V", "createRoute", "", "id", "", "app_debug"})
    public static final class Detail extends com.capstoneproject.kukuku.ui.navigation.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.capstoneproject.kukuku.ui.navigation.Screen.Detail INSTANCE = null;
        
        private Detail() {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String createRoute(long id) {
            return null;
        }
    }
}