package com.ll.spirits;

import com.ll.spirits.product.Product;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@SpringBootTest
class SpiritsApplicationTests {

	@Test
	void contextLoads() {

		Product product = new Product();
		MainCategory mainCategory = new MainCategory();
		SubCategory subCategory = new SubCategory();
		CostRange costRange = new CostRange();
		ABVrange abvRange = new ABVrange();
		NetWeight netWeight = new NetWeight();
		Nation nation = new Nation();
		SiteUser siteUser = new SiteUser();
		Pairing pairing = new Pairing();
		Cask cask = new Cask();
		product.setName("테스트이름");
		product.setAbv(12.3);
		product.setAroma("맛있는향");
		product.setFlavor("맛있는맛");
		product.setInfo("인포주절주절");
		product.setCost(123000);
		mainCategory.setId(1);
		subCategory.setId(1);
		costRange.setId(3);
		abvRange.setId(3);
		netWeight.setId(4);
		nation.setId(2);
		siteUser.setId(5L);
		pairing.setId(1);
		cask.setId(3);

//		saveProductWithAssociations(product, mainCategory, subCategory, costRange, abvRange, netWeight, nation, siteUser, pairing, cask);
	}
}
