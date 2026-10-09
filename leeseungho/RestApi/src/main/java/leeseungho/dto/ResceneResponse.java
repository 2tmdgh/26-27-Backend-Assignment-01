package leeseungho.dto;

import leeseungho.domain.Rescene;
import lombok.Getter;

@Getter
public class ResceneResponse {
    private final Long id;
    private final String name;
    private final String birth;
    private final String major;
    private final String word;

    public ResceneResponse(Rescene rescene) {
        this.id = rescene.getId();
        this.name = rescene.getName();
        this.birth = rescene.getBirth();
        this.major = rescene.getMajor();
        this.word = rescene.getWord();
    }
}
