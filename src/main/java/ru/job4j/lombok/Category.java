package ru.job4j.lombok;

import lombok.*;

@EqualsAndHashCode
@RequiredArgsConstructor
@Getter
public class Category {
    @NonNull
    @EqualsAndHashCode.Include
    private int id;

    @Setter
    private String name;
}
