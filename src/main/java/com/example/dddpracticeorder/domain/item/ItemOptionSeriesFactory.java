package com.example.dddpracticeorder.domain.item;

import java.util.List;

import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroup;

public interface ItemOptionSeriesFactory {
    List<ItemOptionGroup> store(ItemCommand.RegisterItemRequest request, Item item);
}
