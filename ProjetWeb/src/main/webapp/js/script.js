 function recoverInfo(id,nom){
	  console.log(id);
	  var inputid= document.querySelector("#id");
	  var inputnom= document.querySelector("#nom");
	  var btn = document.querySelector(".add");
	  var inputop = document.querySelector("#op");
	  inputop.value = "update";
	  inputid.value = id;
	  inputnom.value = nom;
	  btn.innerText = "Modifier";
 }
 
 
var addbtn = document.addEventListener("submit",function(event){
	event.preventDefault();
	var btn = document.querySelector(".add");
	var inputid= document.querySelector("#id");
	var inputnom= document.querySelector("#nom");
	var inputop = document.querySelector("#op");
	if(btn.innerText == "Ajouter"){
		inputnom.setAttribute("name","nom");
		document.formville.submit();
	}else if(btn.innerText == "Modifier"){
		inputid.setAttribute("name","id");
		inputnom.setAttribute("name","nom");
		inputop.setAttribute("name","op");
		
		document.formville.submit();
	}
	
	
})