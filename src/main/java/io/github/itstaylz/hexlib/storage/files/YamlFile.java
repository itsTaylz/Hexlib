package io.github.itstaylz.hexlib.storage.files;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class YamlFile extends FileBase {

    private YamlConfiguration config;

    public YamlFile(File file) {
        super(file);
        reloadConfig();
    }

    public void reloadConfig() {
        this.config = YamlConfiguration.loadConfiguration(getFile());
    }

    public void save() {
        try {
            this.config.save(getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String path) {
        return this.config.contains(path);
    }

    public void set(String path, Object value) {
        this.config.set(path, value);
    }

    public void setIfNull(String path, Object value) {
        if (!contains(path))
            set(path, value);
    }

    public Object get(String path) {
        return this.config.get(path);
    }

    public <T> T get(String path, Class<T> returnTypeClass) {
        return (T) get(path);
    }

    public <T> T getOrDefault(String path, T defaultValue) {
        if (contains(path))
            return (T) get(path);
        return defaultValue;
    }

    public ConfigurationSection getSection(String path) {
        return config.getConfigurationSection(path);
    }

    public Set<String> getKeys(boolean deep) {
        return config.getKeys(deep);
    }

    public YamlConfiguration getConfig() {
        return config;
    }
}
