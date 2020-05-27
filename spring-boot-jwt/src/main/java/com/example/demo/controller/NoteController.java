package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.NoteModel;
import com.example.demo.service.NoteService;

@RestController
@RequestMapping(value = "note")
public class NoteController {

	@Autowired
	NoteService noteService;

//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public NoteModel addNote(@Valid @RequestBody NoteModel note) {
//		return noteService.createOrUpdate(null, note);
//	}
//	
//	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
//	public NoteModel updateNote(@PathVariable Long id, @Valid @RequestBody NoteModel note) {
//		return noteService.createOrUpdate(id, note);
//	}
//	@RequestMapping(value = "find-all", method = RequestMethod.GET)
//	public List<NoteModel> findAll() {
//		return noteService.findAll();
//	}
//	
	@RequestMapping(method = RequestMethod.GET)
	public List<NoteModel> findByTitle(@PathParam(value = "title") String title) {
		return noteService.findByTitle(title);
	}
	
	@RequestMapping(value = "add-merge", method = RequestMethod.POST)
	public NoteModel addNoteMerge(@Valid @RequestBody NoteModel note) {
		return noteService.addNoteMergeWay(note);
	}
	
	@RequestMapping(value = "add-persist", method = RequestMethod.POST)
	public NoteModel addNotePersist(@Valid @RequestBody NoteModel note) {
		return noteService.addNotePersitWay(note);
	}
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET)
	public NoteModel findById(@PathVariable(value = "id") Long id) throws Exception {
		return noteService.findById(id);
	}
}
