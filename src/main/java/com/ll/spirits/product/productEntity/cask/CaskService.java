package com.ll.spirits.product.productEntity.cask;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CaskService {
    private final CaskRepository caskRepository;

    public List<Cask> getAllCask() {
        return caskRepository.findAll();
    }

    public List<Cask> getCasks(List<Integer> caskIds) {
        return caskRepository.findByIdIn(caskIds);
    }

}
