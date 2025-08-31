package com.koreanstudy.food;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "food")
public class Word {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name_jp;
	private String name_kr;
}
