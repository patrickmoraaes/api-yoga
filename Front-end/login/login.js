document.addEventListener('DOMContentLoaded', () => {
    const form = document.querySelector('form');
    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Evita o envio padrão do formulário

        const email = form.elements['email'].value; 
        const password = form.elements['senha'].value; 
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
                alert('Login bem-sucedido!');
            } else {
                // Falha no login
                const data = await response.json();
                alert(`Falha no login: ${data}`);
            }
        }catch (error) {

            console.error('Erro:', error);
            alert('Erro ao tentar fazer login. Tente novamente mais tarde.');
        }
        
    });
});
