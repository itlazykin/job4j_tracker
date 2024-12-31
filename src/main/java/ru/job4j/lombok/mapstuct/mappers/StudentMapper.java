package ru.job4j.lombok.mapstuct.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.lombok.mapstuct.dto.StudentDto;
import ru.job4j.lombok.mapstuct.model.StudentEntity;

@Mapper
public interface StudentMapper {
    @Mapping(target = "className", source = "classVal")
    StudentDto getModelFromEntity(StudentEntity studentEntity);

    @InheritInverseConfiguration
    StudentEntity getModelFromDto(StudentDto studentDto);

    default StudentDto getModelFromEntityCustom(StudentEntity studentEntity) {
        StudentDto student = new StudentDto();
        student.setId(studentEntity.getId());
        student.setName(studentEntity.getName());
        student.setClassName(studentEntity.getClassVal());
        return student;
    }
}
