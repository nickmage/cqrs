package com.example.controller;

import com.example.entity.UserView;
import com.example.service.MaterializedViewService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Controller("/view")
public class MaterializedViewController {

    private final MaterializedViewService viewService;

    @Get
    public List<UserView> getAllViews() {
        return viewService.getAllViews();
    }

    @Get("/{id}")
    public UserView getViewById(@PathVariable Long id) {
        return viewService.getViewById(id);
    }

    @Post("/refresh")
    public String refreshView() {
        viewService.refreshView();
        return "UserView refreshed successfully";
    }

}
