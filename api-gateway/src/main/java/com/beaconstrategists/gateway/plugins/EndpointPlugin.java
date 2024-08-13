package com.beaconstrategists.gateway.plugins;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public interface EndpointPlugin {
    String getPath();

    RequestMethod getMethod();

    ResponseEntity<?> handleRequest(Map<String, String> pathVariables, Map<String, String> requestParams, Map<String, String> headers, String body);
}

