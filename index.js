let signup = document.querySelector(".signup");
let login = document.querySelector(".login");
let slider = document.querySelector(".slider");
let formSection = document.querySelector(".form-section");

signup.addEventListener("click", () => {
   slider.classList.add("moveslider");
    formSection.classList.add("form-section-move");
});

login.addEventListener("click", () => {
    slider.classList.remove("moveslider");
    formSection.classList.remove("form-section-move");
});

   function passFormData() {
       // Get data from form1
       var name = document.getElementById("name").value;
       var email = document.getElementById("email").value;

       // Set data to form2
       document.getElementById("FirstName").value = name;
       document.getElementById("Email").value = email;
   }

