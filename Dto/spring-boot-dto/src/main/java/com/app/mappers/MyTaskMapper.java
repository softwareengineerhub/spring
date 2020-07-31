package com.app.mappers;

import com.app.dto.MyTaskDto;
import com.app.model.MyTask;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MyTaskMapper {
    MyTaskMapper INSTANCE = Mappers.getMapper(MyTaskMapper.class);

    MyTaskDto toDto(MyTask myTask);

    MyTask toEntity(MyTaskDto myTaskDto);

    List<MyTaskDto> toDto(List<MyTask> myTask);

    List<MyTask> toEntity(List<MyTaskDto> myTaskDto);


}
