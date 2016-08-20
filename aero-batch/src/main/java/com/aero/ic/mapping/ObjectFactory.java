
package com.aero.ic.mapping;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.aero.ic.mapping package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.aero.ic.mapping
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FieldType }
     * 
     */
    public FieldType createFieldType() {
        return new FieldType();
    }

    /**
     * Create an instance of {@link MetaType }
     * 
     */
    public MetaType createMetaType() {
        return new MetaType();
    }

    /**
     * Create an instance of {@link EdiMapping }
     * 
     */
    public EdiMapping createEdiMapping() {
        return new EdiMapping();
    }

    /**
     * Create an instance of {@link ContainerType }
     * 
     */
    public ContainerType createContainerType() {
        return new ContainerType();
    }

    /**
     * Create an instance of {@link SegmentGroupType }
     * 
     */
    public SegmentGroupType createSegmentGroupType() {
        return new SegmentGroupType();
    }

    /**
     * Create an instance of {@link ComponentType }
     * 
     */
    public ComponentType createComponentType() {
        return new ComponentType();
    }

    /**
     * Create an instance of {@link SegmentType }
     * 
     */
    public SegmentType createSegmentType() {
        return new SegmentType();
    }

    /**
     * Create an instance of {@link FieldType.Components }
     * 
     */
    public FieldType.Components createFieldTypeComponents() {
        return new FieldType.Components();
    }

    /**
     * Create an instance of {@link MetaType.Terminator }
     * 
     */
    public MetaType.Terminator createMetaTypeTerminator() {
        return new MetaType.Terminator();
    }

}
