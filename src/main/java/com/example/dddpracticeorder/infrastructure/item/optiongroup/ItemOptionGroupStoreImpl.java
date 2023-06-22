package com.example.dddpracticeorder.infrastructure.item.optiongroup;

import org.springframework.stereotype.Component;

import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroup;
import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroupStore;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionGroupStoreImpl implements ItemOptionGroupStore {

    private final ItemOptionGroupRepository itemOptionGroupRepository;

    @Override
    public ItemOptionGroup store(ItemOptionGroup itemOptionGroup) {
        return itemOptionGroupRepository.save(itemOptionGroup);
    }
}
