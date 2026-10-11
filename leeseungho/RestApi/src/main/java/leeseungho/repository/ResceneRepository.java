package leeseungho.repository;

import leeseungho.domain.Rescene;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ResceneRepository {
    private final Map<Long, Rescene> girlgroup = new HashMap<>();
    private long sequence = 0L;

    public ResceneRepository() {
        save(Rescene.builder()
                .name("원이")
                .birth(LocalDate.of(2004, 5, 25))
                .groupName("리센느")
                .word("오이쉬")
                .build());
        save(Rescene.builder()
                .name("리브")
                .birth(LocalDate.of(2006, 10, 11))
                .groupName("리센느")
                .word("너도? 아, 나도")
                .build());
        save(Rescene.builder()
                .name("미나미")
                .birth(LocalDate.of(2006, 11, 29))
                .groupName("리센느")
                .word("OO 야호~")
                .build());
        save(Rescene.builder()
                .name("메이")
                .birth(LocalDate.of(2008, 8, 19))
                .groupName("리센느")
                .word("OO은 그립감이 좋다!")
                .build());
        save(Rescene.builder()
                .name("제나")
                .birth(LocalDate.of(2008, 11, 27))
                .groupName("리센느")
                .word("내는 원래 OO을 사랑해")
                .build());
    }

    public Rescene save(Rescene newRescene) {
        Rescene rescene = Rescene.builder()
                .id(++sequence)
                .name(newRescene.getName())
                .birth(newRescene.getBirth())
                .groupName(newRescene.getGroupName())
                .word(newRescene.getWord())
                .build();
        girlgroup.put(rescene.getId(), rescene);
        return rescene;
    }

    public List<Rescene> findAll() {
        return new ArrayList<>(girlgroup.values());
    }

    public Optional<Rescene> findById(Long id) {
        return Optional.ofNullable(girlgroup.get(id));
    }

    public boolean delete(Long id) {
        return girlgroup.remove(id) != null;
    }
}
