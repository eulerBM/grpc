package com.project.grpc;

import com.example.grpc.*;
import com.google.common.base.Verify;
import com.project.grpc.Entity.ProductEntity;
import com.project.grpc.Repository.ProductRepository;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public void createProduct(CreateProductRequest request, StreamObserver<IdRequest> responseObserver) {

        ProductEntity product = new ProductEntity(request.getName(), request.getDescription(), request.getPrice());

        productRepository.save(product);

        IdRequest response = IdRequest.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice().floatValue())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getProductById(idProductRequest request, StreamObserver<IdRequest> responseObserver) {

        Optional<ProductEntity> productById = productRepository.findById(request.getId());

        if (productById.isEmpty()) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Produto com ID " + request.getId() + " não encontrado.")
                            .asRuntimeException()
            );
            return;
        }

        ProductEntity product = productById.get();

        IdRequest response = IdRequest.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice().floatValue())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void changeProduct(ProductRequest request, StreamObserver<IdRequest> responseObserver) {

        Optional<ProductEntity> productById = productRepository.findById(request.getId());

        ProductEntity product = productById.get();

        if(!request.getName().isEmpty()){

            product.setName(request.getName());

        }

        if(!request.getDescription().isEmpty()){

            product.setDescription(request.getDescription());

        }

        if(request.getPrice() > 1){

            product.setPrice(new BigDecimal(request.getPrice()));

        }

        productRepository.save(product);

        IdRequest response = IdRequest.newBuilder()
                .setId(product.getId())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice().floatValue())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllProducts(nameProductRequest request, StreamObserver<ProductListResponse> responseObserver) {

        List<ProductEntity> productById = productRepository.findByNameContainingIgnoreCase(request.getName());

        if (productById.isEmpty()) {
            responseObserver.onError(
                    Status.NOT_FOUND
                            .withDescription("Produto com nome " + request.getName() + " não encontrado.")
                            .asRuntimeException()
            );
            return;
        }

        ProductListResponse.Builder responseBuilder = ProductListResponse.newBuilder();

        for (ProductEntity product : productById) {
            IdRequest productProto = IdRequest.newBuilder()
                    .setId(product.getId())
                    .setName(product.getName())
                    .setDescription(product.getDescription())
                    .setPrice(product.getPrice().floatValue())
                    .build();

            responseBuilder.addProducts(productProto);
        }
        responseObserver.onNext(responseBuilder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteProduct(idProduct request, StreamObserver<messageDelete> responseObserver) {

        if (request.getId() <= 0){
            responseObserver.onError(
                    Status.INVALID_ARGUMENT
                            .withDescription("Produto com nome " + request.getId() + " não encontrado.")
                            .asRuntimeException()
            );

        }

        productRepository.deleteById(request.getId());


        messageDelete response = messageDelete.newBuilder()
                .setMessage("product with id " + request.getId() + " deleted")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
