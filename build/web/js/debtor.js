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

document.getElementById('adddebtor').addEventListener('click', function (event) {
    event.preventDefault(); // Ngăn chặn hành động mặc định của nút submit

    let isValid = true;

    // Validate fullName
    const fullName = document.getElementById('fullName').value;
    if (!fullName.trim()) {
        document.getElementById('fullName-error').textContent = 'Please enter a full name.';
        isValid = false;
    } else {
        document.getElementById('fullName-error').textContent = '';
    }

    // Only show confirmation modal if all validations pass
    if (isValid) {
        // Show confirmation modal
        $('#confirmModal').modal('show');
    }
});



document.getElementById('confirmAdd').addEventListener('click', function () {
    // Ẩn modal xác nhận
    $('#confirmModal').modal('hide');

    // Hiển thị modal thành công
    $('#successModal').modal('show');
});

// Đặt event listener cho modal thành công khi nó được đóng
$('#successModal').on('hidden.bs.modal', function () {
    // Gửi form khi modal thành công đóng lại
    document.getElementById('debt-form').submit();
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

