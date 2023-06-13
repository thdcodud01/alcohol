package com.ll.spirits.product.productEntity.pairing;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PairingService {
    private final PairingRepository pairingRepository;

    public List<Pairing> getAllPairing() {
        return pairingRepository.findAll();
    }

    public Pairing getPairingById(Integer pairingId) {
        // Add your logic to retrieve the pairing by ID from the database
        // Example:
        return pairingRepository.findById(pairingId).orElse(null);
    }

    public Pairing getPairing(String pairing) {
        Optional<Pairing> pairing1 = this.pairingRepository.findByPairing(pairing);
        if (pairing1.isPresent()) {
            return pairing1.get();
        } else {
            throw new DataNotFoundException("mainCategory not found");
        }
    }
}
