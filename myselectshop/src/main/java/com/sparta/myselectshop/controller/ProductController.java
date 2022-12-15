package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor  //통해서
public class ProductController {

    private final ProductService productService;// 의존성주입DI를 함

//    // 관심 상품 등록하기
//    @PostMapping("/products")
//    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {
//        // 응답 보내기
//        return productService.createProduct(requestDto);
//    }

    // 관심 상품 등록하기
    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기
        return productService.createProduct(requestDto, request);
    }

    // 관심 상품 조회하기
    @GetMapping("/products")
    public List<ProductResponseDto> getProducts(HttpServletRequest request) {
        // 응답 보내기
        return productService.getProducts(request);
    }
//유저 쪽을 했을때는 HttpServletResponse를 받아와서 response Header에 추가를 했는데
// 이제는 request를 받아와서 request Header안에 들어 있는 토큰값을 가져와야 하기 때문에
//이렇게 수정함

//    // 관심 상품 조회하기
//    @GetMapping("/products")
//    public List<ProductResponseDto> getProducts() {
//        // 응답 보내기
//        return productService.getProducts();
//    }

//    // 관심 상품 최저가 등록하기
//    @PutMapping("/products/{id}")
//    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
//        // 응답 보내기 (업데이트된 상품 id)
//        return productService.updateProduct(id, requestDto);
//    }

    // 관심 상품 최저가 등록하기
    @PutMapping("/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto, HttpServletRequest request) {
        // 응답 보내기 (업데이트된 상품 id)
        return productService.updateProduct(id, requestDto, request); //토큰을 받아와야 하기 때문에 request가 추가됨
    }
}