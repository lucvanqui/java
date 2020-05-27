package com.example.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.NoteEntity;

@Repository
public class NoteDao extends BaseDao<NoteEntity> {

	public List<NoteEntity> searchByTitleQui(String tile) {
		CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		CriteriaQuery<NoteEntity> criteriaQuery = builder.createQuery(NoteEntity.class);
		Root<NoteEntity> root = criteriaQuery.from(NoteEntity.class);
		criteriaQuery.select(root);
		TypedQuery<NoteEntity> query = this.getEntityManager().createQuery(criteriaQuery);
		return query.getResultList();
	}

	public NoteEntity createNoteMerge(NoteEntity note) {
		return this.merge(note);
	}
	
	public NoteEntity createNotePersist(NoteEntity note) {
		 return this.persistReturnObject(note);
	}
	
}
