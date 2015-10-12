package com.fox.general;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stephen on 4/15/15.
 */
public class Strings
{
    public static int wordCount( String string )
    {
        return string.split(",|.|\\?|\\s").length;
    }

    public static String empty() {
        return "";
    }

    public static boolean isNullOrWhiteSpace( String str )
    {
        boolean clear = isNullOrEmpty(str);

        boolean clearState = true;
        if ( !clear )
        {
            char[] chars = str.toCharArray();
            for ( char aChar : chars )
            {
                clearState &= aChar == ' ';
            }
        }

        return clear || clearState;
    }

    public static boolean isNullOrEmpty( String str )
    {
        return str == null || str.isEmpty();
    }

    public static Map<String, Integer> listWordCount(String text)
    {
        TreeMap<String, Integer> frequencies = new TreeMap<>();

        String[] words = text.split("\\w+");

        for ( String word : words )
        {
            if(frequencies.containsKey(word))
                frequencies.put(word, 1);
            else
                frequencies.put(word, frequencies.get(word) + 1);
        }

        return frequencies;
    }

    public static String capitalize( String string )
    {
        char[] temp1 = string.toCharArray();
        char caps = Character.toUpperCase(temp1[0]);
        StringBuilder returner = new StringBuilder(Character.toString(caps));

        for ( int i = 1; i < temp1.length; i++ )
        {
            returner.append(temp1[i]);
        }

        return returner.toString();
    }

    public static String substringExcludeIndex( String s, int... ignoreDexs )
    {
        StringBuilder builder = new StringBuilder();

        ArrayList<Integer> indices = new ArrayList<>();

        for ( int ignoreDex : ignoreDexs )
        {
            indices.add(ignoreDex);
        }

        for ( int i = 0; i < s.length(); i++ )
        {
            if (indices.contains(i))
                continue;
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }

    public static boolean isPalindrome(String s)
    {
        boolean cond = true;
        char[] chars = s.toCharArray();

        for ( int i = 0; i < chars.length / 2; i++ )
        {
            cond &= chars[i] == chars[chars.length - 1 - i];
        }

        return cond;
    }
}
