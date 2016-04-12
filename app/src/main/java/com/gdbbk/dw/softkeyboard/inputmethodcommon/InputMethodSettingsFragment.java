package com.gdbbk.dw.softkeyboard.inputmethodcommon;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

/**
 * Created by Administrator on 16.4.8.
 * This is a helper class for an IME's settings preference fragment. It's recommended for every
 * IME to have its own settings preference fragment which inherits this class.
 */
public abstract class InputMethodSettingsFragment extends PreferenceFragment
        implements InputMethodSettingsInterface{
    private final static String TAG= "BBK_SettingsFragment";
    private final InputMethodSettingsImpl mSettings = new InputMethodSettingsImpl();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Context context = getActivity();
        Log.d(TAG, "[" +
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        setPreferenceScreen(getPreferenceManager().createPreferenceScreen(context));
        mSettings.init(context, getPreferenceScreen());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInputMethodSettingsCategoryTitle(int resId) {
        Log.d(TAG, "[" +
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        mSettings.setInputMethodSettingsCategoryTitle(resId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInputMethodSettingsCategoryTitle(CharSequence title) {
        Log.d(TAG, "[" +
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        mSettings.setInputMethodSettingsCategoryTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSubtypeEnablerTitle(int resId) {
        mSettings.setSubtypeEnablerTitle(resId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSubtypeEnablerTitle(CharSequence title) {
        Log.d(TAG, "[" +
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        mSettings.setSubtypeEnablerTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSubtypeEnablerIcon(int resId) {
        mSettings.setSubtypeEnablerIcon(resId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSubtypeEnablerIcon(Drawable drawable) {
        mSettings.setSubtypeEnablerIcon(drawable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onResume() {
        Log.d(TAG, "[" +
                Thread.currentThread().getStackTrace()[2].getFileName() + "_" +
                Thread.currentThread().getStackTrace()[2].getLineNumber() + "_" +
                Thread.currentThread().getStackTrace()[2].getMethodName() + "]");
        super.onResume();
        mSettings.updateSubtypeEnabler();
    }

}
