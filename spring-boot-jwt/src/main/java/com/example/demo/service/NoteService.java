package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.NoteDao;
import com.example.demo.entity.NoteEntity;
import com.example.demo.model.NoteModel;

@Service
public class NoteService {

	@Autowired
	private NoteDao noteDao;
	
//	public NoteModel createOrUpdate(Long id, NoteModel note) {
//		if (id != null) {
//			NoteEntity existed = noteDao.findById(id).orElse(null);
//			if (existed != null) {
//				existed.setContent(note.getContent());
//				existed.setTitle(note.getTitle());
//				note.setId(existed.getId());
//				noteDao.save(existed);
//			}
//		} else {
//			NoteEntity entity = new NoteEntity();
//			entity.setContent(note.getContent());
//			entity.setTitle(note.getTitle());
//			NoteEntity stored = noteDao.save(entity);
//			note.setId(stored.getId());
//		}
//		return note;
//
//	}
//
//	public NoteModel findById(Long id) {
//		NoteEntity existed = noteDao.findById(id).orElse(null);
//		NoteModel result = null;
//		if (existed != null) {
//			result = new NoteModel();
//			result.setId(existed.getId());
//			result.setContent(existed.getContent());
//			result.setTitle(existed.getTitle());
//		}
//		
//		return result;
//	}
//
//	public List<NoteModel> findAll() {
//		List<NoteEntity> existeds = noteDao.findAll();
//		List<NoteModel> result = new ArrayList<NoteModel>();
//		existeds.stream().map(NoteEntity::convertToModel).forEach(result::add);
//		return result;
//	}
//
	public List<NoteModel> findByTitle(String title) {
		List<NoteEntity> existeds = noteDao.searchByTitleQui(title);
		List<NoteModel> result = new ArrayList<NoteModel>();
		existeds.stream().map(NoteEntity::convertToModel).forEach(result::add);
		return result;
	}
	
	@Transactional
	public NoteModel addNoteMergeWay(NoteModel note) {
		NoteEntity entity = new NoteEntity();
		entity.setContent(note.getContent());
		entity.setTitle(note.getTitle());
		NoteEntity mergedEntity = noteDao.createNoteMerge(entity);
		entity.setContent("DefaultMerge");
		entity.setTitle("DefaultMerge");
		return NoteEntity.convertToModel(mergedEntity);
	}
	
	@Transactional
	public NoteModel addNotePersitWay(NoteModel note) {
		NoteEntity entity = new NoteEntity();
		entity.setContent(note.getContent());
		entity.setTitle(note.getTitle());
		NoteEntity mergedEntity = noteDao.createNotePersist(entity);
		mergedEntity.setTitle("DefaultPersit");
		mergedEntity.setContent("DefaultPersist");
		return NoteEntity.convertToModel(mergedEntity);
	}
	
	@Transactional
	public NoteModel findById(Long id) throws Exception {
		NoteEntity existed = noteDao.find(id);
		if (existed== null) {
			throw new Exception("Not Found");
		}
		noteDao.clear();
		existed.setContent("findAndUpdate");
		existed.setTitle("FindAndUpdate");
		NoteEntity merge = noteDao.merge(existed);
		return NoteEntity.convertToModel(merge);
	}
}
