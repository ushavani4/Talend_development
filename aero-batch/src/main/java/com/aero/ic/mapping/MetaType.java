
package com.aero.ic.mapping;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for meta_type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="meta_type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="terminator">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="segmentTerm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="field" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="component" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "meta_type", namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", propOrder = {
    "terminator"
})
public class MetaType {

    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
    protected MetaType.Terminator terminator;

    /**
     * Gets the value of the terminator property.
     * 
     * @return
     *     possible object is
     *     {@link MetaType.Terminator }
     *     
     */
    public MetaType.Terminator getTerminator() {
        return terminator;
    }

    /**
     * Sets the value of the terminator property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaType.Terminator }
     *     
     */
    public void setTerminator(MetaType.Terminator value) {
        this.terminator = value;
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
     *         &lt;element name="segmentTerm" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="field" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="component" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "segmentTerm",
        "field",
        "component"
    })
    public static class Terminator {

        @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
        protected String segmentTerm;
        @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
        protected String field;
        @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
        protected String component;

        /**
         * Gets the value of the segmentTerm property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSegmentTerm() {
            return segmentTerm;
        }

        /**
         * Sets the value of the segmentTerm property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSegmentTerm(String value) {
            this.segmentTerm = value;
        }

        /**
         * Gets the value of the field property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getField() {
            return field;
        }

        /**
         * Sets the value of the field property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setField(String value) {
            this.field = value;
        }

        /**
         * Gets the value of the component property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getComponent() {
            return component;
        }

        /**
         * Sets the value of the component property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComponent(String value) {
            this.component = value;
        }

    }

}
