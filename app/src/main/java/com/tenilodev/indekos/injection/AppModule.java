package com.tenilodev.indekos.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by azisa on 1/9/2018.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {


    @Provides
    @Singleton
    Context providesContext(Application application){
        return application.getApplicationContext();
    }
}
