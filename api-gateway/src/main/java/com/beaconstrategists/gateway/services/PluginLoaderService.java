package com.beaconstrategists.gateway.services;

import com.beaconstrategists.gateway.plugins.EndpointPlugin;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@Service
public class PluginLoaderService {

    private final Map<String, EndpointPlugin> plugins = new HashMap<>();

    public PluginLoaderService() {
        loadPlugins();
    }

    private void loadPlugins() {
        ServiceLoader<EndpointPlugin> loader = ServiceLoader.load(EndpointPlugin.class);
        for (EndpointPlugin plugin : loader) {
            plugins.put(plugin.getPath(), plugin);
        }
    }

    public EndpointPlugin getPlugin(String path) {
        return plugins.get(path);
    }
}

