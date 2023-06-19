function populateone(){
	var selectedValue = $("#selectedOE").val();
	console.log(selectedValue);
	$.ajax({
    url: "/kyc/getAllInfo/"+selectedValue,
    type: "GET",
    success: function(response) {
        // Process the response data
        //$("#selectedDealer").empty();
    for(var i=0;i<response.length;i++)
    {
		var item = response[i];
		var option = $("<option>").val(item.id).text(item.name);
		$("#selectedDealer").append(option);
    	console.log(item);
    }
    },
    	error: function(xhr, status, error) {
        // Handle the error
       	console.error(error);
    }
	});
};
	 
function populatetwo(){
	var selectedValue = $("#selectedDealer").val();
	console.log(selectedValue);
	$.ajax({
    url: "/kyc/getAllInfo/"+selectedValue,
    type: "GET",
    success: function(response) {
      // Process the response data
      //$("#selectedPOS").empty();
    for(var i=0;i<response.length;i++)
    {
		var item = response[i];
		var option = $("<option>").val(item.id).text(item.name);
		$("#selectedPOS").append(option);
    	console.log(item);
      	}
    },
    	error: function(xhr, status, error) {
      // Handle the error
       	console.error(error);
    }
	});
};

function populatethree(){
	var selectedValue = $("#selectedPOS").val();
	console.log(selectedValue);
	$.ajax({
    url: "/kyc/getAllInfo/"+selectedValue,
    type: "GET",
    success: function(response) {
    // Process the response data
    //$("#selectedAgent").empty();
    for(var i=0;i<response.length;i++)
    {
		var item = response[i];
		var option = $("<option>").val(item.id).text(item.name);
		$("#selectedAgent").append(option);
        console.log(item);
     }
    	},
    	error: function(xhr, status, error) {
        // Handle the error
       	console.error(error);
    	}
	});
};

	 
function func(){
	console.log("entered func()");
	var select = document.getElementById("kind");
	var div1 = document.getElementById("companyform");
	var div2 = document.getElementById("individualform");
	var comp_type = document.getElementById("company-type");
	var comp_label = document.getElementById("company-label");
	var company_select = document.getElementById("selectedPOA-comp");
	var ind_select = document.getElementById("selectedPOA-indi");
	var selectedValue = select.value;
	console.log(selectedValue);
	if(selectedValue=="2")
	{
	 div1.style.display = 'none';
	 div2.style.display = 'block';
	 comp_type.style.display = 'none';
	 comp_label.style.display = 'none';
	 company_select.style.display = 'none';
	}
	else{
		ind_select.style.display = 'none';
	}
}


function validateMobile(mobile,id){
	console.log("inside validateMobile()");
	console.log(id);
	var regex = '^[0-9]{10}$';
	//var mbno = document.getElementById("mobile").value;
	if(!mobile.match(regex))
	{
		if(id=="mobile")
		document.getElementById("span-mobile").innerHTML = "Enter a valid number";
		else if(id=="alt-contact")
		document.getElementById("alt-mobile").innerHTML = "Enter a valid number";
		else if(id=="alt-contact-indi")
		document.getElementById("alt-mobile-indi").innerHTML = "Enter a valid number";
		document.getElementById(id).value = "";
		//return false;
	}
}


function validateSelection(selectedVal,id) {
	console.log(selectedVal,id);
}


function validateEmail(selectedVal,id) {
	console.log("inside validateEmail()");
	var regex = "/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/";
	if(!selectedVal.match(regex))
	{
		if(id=="company-mail")
			document.getElementById("company-mail-msg").innerHTML = "Enter a valid email";
		else if(id=="individual-mail")
			document.getElementById("individual-mail-msg").innerHTML = "Enter a valid email";
		document.getElementById(id).value = "";
	}
	else
	{
		if(id=="company-mail")
			document.getElementById("company-mail-msg").innerHTML = "";
		else if(id=="individual-mail")
			document.getElementById("individual-mail-msg").innerHTML = "";
	}
}


function allowOnlyNumbers(event) {
  var keyCode = event.keyCode || event.which;
  //var keyCode = document.getElementById("mobile").value;
  // Allow only numeric keycodes
  if (keyCode < 48 || keyCode > 57) {
    event.preventDefault();
    return false;
  }
}


function validatePincode(pin,id) {
	console.log(pin,pin.length);
	if(pin.length!==6)
	{
		if(id=="individual-pin")
			document.getElementById("invalid-pin-i").innerHTML = "Enter a valid pincode";
		else if(id=="company-pin")
			document.getElementById("invalid-pin-c").innerHTML = "Enter a valid pincode";
		document.getElementById(id).value = "";
	}
	else{
		if(id=="individual-pin")
			document.getElementById("invalid-pin-i").innerHTML = "";
		else if(id=="company-pin")
			document.getElementById("invalid-pin-c").innerHTML = "";
	}
}


function emptyField(val,id,spanid) {
	console.log(id,spanid);
	if(val.length==0)
	{
		return document.getElementById(spanid).innerHTML = "This field cannot be empty";
	}
	else
	{
		return document.getElementById(spanid).innerHTML = "";
	}
}

	 