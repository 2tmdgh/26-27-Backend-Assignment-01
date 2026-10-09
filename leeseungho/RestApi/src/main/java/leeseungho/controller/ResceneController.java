package leeseungho.controller;

import leeseungho.dto.ResceneRequest;
import leeseungho.dto.ResceneResponse;
import leeseungho.service.ResceneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/girlgroups")
public class ResceneController {
    private final ResceneService resceneService;

    @PostMapping
    public ResponseEntity<ResceneResponse> create(@RequestBody ResceneRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(resceneService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ResceneResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(resceneService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResceneResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(resceneService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResceneResponse> update(@PathVariable("id") Long id, @RequestBody ResceneRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(resceneService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        resceneService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

