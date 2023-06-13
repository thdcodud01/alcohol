package com.ll.spirits.product.productEntity.abvRange;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ABVrangeService {
    private final ABVrangeRepository abVrangeRepository;

    public List<ABVrange> getAllABVrange() {
        return abVrangeRepository.findAll();
    }

    public ABVrange getABVrangeById(Integer abvRangeId) {
        return abVrangeRepository.findById(abvRangeId).orElse(null);
    }
//    public ABVrange getABVrange(String aBVrange) {
//        Optional<ABVrange> abVrange = this.abVrangeRepository.findByABVrange(aBVrange);
//        if (abVrange.isPresent()) {
//            return abVrange.get();
//        } else {
//            throw new DataNotFoundException("abVrange not found");
//        }
//    }
}
