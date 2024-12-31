package ru.job4j.lombok.mapstuct.mappers;

import ru.job4j.lombok.mapstuct.dto.StudentDto;
import ru.job4j.lombok.mapstuct.model.StudentEntity;

public class ManualMapper {
    public StudentDto getDto(StudentEntity studentEntity) {
        StudentDto dto = new StudentDto();
        dto.setId(studentEntity.getId());
        dto.setName(studentEntity.getName());
        dto.setClassName(studentEntity.getClassVal());
        return dto;
    }

    public StudentEntity getEntity(StudentDto studentDto) {
        StudentEntity entity = new StudentEntity();
        entity.setId(studentDto.getId());
        entity.setName(entity.getName());
        entity.setClassVal(studentDto.getClassName());
        return entity;
    }
}
