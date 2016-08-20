
package com.aero.ic.mapping;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="meta" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}meta_type"/>
 *         &lt;element name="container" type="{http://www.aero-ic.com/edi/mapping/edi.xsd}container_type"/>
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
    "meta",
    "container"
})
@XmlRootElement(name = "edi-mapping", namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd")
public class EdiMapping {

    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
    protected MetaType meta;
    @XmlElement(namespace = "http://www.aero-ic.com/edi/mapping/edi.xsd", required = true)
    protected ContainerType container;

    /**
     * Gets the value of the meta property.
     * 
     * @return
     *     possible object is
     *     {@link MetaType }
     *     
     */
    public MetaType getMeta() {
        return meta;
    }

    /**
     * Sets the value of the meta property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaType }
     *     
     */
    public void setMeta(MetaType value) {
        this.meta = value;
    }

    /**
     * Gets the value of the container property.
     * 
     * @return
     *     possible object is
     *     {@link ContainerType }
     *     
     */
    public ContainerType getContainer() {
        return container;
    }

    /**
     * Sets the value of the container property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContainerType }
     *     
     */
    public void setContainer(ContainerType value) {
        this.container = value;
    }

}
