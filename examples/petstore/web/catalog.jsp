<%-- Copyright 2006 Sun Microsystems, Inc. All rights reserved. You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: http://developer.sun.com/berkeley_license.html
$Id: catalog.jsp,v 1.22 2007/03/16 21:42:03 basler Exp $ --%>
<script type="text/javascript" src="common.js"></script>
<script type="text/javascript" src="scroller.js"></script>
<link rel="stylesheet" type="text/css" href="scroller.css"></link>
<script type="text/javascript" src="accordion.js"></script>
<link rel="stylesheet" type="text/css" href="accordion.css"></link>
<script type="text/javascript" src="catalog.js"></script>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib prefix="ui" uri="http://java.sun.com/blueprints/ui" %>
<body>
<jsp:include page="banner.jsp" />
<script type="text/javascript">
    dojo.event.connect(window, "onload", function(){initCatalog();});
</script>
<center>
<table border="0">
<tr>
<td>
  <table id="accordion">
    <tr id="accordionTitle" class="accordionTitle"><td>Pets</td></tr>
    <tr><td>
        <table id="accordionBody" border="0" class="accordionBody">
        </table>
    </td></tr>
  </table>
</td>
<td>
  <div id="CatalogBrowser">
  <table border="0" class="slider" width="500px" >
  <tr height="415" valign="top">
    <td id="bodySpace" border="0" align="center"></td>
  </tr>
  <tr id="targetRow">
    <td width="500" height="70 align="top">
        <div class="nav" id="right_button">
      <img src="${pageContext.request.contextPath}/images/right.gif" name="nextRoll" title="Show More Items" border="0">
    </div>
    <div class="nav" id="left_button">
      <img src="${pageContext.request.contextPath}/images/left.gif" name="previousRoll" title="Show Previous Items" border="0">
    </div>
    <div id="infopane" class="infopane">
    <table class="infopaneTable">
      <tr>
        <td id="infopaneName" class="infopaneTitle">
        </td>
        <td id="infopaneRating" class="infopaneRating">
          <f:view>
          <ui:rating id="rating" maxGrade="5" includeNotInterested="false" includeClear="false" 
                     hoverTexts="#{RatingBean.ratingText}" notInterestedHoverText="Not Interested" clearHoverText="Clear Rating"
                     grade="#{RatingBean.grade}"/>
        </td>
          <td id="infopanePrice" class="infopanePrice"></td>
          <td id="infopanePayPal" class="infopanePayPal">
        <f:verbatim>          
          <%-- code for Google checkout --%>
          <FORM method="POST" action="https://sandbox.google.com/checkout/cws/v2/Merchant/156531684379308/checkoutForm" accept-charset="utf-8">
            <input type="hidden" name="item_name_1" value="pet"/>
            <input type="hidden" name="item_description_1" value="Pet from Java Pet Store."/>
            <input type="hidden" name="item_quantity_1" value="1"/>
            <input type="hidden" name="item_price_1" value="100"/>
            
            <input type="hidden" name="ship_method_name_1" value="Pet Delivery Service"/>
            <input type="hidden" name="ship_method_price_1" value="24.99"/>
            
            <input type="hidden" name="tax_rate" value="0.0875"/>
            <input type="hidden" name="tax_us_state" value="CA"/>
            
            <input type="hidden" name="_charset_"/>
            <input type="image" name="Google Checkout" alt="Fast checkout through Google"
                   src="https://checkout.google.com/buttons/checkout.gif?merchant_id=156531684379308&w=160&h=43&style=trans&variant=text&loc=en_US"  height="46" width="180"/>
          </FORM>
        </f:verbatim>
        <ui:buyNow business="donate@animalfoundation.com" id="buyNow1" 
            itemName="Buy Item One" amount="100.00" quantity="1" 
            type="BuyNow" postData="#{PayPalBean.postData}" target="paypal"/>    
      </td>
        </f:view>
      <td id="infopaneIndicator" class="infopaneIndicator">
      </td>
      <td id="infopaneDetailsIcon">
      </td>
    </tr>
    <tr>
      <td id="infopaneShortDescription" colspan="7" class="infopaneShortDescription">
      </td>
    </tr>
    <tr style="height:20px">
      <td></td>
    </tr>
    <tr>
      <td id="infopaneDescription" colspan="6" class="infopaneDescription">
      </td>
    </tr>
  </table>
  </div>                         
  </td>                    
</tr>
</table>
</td>
<td style="vertical-align:top; width:300px; text-align:right;">
  <div id="downloadAds">
    <jsp:include page="download.jsp" />
  </div>
</td>
</tr>
</table>
</div>
<div id="status" style="text-align:left"></div> <div id="status_2"></div>
<div id="dstatus"></div>
<div id="injection_point"></div>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>