package com.ll.spirits.product.productEntity.netWeight;

import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.nation.Nation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NetWeightService {
    private final NetWeightRepository netWeightRepository;

    public List<NetWeight> getAllNetWeight() {
        return netWeightRepository.findAll();
    }

    public NetWeight getNetWeight(Integer netWeightRangeId) {
        return netWeightRepository.findById(netWeightRangeId).orElse(null);
    }
}
