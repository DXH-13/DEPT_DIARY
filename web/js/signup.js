function refreshCaptcha() {
    var captchaImage = document.querySelector('.captcha img');
    captchaImage.src = 'captcha?' + new Date().getTime();
}

function validateForm() {
    let isValid = true;

    // Reset error messages
    document.getElementById('email-error').textContent = '';
    document.getElementById('username-error').textContent = '';
    document.getElementById('password-error').textContent = '';
    document.getElementById('confirm-password-error').textContent = '';
    document.getElementById('captcha-error').textContent = '';

    // Get form values
    const email = document.getElementById('email').value.trim();
    const username = document.getElementById('name').value.trim();
    const password = document.getElementById('password').value.trim();
    const confirmPassword = document.getElementById('confirmPassword').value.trim();
    const captchaInput = document.querySelector('input[name="captchaInput"]').value.trim();

    // Validate email
    if (!email) {
        document.getElementById('email-error').textContent = 'Email is required.';
        isValid = false;
    } else if (!/\S+@\S+\.\S+/.test(email)) {
        document.getElementById('email-error').textContent = 'Invalid email format.';
        isValid = false;
    }

    // Validate username
    if (!username) {
        document.getElementById('username-error').textContent = 'Username is required.';
        isValid = false;
    }

    // Validate password
    if (!password) {
        document.getElementById('password-error').textContent = 'Password is required.';
        isValid = false;
    }

    // Validate confirm password
//    if (password !== confirmPassword) {
//        document.getElementById('confirm-password-error').textContent = 'Passwords do not match.';
//        isValid = false;
//    }

    // Validate captcha - Note that actual validation should occur on the server-side
    if (!captchaInput) {
        document.getElementById('captcha-error').textContent = 'Captcha is required.';
        isValid = false;
    }

    return isValid; // This should be true if all validations pass
}


// Gắn sự kiện submit vào form
document.getElementById('signupForm').addEventListener('submit', function (e) {
    e.preventDefault(); // Ngăn việc submit form mặc định
    // Thực hiện các hành động sau khi form được submit ở đây, nếu cần
});



//
//window.addEventListener('pageshow', function (event) {
//    // Kiểm tra nếu trang được tải từ bộ nhớ cache
//    if (event.persisted) {
//        window.location.reload();
//    } else {
//        // Reset form ở đây nếu không muốn reload trang
//        document.forms[0].reset();
//    }
//});

document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('signUpButton').addEventListener('click', function () {
        // Validate the form first
        if (validateForm()) {
            // If the form is valid, show the confirmation modal
            $('#confirmationModal').modal('show');
        }
    });

    document.getElementById('confirmSubmit').addEventListener('click', function () {
        // Assume validation has already been done, submit the form
        document.getElementById('signupForm').submit();
    });
});

