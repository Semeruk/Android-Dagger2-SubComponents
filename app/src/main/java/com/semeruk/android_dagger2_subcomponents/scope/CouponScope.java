package com.semeruk.android_dagger2_subcomponents.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(value = RetentionPolicy.RUNTIME)
public @interface CouponScope {
}
