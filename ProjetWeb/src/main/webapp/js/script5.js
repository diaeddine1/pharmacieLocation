function recoverInfo(id,nom,ville){
	  console.log(id);
	  var inputid= document.querySelector("#id");
	  var inputnom= document.querySelector("#nom");
	  var btn = document.querySelector(".add");
	  var inputop = document.querySelector("#op");
	  var inputville = document.querySelector("#ville");
	  inputop.value = "update";
	  inputid.value = id;
	  inputnom.value = nom;
	  inputville.value = ville;
	  btn.innerText = "Modifier";
 }
 
 
var addbtn = document.addEventListener("submit",function(event){
	event.preventDefault();
	var btn = document.querySelector(".add");
	var inputid= document.querySelector("#id");
	var inputnom= document.querySelector("#nom");
	var inputop = document.querySelector("#op");
	var inputville = document.querySelector("#ville");
	if(btn.innerText == "Ajouter"){
		inputnom.setAttribute("name","nom");
		inputville.setAttribute("name","ville");
		document.formville.submit();
	}else if(btn.innerText == "Modifier"){
		inputid.setAttribute("name","id");
		inputnom.setAttribute("name","nom");
		inputville.setAttribute("name","ville");
		inputop.setAttribute("name","op");
		document.formville.submit();
	}
	
	
})