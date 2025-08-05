package com.mcp.mcp_server.services;

import com.mcp.mcp_server.dto.ShoppingItem;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShoppingService {

    private final Map<String, ShoppingItem> shoppingCart = new ConcurrentHashMap<>();

    // Cruds

    @Tool(name = "addItem", description = "Adds an item to the shopping cart.")
    public ShoppingItem addItem(String itemId, ShoppingItem item) {
        return shoppingCart.put(itemId, item);
    }

    @Tool(name = "removeItem", description = "Removes an item from the shopping cart by its ID.")
    public boolean removeItem(String itemId) {
        return shoppingCart.remove(itemId) != null;
    }

    @Tool(name = "getItem", description = "Retrieves an item from the shopping cart by its ID.")
    public ShoppingItem getItem(String itemId) {
        return shoppingCart.get(itemId);
    }

    @Tool(name = "updateItem", description = "Updates an existing item in the shopping cart.")
    public ShoppingItem updateItem(String itemId, ShoppingItem item) {
        return shoppingCart.replace(itemId, item);
    }

    @Tool(name = "getAllItems", description = "Returns all items in the shopping cart.")
    public List<ShoppingItem> getAllItems() {
        return new ArrayList<>(shoppingCart.values());
    }
}
