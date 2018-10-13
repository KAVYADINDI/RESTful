<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Shopping Page</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6{font-family: sans-serif}
</style>
<body class="w3-content" style="max-width:1200px">

  <!-- Top header -->
  <header class="w3-xlarge">
    <p class="w3-left">Mobiles</p>
    <p class="w3-right">
   <a class="fa fa-shopping-cart w3-margin-right" href="/cart"/></a>
    </p>
  </header>

  <!-- Product grid -->
  <div class="w3-row">
    
    <div class="w3-col l3">
     
      <div class="w3-container">
        <img src="/images/oppo.jpg" height=100 width =100>
         <br><br>
            <button ><a href="/addtocart?productId=125">Add to Cart</a></button>
        <p>Oppo<br><b>Rs.9000</b></p>
      </div>
      
    <div class="w3-container">
        <img src="/images/vivo.jpg" height=100 width =100>
         <br><br>
            <button><a href="/addtocart?productId=124">Add to Cart</a></button>
        <p>Vivo<br><b>Rs.10000</b></p>
      </div>
   
    </div>

    <div class="w3-col l3">
      
      <div class="w3-container">
        <img src="/images/one+.jpg" height=100 width =100>
         <br><br>
            <button><a href="/addtocart?productId=1236">Add to Cart</a></button>
        <p>One+<br><b>Rs.14000</b></p>
      </div>
      
      <div class="w3-container">
        <img src="/images/iPhone.jpg" height=100 width =100>
         <br><br>
            <button> <a href="/addtocart?product.productId=1237">Add to Cart</a></button>
        <p>iPhone<br><b>Rs.20000</b></p>
      </div>
      
    </div>
    
     <div class="w3-col l3">

    <div class="w3-container">
        <img src="/images/samsung.jpg" height=100 width =100>
         <br><br>
            <button><a href="/addtocart?product.productId=1238">Add to Cart</a></button>
        <p>Samsung<br><b>Rs.7000</b></p>
      </div>
      <div class="w3-container">
       
          <img src="/images/mortorolla.jpg" height=100 width =100>
      <br><br>
            <button><a href="/addtocart?product.productId=1239">Add to Cart</a></button>
        <p>Mortorolla<br><b class="w3-text-black">Rs.8000</b></p>
      </div>
    </div>
 </div>
</body>
</html>