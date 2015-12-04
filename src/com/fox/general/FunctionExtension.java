package com.fox.general;

import java.util.function.Function;

/**
 * Created by stephen on 10/8/15.
 */
public class FunctionExtension {

    public interface Getter<T> {
        default <B> Function<B, T> asFunction() {
            return b -> this.apply();
        }

        T apply();
    }

}
