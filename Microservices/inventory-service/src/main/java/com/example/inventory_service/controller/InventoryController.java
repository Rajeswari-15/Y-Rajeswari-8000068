package com.example.inventory_service.controller;

import com.example.inventoryservice.entity.Inventory;

import com.example.inventoryservice.service.InventoryService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(
            InventoryService service) {

        this.service = service;

    }

    @PostMapping
    public Inventory saveInventory(
            @RequestBody Inventory inventory) {

        return service.save(inventory);

    }

    @GetMapping
    public List<Inventory> getInventory() {

        return service.getAllInventory();

    }

}