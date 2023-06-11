package com.ll.spirits.product.productEntity.cask;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CaskService {
    private final CaskRepository caskRepository;

    public List<Cask> getAllCask() {
        return caskRepository.findAll();
    }
}
