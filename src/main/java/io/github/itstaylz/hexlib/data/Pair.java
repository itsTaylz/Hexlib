package io.github.itstaylz.hexlib.data;

/**
 * A class used to simply store two values
 * @param key The first value (key)
 * @param value The second value (value)
 * @param <K> The type of the first value (key)
 * @param <V> The type of the second value (value)
 */
public record Pair<K, V>(K key, V value) {
}
