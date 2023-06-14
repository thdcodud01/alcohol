package com.ll.spirits.product.productEntity.netWeight;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.nation.Nation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NetWeightService {
    private final NetWeightRepository netWeightRepository;

    public List<NetWeight> getAllNetWeight() {
        return netWeightRepository.findAll();
    }

    public NetWeight getNetWeightById(Integer netWeightRangeId) {
        return netWeightRepository.findById(netWeightRangeId).orElse(null);
    }
    public NetWeight getNetWeight(String netWeight) {
        Optional<NetWeight> netWeight1 = this.netWeightRepository.findByNetWeight(netWeight);
        if (netWeight1.isPresent()) {
            return netWeight1.get();
        } else {
            throw new DataNotFoundException("netWeight not found");
        }
    }
}
