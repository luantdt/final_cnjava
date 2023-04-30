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

function handleChangeFoodSubmit(e) {
	e.preventDefault();

	const form = document.getElementById("update-food-form");
	const msgBox = document.getElementById("err-msg");
	const file = document.getElementById("fileInput").files[0];
	const formData = new FormData();
	formData.append("id", form.elements.id.value);
	formData.append("name", form.elements.name.value);
	formData.append("description", form.elements.description.value);
	formData.append("quantity", form.elements.quantity.value);
	formData.append("price", form.elements.price.value);
	formData.append("status", form.elements.status.value == "1" ? true : false);

	if (form.elements.category.value != "NO") {
		formData.append("categoryName", form.elements.category.value);
	}

	if (file != undefined) {
		formData.append("file", file);
	}

	if (confirm("Are you sure?")) {
		fetch('/admin/food/update', {
			method: 'POST',
			body: formData
		})
			.then(res => {
				if (res.status == 200) {
					alert("Update food has successfull");
					window.location.href = "/admin/food";
				}
				return res.json();
			})
			.then(data => {
				msgBox.innerHTML = data.data;
			})
			.catch(error => console.error(error));
	}
}

function previewImage(input) {
	if (input.files && input.files[0]) {
		var reader = new FileReader();

		reader.onload = function(e) {
			$('#preview').attr('src', e.target.result);
		}

		reader.readAsDataURL(input.files[0]);
	}
}

function handleAddFoodSubmit(e) {
	e.preventDefault();

	const form = document.getElementById("add-food-form");
	const msgBox = document.getElementById("err-msg");
	const file = document.getElementById("fileInput").files[0];

	const formData = new FormData();

	formData.append("name", form.elements.name.value);
	formData.append("description", form.elements.description.value);
	formData.append("quantity", form.elements.quantity.value);
	formData.append("price", form.elements.price.value);
	formData.append("status", form.elements.status.value == "1" ? true : false);

	if (form.elements.category.value != "NO") {
		formData.append("categoryName", form.elements.category.value);
	}

	if (file != undefined) {
		formData.append("file", file);
	}

	if (confirm("Are you sure?")) {
		fetch('/admin/food/add', {
			method: 'POST',
			body: formData
		})
			.then(res => {
				if (res.status == 200) {
					alert("Add food has successfull");
					window.location.href = "/admin/food";
				}
				return res.json();
			})
			.then(data => {
				msgBox.innerHTML = data.data || data.message;
			})
			.catch(error => console.error(error));
	}
}

function handleDeleteFoodForm(e) {
	let ok = false;
	if (confirm("Are you sure to delete item?")) {
		fetch('/admin/food/' + e.id, {
			method: 'DELETE'
		})
			.then(res => {
				if (res.status == 200) {
					alert("Delete food has successfull");
					location.reload();
					ok = true;
				}
				return res.json();
			})
			.then(data => {
				if (!ok) {
					alert(data.data || data.message);
				}
			})
			.catch(error => console.error(error));
	}

}


document.getElementById("login-form")?.addEventListener("submit", submitForm);
document.getElementById("register-form")?.addEventListener("submit", registerForm);
document.getElementById("update-user-form")?.addEventListener("submit", handleChangeUserSubmit);
document.getElementById("update-food-form")?.addEventListener("submit", handleChangeFoodSubmit);
document.getElementById("add-food-form")?.addEventListener("submit", handleAddFoodSubmit);