package com.ll.spirits.product.productEntity.cask;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
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

    public Cask getCaskById(Integer caskId) {
        // Add your logic to retrieve the cask by ID from the database
        // Example:
        return caskRepository.findById(caskId).orElse(null);
    }
    public Cask getCask(String cask) {
        Optional<Cask> cask1 = this.caskRepository.findByCask(cask);
        if (cask1.isPresent()) {
            return cask1.get();
        } else {
            throw new DataNotFoundException("cask not found");
        }
    }
}
