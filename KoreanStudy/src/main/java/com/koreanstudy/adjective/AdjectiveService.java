package com.koreanstudy.adjective;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdjectiveService {
private final AdjectiveRepository adjectiveRepository;

public AdjectiveService(AdjectiveRepository adjectiveRepository) {
	this.adjectiveRepository = adjectiveRepository;
}

public List<Adjective> findAllWords(){
	return adjectiveRepository.findAll();
}

}
