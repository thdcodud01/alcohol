package com.ll.spirits.product.productEntity.abvRange;

import com.ll.spirits.product.productEntity.costRange.CostRange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ABVrangeService {
    private final ABVrangeRepository abVrangeRepository;

    public List<ABVrange> getAllABVrange() {
        return abVrangeRepository.findAll();
    }
}
