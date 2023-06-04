package com.ll.spirits.product.productEntity.pairing;

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
}
