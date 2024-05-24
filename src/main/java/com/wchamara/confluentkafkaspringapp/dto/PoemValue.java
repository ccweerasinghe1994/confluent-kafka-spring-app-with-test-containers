/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.wchamara.confluentkafkaspringapp.dto;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class PoemValue extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8503038933122362344L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"PoemValue\",\"namespace\":\"com.wchamara.confluentkafkaspringapp.dto\",\"fields\":[{\"name\":\"title\",\"type\":\"string\",\"doc\":\"Title of the poem\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<PoemValue> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PoemValue> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PoemValue> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PoemValue> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PoemValue> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PoemValue to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PoemValue from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PoemValue instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static PoemValue fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** Title of the poem */
  private java.lang.CharSequence title;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public PoemValue() {}

  /**
   * All-args constructor.
   * @param title Title of the poem
   */
  public PoemValue(java.lang.CharSequence title) {
    this.title = title;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }

  @Override
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return title;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: title = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'title' field.
   * @return Title of the poem
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }


  /**
   * Sets the value of the 'title' field.
   * Title of the poem
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Creates a new PoemValue RecordBuilder.
   * @return A new PoemValue RecordBuilder
   */
  public static com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder newBuilder() {
    return new com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder();
  }

  /**
   * Creates a new PoemValue RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new PoemValue RecordBuilder
   */
  public static com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder newBuilder(com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder other) {
    if (other == null) {
      return new com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder();
    } else {
      return new com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder(other);
    }
  }

  /**
   * Creates a new PoemValue RecordBuilder by copying an existing PoemValue instance.
   * @param other The existing instance to copy.
   * @return A new PoemValue RecordBuilder
   */
  public static com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder newBuilder(com.wchamara.confluentkafkaspringapp.dto.PoemValue other) {
    if (other == null) {
      return new com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder();
    } else {
      return new com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder(other);
    }
  }

  /**
   * RecordBuilder for PoemValue instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<PoemValue>
    implements org.apache.avro.data.RecordBuilder<PoemValue> {

    /** Title of the poem */
    private java.lang.CharSequence title;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
    }

    /**
     * Creates a Builder by copying an existing PoemValue instance
     * @param other The existing instance to copy.
     */
    private Builder(com.wchamara.confluentkafkaspringapp.dto.PoemValue other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.title)) {
        this.title = data().deepCopy(fields()[0].schema(), other.title);
        fieldSetFlags()[0] = true;
      }
    }

    /**
      * Gets the value of the 'title' field.
      * Title of the poem
      * @return The value.
      */
    public java.lang.CharSequence getTitle() {
      return title;
    }


    /**
      * Sets the value of the 'title' field.
      * Title of the poem
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.title = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * Title of the poem
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'title' field.
      * Title of the poem
      * @return This builder.
      */
    public com.wchamara.confluentkafkaspringapp.dto.PoemValue.Builder clearTitle() {
      title = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PoemValue build() {
      try {
        PoemValue record = new PoemValue();
        record.title = fieldSetFlags()[0] ? this.title : (java.lang.CharSequence) defaultValue(fields()[0]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PoemValue>
    WRITER$ = (org.apache.avro.io.DatumWriter<PoemValue>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PoemValue>
    READER$ = (org.apache.avro.io.DatumReader<PoemValue>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.title);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.title = in.readString(this.title instanceof Utf8 ? (Utf8)this.title : null);

    } else {
      for (int i = 0; i < 1; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.title = in.readString(this.title instanceof Utf8 ? (Utf8)this.title : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










