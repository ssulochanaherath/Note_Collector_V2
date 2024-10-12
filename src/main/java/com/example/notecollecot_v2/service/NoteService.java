package lk.ijse.gdse.aad67.NoteCollector_V2.service;

import lk.ijse.gdse.aad67.NoteCollector_V2.dto.NoteStatus;
import lk.ijse.gdse.aad67.NoteCollector_V2.dto.impl.NoteDTO;

import java.util.List;

public interface NoteService {
    void saveNote(NoteDTO noteDTO);
    List<NoteDTO> getAllNotes();
    NoteStatus getNote(String noteId);
    void deleteNote(String noteId);
    void updateNote(String noteId, NoteDTO noteDTO);
}
