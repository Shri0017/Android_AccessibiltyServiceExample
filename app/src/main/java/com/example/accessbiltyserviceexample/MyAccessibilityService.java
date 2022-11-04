package com.example.accessbiltyserviceexample;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityRecord;

public class MyAccessibilityService extends AccessibilityService {

    private static final String TAG = "MyAccessibilityService";



    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.e(TAG, "onAccessibilityEvent: ");

        String packageName = event.getPackageName().toString();
        Log.e(TAG, "onAccessibilityEvent:getPackageName: "+event.getPackageName() );
        Log.e(TAG, "onAccessibilityEvent:getEventType: "+event.getEventType() );
        Log.e(TAG, "onAccessibilityEvent:getAction: "+event.getAction());
        Log.e(TAG, "onAccessibilityEvent: Get Content change type: "+event.getContentChangeTypes());
        Log.e(TAG, "onAccessibilityEvent: Accessibility Records :-  "+ AccessibilityRecord.obtain(event));
//        Log.e(TAG, "onAccessibilityEvent:getSourceData:  "+event.getSource() );


        AccessibilityNodeInfo source = event.getSource();
        if (source != null) {
            Log.d(TAG, "onAccessibilityEvent:event.getSource():-  "+source );
            AccessibilityNodeInfo rowNode = AccessibilityNodeInfo.obtain(source);
            Log.d(TAG, "onAccessibilityEvent: rowNode :- "+rowNode);
            AccessibilityNodeInfo labelNode = rowNode.getChild(0);
            AccessibilityNodeInfo completeNode = rowNode.getChild(1);
            CharSequence taskLabel = labelNode.getText();
            Log.d(TAG, "onAccessibilityEvent:taskLabel :-  "+taskLabel );

        }






        PackageManager packageManager = this.getPackageManager();

        try {

            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName,0);
            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            Log.e(TAG, "App name is : "+applicationLabel);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onInterrupt() {
        Log.e(TAG, "onInterrupt: Someting went wrong" );
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        AccessibilityServiceInfo info = new AccessibilityServiceInfo();


//                info.eventTypes = AccessibilityEvent.TYPE_WINDOWS_CHANGED;
            info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
//            info.eventTypes = AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED;


        info.packageNames = new String[]
                {"com.whatsapp", "com.whatsapp"};

        // Set the type of feedback your service will provide.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;


        info.notificationTimeout = 100;

        this.setServiceInfo(info);
        Log.e(TAG, "onServiceConnected: ");
    }
}
