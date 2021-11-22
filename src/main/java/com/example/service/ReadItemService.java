package com.example.service;

import com.example.dto.ReadItemDto;
import com.example.repository.ReadItemRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class ReadItemService {

    private final ReadItemRepository readItemRepository;

    public List<ReadItemDto> getAllReadItemDtos() {
        return readItemRepository.findAll().stream()
                .map(ReadItemDto::new)
                .collect(Collectors.toList());
    }

    public ReadItemDto getReadItemDtoById(Long id) {
        return new ReadItemDto(readItemRepository.findById(id).orElseThrow(NullPointerException::new));
    }

}
