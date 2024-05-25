document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loginForm');
    const errorMessageDiv = document.getElementById('error-message');
    const loadingDiv = document.getElementById('loading');

    const hideErrorMessage = () => {
        errorMessageDiv.style.display = 'none';
        errorMessageDiv.textContent = '';
    };

    // Adicionar evento de foco aos inputs para ocultar a mensagem de erro
    const inputs = form.querySelectorAll('input');
    inputs.forEach(input => {
        input.addEventListener('focus', hideErrorMessage);
    });

    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Evita o envio padrão do formulário

        const email = form.elements['email'].value; 
        const password = form.elements['senha'].value; 

        // Limpar mensagens de erro e carregamento antes de nova tentativa
        hideErrorMessage();
        loadingDiv.style.display = 'none';

        try {
            const response = await fetch('http://localhost:8080/users/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email, password })
            });

            if (response.ok) {
                // Login bem-sucedido
                loadingDiv.style.display = 'block'; // Mostrar o carregamento
                setTimeout(() => {
                    window.location.href = '../yoga1.html';
                }, 2000); // Espera 2 segundos para simular o carregamento
            } else {
                // Falha no login
                const data = await response.json();
                errorMessageDiv.textContent = 'Email ou login incorretos';
                errorMessageDiv.style.display = 'block';
            }
        } catch (error) {
            console.error('Erro:', error);
            errorMessageDiv.textContent = 'Erro ao tentar fazer login. Verifique o email ou senha';
            errorMessageDiv.style.display = 'block';
        }
    });
});
