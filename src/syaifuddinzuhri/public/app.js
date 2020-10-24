import { User } from "./classes/User.js";
import { ListTemplate } from "./classes/ListTemplate.js";
// Select element from HTML
var form = document.querySelector(".new-item-form");
var gender = document.querySelector("#gender");
var fullname = document.querySelector("#fullname");
var hobby = document.querySelector("#hobby");
var phone = document.querySelector("#phone");
var alert = document.querySelector(".alert");
var text = document.querySelector(".alert>small");
var close = document.querySelector(".alert>.close");
var ul = document.querySelector("ul");
// Instance class ListTemplate
var list = new ListTemplate(ul);
form.addEventListener("submit", function (e) {
    e.preventDefault();
    // Check selected gender
    if (gender.selectedIndex > 0) {
        // Initial fomatter user
        var doc = void 0;
        // Instance class User
        doc = new User(gender.value, hobby.value, phone.valueAsNumber);
        // Render list user
        list.render(doc, fullname.value, "end");
        // Reset value form
        gender.selectedIndex = 0;
        fullname.value = "";
        hobby.value = "";
        phone.value = "";
        // Setting alert
        alert.classList.remove("error");
        alert.style.display = "block";
        alert.style.border = "1px solid #00ce89";
        alert.classList.add("success");
        text.innerHTML = "<strong>Success!</strong> Data added succesfully!";
    }
    else {
        // Setting alert
        alert.classList.remove("success");
        alert.style.border = "1px solid #ce003e";
        alert.classList.add("error");
        alert.style.display = "block";
        text.innerHTML = "<strong>Error!</strong> Gender is required!";
    }
});
// Evend close button of alert
close.addEventListener("click", function () {
    alert.style.display = "none";
});
