package com.koreanstudy.sport;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SportService {
private final SportRepository sportRepository;

public SportService(SportRepository sportRepository) {
	this.sportRepository = sportRepository;
}

public List<Sport> findAllWords(){
	return sportRepository.findAll();
}

}
