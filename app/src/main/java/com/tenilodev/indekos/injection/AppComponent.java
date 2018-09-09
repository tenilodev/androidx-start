package com.tenilodev.indekos.injection;

import android.app.Application;

import com.tenilodev.indekos.AndroidStarterApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by azisa on 1/9/2018.
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, NetworkModule.class ,ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance Builder application(Application application);
        Builder networkModule(NetworkModule networkModule);
        AppComponent build();
    }

    void inject(AndroidStarterApplication application);

    @Override
    void inject(DaggerApplication instance);
}
