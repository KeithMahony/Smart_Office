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
    comments = "Source: bugs.proto")
public final class BugReportingServiceGrpc {

  private BugReportingServiceGrpc() {}

  public static final String SERVICE_NAME = "bugs.BugReportingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.ListRequest,
      gRPC.Project.SmartOffice.ListResponse> getGetBugListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBugList",
      requestType = gRPC.Project.SmartOffice.ListRequest.class,
      responseType = gRPC.Project.SmartOffice.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.ListRequest,
      gRPC.Project.SmartOffice.ListResponse> getGetBugListMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.ListRequest, gRPC.Project.SmartOffice.ListResponse> getGetBugListMethod;
    if ((getGetBugListMethod = BugReportingServiceGrpc.getGetBugListMethod) == null) {
      synchronized (BugReportingServiceGrpc.class) {
        if ((getGetBugListMethod = BugReportingServiceGrpc.getGetBugListMethod) == null) {
          BugReportingServiceGrpc.getGetBugListMethod = getGetBugListMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.ListRequest, gRPC.Project.SmartOffice.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "bugs.BugReportingService", "getBugList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.ListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.ListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BugReportingServiceMethodDescriptorSupplier("getBugList"))
                  .build();
          }
        }
     }
     return getGetBugListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.BugIdRequest,
      gRPC.Project.SmartOffice.ListResponse> getGetBugByIDMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getBugByID",
      requestType = gRPC.Project.SmartOffice.BugIdRequest.class,
      responseType = gRPC.Project.SmartOffice.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.BugIdRequest,
      gRPC.Project.SmartOffice.ListResponse> getGetBugByIDMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.BugIdRequest, gRPC.Project.SmartOffice.ListResponse> getGetBugByIDMethod;
    if ((getGetBugByIDMethod = BugReportingServiceGrpc.getGetBugByIDMethod) == null) {
      synchronized (BugReportingServiceGrpc.class) {
        if ((getGetBugByIDMethod = BugReportingServiceGrpc.getGetBugByIDMethod) == null) {
          BugReportingServiceGrpc.getGetBugByIDMethod = getGetBugByIDMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.BugIdRequest, gRPC.Project.SmartOffice.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "bugs.BugReportingService", "getBugByID"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.BugIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.ListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BugReportingServiceMethodDescriptorSupplier("getBugByID"))
                  .build();
          }
        }
     }
     return getGetBugByIDMethod;
  }

  private static volatile io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.NewBugs,
      gRPC.Project.SmartOffice.ListResponse> getPostBugsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "postBugs",
      requestType = gRPC.Project.SmartOffice.NewBugs.class,
      responseType = gRPC.Project.SmartOffice.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.NewBugs,
      gRPC.Project.SmartOffice.ListResponse> getPostBugsMethod() {
    io.grpc.MethodDescriptor<gRPC.Project.SmartOffice.NewBugs, gRPC.Project.SmartOffice.ListResponse> getPostBugsMethod;
    if ((getPostBugsMethod = BugReportingServiceGrpc.getPostBugsMethod) == null) {
      synchronized (BugReportingServiceGrpc.class) {
        if ((getPostBugsMethod = BugReportingServiceGrpc.getPostBugsMethod) == null) {
          BugReportingServiceGrpc.getPostBugsMethod = getPostBugsMethod = 
              io.grpc.MethodDescriptor.<gRPC.Project.SmartOffice.NewBugs, gRPC.Project.SmartOffice.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "bugs.BugReportingService", "postBugs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.NewBugs.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gRPC.Project.SmartOffice.ListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new BugReportingServiceMethodDescriptorSupplier("postBugs"))
                  .build();
          }
        }
     }
     return getPostBugsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BugReportingServiceStub newStub(io.grpc.Channel channel) {
    return new BugReportingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BugReportingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new BugReportingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BugReportingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new BugReportingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class BugReportingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * server streaming
     * </pre>
     */
    public void getBugList(gRPC.Project.SmartOffice.ListRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBugListMethod(), responseObserver);
    }

    /**
     */
    public void getBugByID(gRPC.Project.SmartOffice.BugIdRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetBugByIDMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.NewBugs> postBugs(
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getPostBugsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetBugListMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.ListRequest,
                gRPC.Project.SmartOffice.ListResponse>(
                  this, METHODID_GET_BUG_LIST)))
          .addMethod(
            getGetBugByIDMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.BugIdRequest,
                gRPC.Project.SmartOffice.ListResponse>(
                  this, METHODID_GET_BUG_BY_ID)))
          .addMethod(
            getPostBugsMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                gRPC.Project.SmartOffice.NewBugs,
                gRPC.Project.SmartOffice.ListResponse>(
                  this, METHODID_POST_BUGS)))
          .build();
    }
  }

  /**
   */
  public static final class BugReportingServiceStub extends io.grpc.stub.AbstractStub<BugReportingServiceStub> {
    private BugReportingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BugReportingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BugReportingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BugReportingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming
     * </pre>
     */
    public void getBugList(gRPC.Project.SmartOffice.ListRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetBugListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getBugByID(gRPC.Project.SmartOffice.BugIdRequest request,
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetBugByIDMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.NewBugs> postBugs(
        io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getPostBugsMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class BugReportingServiceBlockingStub extends io.grpc.stub.AbstractStub<BugReportingServiceBlockingStub> {
    private BugReportingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BugReportingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BugReportingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BugReportingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * server streaming
     * </pre>
     */
    public java.util.Iterator<gRPC.Project.SmartOffice.ListResponse> getBugList(
        gRPC.Project.SmartOffice.ListRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetBugListMethod(), getCallOptions(), request);
    }

    /**
     */
    public gRPC.Project.SmartOffice.ListResponse getBugByID(gRPC.Project.SmartOffice.BugIdRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetBugByIDMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BugReportingServiceFutureStub extends io.grpc.stub.AbstractStub<BugReportingServiceFutureStub> {
    private BugReportingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private BugReportingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BugReportingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new BugReportingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gRPC.Project.SmartOffice.ListResponse> getBugByID(
        gRPC.Project.SmartOffice.BugIdRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetBugByIDMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BUG_LIST = 0;
  private static final int METHODID_GET_BUG_BY_ID = 1;
  private static final int METHODID_POST_BUGS = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BugReportingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BugReportingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BUG_LIST:
          serviceImpl.getBugList((gRPC.Project.SmartOffice.ListRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse>) responseObserver);
          break;
        case METHODID_GET_BUG_BY_ID:
          serviceImpl.getBugByID((gRPC.Project.SmartOffice.BugIdRequest) request,
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse>) responseObserver);
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
        case METHODID_POST_BUGS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.postBugs(
              (io.grpc.stub.StreamObserver<gRPC.Project.SmartOffice.ListResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class BugReportingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BugReportingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gRPC.Project.SmartOffice.BugService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BugReportingService");
    }
  }

  private static final class BugReportingServiceFileDescriptorSupplier
      extends BugReportingServiceBaseDescriptorSupplier {
    BugReportingServiceFileDescriptorSupplier() {}
  }

  private static final class BugReportingServiceMethodDescriptorSupplier
      extends BugReportingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BugReportingServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (BugReportingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BugReportingServiceFileDescriptorSupplier())
              .addMethod(getGetBugListMethod())
              .addMethod(getGetBugByIDMethod())
              .addMethod(getPostBugsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
