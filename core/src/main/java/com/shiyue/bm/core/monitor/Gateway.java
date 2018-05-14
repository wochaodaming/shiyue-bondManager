package com.shiyue.bm.core.monitor;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by lishenghao01 on 16/9/24.
 */
@Target(METHOD)
@Retention(RUNTIME)
@Inherited
@Documented
public @interface Gateway {
}
