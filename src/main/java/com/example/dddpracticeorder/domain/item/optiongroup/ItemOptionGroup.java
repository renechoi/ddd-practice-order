package com.example.dddpracticeorder.domain.item.optiongroup;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import com.example.dddpracticeorder.common.exception.InvalidParamException;
import com.example.dddpracticeorder.domain.AbstractEntity;
import com.example.dddpracticeorder.domain.item.Item;
import com.example.dddpracticeorder.domain.item.option.ItemOption;
import com.google.common.collect.Lists;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Entity
@NoArgsConstructor
@Table(name = "item_option_groups")
public class ItemOptionGroup extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private Integer ordering;
    private String itemOptionGroupName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemOptionGroup", cascade = CascadeType.PERSIST)
    private List<ItemOption> itemOptionList = Lists.newArrayList();

    @Builder
    public ItemOptionGroup(Item item, Integer ordering, String itemOptionGroupName) {
        if (item == null) throw new InvalidParamException("ItemOptionGroup.item");
        if (ordering == null) throw new InvalidParamException("ItemOptionGroup.ordering");
        if (StringUtils.isBlank(itemOptionGroupName))
            throw new InvalidParamException("ItemOptionGroup.itemOptionGroupName");

        this.item = item;
        this.ordering = ordering;
        this.itemOptionGroupName = itemOptionGroupName;
    }

    public ItemOptionGroup addItemOption(ItemOption itemOption) {
        this.itemOptionList.add(itemOption);
        return this;
    }
}
