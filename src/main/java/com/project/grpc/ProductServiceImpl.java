package com.project.grpc;

import com.example.grpc.EmptyRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.ProductServiceGrpc;
import com.project.grpc.Entity.ProductEntity;
import com.project.grpc.Repository.ProductRepository;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase{

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void sayHello(EmptyRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("hi world, iam Euler!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getAll(CreateProductRequest request, StreamObserver<HelloResponse> responseObserver) {

        ProductEntity product = new ProductEntity()
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("hi world, iam Euler!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void createProduct(CreateProductRequest request, StreamObserver<HelloResponse> responseObserver) {

        ProductEntity product = new ProductEntity()
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("hi world, iam Euler!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void ProductById(IdRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder()
                .setMessage("hi world, iam Euler!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
