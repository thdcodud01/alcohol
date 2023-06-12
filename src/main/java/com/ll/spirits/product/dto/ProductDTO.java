package com.ll.spirits.product.dto;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class ProductDTO {
    private Integer id;
    private SubCategory subCategory;
    private CostRange costRange;
    private ABVrange abvRange;
    private NetWeight netWeight;
    private List<Pairing> pairings;
    private List<Cask> casks;
    private Nation nation;

    public static ProductDTO fromProduct(Product product) {
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

    public Product toProduct() {
        Product product = new Product();
        product.setId(this.id);
        product.setSubCategory(this.subCategory);
        product.setCostRange(this.costRange);
        product.setAbvRange(this.abvRange);
        product.setNetWeight(this.netWeight);
        product.setPairings(this.pairings);
        product.setCasks(this.casks);
        product.setNation(this.nation);
        // 필요한 필드들을 설정하고, 추가적인 로직을 구현합니다.
        return product;
    }
}



