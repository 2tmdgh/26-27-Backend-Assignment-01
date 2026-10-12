package leeseungho.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Rescene {
    private Long id;
    private String name; // 맴버 이름
    private LocalDate birth; // 생년월일
    private String groupName; // 소속 그룹
    private String word; // 유행어

    public void update(String name, LocalDate birth, String groupName, String word) {
        if (name != null) {
            this.name = name;
        }
        if (birth != null) {
            this.birth = birth;
        }
        if (groupName != null) {
            this.groupName = groupName;
        }
        if (word != null) {
            this.word = word;
        }
    }
}
