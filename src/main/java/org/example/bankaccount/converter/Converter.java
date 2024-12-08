package org.example.bankaccount.converter;

public interface Converter<Entity, RequestDto, ResponseDto>{

    ResponseDto toDto(Entity entity);

    Entity toEntity(RequestDto dto);
}
