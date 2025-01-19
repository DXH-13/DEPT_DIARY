/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener('DOMContentLoaded', function () {
    // Khởi tạo Cleave cho input số tiền
    new Cleave('#amount', {
        numeral: true,
        numeralThousandsGroupStyle: 'thousand'
    });

    // Xác nhận form trước khi submit
    document.getElementById('debtBill').addEventListener('submit', function (event) {
        if (!validateForm()) {
            event.preventDefault();
            console.log('Form không hợp lệ. Vui lòng kiểm tra lại thông tin.');
        }
    });
});

document.addEventListener('DOMContentLoaded', function () {
    const addButton = document.getElementById('addImageButton');
    const container = document.getElementById('imageInputsContainer');

    addButton.addEventListener('click', function () {
        const inputGroup = document.createElement('div');
        inputGroup.classList.add('input-group', 'mb-3');

        const input = document.createElement('input');
        input.type = 'file';
        input.classList.add('form-control');
        input.accept = 'image/png, image/jpeg';
        input.name = 'images[]';

        input.addEventListener('change', function (e) {
            if (e.target.files.length) {
                const file = e.target.files[0];
                const reader = new FileReader();

                reader.onload = function (e) {
                    const img = document.createElement('img');
                    img.src = e.target.result;
                    img.style.maxWidth = '100%'; // Use 100% to make it responsive to the container size
                    img.style.height = 'auto'; // Maintain aspect ratio
                    img.classList.add('img-preview', 'mt-2'); // Add margin-top
                    // Remove any existing previews
                    const existingPreview = inputGroup.querySelector('.img-preview');
                    if (existingPreview) {
                        inputGroup.removeChild(existingPreview);
                    }

                    inputGroup.appendChild(img);
                };

                reader.readAsDataURL(file);
            }
        });

        const removeButton = document.createElement('button');
        removeButton.type = 'button';
        removeButton.classList.add('btn', 'btn-danger');
        removeButton.innerHTML = '<i class="fa fa-minus-circle"></i>';
        removeButton.addEventListener('click', function () {
            inputGroup.remove();
        });

        inputGroup.appendChild(input);
        inputGroup.appendChild(removeButton);

        container.appendChild(inputGroup);
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

// Khi người dùng nhấn vào nút 'Đồng ý', kiểm tra dữ liệu form
document.getElementById('agreeButton').addEventListener('click', function () {
    if (validateForm()) {
        // Nếu dữ liệu form hợp lệ, hiển thị modal xác nhận
        $('#confirmationModal').modal('show');
    }
});

// Khi người dùng nhấn vào nút 'Xác nhận' trong modal xác nhận
document.getElementById('confirmSubmit').addEventListener('click', function () {
    // Hiển thị modal thông báo thành công
    $('#successModal').modal('show');
});

// Xử lý sự kiện khi modal thông báo thành công đóng lại
$('#successModal').on('hidden.bs.modal', function () {
    // Khi modal thông báo thành công đóng, submit form
    document.getElementById('debtBill').submit();
});

// Xử lý sự kiện khi nhấn vào nút đóng (dấu X) của modal thông báo thành công
$('#successModal .close, #successModal').on('click', function () {
    // Đóng modal thông báo thành công và submit form
    document.getElementById('debtBill').submit();
});

// Gắn sự kiện submit vào form
document.getElementById('debtBill').addEventListener('submit', function (e) {
    e.preventDefault(); // Ngăn việc submit form mặc định
    // Thực hiện các hành động sau khi form được submit ở đây, nếu cần
});

function validateForm() {
    let isValid = true;
    const debtType = document.querySelector('input[name="debtType"]:checked');
    const amount = document.getElementById('amount').value.trim();
//    const date = document.getElementById('date').value.trim();
//    const debtTerm = document.getElementById('debtTerm').value.trim(); // Get the debt term value
    const debitOptions = document.getElementById('debitOptions');
    const creditOptions = document.getElementById('creditOptions');
    // Reset error messages
    document.getElementById('debtType-error').textContent = '';
    document.getElementById('amount-error').textContent = '';
//    document.getElementById('date-error').textContent = '';
//    document.getElementById('debtTerm-error').textContent = ''; // Reset debt term error message
    document.getElementById('debitOptions-error').textContent = '';
    document.getElementById('creditOptions-error').textContent = '';

    // Validate debt type
    if (!debtType) {
        document.getElementById('debtType-error').textContent = 'Debt type is required.';
        isValid = false;
    } else if (debtType.value === 'debit' && debitOptions.value === '') {
        // Validate debit options if debit is selected
        document.getElementById('debitOptions-error').textContent = 'Please select a debit option.';
        isValid = false;
    } else if (debtType.value === 'credit' && creditOptions.value === '') {
        // Validate credit options if credit is selected
        document.getElementById('creditOptions-error').textContent = 'Please select a credit option.';
        isValid = false;
    }

    // Validate amount
    if (!amount) {
        document.getElementById('amount-error').textContent = 'Amount is required.';
        isValid = false;
    } else if (parseFloat(amount) < 0) { // Check if amount is negative
        document.getElementById('amount-error').textContent = 'Amount cannot be negative.';
        isValid = false;
    }


    // Validate date
//    if (!date) {
//        document.getElementById('date-error').textContent = 'Create date is required.';
//        isValid = false;
//    }
//    // Validate debt term
//    if (!debtTerm) {
//        document.getElementById('debtTerm-error').textContent = 'Debt term is required.';
//        isValid = false;
//    }

    return isValid;
}



document.addEventListener('DOMContentLoaded', function () {
    // Lắng nghe sự kiện thay đổi cho radio buttons
    document.querySelectorAll('input[name="debtType"]').forEach(function (radio) {
        radio.addEventListener('change', onDebtTypeChange);
    });

    function onDebtTypeChange() {
        // Ẩn cả hai nhóm button
        document.getElementById('debitAttributes').style.display = 'none';
        document.getElementById('creditAttributes').style.display = 'none';

        // Hiển thị nhóm button tương ứng với lựa chọn
        if (document.getElementById('debit').checked) {
            document.getElementById('debitAttributes').style.display = 'block';
        } else if (document.getElementById('credit').checked) {
            document.getElementById('creditAttributes').style.display = 'block';
        }
    }
});



//window.onload = function () {
//    var today = new Date();
//    var date = today.getFullYear() + '-' + (today.getMonth() + 1).toString().padStart(2, '0') + '-' + today.getDate().toString().padStart(2, '0');
//    var time = today.getHours().toString().padStart(2, '0') + ":" + today.getMinutes().toString().padStart(2, '0');
//    var dateTime = date + 'T' + time;
//    document.getElementById("date").value = dateTime;
//};

// JavaScript để cho phép uncheck các nút radio
document.addEventListener('DOMContentLoaded', () => {
    let allRadios = document.querySelectorAll('input[type="radio"]');
    let radioChecked = {}; // Đối tượng để theo dõi trạng thái checked

    allRadios.forEach(radio => {
        radio.addEventListener('click', function () {
            let radioName = this.name;
            if (radioChecked[radioName] == this) { // Kiểm tra nếu radio đã được chọn trước đó
                this.checked = false;
                radioChecked[radioName] = null;
            } else {
                radioChecked[radioName] = this;
            }
        });
    });
});