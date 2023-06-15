package com.ll.spirits.product.productEntity.nation;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NationService {
    private final NationRepository nationRepository;

    public List<Nation> getAllNation() {
        return nationRepository.findAll();
    }

    public Nation getNationById(Integer nationId) {
        return nationRepository.findById(nationId).orElse(null);
    }
    public Nation getNation(String nation) {
        Optional<Nation> nation1 = this.nationRepository.findByNation(nation);
        if (nation1.isPresent()) {
            return nation1.get();
        } else {
            throw new DataNotFoundException("nation not found");
        }
    }
}
