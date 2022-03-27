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
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: holidays.proto")
public final class TimeOffServiceGrpc {

  private TimeOffServiceGrpc() {}

  public static final String SERVICE_NAME = "holidays.TimeOffService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.IdRequest,
      gRPC.Project.SmartOffice.BalanceReply> getGetBalanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBalance",
      requestType = gRPC.Project.SmartOffice.IdRequest.class,
      responseType = gRPC.Project.SmartOffice.BalanceReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.IdRequest,
      gRPC.Project.SmartOffice.BalanceReply> getGetBalanceMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.IdRequest, gRPC.Project.SmartOffice.BalanceReply> getGetBalanceMethod;
    if ((getGetBalanceMethod = TimeOffServiceGrpc.getGetBalanceMethod) == null) {
      synchronized (TimeOffServiceGrpc.class) {
        if ((getGetBalanceMethod = TimeOffServiceGrpc.getGetBalanceMethod) == null) {
          TimeOffServiceGrpc.getGetBalanceMethod = getGetBalanceMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.IdRequest, gRPC.Project.SmartOffice.BalanceReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "holidays.TimeOffService", "getBalance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.IdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.BalanceReply.getDefaultInstance()))
                  .setSchemaDescriptor(new TimeOffServiceMethodDescriptorSupplier("getBalance"))
                  .build();
          }
        }
     }
     return getGetBalanceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TimeOffServiceStub newStub(io.grpc.Channel channel) {
    return new TimeOffServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TimeOffServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TimeOffServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TimeOffServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TimeOffServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class TimeOffServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getBalance(gRPC.Project.SmartOffice.IdRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.BalanceReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBalanceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBalanceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.IdRequest,
                gRPC.Project.SmartOffice.BalanceReply>(
                  this, METHODID_GET_BALANCE)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class TimeOffServiceStub extends io.grpc.stub.AbstractStub<TimeOffServiceStub> {
    private TimeOffServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TimeOffServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeOffServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TimeOffServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void getBalance(gRPC.Project.SmartOffice.IdRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.BalanceReply> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class TimeOffServiceBlockingStub extends io.grpc.stub.AbstractStub<TimeOffServiceBlockingStub> {
    private TimeOffServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TimeOffServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeOffServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TimeOffServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public gRPC.Project.SmartOffice.BalanceReply getBalance(gRPC.Project.SmartOffice.IdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBalanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class TimeOffServiceFutureStub extends io.grpc.stub.AbstractStub<TimeOffServiceFutureStub> {
    private TimeOffServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TimeOffServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TimeOffServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TimeOffServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.Project.SmartOffice.BalanceReply> getBalance(
        gRPC.Project.SmartOffice.IdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBalanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BALANCE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TimeOffServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TimeOffServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BALANCE:
          serviceImpl.getBalance((gRPC.Project.SmartOffice.IdRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.BalanceReply>) responseObserver);
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

  private static abstract class TimeOffServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TimeOffServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gRPC.Project.SmartOffice.HolidayService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TimeOffService");
    }
  }

  private static final class TimeOffServiceFileDescriptorSupplier
      extends TimeOffServiceBaseDescriptorSupplier {
    TimeOffServiceFileDescriptorSupplier() {}
  }

  private static final class TimeOffServiceMethodDescriptorSupplier
      extends TimeOffServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TimeOffServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TimeOffServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TimeOffServiceFileDescriptorSupplier())
              .addMethod(getGetBalanceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
