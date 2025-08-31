package com.koreanstudy.adverb;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adverbs")
public class AdverbController {
	
private final AdverbService adjectiveService;

public AdverbController(AdverbService adjectiveService) {
	this.adjectiveService = adjectiveService;
}

@GetMapping
public List<Adverb> getAllWords(){
	return adjectiveService.findAllWords();
}
}
