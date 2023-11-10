package com.yovvis.function;

/**
 * @author yovvis
 */
@FunctionalInterface
public interface ToBooleanBiFunction<T, U> {
    boolean applyAsBoolean(T var1, U var2);
}
