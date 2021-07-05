package de.lemona.android.guice.test;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.job.JobScheduler;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.PowerManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.inject.Inject;
import com.google.inject.Injector;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.lemona.android.guice.Injection;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;

@RunWith(AndroidJUnit4.class)
public class SystemModuleTest {

    @Test
    public void testNotNullInjection() {
        final Context context = getApplicationContext();
        Assert.assertNotNull("Null context in test", context);

        final Injector injector = Injection.createInjector(context);

        Assert.assertNotNull("Null ActivityManager instance", injector.getInstance(ActivityManager.class));
        Assert.assertNotNull("Null AlarmManager instance", injector.getInstance(AlarmManager.class));
        Assert.assertNotNull("Null AudioManager instance", injector.getInstance(AudioManager.class));
        Assert.assertNotNull("Null BatteryManager instance", injector.getInstance(BatteryManager.class));
        Assert.assertNotNull("Null ConnectivityManager instance", injector.getInstance(ConnectivityManager.class));
        Assert.assertNotNull("Null DownloadManager instance", injector.getInstance(DownloadManager.class));
        Assert.assertNotNull("Null InputMethodManager instance", injector.getInstance(InputMethodManager.class));
        Assert.assertNotNull("Null JobScheduler instance", injector.getInstance(JobScheduler.class));
        Assert.assertNotNull("Null KeyguardManager instance", injector.getInstance(KeyguardManager.class));
        Assert.assertNotNull("Null LayoutInflater instance", injector.getInstance(LayoutInflater.class));
        Assert.assertNotNull("Null LocationManager instance", injector.getInstance(LocationManager.class));
        Assert.assertNotNull("Null MediaRouter instance", injector.getInstance(MediaRouter.class));
        Assert.assertNotNull("Null NotificationManager instance", injector.getInstance(NotificationManager.class));
        Assert.assertNotNull("Null PowerManager instance", injector.getInstance(PowerManager.class));
        Assert.assertNotNull("Null SearchManager instance", injector.getInstance(SearchManager.class));
        Assert.assertNotNull("Null SensorManager instance", injector.getInstance(SensorManager.class));
        Assert.assertNotNull("Null StorageManager instance", injector.getInstance(StorageManager.class));
        Assert.assertNotNull("Null SubscriptionManager instance", injector.getInstance(SubscriptionManager.class));
        Assert.assertNotNull("Null TelephonyManager instance", injector.getInstance(TelephonyManager.class));
        Assert.assertNotNull("Null UiModeManager instance", injector.getInstance(UiModeManager.class));
        Assert.assertNotNull("Null Vibrator instance", injector.getInstance(Vibrator.class));
        Assert.assertNotNull("Null WifiManager instance", injector.getInstance(WifiManager.class));
        Assert.assertNotNull("Null WindowManager instance", injector.getInstance(WindowManager.class));
    }

    @Test
    public void testInjectionInstances() {
        final Context context = getApplicationContext();
        Assert.assertNotNull("Null context in test", context);

        final Injector injector = Injection.createInjector(context);

        Assert.assertSame("Wrong ActivityManager instance", context.getSystemService(Context.ACTIVITY_SERVICE), injector.getInstance(ActivityManager.class));
        Assert.assertSame("Wrong AlarmManager instance", context.getSystemService(Context.ALARM_SERVICE), injector.getInstance(AlarmManager.class));
        Assert.assertSame("Wrong AudioManager instance", context.getSystemService(Context.AUDIO_SERVICE), injector.getInstance(AudioManager.class));
        Assert.assertSame("Wrong BatteryManager instance", context.getSystemService(Context.BATTERY_SERVICE), injector.getInstance(BatteryManager.class));
        Assert.assertSame("Wrong ConnectivityManager instance", context.getSystemService(Context.CONNECTIVITY_SERVICE), injector.getInstance(ConnectivityManager.class));
        Assert.assertSame("Wrong DownloadManager instance", context.getSystemService(Context.DOWNLOAD_SERVICE), injector.getInstance(DownloadManager.class));
        Assert.assertSame("Wrong InputMethodManager instance", context.getSystemService(Context.INPUT_METHOD_SERVICE), injector.getInstance(InputMethodManager.class));
        Assert.assertSame("Wrong JobScheduler instance", context.getSystemService(Context.JOB_SCHEDULER_SERVICE), injector.getInstance(JobScheduler.class));
        //Assert.assertSame("Wrong KeyguardManager instance",     context.getSystemService(Context.KEYGUARD_SERVICE),               injector.getInstance(KeyguardManager.class));
        Assert.assertSame("Wrong LayoutInflater instance", context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), injector.getInstance(LayoutInflater.class));
        Assert.assertSame("Wrong LocationManager instance", context.getSystemService(Context.LOCATION_SERVICE), injector.getInstance(LocationManager.class));
        Assert.assertSame("Wrong MediaRouter instance", context.getSystemService(Context.MEDIA_ROUTER_SERVICE), injector.getInstance(MediaRouter.class));
        Assert.assertSame("Wrong NotificationManager instance", context.getSystemService(Context.NOTIFICATION_SERVICE), injector.getInstance(NotificationManager.class));
        Assert.assertSame("Wrong PowerManager instance", context.getSystemService(Context.POWER_SERVICE), injector.getInstance(PowerManager.class));
        Assert.assertSame("Wrong SearchManager instance", context.getSystemService(Context.SEARCH_SERVICE), injector.getInstance(SearchManager.class));
        Assert.assertSame("Wrong SensorManager instance", context.getSystemService(Context.SENSOR_SERVICE), injector.getInstance(SensorManager.class));
        Assert.assertSame("Wrong StorageManager instance", context.getSystemService(Context.STORAGE_SERVICE), injector.getInstance(StorageManager.class));
        Assert.assertSame("Wrong SubscriptionManager instance", context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE), injector.getInstance(SubscriptionManager.class));
        Assert.assertSame("Wrong TelephonyManager instance", context.getSystemService(Context.TELEPHONY_SERVICE), injector.getInstance(TelephonyManager.class));
        Assert.assertSame("Wrong UiModeManager instance", context.getSystemService(Context.UI_MODE_SERVICE), injector.getInstance(UiModeManager.class));
        Assert.assertSame("Wrong Vibrator instance", context.getSystemService(Context.VIBRATOR_SERVICE), injector.getInstance(Vibrator.class));
        Assert.assertSame("Wrong WifiManager instance", context.getSystemService(Context.WIFI_SERVICE), injector.getInstance(WifiManager.class));
        //Assert.assertSame("Wrong WindowManager instance",       context.getSystemService(Context.WINDOW_SERVICE),                 injector.getInstance(WindowManager.class));
    }

    @Test
    public void testInjectee() {
        final Context context = getApplicationContext();
        Assert.assertNotNull("Null context in test", context);

        final Injector injector = Injection.createInjector(context);

        injector.getInstance(SystemServicesInjectee.class).validate(context);
    }

    @Test
    public void testInjection() {
        final Context context = getApplicationContext();
        Assert.assertNotNull("Null context in test", context);

        Injection.createInjector(context).getInstance(SystemServicesInjectee.class).validate(context);
    }

    /* ========================================================================================== */

    public static class SystemServicesInjectee {

        @Inject
        private ActivityManager activityManager;
        @Inject
        private AlarmManager alarmManager;
        @Inject
        private AudioManager audioManager;
        @Inject
        private BatteryManager batteryManager;
        @Inject
        private ConnectivityManager connectivityManager;
        @Inject
        private DownloadManager downloadManager;
        @Inject
        private InputMethodManager inputMethodManager;
        @Inject
        private JobScheduler jobScheduler;
        @Inject
        private KeyguardManager keyguardManager;
        @Inject
        private LayoutInflater layoutInflater;
        @Inject
        private LocationManager locationManager;
        @Inject
        private MediaRouter mediaRouter;
        @Inject
        private NotificationManager notificationManager;
        @Inject
        private PowerManager powerManager;
        @Inject
        private SearchManager searchManager;
        @Inject
        private SensorManager sensorManager;
        @Inject
        private StorageManager storageManager;
        @Inject
        private SubscriptionManager subscriptionManager;
        @Inject
        private TelephonyManager telephonyManager;
        @Inject
        private UiModeManager uiModeManager;
        @Inject
        private Vibrator vibrator;
        @Inject
        private WifiManager wifiManager;
        @Inject
        private WindowManager windowManager;

        public void validate(Context context) {
            Assert.assertNotNull("Null ActivityManager instance", this.activityManager);
            Assert.assertNotNull("Null AlarmManager instance", this.alarmManager);
            Assert.assertNotNull("Null AudioManager instance", this.audioManager);
            Assert.assertNotNull("Null BatteryManager instance", this.batteryManager);
            Assert.assertNotNull("Null ConnectivityManager instance", this.connectivityManager);
            Assert.assertNotNull("Null DownloadManager instance", this.downloadManager);
            Assert.assertNotNull("Null InputMethodManager instance", this.inputMethodManager);
            Assert.assertNotNull("Null JobScheduler instance", this.jobScheduler);
            Assert.assertNotNull("Null KeyguardManager instance", this.keyguardManager);
            Assert.assertNotNull("Null LayoutInflater instance", this.layoutInflater);
            Assert.assertNotNull("Null LocationManager instance", this.locationManager);
            Assert.assertNotNull("Null MediaRouter instance", this.mediaRouter);
            Assert.assertNotNull("Null NotificationManager instance", this.notificationManager);
            Assert.assertNotNull("Null PowerManager instance", this.powerManager);
            Assert.assertNotNull("Null SearchManager instance", this.searchManager);
            Assert.assertNotNull("Null SensorManager instance", this.sensorManager);
            Assert.assertNotNull("Null StorageManager instance", this.storageManager);
            Assert.assertNotNull("Null SubscriptionManager instance", this.subscriptionManager);
            Assert.assertNotNull("Null TelephonyManager instance", this.telephonyManager);
            Assert.assertNotNull("Null UiModeManager instance", this.uiModeManager);
            Assert.assertNotNull("Null Vibrator instance", this.vibrator);
            Assert.assertNotNull("Null WifiManager instance", this.wifiManager);
            Assert.assertNotNull("Null WindowManager instance", this.windowManager);

            Assert.assertSame("Wrong ActivityManager instance", context.getSystemService(Context.ACTIVITY_SERVICE), this.activityManager);
            Assert.assertSame("Wrong AlarmManager instance", context.getSystemService(Context.ALARM_SERVICE), this.alarmManager);
            Assert.assertSame("Wrong AudioManager instance", context.getSystemService(Context.AUDIO_SERVICE), this.audioManager);
            Assert.assertSame("Wrong BatteryManager instance", context.getSystemService(Context.BATTERY_SERVICE), this.batteryManager);
            Assert.assertSame("Wrong ConnectivityManager instance", context.getSystemService(Context.CONNECTIVITY_SERVICE), this.connectivityManager);
            Assert.assertSame("Wrong DownloadManager instance", context.getSystemService(Context.DOWNLOAD_SERVICE), this.downloadManager);
            Assert.assertSame("Wrong InputMethodManager instance", context.getSystemService(Context.INPUT_METHOD_SERVICE), this.inputMethodManager);
            Assert.assertSame("Wrong JobScheduler instance", context.getSystemService(Context.JOB_SCHEDULER_SERVICE), this.jobScheduler);
            //Assert.assertSame("Wrong KeyguardManager instance",     context.getSystemService(Context.KEYGUARD_SERVICE),               this.keyguardManager);
            Assert.assertSame("Wrong LayoutInflater instance", context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), this.layoutInflater);
            Assert.assertSame("Wrong LocationManager instance", context.getSystemService(Context.LOCATION_SERVICE), this.locationManager);
            Assert.assertSame("Wrong MediaRouter instance", context.getSystemService(Context.MEDIA_ROUTER_SERVICE), this.mediaRouter);
            Assert.assertSame("Wrong NotificationManager instance", context.getSystemService(Context.NOTIFICATION_SERVICE), this.notificationManager);
            Assert.assertSame("Wrong PowerManager instance", context.getSystemService(Context.POWER_SERVICE), this.powerManager);
            Assert.assertSame("Wrong SearchManager instance", context.getSystemService(Context.SEARCH_SERVICE), this.searchManager);
            Assert.assertSame("Wrong SensorManager instance", context.getSystemService(Context.SENSOR_SERVICE), this.sensorManager);
            Assert.assertSame("Wrong StorageManager instance", context.getSystemService(Context.STORAGE_SERVICE), this.storageManager);
            Assert.assertSame("Wrong SubscriptionManager instance", context.getSystemService(Context.TELEPHONY_SUBSCRIPTION_SERVICE), this.subscriptionManager);
            Assert.assertSame("Wrong TelephonyManager instance", context.getSystemService(Context.TELEPHONY_SERVICE), this.telephonyManager);
            Assert.assertSame("Wrong UiModeManager instance", context.getSystemService(Context.UI_MODE_SERVICE), this.uiModeManager);
            Assert.assertSame("Wrong Vibrator instance", context.getSystemService(Context.VIBRATOR_SERVICE), this.vibrator);
            Assert.assertSame("Wrong WifiManager instance", context.getSystemService(Context.WIFI_SERVICE), this.wifiManager);
            //Assert.assertSame("Wrong WindowManager instance",       context.getSystemService(Context.WINDOW_SERVICE),                 this.windowManager);
        }
    }

}
