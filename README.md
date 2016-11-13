# Rest api-versioning

This provides the sample usage of media-type versioning in rest api.

So here versioning will be controlled by the header. eg:
`Accept=[application/vnd.nbenja-v1.1+json]`

## Usage
```java
    @GetMapping(path = "/products", produces = {"application/vnd.nbenja-v1.0+json"})
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
```

```java
    @GetMapping(path = "/products", produces = {"application/vnd.nbenja-v1.1+json"})
    public List<Product> getDiscountedProducts() {
        return  productRepository.findAll().stream().map(p -> {p.setPrice(p.getPrice() -100);
            return  p;}).collect(Collectors.toList());
    }
```

Request URI = /home/products
Headers = {Accept=[application/vnd.nbenja-v1.1+json]}
