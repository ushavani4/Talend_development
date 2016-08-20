
package com.aero.ic.mapping;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for container_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="container_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headerSegment" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}segment_type"/>
 *         &lt;element name="segmentGroup" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}segmentGroup_type"/>
 *         &lt;element name="trailerSegment" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}segment_type"/>
 *       &lt;/sequence>
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "container_type", namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", propOrder = {
    "headerSegment",
    "segmentGroup",
    "trailerSegment"
})
public class ContainerType {

    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
    protected SegmentType headerSegment;
    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
    protected SegmentGroupType segmentGroup;
    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
    protected SegmentType trailerSegment;
    @XmlAttribute(name = "type")
    protected String type;

    /**
     * Gets the value of the headerSegment property.
     * 
     * @return
     *     possible object is
     *     {@link SegmentType }
     *     
     */
    public SegmentType getHeaderSegment() {
        return headerSegment;
    }

    /**
     * Sets the value of the headerSegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentType }
     *     
     */
    public void setHeaderSegment(SegmentType value) {
        this.headerSegment = value;
    }

    /**
     * Gets the value of the segmentGroup property.
     * 
     * @return
     *     possible object is
     *     {@link SegmentGroupType }
     *     
     */
    public SegmentGroupType getSegmentGroup() {
        return segmentGroup;
    }

    /**
     * Sets the value of the segmentGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentGroupType }
     *     
     */
    public void setSegmentGroup(SegmentGroupType value) {
        this.segmentGroup = value;
    }

    /**
     * Gets the value of the trailerSegment property.
     * 
     * @return
     *     possible object is
     *     {@link SegmentType }
     *     
     */
    public SegmentType getTrailerSegment() {
        return trailerSegment;
    }

    /**
     * Sets the value of the trailerSegment property.
     * 
     * @param value
     *     allowed object is
     *     {@link SegmentType }
     *     
     */
    public void setTrailerSegment(SegmentType value) {
        this.trailerSegment = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
