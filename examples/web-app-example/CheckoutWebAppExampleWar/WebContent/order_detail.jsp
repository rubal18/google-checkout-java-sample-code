<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Iterator" %>

<%@ page import="com.google.checkout.example.GoogleOrder" %>
<%@ page import="com.google.checkout.example.Message" %>
<%@ page import="com.google.checkout.impl.util.EncodeHelper" %>
<%@ page import="com.google.checkout.MerchantConstants" %>
<%@ page import="com.google.checkout.example.CheckoutRequestFactory" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Detail</title>
</head>
<body>
<script language="JavaScript">
  function toggle(e) {
    if(document.getElementById('div_'+e).style.display == 'none') {
      document.getElementById('div_'+e).style.display='block';
      document.getElementById('b_'+e).value='-';
      sz(document.getElementById('ta_'+e));
    }
    else {
      document.getElementById('div_'+e).style.display='none';
      document.getElementById('b_'+e).value='+';
    }
  };
  
  function sz(t) {
    a = t.value.split('\n');
    b=1;
    for (x=0;x < a.length; x++) {
      if (a[x].length >= t.cols) b+= Math.floor(a[x].length/t.cols);
    }
    b+= a.length;
    t.rows = b;
  };
</script>
<h1>Order Detail</h1>
<%
  MerchantConstants mc = com.google.checkout.example.CheckoutRequestFactory.getMerchantConstants();
  String orderNumber = request.getParameter("orderNumber");
  
  GoogleOrder order = GoogleOrder.findOrCreate(mc.getMerchantId(), orderNumber);
  Collection messages = order.getEvents();
  Iterator it = messages.iterator();
  Message m;
  int count = 0;
  while( it.hasNext() ) {
	  count++;
	  m = (Message) it.next();
	  String body = m.getBody();
 	  String header = EncodeHelper.EscapeXmlChars(m.getHeader());
%>
		<a href="javascript:toggle('<%=count %>');"><strong><%=header %></strong></a>
		<br/>
		<div id="div_<%=count %>" style='display:none;'>
		<textarea id="ta_<%=count %>" readonly="true" cols="145" rows="20"><%=body%></textarea>
	  	</div>
	  <% 	  
  }
%>
</body>
</html>