package com.restaurant.rest.presentation.mapper;

import com.restaurant.domain.model.Dessert;
import com.restaurant.domain.repository.DessertRepository;
import com.restaurant.rest.presentation.dto.DessertDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DessertMapper {

    private final DessertRepository repository;

    public List<Dessert> toDomain(List<DessertDTO> desserts) {
        return desserts.stream()
                .map(this::toDomain)
                .toList();
    }

    public Dessert toDomain(DessertDTO dessert) {
        return new Dessert(dessert.name(), repository);
    }

    public List<DessertDTO> toDTO(List<Dessert> desserts) {
        return desserts.stream()
                .map(this::toDTO)
                .toList();
    }

    public DessertDTO toDTO(Dessert dessert) {
        return new DessertDTO(dessert.name(), dessert.isAvailable());
    }
}
