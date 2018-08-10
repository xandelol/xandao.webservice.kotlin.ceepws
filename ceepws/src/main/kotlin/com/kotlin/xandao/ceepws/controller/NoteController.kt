package com.kotlin.xandao.ceepws.controller

import com.kotlin.xandao.ceepws.model.Note
import com.kotlin.xandao.ceepws.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController{

    @Autowired
    lateinit var noteRepository:NoteRepository

    @GetMapping
    fun list():List<Note>{
        return noteRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody note:Note): Note{
        return noteRepository.save(note)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note):Note{
        if(noteRepository.existsById(id)){
            val safeNote = Note(id, note.title, note.description)
            return noteRepository.save(safeNote)
        }
        return Note()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long){
        if(noteRepository.existsById(id)){
            noteRepository.deleteById(id)
        }
    }
}