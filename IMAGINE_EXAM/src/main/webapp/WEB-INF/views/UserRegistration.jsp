<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="true"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Registration</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- Script added for map support from google -->
<script src="http://maps.google.com/maps/api/js?sensor=false"
	type="text/javascript"></script>

</head>
<body>

	<div id="map" style="width: 400px; height: 300px;"></div>

	<script type="text/javascript"> 

   var address = 'Guwahati, India';

   var map = new google.maps.Map(document.getElementById('map'), { 
       mapTypeId: google.maps.MapTypeId.TERRAIN,
       zoom: 6
   });

   var geocoder = new google.maps.Geocoder();
   var latlng = "26.125586, 91.680936";
   var title = "Pritom Map";
   var imageURL = "";


   <!--To fetch the location using the lat and longitute -->
   var latlngStr = latlng.split(',', 2);
   var lat = parseFloat(latlngStr[0]);
   var lng = parseFloat(latlngStr[1]);
   var latlng = new google.maps.LatLng(lat, lng);
   
   geocoder.geocode({
      'address': address
   },

   /*geocoder.geocode({ 'latLng': latlng },*/

   function(results, status) {
      if(status == google.maps.GeocoderStatus.OK) {
         new google.maps.Marker({
            position: results[0].geometry.location,
            map: map
         });
         map.setCenter(results[0].geometry.location);
      }
      else {
         // Google couldn't geocode this request. Handle appropriately.
      }
   }

   /*function codeLatLng(latlng, title, imageURL) {
	    var latlngStr = latlng.split(',', 2);
	    var lat = parseFloat(latlngStr[0]);
	    var lng = parseFloat(latlngStr[1]);
	    var latlng = new google.maps.LatLng(lat, lng);
	    geocoder.geocode({ 'latLng': latlng }, function (results, status) {
	        if (status == google.maps.GeocoderStatus.OK) {
	            if (results[1]) {
	                map.setZoom(11);
	                marker = new google.maps.Marker({position: latlng,map: map,icon: imageURL,title: title,content: title});
					
	               
	            	var infowindow = new google.maps.InfoWindow({content: title});
					google.maps.event.addListener(marker, 'click', function() {infowindow.open(marker.get('map'), marker);});
					
	            } else {
	                alert('No results found');
	            }
	        } else {
	            alert('Geocoder failed due to: ' + status);
	        }
	    });
	}*/

   
   );

   </script>

	<form:form id="userForm" action="saveUser">
		<table>
			<tr>

				<td><form:label path="userName">User-name</form:label></td>

				<td><form:input id="username" name="username" path="username" />
				</td>

			</tr>

			<tr>
				<td><form:label path="password">PPassword</form:label></td>
				<td><form:password id="password" name="password" path="password" /></td>
			</tr>
			
			<tr>
				<td><form:label path="latitude">Latitute</form:label></td>
				<td><form:input id="latitude" name="latitude" path="latitude" />
			</tr>
			
			<tr>
				<td><form:label path="longitute">Longitute</form:label></td>
				<td><form:input id="longitute" name="longitute" path="longitute" />
			</tr>

			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>