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

function handleChangeUserSubmit(event) {
	event.preventDefault();

	const form = document.getElementById("update-user-form");
	const msgBox = document.getElementById("err-msg");

	const data = {
		id: form.elements.id.value,
		name: form.elements.name.value,
		email: form.elements.email.value,
		phone: form.elements.phone.value,
		address: form.elements.address.value,
		status: form.elements.status.value == "1" ? true : false,
		role: form.elements.role.value == "NO" ? document.getElementById("thisRole").innerHTML : form.elements.role.value,
	};

	if (confirm("Are you sure?")) {
		console.log(data);
		fetch('/auth/update', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(data)
		})
			.then(res => {
				if (res.status == 200) {
					alert("Update user has successfull");
					window.location.href = "/admin/user";
				}
				return res.json();
			})
			.then(data => {
				msgBox.innerHTML = data.data;
			})
			.catch(error => console.error(error));
	}
}


document.getElementById("login-form")?.addEventListener("submit", submitForm);
document.getElementById("register-form")?.addEventListener("submit", registerForm);
document.getElementById("update-user-form")?.addEventListener("submit", handleChangeUserSubmit);