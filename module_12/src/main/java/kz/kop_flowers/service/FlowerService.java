package kz.kop_flowers.service;

import kz.kop_flowers.model.dto.FlowerDto;

import java.util.List;

public interface FlowerService {

    List<FlowerDto> getAllFlowers();

    List<FlowerDto> getFlowersByCategory(Integer categoryId);

    FlowerDto getFlowerById(Integer id);

    FlowerDto createFlower(FlowerDto flower);

    void deleteFlowerById(Integer id);

    FlowerDto updateFlower(Integer id, FlowerDto flower);
}
