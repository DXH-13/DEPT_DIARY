/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function previewImage(event) {
    var reader = new FileReader();
    reader.onload = function () {
        var output = document.getElementById('avatar-preview');
        output.src = reader.result;
        output.style.display = 'block';
    }
    reader.readAsDataURL(event.target.files[0]);
}

function validateForm() {
    let isValid = true;


    var fullName = document.getElementsByName("fullName")[0].value;
    if (fullName.trim() === "") {
        document.getElementById("fullName-error").innerText = "Full Name cannot be empty.";
        isValid = false;
    } else {
        document.getElementById("fullName-error").innerText = "";
    }


    var phoneNumber = document.getElementsByName("phoneNumber")[0].value;
    var phoneNumberPattern = /^\d{10,15}$/;
    if (!phoneNumber) {
        document.getElementById("phoneNumber-error").innerText = "";
    } else if (!phoneNumberPattern.test(phoneNumber)) {
        document.getElementById("phoneNumber-error").innerText = "Phone Number must be between 10 to 15 digits.";
        isValid = false;
    } else {
        document.getElementById("phoneNumber-error").innerText = "";
    }


//    var address = document.getElementsByName("address")[0].value;
//    if (address.trim() === "") {
//        document.getElementById("address-error").innerText = "Address cannot be empty.";
//        isValid = false;
//    } else {
//        document.getElementById("address-error").innerText = "";
//    }
    if (!isValid) {
        event.preventDefault();
    }

    return isValid;
}

function submitForm() {
    document.getElementById('debt-form').submit();
}
window.addEventListener('pageshow', function (event) {
    if (event.persisted) {
        window.location.reload();
    } else {
        document.forms[0].reset();
    }
});

document.getElementById('update').addEventListener('click', function () {
    if (validateForm()) {
        $('#confirmationModal').modal('show');
    }
});

document.getElementById('confirmSubmit').addEventListener('click', function () {
    $('#successModal').modal('show');
});

$('#successModal').on('hidden.bs.modal', function () {
    document.getElementById('debt-form').submit();
});

$('#successModal .close, #successModal').on('click', function () {
    document.getElementById('debt-form').submit();
});

document.getElementById('debt-form').addEventListener('submit', function (e) {
    e.preventDefault();
});







