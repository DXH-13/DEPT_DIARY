/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function refreshCaptcha() {
    var captchaImage = document.querySelector('.captcha img');
    captchaImage.src = 'captcha?' + new Date().getTime();
}
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('login-btn').addEventListener('click', function (event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định của form (gửi form)

        // Xóa thông báo lỗi trước đó
        document.getElementById('username-error').textContent = '';
        document.getElementById('password-error').textContent = '';
        document.getElementById('captcha-error').textContent = '';

        // Lấy giá trị từ các trường input
        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();
        const captchaInput = document.querySelector('input[name="captchaInput"]').value.trim();

        let isValid = true;

        // Kiểm tra username
        if (!username) {
            document.getElementById('username-error').textContent = 'Please enter your username.';
            isValid = false;
        }

        // Kiểm tra password
        if (!password) {
            document.getElementById('password-error').textContent = 'Please enter your password.';
            isValid = false;
        }
        // Kiểm tra captcha
        if (!captchaInput) {
            document.getElementById('captcha-error').textContent = 'Please enter captcha.';
            isValid = false;
        }


        // Nếu tất cả thông tin đã được nhập, gửi form
        if (isValid) {
            document.querySelector('.login-form form').submit();
        }
    });
});

window.addEventListener('pageshow', function (event) {
    // Kiểm tra nếu trang được tải từ bộ nhớ cache
    if (event.persisted) {
        window.location.reload();
    } else {
        // Reset form ở đây nếu không muốn reload trang
        document.forms[0].reset();
    }
});

