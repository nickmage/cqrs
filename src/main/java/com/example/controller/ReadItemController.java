package com.example.controller;

import com.example.dto.ReadItemDto;
import com.example.service.ReadItemService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/item/read")
@RequiredArgsConstructor
public class ReadItemController {
    private final ReadItemService readItemService;

    @Get
    public List<ReadItemDto> getAllReadItemDtos(){
        return readItemService.getAllReadItemDtos();
    }

    @Get("/{id}")
    public ReadItemDto getReadItemDtoById(@PathVariable Long id){
        return readItemService.getReadItemDtoById(id);
    }

}
