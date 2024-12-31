package ru.job4j.lombok.mapstuct.spring;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RestController
@RequestMapping("/api/item")
public class TrackerController {
    private final TrackerService trackerService;

    @PostMapping
    public ItemDtoResponse save(@RequestBody ItemDtoRequest itemDtoRequest) {
        return trackerService.save(itemDtoRequest);
    }
}
