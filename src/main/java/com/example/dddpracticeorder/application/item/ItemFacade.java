package com.example.dddpracticeorder.application.item;

import org.springframework.stereotype.Service;

import com.example.dddpracticeorder.domain.item.ItemCommand;
import com.example.dddpracticeorder.domain.item.ItemInfo;
import com.example.dddpracticeorder.domain.item.ItemService;
import com.example.dddpracticeorder.domain.notification.NotificationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemFacade {
    private final ItemService itemService;
    private final NotificationService notificationService;

    public String registerItem(ItemCommand.RegisterItemRequest request, String partnerToken) {
        var itemToken = itemService.registerItem(request, partnerToken);
        notificationService.sendEmail(null, null, null);
        return itemToken;
    }

    public void changeOnSaleItem(String itemToken) {
        itemService.changeOnSale(itemToken);
    }

    public void changeEndOfSaleItem(String itemToken) {
        itemService.changeEndOfSale(itemToken);
    }

    public ItemInfo.Main retrieveItemInfo(String itemToken) {
        return itemService.retrieveItemInfo(itemToken);
    }
}
