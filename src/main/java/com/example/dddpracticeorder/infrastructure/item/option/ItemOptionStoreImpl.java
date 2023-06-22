package com.example.dddpracticeorder.infrastructure.item.option;

import org.springframework.stereotype.Component;

import com.example.dddpracticeorder.domain.item.option.ItemOption;
import com.example.dddpracticeorder.domain.item.option.ItemOptionStore;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionStoreImpl implements ItemOptionStore {

    private final ItemOptionRepository itemOptionRepository;

    @Override
    public void store(ItemOption itemOption) {
        itemOptionRepository.save(itemOption);
    }
}
