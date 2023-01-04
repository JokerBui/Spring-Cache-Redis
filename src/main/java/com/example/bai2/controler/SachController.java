package com.example.bai2.controler;


import com.example.bai2.sach.Sach;
import com.example.bai2.service.SachService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sach")
@Slf4j
public class SachController {
    @Autowired
    private SachService service;


    @GetMapping("/")
    public ResponseEntity<List<Sach>> showSachList() {
        return ResponseEntity.ok(service.listAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Sach> SachNewForm(@RequestBody Sach sach) {
        return ResponseEntity.ok(service.save(sach));
    }
    @CachePut(value = "sach",  key = "#id")
    @PutMapping("/update/{id}")
    public ResponseEntity<Sach> SachUpdate(@PathVariable Integer id,@RequestBody Sach sach) throws Exception {
        return ResponseEntity.ok(service.update(id, sach));
    }
    @CacheEvict(value = "sach",key = "#id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Sach> SachDelete(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.delete(id));
    }
    @Cacheable(key = "#id", value = "sach" )
    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Sach>> SachGetId(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.listAllById(id));
    }
    @Cacheable(key = "#keyword", value = "sach" )
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Sach>> search(@PathVariable String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }
    @Cacheable(key = "#keyword", value = "sach" )
    @GetMapping("/searchNative/{keyword}")
    public ResponseEntity<List<Sach>> searchNative(@PathVariable String keyword) {
        return ResponseEntity.ok(service.searchNative(keyword));
    }

}
