package com.example.dddpracticeorder.domain.item;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dddpracticeorder.domain.partner.PartnerReader;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final PartnerReader partnerReader;
    private final ItemStore itemStore;
    private final ItemReader itemReader;
    private final ItemOptionSeriesFactory itemOptionSeriesFactory;

    @Override
    @Transactional
    public String registerItem(ItemCommand.RegisterItemRequest command, String partnerToken) {
        var item = itemStore.store(command.toEntity(partnerReader.getPartner(partnerToken).getId()));
        itemOptionSeriesFactory.store(command, item);
        return item.getItemToken();
    }

    @Override
    @Transactional
    public void changeOnSale(String itemToken) {
        var item = itemReader.getItemBy(itemToken);
        item.changeOnSale();
    }

    @Override
    @Transactional
    public void changeEndOfSale(String itemToken) {
        var item = itemReader.getItemBy(itemToken);
        item.changeEndOfSale();
    }

    @Override
    @Transactional(readOnly = true)
    public ItemInfo.Main retrieveItemInfo(String itemToken) {
        var item = itemReader.getItemBy(itemToken);
        var itemOptionGroupInfoList = itemReader.getItemOptionSeries(item);
        return new ItemInfo.Main(item, itemOptionGroupInfoList);
    }
}
