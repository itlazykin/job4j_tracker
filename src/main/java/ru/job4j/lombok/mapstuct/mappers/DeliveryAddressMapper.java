package ru.job4j.lombok.mapstuct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.job4j.lombok.mapstuct.dto.DeliveryAddressDTO;
import ru.job4j.lombok.mapstuct.model.AddressEntity;
import ru.job4j.lombok.mapstuct.model.StudentEntity;

@Mapper
public interface DeliveryAddressMapper {
    @Mapping(source = "student.name", target = "name")
    @Mapping(source = "address.houseNo", target = "houseNumber")
    DeliveryAddressDTO getDeliveryAddress(StudentEntity student, AddressEntity address);
}
