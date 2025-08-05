package com.mcp.mcp_server.controller;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Tool(name = "sum", description = "Calculates the sum of two numbers.")
    @GetMapping("/sum")
    public int sum(){
        int a = 5;
        int b = 10;
        return a + b;
    }

}
