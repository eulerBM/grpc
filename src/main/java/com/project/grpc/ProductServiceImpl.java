package com.project.grpc;

import com.example.grpc.IdRequest;
import com.example.grpc.ProductServiceGrpc;
import com.example.grpc.idProductRequest;
import com.project.grpc.Entity.ProductEntity;
import com.project.grpc.Repository.ProductRepository;

import com.example.grpc.CreateProductRequest;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

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
}
