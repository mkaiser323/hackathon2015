var searchRadius=1000, lat1, lon1; //lat1 = 40.87290431282505, lon1 = -73.89342457805594;
//lon1 and lat1 are the coordinates to the user's location; lon2 and lat2 (local variables) are the pets' locations
$(document).ready(function(){
	//add_object();
	setValues();
	display_all();
	$('#search_radius').keydown(function(event){
		var key = event.which || event.keycode;
		if(key == 13){
			search();
		}
	});
	$('#type').keydown(function(event){
		var key = event.which || event.keycode;
		if(key == 13){
			search();
		}
	});
});

var display_all = function(){
	for(var i = 0; i < posts.length; i++){
		add_post(i);
	}

}

var search = function(){
	$("#newsfeed").empty();

	var query = document.getElementById("type").value;
	searchRadius = document.getElementById("search_radius").value;
	if(searchRadius === ""){
		searchRadius = 1000;
	}
	for(var i = 0; i < posts.length; i++){
		var type = posts[i].type;
		var typecheck;
		if (query === ""){
			typecheck = true;
		} else {
			typecheck = type == query;
		}
		var lat2 = posts[i].lat,
		lon2 = posts[i].lon;
		if(typecheck){
			//alert("lat1: " + lat1 +" lon1: " + lon1 +" lat2: " + lat2 +" lon2: " + lon2)
			var dist = distance(lat1, lon1, lat2, lon2);
			if(dist <= searchRadius){
				add_post(i);
			}
		}
	}
}

var setValues = function(){
	console.log("in getLocation");
	//searchRadius = document.getElementById("search_radius").value;
	//alert(searchRadius);
	if(navigator.geolocation){
		navigator.geolocation.getCurrentPosition(getDistance);
		console.log("it worked?");
	} else {
		console.log("whoops");
	}
}


var getDistance = function(position){
	console.log("in getDistance");
	lon1 = position.coords.longitude;
	lat1 = position.coords.latitude;

	console.log("lon1:");
}

var add_object = function(){
	var obj = {
		"name":"Sporty(added dynamically)",
		"img":"img/sporty.jpg",
		"type":"dog",
		"description":"placeholder text",
		"phone":"123-456-7890",
		"lat":40.87290431282505,
		"lon":-73.89342457805594
	}
	posts.push(obj);
}

var distance = function(lat1, lon1, lat2, lon2, unit) {
    var radlat1 = Math.PI * lat1 / 180
    var radlat2 = Math.PI * lat2 / 180
    var radlon1 = Math.PI * lon1 / 180
    var radlon2 = Math.PI * lon2 / 180
    var theta = lon1 - lon2
    var radtheta = Math.PI * theta / 180
    var dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
    dist = Math.acos(dist)
    dist = dist * 180 / Math.PI
    dist = dist * 60 * 1.1515
    if (unit == "K") {
        dist = dist * 1.609344
    }
    if (unit == "N") {
        dist = dist * 0.8684
    }
    return dist;
}


var add_post = function(i){
	var out,
	name = posts[i].name,
	img = posts[i].img,
	description = posts[i].description,
	phone = posts[i].phone;

	out = "<div class = 'col-md-4'><div class = 'post'>";
	out += "<img src ='"+img+"'/>";
	out += "<div class = 'text'>";
	out += "<h1>"+name+"</h1>";
	out += "<p>"+description+"<p>";
	out += "<p class = 'phone'><i class = 'fa fa-phone'></i> "+phone+"</p>";
	out += "</div></div></div>";

	document.getElementById("newsfeed").innerHTML += out;
}
