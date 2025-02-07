package exercise.specification;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return Specification.where(byTitleCont(params.getTitleCont())
                        .and(byCategoryId(params.getCategoryId()))
                        .and(byPriceGt(params.getPriceGt())))
                        .and(byPriceLt(params.getPriceLt())
                        .and(byRatingGt(params.getRatingGt())));
    }

    private Specification<Product> byTitleCont(String titleCont) {
        return (root, query, cb)
                -> titleCont == null ? null : cb.like(root.get("title"), "%" + titleCont + "%");
    }

    private Specification<Product> byCategoryId(Long categoryId) {
        return (root, query, cb)
                -> categoryId == null ? null : cb.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Product> byPriceGt(Integer priceGt) {
        return (root, query, cb)
                -> priceGt == null ? null : cb.greaterThan(root.get("price"), priceGt);
    }

    private Specification<Product> byPriceLt(Integer priceLt) {
        return (root, query, cb)
                -> priceLt == null ? null : cb.lessThan(root.get("price"), priceLt);
    }

    private Specification<Product> byRatingGt(Double ratingGt) {
        return (root, query, cb)
                -> ratingGt == null ? null : cb.greaterThan(root.get("rating"), ratingGt);
    }
}
// END
