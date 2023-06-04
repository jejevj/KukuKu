package com.capstoneproject.kukuku;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavHostController;
import com.capstoneproject.kukuku.databinding.ActivityCameraBinding;
import dagger.hilt.android.AndroidEntryPoint;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0004R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/capstoneproject/kukuku/CameraActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "navController", "Landroidx/navigation/NavHostController;", "(Landroidx/navigation/NavHostController;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "imageCapture", "Landroidx/camera/core/ImageCapture;", "getNavController", "()Landroidx/navigation/NavHostController;", "setNavController", "viewBinding", "Lcom/capstoneproject/kukuku/databinding/ActivityCameraBinding;", "allPermissionsGranted", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestPermissions", "startCamera", "takePhoto", "Companion", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class CameraActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull
    private androidx.navigation.NavHostController navController;
    private com.capstoneproject.kukuku.databinding.ActivityCameraBinding viewBinding;
    private androidx.camera.core.ImageCapture imageCapture;
    private java.util.concurrent.ExecutorService cameraExecutor;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> activityResultLauncher = null;
    @org.jetbrains.annotations.NotNull
    public static final com.capstoneproject.kukuku.CameraActivity.Companion Companion = null;
    private static final java.lang.String TAG = "CameraXApp";
    private static final java.lang.String FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS";
    private static final java.lang.String[] REQUIRED_PERMISSIONS = null;
    
    public CameraActivity(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.navigation.NavHostController getNavController() {
        return null;
    }
    
    public final void setNavController(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController p0) {
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void takePhoto() {
    }
    
    private final void startCamera() {
    }
    
    private final void requestPermissions() {
    }
    
    private final boolean allPermissionsGranted() {
        return false;
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/capstoneproject/kukuku/CameraActivity$Companion;", "", "()V", "FILENAME_FORMAT", "", "REQUIRED_PERMISSIONS", "", "[Ljava/lang/String;", "TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}