package ru.job4j.lombok.mapstuct;

import org.mapstruct.factory.Mappers;
import ru.job4j.lombok.mapstuct.dto.DeliveryAddressDTO;
import ru.job4j.lombok.mapstuct.dto.StudentDto;
import ru.job4j.lombok.mapstuct.dto.StudentSubjectDto;
import ru.job4j.lombok.mapstuct.mappers.DeliveryAddressMapper;
import ru.job4j.lombok.mapstuct.mappers.StudentSubjectMapper;
import ru.job4j.lombok.mapstuct.model.AddressEntity;
import ru.job4j.lombok.mapstuct.model.StudentEntity;
import ru.job4j.lombok.mapstuct.mappers.StudentMapper;
import ru.job4j.lombok.mapstuct.model.StudentSubject;
import ru.job4j.lombok.mapstuct.model.SubjectEntity;

public class Main {
    public static void main(String[] args) {
        StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);
        StudentEntity studentEntity = new StudentEntity(0, "entity", "junior");
        StudentDto studentDto = new StudentDto(11, "dto", "middle");
        StudentDto fromEntity = studentMapper.getModelFromEntity(studentEntity);
        System.out.println("fromEntity - " + fromEntity);
        StudentEntity fromDto = studentMapper.getModelFromDto(studentDto);
        System.out.println("fromDto - " + fromDto);
        System.out.println();
        DeliveryAddressMapper deliveryAddressMapper = Mappers.getMapper(DeliveryAddressMapper.class);
        StudentEntity sEntity = new StudentEntity(0, "entity", "junior");
        StudentDto sDto = new StudentDto(11, "dto", "middle");
        AddressEntity address = new AddressEntity(100, "cityGood", "stateNew");
        DeliveryAddressDTO deliveryAddressDTO = deliveryAddressMapper.getDeliveryAddress(sEntity, address);
        System.out.println("deliveryAddressDTO = " + deliveryAddressDTO);
        System.out.println();
        StudentSubjectMapper studentSubjectMapper = Mappers.getMapper(StudentSubjectMapper.class);
        StudentSubject studentSubject = new StudentSubject(420, "name", "classVal", new SubjectEntity());
        StudentSubjectDto studentSubjectDto = studentSubjectMapper.getModelFromEntity(studentSubject);
        System.out.println("studentSubjectDto - " + studentSubjectDto);
    }
}
