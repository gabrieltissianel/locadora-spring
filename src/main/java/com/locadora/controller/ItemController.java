package com.locadora.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.application.ItemApplication;
import com.locadora.model.Item;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/itens")
@AllArgsConstructor
public class ItemController {

    private final ItemApplication itemApplication;

    @GetMapping("/list")
    public List<Item> list() {
        return itemApplication.list();
    }

    @PostMapping("/add")
    public Item add(@RequestBody Item item) {
        return itemApplication.add(item);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id) {
        itemApplication.remove(id);
    }

    @PostMapping("/edit")
    public Item edit(@RequestBody Item item) {
        return itemApplication.update(item);
    }
}
