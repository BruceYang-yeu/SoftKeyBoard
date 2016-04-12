package com.gdbbk.dw.softkeyboard.keyboard;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.util.Log;


import com.gdbbk.dw.softkeyboard.R;
import com.gdbbk.dw.softkeyboard.inputmethodcommon.InputMethodSettingsFragment;


/**
 * Created by Administrator on 16.4.8.
 * Displays the IME preferences inside the input method setting.
 */
public class ImePreferences extends PreferenceActivity {
    private final static String TAG= "BBK_ImePreferences";

    @Override
    public Intent getIntent() {
        final Intent modIntent = new Intent(super.getIntent());
        Log.d(TAG, "["+
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        modIntent.putExtra(EXTRA_SHOW_FRAGMENT, Settings.class.getName());
        modIntent.putExtra(EXTRA_NO_HEADERS, true);
        return modIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "[" +
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
                // We overwrite the title of the activity, as the default one is "Voice Search".
                setTitle(R.string.settings_name);
    }

    @Override
    protected boolean isValidFragment(final String fragmentName) {
        Log.d(TAG, "["+
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        Log.d(TAG, "fragmentName:==>" + fragmentName.toString());
        return Settings.class.getName().equals(fragmentName);
    }

    public static class Settings extends InputMethodSettingsFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "["+
                    Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                    Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                    Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
            setInputMethodSettingsCategoryTitle(R.string.language_selection_title);
            setSubtypeEnablerTitle(R.string.select_language);

            // Load the preferences from an XML resource
          //  addPreferencesFromResource(R.xml.ime_preferences);
        }
    }
}
