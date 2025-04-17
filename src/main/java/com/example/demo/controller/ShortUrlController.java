package com.example.demo.controller;

import com.example.demo.dto.UrlRequest;
import com.example.demo.entity.ShortUrl;
import com.example.demo.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/url")
@RequiredArgsConstructor
public class ShortUrlController {

    private final ShortUrlService service;

    @PostMapping
    public ResponseEntity<?> createShortUrl(@RequestBody UrlRequest request) {
        ShortUrl shortUrl = service.createShortUrl(request.getOriginalUrl());
        return ResponseEntity.ok("http://localhost:8080/" + shortUrl.getShortCode());
    }


}
