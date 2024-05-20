document.addEventListener("DOMContentLoaded", function() {
    const formulario = document.querySelector("#cadastroForm");
    const btn = document.querySelector(".register-button");
    const nome = document.querySelector("#name");
    const email = document.querySelector("#email");
    const senha = document.querySelector("#password");
    const confirmarSenha = document.querySelector("#confirmPassword");

    if (formulario && btn && nome && email && senha && confirmarSenha) {
        btn.addEventListener("click", function(event) {
            event.preventDefault(); // Previne o envio padrão do formulário
            if (senha.value === confirmarSenha.value) {
                cadastrar();
            } else {
                alert("As senhas não coincidem!");
            }
        });
    } else {
        console.error("Algum elemento do formulário não foi encontrado.");
    }

    function cadastrar() {
        fetch("http://localhost:8080/users/create", { 
            method: "POST",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: nome.value,
                email: email.value,
                password: senha.value
            })
        })
        .then(response => {
            if (!response.ok) {
                if (response.status === 409) {
                    throw new Error("O email fornecido já está em uso.");
                }
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(data => {
            console.log("Success:", data);
            window.location.href = '../login/login.html';
        })
        .catch((error) => {
            console.error("Error:", error);
            alert("Ocorreu um erro ao processar sua solicitação. Por favor, tente novamente mais tarde.");
        });
    }
});
