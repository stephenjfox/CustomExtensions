package com.fox.types;

import com.fox.io.log.ConsoleLogger;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by stephen on 10/10/15.
 */
public class Classes {
    public static <E, T extends E> Class<T> dotClass( Object interfacingInstance ) {

        Class<?> aClass = interfacingInstance.getClass();

        try {
            return dotClass(getPreliminarySuperType(aClass));
        }
        catch (ClassNotFoundException e) {
            ConsoleLogger.exception(e, "Returning null due to {@link ClassNotFoundException}");
            return null;
        }
    }

    public static <E, T extends E> Class<T> dotClass( Type superClass ) throws ClassNotFoundException {
        return (Class<T>) Class.forName(superClass.getTypeName());
    }

    public static <T> Type getPreliminarySuperType( Class<? extends T> aClass ) {
//        Type type = ( (ParameterizedType) suuper ).getActualTypeArguments()[0];

        return ( (ParameterizedType) aClass.getGenericSuperclass() ).getActualTypeArguments()[0];
    }

}
