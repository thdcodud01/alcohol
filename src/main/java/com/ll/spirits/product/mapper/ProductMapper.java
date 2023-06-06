package com.ll.spirits.product.mapper;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.dto.ProductDTO;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductDTO toProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setSubCategory(product.getSubCategory());
        productDTO.setCostRange(product.getCostRange());
        productDTO.setAbvRange(product.getAbvRange());
        productDTO.setNetWeight(product.getNetWeight());
        productDTO.setPairings(product.getPairings());
        productDTO.setCasks(product.getCasks());
        productDTO.setNation(product.getNation());
        return productDTO;
    }

    public List<ProductDTO> toProductDTOList(List<Product> productList) {
        return productList.stream()
                .map(this::toProductDTO)
                .collect(Collectors.toList());
    }
}

// ProductDTO와 Product 객체 간의 매핑을 담당
// toProductDTO 메서드는 단일 Product 객체를 ProductDTO로 매핑하고,
// toProductDTOList 메서드는 Product 객체의 리스트를 ProductDTO의 리스트로 매핑

