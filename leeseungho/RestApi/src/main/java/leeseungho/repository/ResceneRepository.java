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
        save(new Rescene(null, "원이", LocalDate.of(2004,5,25), "리센느", "오이쉬"));
        save(new Rescene(null, "리브", LocalDate.of(2006,10,11), "리센느", "너도? 아, 나도"));
        save(new Rescene(null, "미나미", LocalDate.of(2004,11,29), "리센느", "OO 야호~"));
        save(new Rescene(null, "메이", LocalDate.of(2004,8,19), "리센느", "OO은(는) 그립감이 좋다!"));
        save(new Rescene(null, "제나", LocalDate.of(2004,11,27), "리센느", "내는 원래 OO을(를) 사랑해~!"));
    }

    public Rescene save(Rescene newRescene) {
        Rescene rescene = new Rescene(
                ++sequence,
                newRescene.getName(),
                newRescene.getBirth(),
                newRescene.getGroupName(),
                newRescene.getWord()
        );
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
