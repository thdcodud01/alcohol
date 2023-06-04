package com.ll.spirits.product.productEntity.nation;

import com.ll.spirits.product.productEntity.costRange.CostRange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NationService {
    private final NationRepository nationRepository;

    public List<Nation> getAllNation() {
        return nationRepository.findAll();
    }
}
