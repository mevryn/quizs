package com.mpk.repositories;

import com.mpk.entities.card.CharacterCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CharacterCardRepository extends CrudRepository<CharacterCard, Integer>, PagingAndSortingRepository<CharacterCard, Integer> {

    @Query("select C from CharacterCard C")
    Iterable<CharacterCard> findAllCharacterCards();
}
