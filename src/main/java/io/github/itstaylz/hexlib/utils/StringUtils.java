package io.github.itstaylz.hexlib.utils;

import net.md_5.bungee.api.ChatColor;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A set of utilities to use for Strings
 */
public final class StringUtils {

    private static final Pattern HEX_PATTERN = Pattern.compile("#([a-f]|[A-F]|\\d){6}");

    /**
     * Replaces & color codes with the respective ChatColor
     * @param text The text to be colorized
     * @return The colorized text
     */
    public static String colorize(@NotNull String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    /**
     * Replaces hex color codes with the respective ChatColor
     * @param text The text to be colorized
     * @return The colorized text
     */
    public static String hexColorize(@NotNull String text) {
        Matcher matcher = HEX_PATTERN.matcher(text);
        while (matcher.find()) {
            String code = matcher.group();
            text = text.replaceFirst(code, ChatColor.of(code).toString());
        }
        return text;
    }

    /**
     * Colorizes all & and hex color codes in a string
     * @param text The text to be colorized
     * @return The colorized text
     */
    public static String fullColorize(@NotNull String text) {
        return hexColorize(colorize(text));
    }

    /**
     * Merges a string array into a single String
     * @param array The array to be merged
     * @param inBetween The string to be placed between each string in the array
     * @return The merged string
     */
    public static String appendArray(@NotNull String[] array, String inBetween) {
        return appendArray(array, inBetween, 0, array.length);
    }

    /**
     * Merges a string array into a single String
     * @param array The array to be merged
     * @param inBetween The string to be placed between each string in the array
     * @param starting The starting index of the array
     * @return The merged string
     */
    public static String appendArray(@NotNull String[] array, String inBetween, int starting) {
        return appendArray(array, inBetween, starting, array.length);
    }

    /**
     * Merges a string array into a single String
     * @param array The array to be merged
     * @param inBetween The string to be placed between each string in the array
     * @param starting The starting index of the array
     * @param ending The ending index of the array
     * @return The merged string
     */
    public static String appendArray(@NotNull String[] array, String inBetween, int starting, int ending) {
        StringBuilder sb = new StringBuilder();
        for (int i = starting; i < ending - 1; i++) {
            sb.append(array[i]).append(inBetween);
        }
        sb.append(array[ending-1]);
        return sb.toString();
    }
}
