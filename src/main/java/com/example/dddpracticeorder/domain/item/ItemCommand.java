package com.example.dddpracticeorder.domain.item;

import java.util.List;

import com.example.dddpracticeorder.domain.item.option.ItemOption;
import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroup;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

public class ItemCommand {

    @Getter
    @Builder
    @ToString
    public static class RegisterItemRequest {
        private final String itemName;
        private final Long itemPrice;
        private final List<RegisterItemOptionGroupRequest> itemOptionGroupRequestList; // ex) 색상, 사이즈

        public Item toEntity(Long partnerId) {
            return Item.builder()
                    .partnerId(partnerId)
                    .itemName(itemName)
                    .itemPrice(itemPrice)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterItemOptionGroupRequest {  // ex) 색상
        private final Integer ordering;
        private final String itemOptionGroupName;
        private final List<RegisterItemOptionRequest> itemOptionRequestList;  // ex) R, B, W

        public ItemOptionGroup toEntity(Item item) {
            return ItemOptionGroup.builder()
                    .item(item)
                    .ordering(ordering)
                    .itemOptionGroupName(itemOptionGroupName)
                    .build();
        }
    }

    @Getter
    @Builder
    @ToString
    public static class RegisterItemOptionRequest {
        private final Integer ordering;
        private final String itemOptionName;
        private final Long itemOptionPrice;

        public ItemOption toEntity(ItemOptionGroup itemOptionGroup) {
            return ItemOption.builder()
                    .itemOptionGroup(itemOptionGroup)
                    .ordering(ordering)
                    .itemOptionName(itemOptionName)
                    .itemOptionPrice(itemOptionPrice)
                    .build();
        }
    }
}
