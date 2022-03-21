// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: bugs.proto

package gRPC.Project.SmartOffice;

public final class OfficeService {
  private OfficeService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bugs_LogRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bugs_LogRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bugs_LogResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bugs_LogResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bugs_ListRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bugs_ListRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bugs_ListResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bugs_ListResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_bugs_NewBugs_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_bugs_NewBugs_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nbugs.proto\022\004bugs\",\n\nLogRequest\022\014\n\004name" +
      "\030\001 \001(\t\022\020\n\010password\030\002 \001(\t\"/\n\013LogResponse\022" +
      "\017\n\007success\030\001 \001(\010\022\017\n\007message\030\002 \001(\t\"\037\n\013Lis" +
      "tRequest\022\020\n\010quantity\030\001 \001(\005\"T\n\014ListRespon" +
      "se\022\r\n\005title\030\001 \001(\t\022\017\n\007details\030\002 \001(\t\022\020\n\010se" +
      "verity\030\003 \001(\005\022\022\n\nreportedBy\030\004 \001(\t\";\n\007NewB" +
      "ugs\022\r\n\005title\030\001 \001(\t\022\017\n\007details\030\002 \001(\t\022\020\n\010s" +
      "everity\030\003 \001(\0052\260\001\n\023BugReportingService\022.\n" +
      "\005logIn\022\020.bugs.LogRequest\032\021.bugs.LogRespo" +
      "nse\"\000\0227\n\ngetBugList\022\021.bugs.ListRequest\032\022" +
      ".bugs.ListResponse\"\0000\001\0220\n\010postBugs\022\r.bug" +
      "s.NewBugs\032\021.bugs.LogResponse\"\000(\001B+\n\030gRPC" +
      ".Project.SmartOfficeB\rOfficeServiceP\001b\006p" +
      "roto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_bugs_LogRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_bugs_LogRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bugs_LogRequest_descriptor,
        new java.lang.String[] { "Name", "Password", });
    internal_static_bugs_LogResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_bugs_LogResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bugs_LogResponse_descriptor,
        new java.lang.String[] { "Success", "Message", });
    internal_static_bugs_ListRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_bugs_ListRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bugs_ListRequest_descriptor,
        new java.lang.String[] { "Quantity", });
    internal_static_bugs_ListResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_bugs_ListResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bugs_ListResponse_descriptor,
        new java.lang.String[] { "Title", "Details", "Severity", "ReportedBy", });
    internal_static_bugs_NewBugs_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_bugs_NewBugs_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_bugs_NewBugs_descriptor,
        new java.lang.String[] { "Title", "Details", "Severity", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
