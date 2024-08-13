package com.beaconstrategists.gateway.plugins.impl;

import com.beaconstrategists.gateway.plugins.EndpointPlugin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public class SamplePlugin  implements EndpointPlugin {

    @Override
    public String getPath() {
        return "/sample";
    }

    @Override
    public RequestMethod getMethod() {
        return RequestMethod.GET;
    }

    @Override
    public ResponseEntity<?> handleRequest(Map<String, String> pathVariables, Map<String, String> requestParams, Map<String, String> headers, String body) {
        // Handle request logic
        return ResponseEntity.ok("Sample Plugin Response");
    }
}

