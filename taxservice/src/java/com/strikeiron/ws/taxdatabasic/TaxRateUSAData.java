/**
 * TaxRateUSAData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.2.1 Jun 14, 2005 (09:15:57 EDT) WSDL2Java emitter.
 */

package com.strikeiron.ws.taxdatabasic;

public class TaxRateUSAData  implements java.io.Serializable {
    private java.lang.String zip_code;
    private java.lang.String state;
    private java.lang.String county_name;
    private java.lang.String city_name;
    private double state_sales_tax;
    private double state_use_tax;
    private double county_sales_tax;
    private double county_use_tax;
    private double city_sales_tax;
    private double city_use_tax;
    private double total_sales_tax;
    private double total_use_tax;
    private java.lang.String tax_shipping_alone;
    private java.lang.String tax_shipping_handling;

    public TaxRateUSAData() {
    }

    public TaxRateUSAData(
           java.lang.String zip_code,
           java.lang.String state,
           java.lang.String county_name,
           java.lang.String city_name,
           double state_sales_tax,
           double state_use_tax,
           double county_sales_tax,
           double county_use_tax,
           double city_sales_tax,
           double city_use_tax,
           double total_sales_tax,
           double total_use_tax,
           java.lang.String tax_shipping_alone,
           java.lang.String tax_shipping_handling) {
           this.zip_code = zip_code;
           this.state = state;
           this.county_name = county_name;
           this.city_name = city_name;
           this.state_sales_tax = state_sales_tax;
           this.state_use_tax = state_use_tax;
           this.county_sales_tax = county_sales_tax;
           this.county_use_tax = county_use_tax;
           this.city_sales_tax = city_sales_tax;
           this.city_use_tax = city_use_tax;
           this.total_sales_tax = total_sales_tax;
           this.total_use_tax = total_use_tax;
           this.tax_shipping_alone = tax_shipping_alone;
           this.tax_shipping_handling = tax_shipping_handling;
    }


    /**
     * Gets the zip_code value for this TaxRateUSAData.
     * 
     * @return zip_code
     */
    public java.lang.String getZip_code() {
        return zip_code;
    }


    /**
     * Sets the zip_code value for this TaxRateUSAData.
     * 
     * @param zip_code
     */
    public void setZip_code(java.lang.String zip_code) {
        this.zip_code = zip_code;
    }


    /**
     * Gets the state value for this TaxRateUSAData.
     * 
     * @return state
     */
    public java.lang.String getState() {
        return state;
    }


    /**
     * Sets the state value for this TaxRateUSAData.
     * 
     * @param state
     */
    public void setState(java.lang.String state) {
        this.state = state;
    }


    /**
     * Gets the county_name value for this TaxRateUSAData.
     * 
     * @return county_name
     */
    public java.lang.String getCounty_name() {
        return county_name;
    }


    /**
     * Sets the county_name value for this TaxRateUSAData.
     * 
     * @param county_name
     */
    public void setCounty_name(java.lang.String county_name) {
        this.county_name = county_name;
    }


    /**
     * Gets the city_name value for this TaxRateUSAData.
     * 
     * @return city_name
     */
    public java.lang.String getCity_name() {
        return city_name;
    }


    /**
     * Sets the city_name value for this TaxRateUSAData.
     * 
     * @param city_name
     */
    public void setCity_name(java.lang.String city_name) {
        this.city_name = city_name;
    }


    /**
     * Gets the state_sales_tax value for this TaxRateUSAData.
     * 
     * @return state_sales_tax
     */
    public double getState_sales_tax() {
        return state_sales_tax;
    }


    /**
     * Sets the state_sales_tax value for this TaxRateUSAData.
     * 
     * @param state_sales_tax
     */
    public void setState_sales_tax(double state_sales_tax) {
        this.state_sales_tax = state_sales_tax;
    }


    /**
     * Gets the state_use_tax value for this TaxRateUSAData.
     * 
     * @return state_use_tax
     */
    public double getState_use_tax() {
        return state_use_tax;
    }


    /**
     * Sets the state_use_tax value for this TaxRateUSAData.
     * 
     * @param state_use_tax
     */
    public void setState_use_tax(double state_use_tax) {
        this.state_use_tax = state_use_tax;
    }


    /**
     * Gets the county_sales_tax value for this TaxRateUSAData.
     * 
     * @return county_sales_tax
     */
    public double getCounty_sales_tax() {
        return county_sales_tax;
    }


    /**
     * Sets the county_sales_tax value for this TaxRateUSAData.
     * 
     * @param county_sales_tax
     */
    public void setCounty_sales_tax(double county_sales_tax) {
        this.county_sales_tax = county_sales_tax;
    }


    /**
     * Gets the county_use_tax value for this TaxRateUSAData.
     * 
     * @return county_use_tax
     */
    public double getCounty_use_tax() {
        return county_use_tax;
    }


    /**
     * Sets the county_use_tax value for this TaxRateUSAData.
     * 
     * @param county_use_tax
     */
    public void setCounty_use_tax(double county_use_tax) {
        this.county_use_tax = county_use_tax;
    }


    /**
     * Gets the city_sales_tax value for this TaxRateUSAData.
     * 
     * @return city_sales_tax
     */
    public double getCity_sales_tax() {
        return city_sales_tax;
    }


    /**
     * Sets the city_sales_tax value for this TaxRateUSAData.
     * 
     * @param city_sales_tax
     */
    public void setCity_sales_tax(double city_sales_tax) {
        this.city_sales_tax = city_sales_tax;
    }


    /**
     * Gets the city_use_tax value for this TaxRateUSAData.
     * 
     * @return city_use_tax
     */
    public double getCity_use_tax() {
        return city_use_tax;
    }


    /**
     * Sets the city_use_tax value for this TaxRateUSAData.
     * 
     * @param city_use_tax
     */
    public void setCity_use_tax(double city_use_tax) {
        this.city_use_tax = city_use_tax;
    }


    /**
     * Gets the total_sales_tax value for this TaxRateUSAData.
     * 
     * @return total_sales_tax
     */
    public double getTotal_sales_tax() {
        return total_sales_tax;
    }


    /**
     * Sets the total_sales_tax value for this TaxRateUSAData.
     * 
     * @param total_sales_tax
     */
    public void setTotal_sales_tax(double total_sales_tax) {
        this.total_sales_tax = total_sales_tax;
    }


    /**
     * Gets the total_use_tax value for this TaxRateUSAData.
     * 
     * @return total_use_tax
     */
    public double getTotal_use_tax() {
        return total_use_tax;
    }


    /**
     * Sets the total_use_tax value for this TaxRateUSAData.
     * 
     * @param total_use_tax
     */
    public void setTotal_use_tax(double total_use_tax) {
        this.total_use_tax = total_use_tax;
    }


    /**
     * Gets the tax_shipping_alone value for this TaxRateUSAData.
     * 
     * @return tax_shipping_alone
     */
    public java.lang.String getTax_shipping_alone() {
        return tax_shipping_alone;
    }


    /**
     * Sets the tax_shipping_alone value for this TaxRateUSAData.
     * 
     * @param tax_shipping_alone
     */
    public void setTax_shipping_alone(java.lang.String tax_shipping_alone) {
        this.tax_shipping_alone = tax_shipping_alone;
    }


    /**
     * Gets the tax_shipping_handling value for this TaxRateUSAData.
     * 
     * @return tax_shipping_handling
     */
    public java.lang.String getTax_shipping_handling() {
        return tax_shipping_handling;
    }


    /**
     * Sets the tax_shipping_handling value for this TaxRateUSAData.
     * 
     * @param tax_shipping_handling
     */
    public void setTax_shipping_handling(java.lang.String tax_shipping_handling) {
        this.tax_shipping_handling = tax_shipping_handling;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TaxRateUSAData)) return false;
        TaxRateUSAData other = (TaxRateUSAData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.zip_code==null && other.getZip_code()==null) || 
             (this.zip_code!=null &&
              this.zip_code.equals(other.getZip_code()))) &&
            ((this.state==null && other.getState()==null) || 
             (this.state!=null &&
              this.state.equals(other.getState()))) &&
            ((this.county_name==null && other.getCounty_name()==null) || 
             (this.county_name!=null &&
              this.county_name.equals(other.getCounty_name()))) &&
            ((this.city_name==null && other.getCity_name()==null) || 
             (this.city_name!=null &&
              this.city_name.equals(other.getCity_name()))) &&
            this.state_sales_tax == other.getState_sales_tax() &&
            this.state_use_tax == other.getState_use_tax() &&
            this.county_sales_tax == other.getCounty_sales_tax() &&
            this.county_use_tax == other.getCounty_use_tax() &&
            this.city_sales_tax == other.getCity_sales_tax() &&
            this.city_use_tax == other.getCity_use_tax() &&
            this.total_sales_tax == other.getTotal_sales_tax() &&
            this.total_use_tax == other.getTotal_use_tax() &&
            ((this.tax_shipping_alone==null && other.getTax_shipping_alone()==null) || 
             (this.tax_shipping_alone!=null &&
              this.tax_shipping_alone.equals(other.getTax_shipping_alone()))) &&
            ((this.tax_shipping_handling==null && other.getTax_shipping_handling()==null) || 
             (this.tax_shipping_handling!=null &&
              this.tax_shipping_handling.equals(other.getTax_shipping_handling())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getZip_code() != null) {
            _hashCode += getZip_code().hashCode();
        }
        if (getState() != null) {
            _hashCode += getState().hashCode();
        }
        if (getCounty_name() != null) {
            _hashCode += getCounty_name().hashCode();
        }
        if (getCity_name() != null) {
            _hashCode += getCity_name().hashCode();
        }
        _hashCode += new Double(getState_sales_tax()).hashCode();
        _hashCode += new Double(getState_use_tax()).hashCode();
        _hashCode += new Double(getCounty_sales_tax()).hashCode();
        _hashCode += new Double(getCounty_use_tax()).hashCode();
        _hashCode += new Double(getCity_sales_tax()).hashCode();
        _hashCode += new Double(getCity_use_tax()).hashCode();
        _hashCode += new Double(getTotal_sales_tax()).hashCode();
        _hashCode += new Double(getTotal_use_tax()).hashCode();
        if (getTax_shipping_alone() != null) {
            _hashCode += getTax_shipping_alone().hashCode();
        }
        if (getTax_shipping_handling() != null) {
            _hashCode += getTax_shipping_handling().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TaxRateUSAData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.strikeiron.com", "TaxRateUSAData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("zip_code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "zip_code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "state"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("county_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "county_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city_name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "city_name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state_sales_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "state_sales_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("state_use_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "state_use_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("county_sales_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "county_sales_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("county_use_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "county_use_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city_sales_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "city_sales_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city_use_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "city_use_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_sales_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "total_sales_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_use_tax");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "total_use_tax"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax_shipping_alone");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "tax_shipping_alone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tax_shipping_handling");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.strikeiron.com", "tax_shipping_handling"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
