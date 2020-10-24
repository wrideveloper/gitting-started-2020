import { User } from "./classes/User.js";
import { HasFormatter } from "./interfaces/HasFormatter.js";
import { ListTemplate } from "./classes/ListTemplate.js";

// Select element from HTML
const form = document.querySelector(".new-item-form") as HTMLFormElement;
const gender = document.querySelector("#gender") as HTMLSelectElement;
const fullname = document.querySelector("#fullname") as HTMLInputElement;
const hobby = document.querySelector("#hobby") as HTMLInputElement;
const phone = document.querySelector("#phone") as HTMLInputElement;
const alert = document.querySelector(".alert") as HTMLDivElement;
const text = document.querySelector(".alert>small") as HTMLDivElement;
const close = document.querySelector(".alert>.close") as HTMLElement;
const ul = document.querySelector("ul") as HTMLUListElement;

// Instance class ListTemplate
const list = new ListTemplate(ul);

form.addEventListener("submit", (e: Event) => {
  e.preventDefault();

  // Check selected gender
  if (gender.selectedIndex > 0) {
    // Initial fomatter user
    let doc: HasFormatter;
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
  } else {
    // Setting alert
    alert.classList.remove("success");
    alert.style.border = "1px solid #ce003e";
    alert.classList.add("error");
    alert.style.display = "block";
    text.innerHTML = "<strong>Error!</strong> Gender is required!";
  }
});

// Evend close button of alert
close.addEventListener("click", () => {
  alert.style.display = "none";
});
