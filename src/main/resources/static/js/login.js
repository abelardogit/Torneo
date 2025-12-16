document.addEventListener("DOMContentLoaded", () => {
    const btnSubmit = document.querySelector(".btn-submit");
    const inputIdentificador = document.querySelector('input[name="identificador"]');
    const inputPassword = document.querySelector('input[type="password"]');
    const mensajeDiv = document.getElementById("mensaje-estado");
    const API_URL = '/login';

    function mostrarMensaje(texto, tipo) {
        mensajeDiv.className = "";
        mensajeDiv.textContent = texto;
        mensajeDiv.style.display = "block";

        if (tipo === 'error') mensajeDiv.classList.add('mensaje-error');
        else if (tipo === 'exito') mensajeDiv.classList.add('mensaje-exito');
    }

    async function realizarLogin(e) {
        e.preventDefault();

        const payload = {
            identifier: inputIdentificador.value,
            password: inputPassword.value
        };

        try {
            const response = await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(payload)
            });

            if (response.ok) {
                mostrarMensaje(`¡Login correcto! Entrando...`, 'exito');
                setTimeout(() => {
                   window.location.href = "/index.html";
                }, 1000);
            } else {
                mostrarMensaje("Usuario o contraseña incorrectos", 'error');
            }

        } catch (error) {
            console.error("Error:", error);
            mostrarMensaje("Error de conexión con el servidor", 'error');
        }
    }

    btnSubmit.addEventListener("click", realizarLogin);
});