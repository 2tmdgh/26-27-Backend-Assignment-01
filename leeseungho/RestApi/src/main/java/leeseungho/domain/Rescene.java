package leeseungho.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Rescene {
    private Long id;
    private String name; // 맴버 이름
    private String birth; // 생년월일
    private String major; // 소속 그룹
    private String word; // 유행어

    public void update(String name, String birth, String major, String word) {
        if (name != null) {
            this.name = name;
        }
        if (birth != null) {
            this.birth= birth;
        }
        if (major != null) {
            this.major = major;
        }
        if (word != null) {
            this.word = word;
        }
    }
}
