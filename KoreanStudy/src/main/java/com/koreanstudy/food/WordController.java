package com.koreanstudy.food;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/words")
public class WordController {
	
private final WordService wordService;

public WordController(WordService wordService) {
	this.wordService = wordService;
}

@GetMapping
public List<Word> getAllWords(){
	return wordService.findAllWords();
}
}
