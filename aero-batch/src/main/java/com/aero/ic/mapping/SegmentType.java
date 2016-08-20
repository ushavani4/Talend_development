
package com.aero.ic.mapping;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for segment_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="segment_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="field" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}field_type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="segment" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}segment_type" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="segmentGroup" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}segmentGroup_type" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="minOccurs" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxOccurs" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="code" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="header" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="trailer" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="message" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="property-name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="path" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "segment_type", namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", propOrder = {
    "field",
    "segment",
    "segmentGroup"
})
public class SegmentType {

    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd")
    protected List<FieldType> field;
    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd")
    protected List<SegmentType> segment;
    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd")
    protected List<SegmentGroupType> segmentGroup;
    @XmlAttribute(name = "minOccurs", required = true)
    protected int minOccurs;
    @XmlAttribute(name = "maxOccurs", required = true)
    protected int maxOccurs;
    @XmlAttribute(name = "id", required = true)
    protected String id;
    @XmlAttribute(name = "code", required = true)
    protected String code;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "header")
    protected Boolean header;
    @XmlAttribute(name = "trailer")
    protected Boolean trailer;
    @XmlAttribute(name = "message")
    protected Boolean message;
    @XmlAttribute(name = "property-name")
    protected String propertyName;
    @XmlAttribute(name = "path", required = true)
    protected String path;

    /**
     * Gets the value of the field property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the field property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FieldType }
     * 
     * 
     */
    public List<FieldType> getField() {
        if (field == null) {
            field = new ArrayList<FieldType>();
        }
        return this.field;
    }

    /**
     * Gets the value of the segment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SegmentType }
     * 
     * 
     */
    public List<SegmentType> getSegment() {
        if (segment == null) {
            segment = new ArrayList<SegmentType>();
        }
        return this.segment;
    }

    /**
     * Gets the value of the segmentGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the segmentGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSegmentGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SegmentGroupType }
     * 
     * 
     */
    public List<SegmentGroupType> getSegmentGroup() {
        if (segmentGroup == null) {
            segmentGroup = new ArrayList<SegmentGroupType>();
        }
        return this.segmentGroup;
    }

    /**
     * Gets the value of the minOccurs property.
     * 
     */
    public int getMinOccurs() {
        return minOccurs;
    }

    /**
     * Sets the value of the minOccurs property.
     * 
     */
    public void setMinOccurs(int value) {
        this.minOccurs = value;
    }

    /**
     * Gets the value of the maxOccurs property.
     * 
     */
    public int getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * Sets the value of the maxOccurs property.
     * 
     */
    public void setMaxOccurs(int value) {
        this.maxOccurs = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
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

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isHeader() {
        if (header == null) {
            return false;
        } else {
            return header;
        }
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHeader(Boolean value) {
        this.header = value;
    }

    /**
     * Gets the value of the trailer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isTrailer() {
        if (trailer == null) {
            return false;
        } else {
            return trailer;
        }
    }

    /**
     * Sets the value of the trailer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTrailer(Boolean value) {
        this.trailer = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isMessage() {
        if (message == null) {
            return false;
        } else {
            return message;
        }
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMessage(Boolean value) {
        this.message = value;
    }

    /**
     * Gets the value of the propertyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Sets the value of the propertyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyName(String value) {
        this.propertyName = value;
    }

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPath(String value) {
        this.path = value;
    }

}
