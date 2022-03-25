package gRPC.Project.SmartOffice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: profiling.proto")
public final class ProfilingServiceGrpc {

  private ProfilingServiceGrpc() {}

  public static final String SERVICE_NAME = "profiling.ProfilingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.LogRequest,
      gRPC.Project.SmartOffice.LogResponse> getLogInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logIn",
      requestType = gRPC.Project.SmartOffice.LogRequest.class,
      responseType = gRPC.Project.SmartOffice.LogResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.LogRequest,
      gRPC.Project.SmartOffice.LogResponse> getLogInMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.LogRequest, gRPC.Project.SmartOffice.LogResponse> getLogInMethod;
    if ((getLogInMethod = ProfilingServiceGrpc.getLogInMethod) == null) {
      synchronized (ProfilingServiceGrpc.class) {
        if ((getLogInMethod = ProfilingServiceGrpc.getLogInMethod) == null) {
          ProfilingServiceGrpc.getLogInMethod = getLogInMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.LogRequest, gRPC.Project.SmartOffice.LogResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "profiling.ProfilingService", "logIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.LogRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.LogResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProfilingServiceMethodDescriptorSupplier("logIn"))
                  .build();
          }
        }
     }
     return getLogInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.eListRequest,
      gRPC.Project.SmartOffice.eListResponse> getGetEmployeeListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEmployeeList",
      requestType = gRPC.Project.SmartOffice.eListRequest.class,
      responseType = gRPC.Project.SmartOffice.eListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.eListRequest,
      gRPC.Project.SmartOffice.eListResponse> getGetEmployeeListMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.eListRequest, gRPC.Project.SmartOffice.eListResponse> getGetEmployeeListMethod;
    if ((getGetEmployeeListMethod = ProfilingServiceGrpc.getGetEmployeeListMethod) == null) {
      synchronized (ProfilingServiceGrpc.class) {
        if ((getGetEmployeeListMethod = ProfilingServiceGrpc.getGetEmployeeListMethod) == null) {
          ProfilingServiceGrpc.getGetEmployeeListMethod = getGetEmployeeListMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.eListRequest, gRPC.Project.SmartOffice.eListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "profiling.ProfilingService", "getEmployeeList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.eListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.eListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProfilingServiceMethodDescriptorSupplier("getEmployeeList"))
                  .build();
          }
        }
     }
     return getGetEmployeeListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.eListRequest,
      gRPC.Project.SmartOffice.eListResponse> getGetAllEmployeeListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllEmployeeList",
      requestType = gRPC.Project.SmartOffice.eListRequest.class,
      responseType = gRPC.Project.SmartOffice.eListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.eListRequest,
      gRPC.Project.SmartOffice.eListResponse> getGetAllEmployeeListMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.eListRequest, gRPC.Project.SmartOffice.eListResponse> getGetAllEmployeeListMethod;
    if ((getGetAllEmployeeListMethod = ProfilingServiceGrpc.getGetAllEmployeeListMethod) == null) {
      synchronized (ProfilingServiceGrpc.class) {
        if ((getGetAllEmployeeListMethod = ProfilingServiceGrpc.getGetAllEmployeeListMethod) == null) {
          ProfilingServiceGrpc.getGetAllEmployeeListMethod = getGetAllEmployeeListMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.eListRequest, gRPC.Project.SmartOffice.eListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "profiling.ProfilingService", "getAllEmployeeList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.eListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.eListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ProfilingServiceMethodDescriptorSupplier("getAllEmployeeList"))
                  .build();
          }
        }
     }
     return getGetAllEmployeeListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProfilingServiceStub newStub(io.grpc.Channel channel) {
    return new ProfilingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProfilingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProfilingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProfilingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProfilingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ProfilingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void logIn(gRPC.Project.SmartOffice.LogRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.LogResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogInMethod(), responseObserver);
    }

    /**
     */
    public void getEmployeeList(gRPC.Project.SmartOffice.eListRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.eListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEmployeeListMethod(), responseObserver);
    }

    /**
     */
    public void getAllEmployeeList(gRPC.Project.SmartOffice.eListRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.eListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllEmployeeListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLogInMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.LogRequest,
                gRPC.Project.SmartOffice.LogResponse>(
                  this, METHODID_LOG_IN)))
          .addMethod(
            getGetEmployeeListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.eListRequest,
                gRPC.Project.SmartOffice.eListResponse>(
                  this, METHODID_GET_EMPLOYEE_LIST)))
          .addMethod(
            getGetAllEmployeeListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.eListRequest,
                gRPC.Project.SmartOffice.eListResponse>(
                  this, METHODID_GET_ALL_EMPLOYEE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class ProfilingServiceStub extends io.grpc.stub.AbstractStub<ProfilingServiceStub> {
    private ProfilingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfilingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfilingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfilingServiceStub(channel, callOptions);
    }

    /**
     */
    public void logIn(gRPC.Project.SmartOffice.LogRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.LogResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getEmployeeList(gRPC.Project.SmartOffice.eListRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.eListResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetEmployeeListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllEmployeeList(gRPC.Project.SmartOffice.eListRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.eListResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetAllEmployeeListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProfilingServiceBlockingStub extends io.grpc.stub.AbstractStub<ProfilingServiceBlockingStub> {
    private ProfilingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfilingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfilingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfilingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public gRPC.Project.SmartOffice.LogResponse logIn(gRPC.Project.SmartOffice.LogRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogInMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<gRPC.Project.SmartOffice.eListResponse> getEmployeeList(
        gRPC.Project.SmartOffice.eListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetEmployeeListMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<gRPC.Project.SmartOffice.eListResponse> getAllEmployeeList(
        gRPC.Project.SmartOffice.eListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetAllEmployeeListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProfilingServiceFutureStub extends io.grpc.stub.AbstractStub<ProfilingServiceFutureStub> {
    private ProfilingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProfilingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProfilingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProfilingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.Project.SmartOffice.LogResponse> logIn(
        gRPC.Project.SmartOffice.LogRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogInMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOG_IN = 0;
  private static final int METHODID_GET_EMPLOYEE_LIST = 1;
  private static final int METHODID_GET_ALL_EMPLOYEE_LIST = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProfilingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProfilingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOG_IN:
          serviceImpl.logIn((gRPC.Project.SmartOffice.LogRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.LogResponse>) responseObserver);
          break;
        case METHODID_GET_EMPLOYEE_LIST:
          serviceImpl.getEmployeeList((gRPC.Project.SmartOffice.eListRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.eListResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_EMPLOYEE_LIST:
          serviceImpl.getAllEmployeeList((gRPC.Project.SmartOffice.eListRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.eListResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProfilingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProfilingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gRPC.Project.SmartOffice.ProfileService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProfilingService");
    }
  }

  private static final class ProfilingServiceFileDescriptorSupplier
      extends ProfilingServiceBaseDescriptorSupplier {
    ProfilingServiceFileDescriptorSupplier() {}
  }

  private static final class ProfilingServiceMethodDescriptorSupplier
      extends ProfilingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProfilingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProfilingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProfilingServiceFileDescriptorSupplier())
              .addMethod(getLogInMethod())
              .addMethod(getGetEmployeeListMethod())
              .addMethod(getGetAllEmployeeListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
