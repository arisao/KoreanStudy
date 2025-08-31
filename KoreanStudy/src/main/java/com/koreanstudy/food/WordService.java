package com.koreanstudy.food;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WordService {
private final WordRepository wordRepository;

public WordService(WordRepository wordRepository) {
	this.wordRepository = wordRepository;
}

public List<Word> findAllWords(){
	return wordRepository.findAll();
}

}
