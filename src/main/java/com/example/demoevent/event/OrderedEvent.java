package com.example.demoevent.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderedEvent {
    private String productName;
}