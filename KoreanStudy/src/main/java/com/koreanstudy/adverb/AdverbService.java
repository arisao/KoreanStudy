package com.koreanstudy.adverb;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdverbService {
private final AdverbRepository adjectiveRepository;

public AdverbService(AdverbRepository adjectiveRepository) {
	this.adjectiveRepository = adjectiveRepository;
}

public List<Adverb> findAllWords(){
	return adjectiveRepository.findAll();
}

}
