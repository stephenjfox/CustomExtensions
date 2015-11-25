package com.fox.general;

import com.fox.io.log.ConsoleLogger;

import java.lang.reflect.Field;

/**
 * Created by stephen on 4/15/15.
 */
public class ObjectExtension
{
    public static String propertyToString(Object o)
    {
        StringBuilder builder = new StringBuilder();

        // Dependencies and the things we need to do.

        /*
         foreach (var prop in o.GetType().GetProperties())
            {
                Console.WriteLine("Property type before 'for' loop {0}", prop.GetType());
                Console.WriteLine("Property declaring type: " + prop.DeclaringType);
                if (prop.GetValue(o) is IDictionary<object, object>)
                {
                    var tempDict = prop.GetValue(o) as IDictionary<string, int>;
                    builder.AppendFormat("Character {0}: {1}\n", prop.Name, prop.GetValue(o));
                    foreach (var item in tempDict)
                    {
                        builder.AppendFormat("\tKey: {0}, Value: {1}\n ", item.Key, item.Value);
                    }
                }
                else
                {
                    //Debug.Write("Character " + prop.Name + ": " + prop.GetValue(o));
                    builder.AppendFormat("Character {0}: {1}\n", prop.Name, prop.GetValue(o));
                }
            }
         */

        for ( Field field : o.getClass().getFields() ) {

            ConsoleLogger.writeLineFormatted("Property type at top of for-loop: %s", field.getType());
        }

        return builder.toString();
    }
}
