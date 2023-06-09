package com.ll.spirits.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class ProductFilter {
    private Integer mainCategoryId;
    private Integer subCategoryId;
    private Integer costRangeId;
    private Integer abvRangeId;
    private Integer netWeightRangeId;
    private List<Integer> pairingIds;
    private List<Integer> caskIds;
    private Integer nationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public void setMainCategoryId(Integer mainCategoryId) {
        this.mainCategoryId = mainCategoryId;
    }

    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public void setCostRangeId(Integer costRangeId) {
        this.costRangeId = costRangeId;
    }

    public void setAbvRangeId(Integer abvRangeId) {
        this.abvRangeId = abvRangeId;
    }

    public void setNetWeightRangeId(Integer netWeightRangeId) {
        this.netWeightRangeId = netWeightRangeId;
    }

    public void setPairingIds(List<Integer> pairingIds) {
        this.pairingIds = pairingIds;
    }

    public void setCaskIds(List<Integer> caskIds) {
        this.caskIds = caskIds;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }
}

