
const name=document.getElementById("name");
const password=document.getElementById("password");
const confpassword=document.getElementById("confirmpassword");
const nickname=document.getElementById("nickname");
const mobilenumber=document.getElementById("mobilenumber");
const error=document.getElementById("error");
const form=document.getElementById("form");

form.addEventListener('submit',(e)=>{
	let messages=[];
	if(name.value==='' || name.value==null){
		messages.push('name is required');
	}
	else if(password.value==''|| password.value==null){
		messages.push("password is required");
	}
	else if(password.value!=confpassword.value){
		messages.push("password and confirm password doesnot match");
	}
	else if(nickname.value==''|| nickname.value==null){
		messages.push("nickname is required");
	}
	else if(mobilenumber.value==''|| mobilenumber.value==null){
		messages.push("mobilenumber is required");
	}
	if(messages.length>0){
		e.preventDefault();
		error.innerText=messages.join(',');
	}
})