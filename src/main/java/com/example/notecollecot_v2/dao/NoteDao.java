package lk.ijse.gdse.aad67.NoteCollector_V2.dao;

import lk.ijse.gdse.aad67.NoteCollector_V2.entity.impl.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, String> {

}
