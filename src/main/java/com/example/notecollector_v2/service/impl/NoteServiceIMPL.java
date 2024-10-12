package com.example.notecollector_v2.service.impl;

import jakarta.transaction.Transactional;
import com.example.notecollector_v2.customStatusCodes.SelectedUserAndNoteErrorStatus;
import com.example.notecollector_v2.dao.NoteDao;
import com.example.notecollector_v2.dto.NoteStatus;
import com.example.notecollector_v2.dto.impl.NoteDTO;
import com.example.notecollector_v2.entity.impl.NoteEntity;
import com.example.notecollector_v2.exception.DataPersistException;
import com.example.notecollector_v2.exception.NoteNotFoundException;
import com.example.notecollector_v2.service.NoteService;
import com.example.notecollector_v2.util.AppUtil;
import com.example.notecollector_v2.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NoteServiceIMPL implements NoteService {
   @Autowired
   private NoteDao noteDao;
   @Autowired
   private Mapping noteMapping;

    @Override
    public void saveNote(NoteDTO noteDTO) {
        noteDTO.setNoteId(AppUtil.generateNoteId());
        NoteEntity savedNote =
                noteDao.save(noteMapping.toNoteEntity(noteDTO));
        if(savedNote == null){
            throw new DataPersistException("Note not saved");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteMapping.asNoteDTOList( noteDao.findAll());
    }

    @Override
    public NoteStatus getNote(String noteId) {
       if(noteDao.existsById(noteId)){
           var selectedUser = noteDao.getReferenceById(noteId);
           return noteMapping.toNoteDTO(selectedUser);
       }else {
           return new SelectedUserAndNoteErrorStatus(2,"Selected note not found");
       }
    }

    @Override
    public void deleteNote(String noteId) {
        Optional<NoteEntity> foundNote = noteDao.findById(noteId);
        if (!foundNote.isPresent()) {
            throw new NoteNotFoundException("Note not found");
        }else {
            noteDao.deleteById(noteId);
        }
    }

    @Override
    public void updateNote(String noteId, NoteDTO noteDTO) {
        Optional<NoteEntity> findNote = noteDao.findById(noteId);
        if (!findNote.isPresent()) {
            throw new NoteNotFoundException("Note not found");
        }else {
            findNote.get().setNoteTitle(noteDTO.getNoteTitle());
            findNote.get().setNoteDesc(noteDTO.getNoteDesc());
            findNote.get().setCreatedDate(noteDTO.getCreatedDate());
            findNote.get().setPriorityLevel(noteDTO.getPriorityLevel());
        }
    }
}