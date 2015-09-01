package io.anotherwise.flashlight;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;

/**
 * Created by marcelobarbosa on 9/1/15.
 */
public class Flashlight {

    private static Camera camera;
    private static Camera.Parameters params;
    private static boolean hasFlash;

    public Flashlight(Context context){
        hasFlash = context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public Camera getCamera() {
        if (camera == null) {
            camera = Camera.open();
            params = camera.getParameters();
        }
        return camera;
    }

    public String flashSwitch(){
        if(hasFlash){
            getCamera();
            if (params.getFlashMode() != "torch") {
                params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(params);
                camera.startPreview();
            } else {
                params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(params);
                camera.stopPreview();
            }
        }
        return params.getFlashMode();
    }
}
