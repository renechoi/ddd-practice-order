package com.example.dddpracticeorder.infrastructure.item;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.item.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemToken(String itemToken);
}
