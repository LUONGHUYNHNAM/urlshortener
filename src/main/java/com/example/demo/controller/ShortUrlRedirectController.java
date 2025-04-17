package com.example.demo.controller;

import com.example.demo.entity.ShortUrl;
import com.example.demo.service.ShortUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ShortUrlRedirectController {

    private final ShortUrlService service;

    @GetMapping("/{shortCode}")
    public ResponseEntity<?> redirect(@PathVariable String shortCode) {
        Optional<ShortUrl> shortUrlOpt = service.getOriginalUrl(shortCode);
        if (shortUrlOpt.isPresent()) {
            String originalUrl = shortUrlOpt.get().getOriginalUrl();
                return ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create(originalUrl))
                        .build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Short URL not found");
        }

    }
}
