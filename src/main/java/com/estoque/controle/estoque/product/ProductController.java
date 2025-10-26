package com.estoque.controle.estoque.product;

import com.estoque.controle.estoque.product.dto.*;
import com.estoque.controle.estoque.product.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    private final CreateProductService createProductService;
    private final GetAllProductService getAllProductService;
    private final UpdatedProductService updatedProductService;
    private final StockAdjusterService stockAdjusterService;
    private final FindLowStockProductsService findLowStockProducts;

    public ProductController( CreateProductService createProductService, GetAllProductService getAllProductService,FindLowStockProductsService findLowStockProducts, UpdatedProductService updatedProductService, StockAdjusterService stockAdjusterService){
        this.createProductService = createProductService;
        this.getAllProductService = getAllProductService;
        this.findLowStockProducts = findLowStockProducts;
        this.updatedProductService = updatedProductService;
        this.stockAdjusterService = stockAdjusterService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid CreateProductRequestDTO createProductRequestDTO){
        createProductService.createProduct(createProductRequestDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllProductResponseDTO> frindAll(){return getAllProductService.findAll();}

    @GetMapping("/low-stock")
    public List<FindLowStockProductsResponseDTO> getLowStockProducts(
            @RequestParam(defaultValue = "5") Integer limit
    ) {
        return findLowStockProducts.findLowStockProducts(limit);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void UpdatedProduct(@PathVariable @Valid Long id, @RequestBody @Valid UpdatedProductRequestDTO updatedProductRequestDTO){
        updatedProductService.updatedProduct(id, updatedProductRequestDTO);
    }

    @PutMapping("/stock/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void StockAdjuster(@PathVariable @Valid Long id, @RequestBody @Valid StockAdjusterRequestDTO stockAdjusterRequestDTO){
        stockAdjusterService.StockAdjuster(id, stockAdjusterRequestDTO);
    }
}
