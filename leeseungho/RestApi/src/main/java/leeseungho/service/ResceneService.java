package leeseungho.service;

import leeseungho.domain.Rescene;
import leeseungho.dto.ResceneRequest;
import leeseungho.dto.ResceneResponse;
import leeseungho.repository.ResceneRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Builder
@Service
@RequiredArgsConstructor
public class ResceneService {
    private final ResceneRepository resceneRepository;

    public ResceneResponse create(ResceneRequest request) {
        Rescene rescene =
                Rescene.builder()
                        .name(request.getName())
                        .birth(request.getBirth())
                        .groupName("Rescene")
                        .word(request.getWord())
                        .build();
                //new Rescene(null, request.getName(), request.getBirth(), request.getGroupName(), request.getWord());
        return new ResceneResponse(resceneRepository.save(rescene));
    }
    public List<ResceneResponse> findAll() {
        return resceneRepository.findAll().stream()
                .map(ResceneResponse::new)
                .toList();
    }
    public ResceneResponse findById(Long id) {
        return new ResceneResponse(resceneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 맴버입니다.")));
    }

    public ResceneResponse update(Long id, ResceneRequest request) {
        Rescene rescene = resceneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 맴버입니다."));

        rescene.update(request.getName(), request.getBirth(), request.getWord());
        return new ResceneResponse(rescene);
    }

    public void delete(Long id) {
        if (!resceneRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 맴버입니다.");
        }
    }
}
