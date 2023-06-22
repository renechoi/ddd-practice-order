package com.example.dddpracticeorder.infrastructure.item;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.example.dddpracticeorder.domain.item.Item;
import com.example.dddpracticeorder.domain.item.ItemCommand;
import com.example.dddpracticeorder.domain.item.ItemOptionSeriesFactory;
import com.example.dddpracticeorder.domain.item.option.ItemOptionStore;
import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroup;
import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroupStore;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ItemOptionSeriesFactoryImpl implements ItemOptionSeriesFactory {
    private final ItemOptionGroupStore itemOptionGroupStore;
    private final ItemOptionStore itemOptionStore;

    @Override
    public List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest command, Item item) {
        var itemOptionGroupRequestList = command.getItemOptionGroupRequestList();
        if (CollectionUtils.isEmpty(itemOptionGroupRequestList)) return Collections.emptyList();

        return itemOptionGroupRequestList.stream()
                .map(requestItemOptionGroup -> {
                    // itemOptionGroup store
                    var itemOptionGroup = itemOptionGroupStore.store(requestItemOptionGroup.toEntity(item));

                    // itemOption store
                    requestItemOptionGroup.getItemOptionRequestList().forEach(requestItemOption -> {
                        itemOptionStore.store(requestItemOption.toEntity(itemOptionGroup));
                    });

                    return itemOptionGroup;
                }).collect(Collectors.toList());
    }
}
