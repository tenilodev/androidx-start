package com.tenilodev.indekos.injection;



import com.tenilodev.indekos.ui.base.BaseActivity;
import com.tenilodev.indekos.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by azisa on 1/9/2018.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract BaseActivity baseActivity();

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();



}
