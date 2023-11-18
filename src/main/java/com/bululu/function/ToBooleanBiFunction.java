package com.bululu.function;

/**
 * <origin：lang3>
 *
 * @author yovvis
 */
@FunctionalInterface
public interface ToBooleanBiFunction<T, U> {
    boolean applyAsBoolean(T var1, U var2);
}
