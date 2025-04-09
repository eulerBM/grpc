package com.project.grpc;

import com.example.grpc.EmptyRequest;
import com.example.grpc.HelloResponse;
import com.example.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase{

    @Override
    public void sayHello(EmptyRequest request, StreamObserver<HelloResponse> responseObserver) {
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
