/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function refreshCaptcha() {
    var captchaImage = document.querySelector('.captcha img');
    captchaImage.src = 'captcha?' + new Date().getTime();
}
