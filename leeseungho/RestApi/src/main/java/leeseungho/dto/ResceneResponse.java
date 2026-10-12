package leeseungho.dto;

import leeseungho.domain.Rescene;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@RequiredArgsConstructor
public class ResceneResponse {
    private final Long id; // -> record 타입으로 변경 가능
    private final String name;
    private final LocalDate birth;
    private final String groupName;
    private final String word;

    public ResceneResponse(Rescene rescene) {
        this.id = rescene.getId();
        this.name = rescene.getName();
        this.birth = rescene.getBirth();
        this.groupName = rescene.getGroupName();
        this.word = rescene.getWord();
    }
}

/*
public record ResceneResponse(
        Long id,
        String name,
        LocalDate birth,
        String groupName,
        String word
)
{
public ResceneResponse(Rescene rescene) {
    this(
        rescene.getId(),
        rescene.getName(),
        rescene.getBirth(),
        rescene.getGroupName(),
        rescene.getWord()
        );
    }
}
 */
