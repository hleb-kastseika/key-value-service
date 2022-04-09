package hk.keyvalue.controller;

import hk.keyvalue.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class StorageController {
    @Autowired
    StorageService storageService;

    @GetMapping("/{key}")
    public String getValue(@PathVariable String key) {
        String value = storageService.get(key);
        if (value == null) {
            throw new ResponseStatusException(NOT_FOUND, "Value not found");
        }
        return value;
    }

    @PostMapping("/{key}/{value}")
    public void saveValue(@PathVariable String key, @PathVariable String value) {
        storageService.save(key, value);
    }
}
