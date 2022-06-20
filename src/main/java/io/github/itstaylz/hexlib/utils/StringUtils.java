package io.github.itstaylz.hexlib.utils;

import net.md_5.bungee.api.ChatColor;

public final class StringUtils {

    public static String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String appendArray(String[] array, String inBetween) {
        return appendArray(array, inBetween, 0, array.length);
    }

    public static String appendArray(String[] array, String inBetween, int starting) {
        return appendArray(array, inBetween, starting, array.length);
    }

    public static String appendArray(String[] array, String inBetween, int starting, int ending) {
        StringBuilder sb = new StringBuilder();
        for (int i = starting; i < ending - 1; i++) {
            sb.append(array[i]).append(inBetween);
        }
        sb.append(array[ending-1]);
        return sb.toString();
    }
}
