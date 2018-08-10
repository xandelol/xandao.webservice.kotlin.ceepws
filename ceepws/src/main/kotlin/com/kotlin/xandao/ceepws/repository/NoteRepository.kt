package com.kotlin.xandao.ceepws.repository

import com.kotlin.xandao.ceepws.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>