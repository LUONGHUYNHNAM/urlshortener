package com.example.demo.service;

import com.example.demo.entity.ShortUrl;
import com.example.demo.repository.ShortUrlRepository;
import com.example.demo.utils.RandomCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShortUrlService {
    private final ShortUrlRepository repository;

    @Transactional
    public ShortUrl createShortUrl(String originalUrl) {

        String shortCode;
        do {
            shortCode = RandomCodeGenerator.generateShortCode();
        } while (repository.existsByShortCode(shortCode));

        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setShortCode(shortCode);
        shortUrl.setCreateAt(LocalDateTime.now());

        return repository.save(shortUrl);
    }

        public Optional<ShortUrl> getOriginalUrl(String shortCode) {
        Optional<ShortUrl> s =  repository.findByShortCode(shortCode);
        System.out.println(s);
        return repository.findByShortCode(shortCode);
        }
}
//xin chao