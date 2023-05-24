package com.ll.alcohol.product;

import com.ll.alcohol.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
