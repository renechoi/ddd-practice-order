package com.example.dddpracticeorder.infrastructure.item.optiongroup;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.item.optiongroup.ItemOptionGroup;

public interface ItemOptionGroupRepository extends JpaRepository<ItemOptionGroup, Long> {
}
