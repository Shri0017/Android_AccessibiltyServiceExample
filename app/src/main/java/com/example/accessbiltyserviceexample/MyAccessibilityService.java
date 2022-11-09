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
        Log.e(TAG, "onAccessibilityEvent: Get event Text : "+event.getText() );
        Log.e(TAG, "onAccessibilityEvent: Accessibility Records :-  "+ AccessibilityRecord.obtain(event));
        Log.e(TAG, "onAccessibilityEvent:Get Source:  "+event.getSource());
//        Log.e(TAG, "onAccessibilityEvent: AccessibilityNodeInfo.:  "+AccessibilityNodeInfo.obtain(event.getSource()));
        Log.e(TAG,"----------------------------------------------------------");

//        AccessibilityNodeInfo source = event.getSource();
//        if (source != null) {
////            Log.d(TAG, "onAccessibilityEvent:event.getSource():-  "+source );
//            AccessibilityNodeInfo rowNode = AccessibilityNodeInfo.obtain(source);
////            Log.d(TAG, "onAccessibilityEvent: rowNode :- "+rowNode);
//            AccessibilityNodeInfo labelNode = rowNode.getChild(0);
//            AccessibilityNodeInfo completeNode = rowNode.getChild(1);
//            CharSequence taskLabel = labelNode.getText();
//            Log.d(TAG, "onAccessibilityEvent:taskLabel :-  "+taskLabel );
//
//        }






//        PackageManager packageManager = this.getPackageManager();
//
//        try {
//
//            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName,0);
//            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
//            Log.e(TAG, "App name is : "+applicationLabel);
//
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onInterrupt() {
        Log.e(TAG, "onInterrupt: Someting went wrong" );
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();

        AccessibilityServiceInfo info = new AccessibilityServiceInfo();


//            info.eventTypes = AccessibilityEvent.TYPE_WINDOWS_CHANGED;
//            info.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
//            info.eventTypes = AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED;
//              info.eventTypes =  AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED |AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED| AccessibilityEvent.TYPE_VIEW_CLICKED|AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED|AccessibilityEvent.TYPE_VIEW_FOCUSED|
//                                AccessibilityEvent.TYPE_VIEW_HOVER_ENTER | AccessibilityEvent.TYPE_VIEW_HOVER_EXIT | AccessibilityEvent.TYPE_VIEW_LONG_CLICKED | AccessibilityEvent.TYPE_VIEW_SCROLLED |AccessibilityEvent.TYPE_VIEW_SELECTED |
//                                AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED |AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED | AccessibilityEvent.TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY;
//              info.eventTypes = AccessibilityEvent.WINDOWS_CHANGE_ACCESSIBILITY_FOCUSED | AccessibilityEvent.WINDOWS_CHANGE_ACTIVE | AccessibilityEvent.WINDOWS_CHANGE_ADDED | AccessibilityEvent.WINDOWS_CHANGE_BOUNDS |AccessibilityEvent.WINDOWS_CHANGE_CHILDREN | AccessibilityEvent.WINDOWS_CHANGE_FOCUSED |AccessibilityEvent.WINDOWS_CHANGE_LAYER | AccessibilityEvent.WINDOWS_CHANGE_PARENT | AccessibilityEvent.WINDOWS_CHANGE_PIP | AccessibilityEvent.WINDOWS_CHANGE_TITLE ;
                info.eventTypes = AccessibilityEvent.CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION | AccessibilityEvent.CONTENT_CHANGE_TYPE_DRAG_DROPPED | AccessibilityEvent.CONTENT_CHANGE_TYPE_DRAG_CANCELLED |AccessibilityEvent.CONTENT_CHANGE_TYPE_DRAG_STARTED | AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_APPEARED | AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_TITLE | AccessibilityEvent.CONTENT_CHANGE_TYPE_PANE_DISAPPEARED | AccessibilityEvent.CONTENT_CHANGE_TYPE_STATE_DESCRIPTION |AccessibilityEvent.CONTENT_CHANGE_TYPE_SUBTREE | AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT | AccessibilityEvent.CONTENT_CHANGE_TYPE_UNDEFINED | AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT;
//        info.packageNames = new String[]
//                {"com.flipkart.android", "com.flipkart.android"};

        // Set the type of feedback your service will provide.
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;


        info.notificationTimeout = 100;

        this.setServiceInfo(info);
        Log.e(TAG, "onServiceConnected: ");
    }
}
