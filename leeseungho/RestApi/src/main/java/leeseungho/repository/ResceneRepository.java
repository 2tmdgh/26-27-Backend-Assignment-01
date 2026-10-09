package leeseungho.repository;

import leeseungho.domain.Rescene;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ResceneRepository {
    private final Map<Long, Rescene> girlgroup = new HashMap<>();
    private long sequence = 0L;

    public ResceneRepository() {
        save(new Rescene(null, "원이", "20040525", "리센느", "오이쉬"));
        save(new Rescene(null, "리브", "20061011", "리센느", "너도? 아, 나도"));
        save(new Rescene(null, "미나미", "20061129", "리센느", "OO 야호"));
        save(new Rescene(null, "메이", "20080819", "리센느", "기회는 그립감이 좋다!"));
        save(new Rescene(null, "제나", "20081127", "리센느", "내는 원래 OO을 사랑해"));
    }

    public Rescene save(Rescene newRescene) {
        Rescene rescene = new Rescene(++sequence, newRescene.getName(),
                newRescene.getBirth(), newRescene.getMajor(), newRescene.getWord());
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