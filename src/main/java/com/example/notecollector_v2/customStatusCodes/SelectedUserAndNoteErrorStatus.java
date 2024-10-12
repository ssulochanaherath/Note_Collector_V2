package com.example.notecollector_v2.customStatusCodes;

import com.example.notecollector_v2.dto.NoteStatus;
import com.example.notecollector_v2.dto.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedUserAndNoteErrorStatus implements UserStatus, NoteStatus {
    private int statusCode;
    private String statusMessage;
}
