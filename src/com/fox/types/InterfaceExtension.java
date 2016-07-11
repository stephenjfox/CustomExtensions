package com.fox.types;

import com.fox.io.log.ConsoleLogger;

import java.lang.reflect.Type;

/**
 * Created by stephen on 10/10/15.
 */
public class InterfaceExtension {

  public static <E, T extends E> Class<T> dotClass(Object interfacingInstance) {

    Class<?> aClass = interfacingInstance.getClass();

    try {
      return dotClass(getPreliminaryInterfaceType(aClass));
    } catch (ClassNotFoundException e) {
      ConsoleLogger.exception(e, "Returning null due to {@link ClassNotFoundException}");
      return null;
    }
  }

  public static <E, T extends E> Class<T> dotClass(Type superInterface) throws ClassNotFoundException {
    return (Class<T>) Class.forName(superInterface.getTypeName());
  }

  public static <T> Type getPreliminaryInterfaceType(Class<? extends T> aClass) {
    return aClass.getGenericInterfaces()[0];
  }

}
