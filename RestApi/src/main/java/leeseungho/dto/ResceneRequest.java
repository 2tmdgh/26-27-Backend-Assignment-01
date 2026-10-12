package leeseungho.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter

public class ResceneRequest {
    private String name;
    private LocalDate birth;
    private String groupName;
    private String word;
}
