const hamBurger = document.querySelector(".toggle-btn");

hamBurger.addEventListener("click", function () {
    document.querySelector("#sidebar").classList.toggle("expand");
});

function openUpdateDebtPopupForm() {
        // Lấy id của người nợ từ các thuộc tính khác nhau của thẻ
        var debtorId = this.parentNode.parentNode.parentNode.querySelector('.profile-name').innerHTML;
        // Gửi form POST
        document.getElementById('informationForm' + debtorId).submit();
    }



function closeAddDebtPopupForm() {
    document.getElementById('AddDebtPopup').style.display = 'none';
    document.getElementById("overlay").style.display = "none";
}

function openAddDebtPopupForm() {
    document.getElementById('AddDebtPopup').style.display = 'block';
    document.getElementById("overlay").style.display = "block";
}


function closeUpdateDebtPopupForm() {
    document.getElementById('UpdateDebtPopup').style.display = 'none';
    document.getElementById("overlay").style.display = "none";
}

//function openUpdateDebtPopupForm(debtorId) {
//    document.getElementById('UpdateDebtPopup').style.display = 'block';
//    document.getElementById("overlay").style.display = "block";
//}

//function openUpdateDebtPopupForm(firstName, lastName, dateOfBirth, avatar, phoneNumber, address, email, amount) {
//    document.getElementById("firstName").value = firstName;
//    document.getElementById("lastName").value = lastName;
//    document.getElementById("dateOfBirth").value = dateOfBirth;
//    document.getElementById("avatar").value = avatar;
//    document.getElementById("phoneNumber").value = phoneNumber;
//    document.getElementById("address").value = address;
//    document.getElementById("email").value = email;
//    document.getElementById("amount").value = amount;
//    document.getElementById('UpdateDebtPopup').style.display = 'block';
//    document.getElementById("overlay").style.display = "block";
//}
function openUpdateDebtPopupForm(debtor) {
    document.getElementById("firstName").value = debtor.firstName;
    document.getElementById("lastName").value = debtor.lastName;
    document.getElementById("dateOfBirth").value = debtor.dateOfBirth;
    document.getElementById("avatar").value = debtor.avatar;
    document.getElementById("phoneNumber").value = debtor.phoneNumber;
    document.getElementById("address").value = debtor.address;
    document.getElementById("email").value = debtor.email;
    document.getElementById("amount").value = debtor.amount;

    // Show the update debtor popup form
    document.getElementById('UpdateDebtPopup').style.display = 'block';
    document.getElementById("overlay").style.display = "block";
}






