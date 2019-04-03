package com.semeruk.android_dagger2_subcomponents.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

// If we wish to use a component created for the
// entire activity lifecycle,
// we can define our own MainActivityScope interface
@Scope
@Retention(value= RetentionPolicy.RUNTIME)
public @interface MainActivityScope {
}