const URL = "http://localhost:8080/sendEmail";

function submit() {
  event.preventDefault();
  const email = document.getElementById("emailAddress").value;
  const subject = document.getElementById("subject").value;
  const body = document.getElementById("body").value;

  const formData = {
    emailAddress: email,
    subject: subject,
    body: body,
  };

  console.log(formData);
  fetch(URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      } else {
        throw new Error("Erreur lors de l'envoi de l'email.");
      }
    })
    .then((data) => {
      // Afficher la réponse
      console.log(data);
      console.log("Mail envoyé avec succès");
    })
    .catch((error) => {
      console.error("Erreur:", error);
    });
}

function sendDefaultEmail() {
  fetch(URL)
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      console.log("Mail par default envoyé !");
    });
}
