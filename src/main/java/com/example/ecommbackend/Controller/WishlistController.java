package com.example.ecommbackend.Controller;



import com.example.ecommbackend.Model.Wishlist;
import com.example.ecommbackend.Service.WishlistService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @GetMapping("/get")
    public Wishlist create(HttpServletRequest request) {
        return wishlistService.getUserWishlist(request);
    }

    @PutMapping("/addProduct")
    public ResponseEntity<?> addProduct(HttpServletRequest request,
                                     @RequestParam(value = "productId", required = true) int productId) {
        return wishlistService.addProductToWishlist(request,productId);
    }

    @PutMapping("/deleteProduct")
    public ResponseEntity<?> deleteProduct(HttpServletRequest request,
                                  @RequestParam(value = "productId", required = true) int productId) {
        return wishlistService.deleteProductFromWishlist(request, productId);
    }
}
