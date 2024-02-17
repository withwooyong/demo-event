package com.example.demoevent.event;

import com.example.demoevent.dto.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberEvent {
    private MemberDto memberDto;
}
