
package com.aero.ic.mapping;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for field_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="field_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="components" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="component" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}component_type" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="minOccurs" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxOccurs" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="enumerated" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="property-name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="repeats" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="formatter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "field_type", namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", propOrder = {
    "components"
})
public class FieldType {

    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd")
    protected FieldType.Components components;
    @XmlAttribute(name = "minOccurs", required = true)
    protected int minOccurs;
    @XmlAttribute(name = "maxOccurs", required = true)
    protected int maxOccurs;
    @XmlAttribute(name = "value")
    protected String value;
    @XmlAttribute(name = "enumerated")
    protected Boolean enumerated;
    @XmlAttribute(name = "ref")
    protected String ref;
    @XmlAttribute(name = "property-name")
    protected String propertyName;
    @XmlAttribute(name = "type")
    protected String type;
    @XmlAttribute(name = "repeats")
    protected BigInteger repeats;
    @XmlAttribute(name = "formatter")
    protected String formatter;

    /**
     * Gets the value of the components property.
     * 
     * @return
     *     possible object is
     *     {@link FieldType.Components }
     *     
     */
    public FieldType.Components getComponents() {
        return components;
    }

    /**
     * Sets the value of the components property.
     * 
     * @param value
     *     allowed object is
     *     {@link FieldType.Components }
     *     
     */
    public void setComponents(FieldType.Components value) {
        this.components = value;
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
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the enumerated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnumerated() {
        return enumerated;
    }

    /**
     * Sets the value of the enumerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnumerated(Boolean value) {
        this.enumerated = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
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
     * Gets the value of the repeats property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRepeats() {
        return repeats;
    }

    /**
     * Sets the value of the repeats property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRepeats(BigInteger value) {
        this.repeats = value;
    }

    /**
     * Gets the value of the formatter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormatter() {
        return formatter;
    }

    /**
     * Sets the value of the formatter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormatter(String value) {
        this.formatter = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="component" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}component_type" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "component"
    })
    public static class Components {

        @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd")
        protected List<ComponentType> component;

        /**
         * Gets the value of the component property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the component property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getComponent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ComponentType }
         * 
         * 
         */
        public List<ComponentType> getComponent() {
            if (component == null) {
                component = new ArrayList<ComponentType>();
            }
            return this.component;
        }

    }

}
