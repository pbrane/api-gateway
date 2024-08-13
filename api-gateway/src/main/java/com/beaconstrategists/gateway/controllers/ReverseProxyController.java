package com.beaconstrategists.gateway.controllers;

import com.beaconstrategists.gateway.plugins.EndpointPlugin;
import com.beaconstrategists.gateway.services.PluginLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReverseProxyController {

    @Autowired
    private PluginLoaderService pluginLoaderService;

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    public ResponseEntity<?> handleRequest(
            @RequestHeader Map<String, String> headers,
            @RequestBody(required = false) String body,
            @RequestParam Map<String, String> requestParams,
            @PathVariable Map<String, String> pathVariables
    ) {
        String path = ""; // logic to determine the path from the request
        EndpointPlugin plugin = pluginLoaderService.getPlugin(path);

        if (plugin != null) {
            return plugin.handleRequest(pathVariables, requestParams, headers, body);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

