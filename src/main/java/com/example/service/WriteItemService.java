package com.example.service;

import com.example.entity.ReadItem;
import com.example.entity.WriteItem;
import com.example.repository.ReadItemRepository;
import com.example.repository.WriteItemRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class WriteItemService {

    private final WriteItemRepository writeItemRepository;
    private final ReadItemRepository readItemRepository;

    @Transactional
    public List<WriteItem> getAllWriteItems() {
        return writeItemRepository.findAll();
    }

    @Transactional
    public WriteItem createWriteItem(WriteItem writeItem) {
        ReadItem readItem = convertWriteItemToReadItem(writeItem);
        readItemRepository.save(readItem);

        writeItem.setReadItem(readItem);
        writeItemRepository.save(writeItem);

        return writeItem;
    }

    @Transactional
    public WriteItem updateWriteItem(Long id, WriteItem item) {
        Long readItemToUpdateId = writeItemRepository.findById(id).orElseThrow(NullPointerException::new).getReadItem().getId();
        ReadItem readItemToUpdate = convertWriteItemToReadItem(item);
        readItemToUpdate.setId(readItemToUpdateId);
        readItemRepository.update(readItemToUpdate);

        item.setId(id);
        item.setReadItem(readItemToUpdate);
        return writeItemRepository.update(item);//writeItemRepository.save(item); <- doesn't work (maybe it's a micronaut Crud repository implementation bug)
    }

    @Transactional
    public void deleteWriteItemById(Long id) {
        WriteItem toDelete = writeItemRepository.findById(id).orElseThrow(NullPointerException::new);
        ReadItem r = toDelete.getReadItem();
        writeItemRepository.delete(toDelete);

        readItemRepository.delete(r);
    }

    public ReadItem convertWriteItemToReadItem(WriteItem writeItem) {
        ReadItem readItem = new ReadItem();
        readItem.setProductCode(writeItem.getProductCode());
        readItem.setName(writeItem.getName());
        readItem.setPrice(writeItem.getPrice());
        readItem.setAvailable(writeItem.isAvailable());
        return readItem;
    }

}
