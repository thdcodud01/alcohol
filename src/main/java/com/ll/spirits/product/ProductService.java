package com.ll.spirits.product;

import com.ll.spirits.DataNotFoundException;
import com.ll.spirits.product.productEntity.abvRange.ABVrange;
import com.ll.spirits.product.productEntity.abvRange.ABVrangeRepository;
import com.ll.spirits.product.productEntity.cask.Cask;
import com.ll.spirits.product.productEntity.cask.CaskRepository;
import com.ll.spirits.product.productEntity.costRange.CostRange;
import com.ll.spirits.product.productEntity.costRange.CostRangeRepository;
import com.ll.spirits.product.productEntity.mainCategory.MainCategory;
import com.ll.spirits.product.productEntity.mainCategory.MainCategoryRepository;
import com.ll.spirits.product.productEntity.nation.Nation;
import com.ll.spirits.product.productEntity.nation.NationRepository;
import com.ll.spirits.product.productEntity.netWeight.NetWeight;
import com.ll.spirits.product.productEntity.netWeight.NetWeightRepository;
import com.ll.spirits.product.productEntity.pairing.Pairing;
import com.ll.spirits.product.productEntity.pairing.PairingRepository;
import com.ll.spirits.product.productEntity.subCategory.SubCategory;
import com.ll.spirits.product.productEntity.subCategory.SubCategoryRepository;
import com.ll.spirits.review.Review;
import com.ll.spirits.review.ReviewRepository;
import com.ll.spirits.user.SiteUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
@Data
@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductForm productForm;
    private final ProductRepository productRepository;
    // 이하 외래키로 들어오는 것들.
    private final ReviewRepository reviewRepository;
    private final MainCategoryRepository mainCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final CostRangeRepository costRangeRepository;
    private final ABVrangeRepository abvRangeRepository;
    private final NetWeightRepository netWeightRepository;
    private final NationRepository nationRepository;
    private final CaskRepository caskRepository;
    private final PairingRepository pairingRepository;
    private final EntityManager entityManager;

    public List<Product> getTopVotedProducts(int limit) {
        String jpql = "SELECT p FROM Product p ORDER BY SIZE(p.voter) DESC";
        TypedQuery<Product> query = entityManager.createQuery(jpql, Product.class);
        query.setMaxResults(limit);
        return query.getResultList();
    }
    public List<Product> getList() {
        return this.productRepository.findAll();
    }
    public Product getProduct(Integer id) {
        Optional<Product> product = this.productRepository.findById(id);
        if (product.isPresent()) {
            return product.get();
        } else {
            throw new DataNotFoundException("product not found"); // 예외처리로 에러(DataNotFoundException)를 표시
        }
    }

    // 대분류에 따라 제품을 조회하는 메서드
    public List<Product> getProductsByMainCategory(Integer mainCategory, String kw) {
        // ProductRepository의 메서드를 호출하여 대분류에 맞는 제품을 조회합니다.
        if (mainCategory != null) {
            return productRepository.findByMainCategoryAndKeyword(mainCategory, kw);
        } else {
            return productRepository.findAllByKeyword(kw);
        }
    }


    public void createProduct(ProductForm productForm,
                              SiteUser siteUser,
                              MultipartFile file1,
                              MultipartFile file2
    ) throws IOException {
        // 저장할 경로를 여기서 지정해줌
        String projectPath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static" + File.separator + "files";

//      String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID(); // 랜덤으로 이름을 만들어줄 수 있음
        // uuid는 파일에 붙일 랜덤이름을 생성

        // 제품 이미지파일 1 처리
        String fileName1 = uuid + "_file1_" + file1.getOriginalFilename();
        // 랜덤이름(uuid)을 앞에다 붙이고 그 다음에 언더바(_) 하고 파일이름을 뒤에 붙여서 저장될 파일 이름을 생성해줌
        String filePath1 = "/files/" + fileName1;
        File saveFile1 = new File(projectPath, fileName1);
        file1.transferTo(saveFile1);

        // 제품 이미지파일 2 처리
        String fileName2 = uuid + "_file2_" + file2.getOriginalFilename();
        // 랜덤이름(uuid)을 앞에다 붙이고 그 다음에 언더바(_) 하고 파일이름을 뒤에 붙여서 저장될 파일 이름을 생성해줌
        String filePath2 = "/files/" + fileName2;
        File saveFile2 = new File(projectPath, fileName2);
        file2.transferTo(saveFile2);

        MainCategory mainCategory = mainCategoryRepository.findById(productForm.getMainCategoryId())
                .orElseThrow(() -> new DataNotFoundException("mainCategory not found"));

        SubCategory subCategory = subCategoryRepository.findById(productForm.getSubCategoryId())
                .orElseThrow(() -> new DataNotFoundException("subCategory not found"));

        CostRange costRange = costRangeRepository.findById(productForm.getCostRangeId())
                .orElseThrow(() -> new DataNotFoundException("costRange not found"));

        ABVrange abvRange = abvRangeRepository.findById(productForm.getAbvRangeId())
                .orElseThrow(() -> new DataNotFoundException("abvRange not found"));

        NetWeight netWeight = netWeightRepository.findById(productForm.getNetWeightId())
                .orElseThrow(() -> new DataNotFoundException("netWeight not found"));

        Nation nation = nationRepository.findById(productForm.getNationId())
                .orElseThrow(() -> new DataNotFoundException("nation not found"));

        // 캐스크 ID 리스트 검증 및 조회
        List<Integer> caskList = productForm.getCasks();
        int maxCasks = 4;

        if (caskList == null) {
            caskList = new ArrayList<>();
        } else {
            // 입력된 값의 개수를 확인하여 최대 개수까지만 처리합니다.
            if (caskList.size() > maxCasks) {
                caskList = caskList.subList(0, maxCasks);
            }
        }

        List<Cask> casks = caskRepository.findAllById(caskList);

        // 페어링 ID 리스트 검증 및 조회
        List<Integer> pairingList = productForm.getPairings();
        int maxPairings = 3;

        if (pairingList == null) {
            pairingList = new ArrayList<>();
        } else {
            // 입력된 값의 개수를 확인하여 최대 개수까지만 처리합니다.
            if (pairingList.size() > maxPairings) {
                pairingList = pairingList.subList(0, maxPairings);
            }
        }

        List<Pairing> pairings = pairingRepository.findAllById(pairingList);

        Product product = new Product();
        product.setName(productForm.getName());
        product.setAbv(productForm.getAbv());
        product.setAroma(productForm.getAroma());
        product.setFlavor(productForm.getFlavor());
        product.setInfo(productForm.getInfo());
        product.setSubject(productForm.getSubject());
        product.setCost(productForm.getCost());
        product.setMainCategory(mainCategory);
        product.setSubCategory(subCategory);
        product.setCostRange(costRange);
        product.setAbvRange(abvRange);
        product.setNetWeight(netWeight);
        product.setNation(nation);
        product.setAuthor(siteUser);

        product.setFilename1(fileName1);
        product.setFilepath1(filePath1);
        product.setFilename2(fileName2);
        product.setFilepath2(filePath2);
        // product를 먼저 저장합니다.
        product = productRepository.save(product);

        // product와 맵핑되는 pairings를 생성합니다.
        product.getPairings().addAll(pairings);

        // product와 맵핑되는 casks를 생성합니다.
        product.getCasks().addAll(casks);

        // 저장된 product를 다시 저장합니다.
        productRepository.save(product);
    }
    public void modifyProduct(Integer id, ProductForm productForm, SiteUser siteUser) { // 추천 메서드
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            // 제품이 존재하지 않을 경우, 에러 처리 또는 다른 동작 수행
            System.out.println("존재하지 않는 제품입니다.");
            return;
        }

        MainCategory mainCategory = mainCategoryRepository.findById(productForm.getMainCategoryId())
                .orElseThrow(() -> new DataNotFoundException("mainCategory not found"));

        SubCategory subCategory = subCategoryRepository.findById(productForm.getSubCategoryId())
                .orElseThrow(() -> new DataNotFoundException("subCategory not found"));

        CostRange costRange = costRangeRepository.findById(productForm.getCostRangeId())
                .orElseThrow(() -> new DataNotFoundException("costRange not found"));

        ABVrange abvRange = abvRangeRepository.findById(productForm.getAbvRangeId())
                .orElseThrow(() -> new DataNotFoundException("abvRange not found"));

        NetWeight netWeight = netWeightRepository.findById(productForm.getNetWeightId())
                .orElseThrow(() -> new DataNotFoundException("netWeight not found"));

        Nation nation = nationRepository.findById(productForm.getNationId())
                .orElseThrow(() -> new DataNotFoundException("nation not found"));

        // 캐스크 ID 리스트 검증 및 조회
        List<Integer> caskList = productForm.getCasks();
        int maxCasks = 4;

        if (caskList == null) {
            caskList = new ArrayList<>();
        } else {
            // 입력된 값의 개수를 확인하여 최대 개수까지만 처리합니다.
            if (caskList.size() > maxCasks) {
                caskList = caskList.subList(0, maxCasks);
            }
        }

        List<Cask> casks = caskRepository.findAllById(caskList);

        // 페어링 ID 리스트 검증 및 조회
        List<Integer> pairingList = productForm.getPairings();
        int maxPairings = 3;

        if (pairingList == null) {
            pairingList = new ArrayList<>();
        } else {
            // 입력된 값의 개수를 확인하여 최대 개수까지만 처리합니다.
            if (pairingList.size() > maxPairings) {
                pairingList = pairingList.subList(0, maxPairings);
            }
        }

        List<Pairing> pairings = pairingRepository.findAllById(pairingList);

        // 제품 정보 업데이트
        product.setName(productForm.getName());
        product.setAbv(productForm.getAbv());
        product.setAroma(productForm.getAroma());
        product.setFlavor(productForm.getFlavor());
        product.setInfo(productForm.getInfo());
        product.setSubject(productForm.getSubject());
        product.setCost(productForm.getCost());
        product.setMainCategory(mainCategory);
        product.setSubCategory(subCategory);
        product.setCostRange(costRange);
        product.setAbvRange(abvRange);
        product.setNetWeight(netWeight);
        product.setNation(nation);
        product.setAuthor(siteUser);

        // product를 먼저 저장합니다.
        product = productRepository.save(product);

        // product와 맵핑되는 pairings를 생성합니다.
        product.getPairings().clear(); // 기존 맵핑 제거
        for (Pairing pairing : pairings) {
            product.getPairings().add(pairing);
        }

        // product와 맵핑되는 casks를 생성합니다.
        product.getCasks().clear(); // 기존 맵핑 제거
        for (Cask cask : casks) {
            product.getCasks().add(cask);
        }

        // 저장된 product를 다시 저장합니다.
        productRepository.save(product);
    }
    public List<Product> getListSearch(String kw) {
        return this.productRepository.findAllByKeyword(kw);
    }
    public List<Review> getListReviewSearch(String kw) {
        return this.productRepository.findAllByKeywordInReview(kw);
    }
    public List<SiteUser> getListSiteUserSearch(String kw) {
        return this.productRepository.findAllByKeywordInSiteUser(kw);
    }
    public List<Product> getProductsByVoter(SiteUser voter) {
        return productRepository.findByVoter(voter);
    }
    public List<Product> getProductsByWish(SiteUser wish) {
        return productRepository.findByWish(wish);
    }
    public List<Product> getProductsByMainCategoryId(Integer mainCategory) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return productRepository.findByMainCategoryId(mainCategory);
    }
    public List<Product> getProductsBySubCategoryId(Integer subCategoryId) {
        return productRepository.findBySubCategoryId(subCategoryId);
    }
    public List<Product> getProductsByMainCategoryIdAndSubCategoryId(Integer mainCategoryId, Integer subCategoryId) {
        // ProductRepository를 사용하여 mainCategory에 해당하는 제품 리스트를 조회합니다.
        return productRepository.getProductsByMainCategoryIdAndSubCategoryId(mainCategoryId, subCategoryId);
    }
    public List<Product> getProductsByCategory(String mainCategoryId, String subCategoryId) { // 메인카테고리와 서브카테고리 같이 찾는 로직
        return this.productRepository.getProductsByMainCategoryAndSubCategory(mainCategoryId, subCategoryId);
    }
    public List<Review> getReviewsByProduct(Product product) { // 리뷰부분 제대로 작동하지 않을 시 최우선으로 삭제 고려할 것
        return reviewRepository.findByProduct(product);
    }
    public void vote(Product product, SiteUser siteUser) { // 추천 메서드
        product.getVoter().add(siteUser);
        this.productRepository.save(product);
    }
    public void cancelVote(Product product, SiteUser siteUser) { // 추천 취소 메서드
        product.getVoter().remove(siteUser);
        this.productRepository.save(product);
    }
    public void wish(Product product, SiteUser siteUser) { // 찜 메서드
        product.getWish().add(siteUser);
        this.productRepository.save(product);
    }
    public void cancelWish(Product product, SiteUser siteUser) { // 찜 취소 메서드
        product.getWish().remove(siteUser);
        this.productRepository.save(product);
    }
    public void delete(Product product) { // 삭제 메서드
        this.productRepository.delete(product);
    }
    private boolean isProductHasPairing(Product product, Long pairingId) {
        for (Pairing pairing : product.getPairings()) {
            if (pairing.getId().equals(pairingId)) {
                return true;
            }
        }
        return false;
    }
    private boolean isProductHasCask(Product product, Long caskId) {
        for (Cask cask : product.getCasks()) {
            if (cask.getId().equals(caskId)) {
                return true;
            }
        }
        return false;
    }
    public List<Product> getFilteredProducts(Integer subCategoryId,
                                             Integer costRangeId,
                                             Integer abvRangeId,
                                             Integer netWeightId,
                                             Integer pairingId,
                                             Integer caskId,
                                             Integer nationId,
                                             String kw) {
        if (subCategoryId == null &&
                costRangeId == null &&
                abvRangeId == null &&
                netWeightId == null &&
                pairingId == null &&
                caskId == null &&
                nationId == null &&
                kw == null) {
            return productRepository.findAll(); // 필터링 조건이 없는 경우 모든 제품 조회
        }
        return productRepository.findProductBySubCategoryIdAndCostRangeIdAndAbvRangeIdAndNetWeightIdAndNationIdAndKwAndCaskAndPairing(
                subCategoryId,
                costRangeId,
                abvRangeId,
                netWeightId,
                pairingId,
                caskId,
                nationId,
                kw);
    }
    public Product countingViews(Product product) {
        // Logic to save the product, such as calling a repository or performing other operations
        // For example:
        Product savedProduct = productRepository.save(product);
        // Additional logic or operations if needed
        return savedProduct;
    }
    private Specification<Product> search(String kw) {
        return new Specification<>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Product> p, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.distinct(true);  // 중복을 제거
                Join<Product, SiteUser> u1 = p.join("author", JoinType.LEFT);
                Join<Product, Review> r = p.join("reviewList", JoinType.LEFT);
                Join<Review, SiteUser> u2 = r.join("author", JoinType.LEFT);
                Join<Product, ABVrange> abvRange = p.join("abvRange", JoinType.LEFT);
                Join<Product, CostRange> costRange = p.join("costRange", JoinType.LEFT);
                Join<Product, MainCategory> mainCategory = p.join("mainCategory", JoinType.LEFT);
                Join<Product, Nation> nation = p.join("nation", JoinType.LEFT);
                Join<Product, NetWeight> netWeight = p.join("netWeight", JoinType.LEFT);
                Join<Product, SubCategory> subCategory = p.join("subCategory", JoinType.LEFT);
                Join<Product, Cask> cask = p.join("casks", JoinType.LEFT);
                Join<Product, Pairing> pairing = p.join("pairings", JoinType.LEFT);

                return cb.or(
                        cb.like(p.get("name"), "%" + kw + "%"),                          // 제품명
                        cb.like(p.get("info"), "%" + kw + "%"),                          // 상품 정보
                        cb.like(u1.get("username"), "%" + kw + "%"),                     // 질문 작성자
                        cb.like(u2.get("username"), "%" + kw + "%"),                     // 답변 작성자
                        cb.like(p.get("subject"), "%" + kw + "%"),                        // 제목
                        cb.like(p.get("content"), "%" + kw + "%"),                        // 내용
                        cb.like(abvRange.get("abvRange"), "%" + kw + "%"),                // ABV 범위
                        cb.like(costRange.get("costRange"), "%" + kw + "%"),              // 가격 범위
                        cb.like(mainCategory.get("mainCategory"), "%" + kw + "%"),        // 메인 카테고리
                        cb.like(nation.get("nation"), "%" + kw + "%"),                    // 국가
                        cb.like(netWeight.get("netWeight"), "%" + kw + "%"),              // 순중량
                        cb.like(subCategory.get("subCategory"), "%" + kw + "%"),          // 서브 카테고리
                        cb.like(cask.get("cask"), "%" + kw + "%"),                        // Cask
                        cb.like(pairing.get("pairing"), "%" + kw + "%")                   // Pairing
                );
            }
        };
    }
}
