package com.ll.spirits.product.productEntity.pairing;

import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PairingService {

    private final PairingRepository pairingRepository;

    public List<Pairing> getAllPairing() {
        return pairingRepository.findAll();
    }

    public List<Pairing> getPairings(List<Integer> pairingIds) {
        return pairingRepository.findByIdIn(pairingIds);
    }

}
