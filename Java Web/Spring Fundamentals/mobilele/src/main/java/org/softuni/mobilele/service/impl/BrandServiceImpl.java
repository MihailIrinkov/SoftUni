package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.BrandDTO;
import org.softuni.mobilele.model.dto.ModelDTO;
import org.softuni.mobilele.repository.BrandRepository;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    //    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
//        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public List<BrandDTO> getAllBrands() {
//        List<Brand> allBrands = this.modelRepository
//                .findAll()
//                .stream()
//                .map(m -> m.getBrand())
//                .toList();


        // -------------------------
//        Map<String, BrandDTO> brands = new TreeMap<>();
//
//        for (Model m : modelRepository.findAll()) {
//            if(!brands.containsKey(m.getBrand().getName())) {
//                brands.put(m.getBrand().getName(),
//                        new BrandDTO(m.getBrand().getName(),
//                                new ArrayList<>()));
//            }
//            brands.get(m.getBrand().getName()).getModels().add(
//                    new ModelDTO(m.getId(), m.getName()));
//        }
//
//        return brands.values().stream().toList();

        // -----------------------------

        return brandRepository.findAll().stream()
                .map(brand -> new BrandDTO(
                        brand.getName(),
                        brand.getModels().stream()
                                .map(model -> new ModelDTO(model.getId(), model.getName()))
                                .sorted(Comparator.comparing(ModelDTO::getName))
                                .collect(Collectors.toList())))
                .sorted(Comparator.comparing(BrandDTO::getName))
                .collect(Collectors.toList());
    }
}
