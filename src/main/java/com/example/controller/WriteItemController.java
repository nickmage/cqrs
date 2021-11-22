package com.example.controller;

import com.example.entity.ReadItem;
import com.example.entity.WriteItem;
import com.example.service.ReadItemService;
import com.example.service.WriteItemService;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Controller("/item/write")
@RequiredArgsConstructor
public class WriteItemController {

    private final WriteItemService writeItemService;

    @Get
    public List<WriteItem> getAllWriteItems(){
        return writeItemService.getAllWriteItems();
    }

    @Post
    public WriteItem createWriteItem(@Body WriteItem item){
        return writeItemService.createWriteItem(item);
    }

    @Put("/{id}")
    public WriteItem updateWriteItem(@PathVariable Long id, @Body WriteItem item){
        return writeItemService.updateWriteItem(id, item);
    }

    @Delete("/{id}")
    public Object createWriteItem(@PathVariable Long id){
        writeItemService.deleteWriteItemById(id);
        return new Object();
    }

}
