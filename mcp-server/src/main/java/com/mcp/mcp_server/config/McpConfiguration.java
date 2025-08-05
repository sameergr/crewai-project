package com.mcp.mcp_server.config;

import com.mcp.mcp_server.controller.SampleController;
import com.mcp.mcp_server.services.ShoppingService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class McpConfiguration {

    @Bean
    public ToolCallbackProvider weatherTools(SampleController sampleController, ShoppingService shoppingService) {
        return  MethodToolCallbackProvider.builder().toolObjects(sampleController, shoppingService).build();
    }

}
