const name=document.getElementById("name");
const password=document.getElementById("password");
const form=document.getElementById("form");
const error=document.getElementById("error");
form.addEventListener('submit',(e)=>{
	let messages=[];
	if(name.value==='' || name.value==null){
		messages.push("Name is required");
	}
	else if(password.value==='' || password.value==null){
		messages.push("password required");
	}
	if(messages.length>0){
		e.preventDefault();
		error.innerText=messages.join(',');
	}
	
})