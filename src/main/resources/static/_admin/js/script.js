function submitForm(event) {
	event.preventDefault();

	const form = document.getElementById("login-form");
	const data = {
		email: form.elements.email.value,
		password: form.elements.password.value
	};

	fetch('/auth/login', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	})
		.then(res => {
			if (res.status == 200) {
				window.location.href = "/";
			} else {
				document.getElementById("err-msg").innerHTML = "Your email or password is not correct";
			}
		})
		.catch(error => console.error(error));
}

function registerForm(event) {
	event.preventDefault();

	const form = document.getElementById("register-form");
	const repeatPassword = document.getElementById("exampleRepeatPassword");
	const msgBox = document.getElementById("err-msg");

	if (repeatPassword.value != form.elements.password.value) {
		msgBox.innerHTML = "Password and repeat password do not math";
		return;
	}

	const data = {
		name: form.elements.name.value,
		password: form.elements.password.value,
		email: form.elements.email.value,
		phone: form.elements.phone.value,
		address: form.elements.address.value
	};


	fetch('/auth/register', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(data)
	})
		.then(res => {
			if (res.status == 200) {
				window.location.href = "/";
			}
			return res.json();
		})
		.then(data => {
			msgBox.innerHTML = data.data;
		})
		.catch(error => console.error(error));
}


document.getElementById("login-form")?.addEventListener("submit", submitForm);
document.getElementById("register-form")?.addEventListener("submit", registerForm);