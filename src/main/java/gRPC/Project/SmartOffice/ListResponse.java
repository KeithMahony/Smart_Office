// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bugs.proto

package gRPC.Project.SmartOffice;

/**
 * Protobuf type {@code bugs.ListResponse}
 */
public  final class ListResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:bugs.ListResponse)
    ListResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ListResponse.newBuilder() to construct.
  private ListResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ListResponse() {
    title_ = "";
    details_ = "";
    severity_ = 0;
    reportedBy_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ListResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            title_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            details_ = s;
            break;
          }
          case 24: {

            severity_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            reportedBy_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return gRPC.Project.SmartOffice.OfficeService.internal_static_bugs_ListResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return gRPC.Project.SmartOffice.OfficeService.internal_static_bugs_ListResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            gRPC.Project.SmartOffice.ListResponse.class, gRPC.Project.SmartOffice.ListResponse.Builder.class);
  }

  public static final int TITLE_FIELD_NUMBER = 1;
  private volatile java.lang.Object title_;
  /**
   * <code>string title = 1;</code>
   */
  public java.lang.String getTitle() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      title_ = s;
      return s;
    }
  }
  /**
   * <code>string title = 1;</code>
   */
  public com.google.protobuf.ByteString
      getTitleBytes() {
    java.lang.Object ref = title_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      title_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DETAILS_FIELD_NUMBER = 2;
  private volatile java.lang.Object details_;
  /**
   * <code>string details = 2;</code>
   */
  public java.lang.String getDetails() {
    java.lang.Object ref = details_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      details_ = s;
      return s;
    }
  }
  /**
   * <code>string details = 2;</code>
   */
  public com.google.protobuf.ByteString
      getDetailsBytes() {
    java.lang.Object ref = details_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      details_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SEVERITY_FIELD_NUMBER = 3;
  private int severity_;
  /**
   * <code>int32 severity = 3;</code>
   */
  public int getSeverity() {
    return severity_;
  }

  public static final int REPORTEDBY_FIELD_NUMBER = 4;
  private volatile java.lang.Object reportedBy_;
  /**
   * <code>string reportedBy = 4;</code>
   */
  public java.lang.String getReportedBy() {
    java.lang.Object ref = reportedBy_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      reportedBy_ = s;
      return s;
    }
  }
  /**
   * <code>string reportedBy = 4;</code>
   */
  public com.google.protobuf.ByteString
      getReportedByBytes() {
    java.lang.Object ref = reportedBy_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      reportedBy_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getTitleBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, title_);
    }
    if (!getDetailsBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, details_);
    }
    if (severity_ != 0) {
      output.writeInt32(3, severity_);
    }
    if (!getReportedByBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, reportedBy_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTitleBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, title_);
    }
    if (!getDetailsBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, details_);
    }
    if (severity_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, severity_);
    }
    if (!getReportedByBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, reportedBy_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof gRPC.Project.SmartOffice.ListResponse)) {
      return super.equals(obj);
    }
    gRPC.Project.SmartOffice.ListResponse other = (gRPC.Project.SmartOffice.ListResponse) obj;

    boolean result = true;
    result = result && getTitle()
        .equals(other.getTitle());
    result = result && getDetails()
        .equals(other.getDetails());
    result = result && (getSeverity()
        == other.getSeverity());
    result = result && getReportedBy()
        .equals(other.getReportedBy());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TITLE_FIELD_NUMBER;
    hash = (53 * hash) + getTitle().hashCode();
    hash = (37 * hash) + DETAILS_FIELD_NUMBER;
    hash = (53 * hash) + getDetails().hashCode();
    hash = (37 * hash) + SEVERITY_FIELD_NUMBER;
    hash = (53 * hash) + getSeverity();
    hash = (37 * hash) + REPORTEDBY_FIELD_NUMBER;
    hash = (53 * hash) + getReportedBy().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static gRPC.Project.SmartOffice.ListResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(gRPC.Project.SmartOffice.ListResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code bugs.ListResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:bugs.ListResponse)
      gRPC.Project.SmartOffice.ListResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return gRPC.Project.SmartOffice.OfficeService.internal_static_bugs_ListResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return gRPC.Project.SmartOffice.OfficeService.internal_static_bugs_ListResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              gRPC.Project.SmartOffice.ListResponse.class, gRPC.Project.SmartOffice.ListResponse.Builder.class);
    }

    // Construct using gRPC.Project.SmartOffice.ListResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      title_ = "";

      details_ = "";

      severity_ = 0;

      reportedBy_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return gRPC.Project.SmartOffice.OfficeService.internal_static_bugs_ListResponse_descriptor;
    }

    @java.lang.Override
    public gRPC.Project.SmartOffice.ListResponse getDefaultInstanceForType() {
      return gRPC.Project.SmartOffice.ListResponse.getDefaultInstance();
    }

    @java.lang.Override
    public gRPC.Project.SmartOffice.ListResponse build() {
      gRPC.Project.SmartOffice.ListResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public gRPC.Project.SmartOffice.ListResponse buildPartial() {
      gRPC.Project.SmartOffice.ListResponse result = new gRPC.Project.SmartOffice.ListResponse(this);
      result.title_ = title_;
      result.details_ = details_;
      result.severity_ = severity_;
      result.reportedBy_ = reportedBy_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof gRPC.Project.SmartOffice.ListResponse) {
        return mergeFrom((gRPC.Project.SmartOffice.ListResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(gRPC.Project.SmartOffice.ListResponse other) {
      if (other == gRPC.Project.SmartOffice.ListResponse.getDefaultInstance()) return this;
      if (!other.getTitle().isEmpty()) {
        title_ = other.title_;
        onChanged();
      }
      if (!other.getDetails().isEmpty()) {
        details_ = other.details_;
        onChanged();
      }
      if (other.getSeverity() != 0) {
        setSeverity(other.getSeverity());
      }
      if (!other.getReportedBy().isEmpty()) {
        reportedBy_ = other.reportedBy_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      gRPC.Project.SmartOffice.ListResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (gRPC.Project.SmartOffice.ListResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object title_ = "";
    /**
     * <code>string title = 1;</code>
     */
    public java.lang.String getTitle() {
      java.lang.Object ref = title_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        title_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string title = 1;</code>
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      java.lang.Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string title = 1;</code>
     */
    public Builder setTitle(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      title_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string title = 1;</code>
     */
    public Builder clearTitle() {
      
      title_ = getDefaultInstance().getTitle();
      onChanged();
      return this;
    }
    /**
     * <code>string title = 1;</code>
     */
    public Builder setTitleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      title_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object details_ = "";
    /**
     * <code>string details = 2;</code>
     */
    public java.lang.String getDetails() {
      java.lang.Object ref = details_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        details_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string details = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDetailsBytes() {
      java.lang.Object ref = details_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        details_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string details = 2;</code>
     */
    public Builder setDetails(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      details_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string details = 2;</code>
     */
    public Builder clearDetails() {
      
      details_ = getDefaultInstance().getDetails();
      onChanged();
      return this;
    }
    /**
     * <code>string details = 2;</code>
     */
    public Builder setDetailsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      details_ = value;
      onChanged();
      return this;
    }

    private int severity_ ;
    /**
     * <code>int32 severity = 3;</code>
     */
    public int getSeverity() {
      return severity_;
    }
    /**
     * <code>int32 severity = 3;</code>
     */
    public Builder setSeverity(int value) {
      
      severity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 severity = 3;</code>
     */
    public Builder clearSeverity() {
      
      severity_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object reportedBy_ = "";
    /**
     * <code>string reportedBy = 4;</code>
     */
    public java.lang.String getReportedBy() {
      java.lang.Object ref = reportedBy_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        reportedBy_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string reportedBy = 4;</code>
     */
    public com.google.protobuf.ByteString
        getReportedByBytes() {
      java.lang.Object ref = reportedBy_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reportedBy_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string reportedBy = 4;</code>
     */
    public Builder setReportedBy(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      reportedBy_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string reportedBy = 4;</code>
     */
    public Builder clearReportedBy() {
      
      reportedBy_ = getDefaultInstance().getReportedBy();
      onChanged();
      return this;
    }
    /**
     * <code>string reportedBy = 4;</code>
     */
    public Builder setReportedByBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      reportedBy_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:bugs.ListResponse)
  }

  // @@protoc_insertion_point(class_scope:bugs.ListResponse)
  private static final gRPC.Project.SmartOffice.ListResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new gRPC.Project.SmartOffice.ListResponse();
  }

  public static gRPC.Project.SmartOffice.ListResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListResponse>
      PARSER = new com.google.protobuf.AbstractParser<ListResponse>() {
    @java.lang.Override
    public ListResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ListResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public gRPC.Project.SmartOffice.ListResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
