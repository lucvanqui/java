package com.example.demo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.example.demo.model.NoteModel;

@Entity
@Table(name = "note")
public class NoteEntity extends Audit {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
    private String title;

    @NotBlank
    private String content;

   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public static NoteModel convertToModel(NoteEntity entity) {
		NoteModel model = new NoteModel();
		model.setContent(entity.getContent());
		model.setTitle(entity.getTitle());
		model.setId(entity.getId());
		return model;
	}
}
