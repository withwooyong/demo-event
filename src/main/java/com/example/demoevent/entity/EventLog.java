package com.example.demoevent.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EventLog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;

//    누가, 언제, 어떤행위로, 어떤변경을
//    private String type;
//
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    private int published;
//    private LocalDateTime publishedAt;
//
//    private String eventChannel;
//    private String reason;
//    private String requestedBy;
}