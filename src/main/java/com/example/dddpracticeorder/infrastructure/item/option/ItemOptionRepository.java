package com.example.dddpracticeorder.infrastructure.item.option;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.item.option.ItemOption;

public interface ItemOptionRepository extends JpaRepository<ItemOption, Long> {
}
