package com.example.notecollector_v2.service;

import com.example.notecollector_v2.dto.NoteStatus;
import com.example.notecollector_v2.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    void deleteNote(String noteId);
    void updateNote(String noteId, NoteDTO noteDTO);
}
