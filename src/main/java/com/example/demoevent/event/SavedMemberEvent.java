package com.example.demoevent.event;

import com.example.demoevent.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavedMemberEvent {
    private MemberDto memberDto;
}
