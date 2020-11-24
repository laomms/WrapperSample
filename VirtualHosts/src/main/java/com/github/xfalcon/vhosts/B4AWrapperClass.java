package B4AWrapperClass;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.IOnActivityResult;
import anywheresoftware.b4a.BA.Permissions;


import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.app.AlertDialog;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.github.clans.fab.FloatingActionButton;
import com.github.xfalcon.vhosts.AdvanceActivity;
import com.github.xfalcon.vhosts.BootReceiver;
import com.github.xfalcon.vhosts.VhostsActivity;
import com.github.xfalcon.vhosts.util.LogUtils;
import com.github.xfalcon.vhosts.vservice.VhostsService;
import com.suke.widget.SwitchButton;

import java.lang.reflect.Field;


@Version(1.0f)
@Permissions(values={"android.permission.INTERNET"})
@ShortName("VirtualHosts")
@ActivityObject
//@Permissions(values = {"appcompat-1.0.0.aar","localbroadcastmanager-1.0.0.aar","com.android.support:appcompat-v7:28.0.0","android.permission.WRITE_EXTERNAL_STORAGE","android.permission.ACCESS_FINE_LOCATION"})
@DependsOn(values={"localbroadcastmanager-1.0.0", "constraintlayout-2.0.4.aar", "constraintlayout-solver-2.0.4","switch-button-0.0.3.aar","com.github.zcweng:switch-button:0.0.3@aar","fab-1.6.4.aar","com.github.clans:fab:1.6.4" ,"Baidu_Mtj_3.9.0.6.jar"} )
public class B4AWrapperClass extends AbsObjectWrapper<VhostsActivity> {

    @Hide
    public static BA ba;
    @Hide
    public static String eventName;
    private static VhostsActivity activityx;
    private IOnActivityResult ion;
    BALayout layout;
    Intent intent;
    Context context;
    private boolean waitingForVPNStart;

    public void Initialize(BA paramBA, String EventName) {
        eventName = EventName.toLowerCase(BA.cul);
        ba = paramBA;
        activityx = new VhostsActivity();
        setObject(activityx);
        intent = new Intent(BA.applicationContext, VhostsActivity.class);
        ba.activity.setContentView(BA.applicationContext.getResources().getIdentifier("activity_vhosts", "layout", BA.packageName));
        ba.activity.startActivity(new Intent(ba.activity.getApplicationContext(), VhostsActivity.class));
    }


  
}
