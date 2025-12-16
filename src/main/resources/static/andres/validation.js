document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('registroForm');
    const mensajeError = document.getElementById('mensajeError');
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirmPassword');
    const aceptaTerminosCheckbox = document.getElementById('aceptaTerminos');
    const btnSubmit = form.querySelector('.btn-submit');

    // Función para mostrar mensajes al usuario
    function mostrarMensaje(tipo, mensaje) {
        mensajeError.textContent = mensaje;
        // La clase depende de si es un mensaje de error o éxito
        mensajeError.className = `message-area ${tipo === 'error' ? 'error-message' : 'success-message'}`;
    }

    // Limpiar mensaje al escribir
    form.querySelectorAll('input').forEach(input => {
        input.addEventListener('input', () => {
            mensajeError.textContent = '';
            mensajeError.className = 'message-area';
        });
    });

    /**
     * Función principal de Validación y Envío
     */
    form.addEventListener('submit', async (event) => {
        event.preventDefault(); // Detener el envío por defecto
        mostrarMensaje('limpiar', '');
        btnSubmit.disabled = true; // Deshabilitar el botón para evitar doble envío

        // --- 1. Validaciones de Frontend ---

        // Validar que las contraseñas coincidan
        if (passwordInput.value !== confirmPasswordInput.value) {
            mostrarMensaje('error', 'Las contraseñas no coinciden.');
            btnSubmit.disabled = false;
            return;
        }

        // Validar longitud mínima de contraseña (8 caracteres)
        if (passwordInput.value.length < 8) {
            mostrarMensaje('error', 'La contraseña debe tener al menos 8 caracteres.');
            btnSubmit.disabled = false;
            return;
        }

        // Validar Aceptación de Términos
        if (!aceptaTerminosCheckbox.checked) {
            mostrarMensaje('error', 'Debes aceptar los Términos y Condiciones.');
            btnSubmit.disabled = false;
            return;
        }

        // --- 2. Recolección de Datos ---

        // Ajuste CLAVE: Los nombres de las propiedades deben coincidir con camelCase en RegisterRequest
        const formData = {
            firstName: document.getElementById('first_name').value.trim(), // De first_name a firstName
            lastName: document.getElementById('last_name').value.trim(),   // De last_name a lastName
            username: document.getElementById('username').value.trim(),
            email: document.getElementById('email').value.trim(),
            password: passwordInput.value,
            riotId: document.getElementById('riot_id').value.trim(),       // De riot_id a riotId
            epicId: document.getElementById('epic_id').value.trim(),       // De epic_id a epicId
            fifaId: document.getElementById('fifa_id').value.trim()       // De fifa_id a fifaId
        };

        // --- 3. Envío de Datos al Backend ---
        try {
            // Ajuste CLAVE: URL del endpoint
            // El backend es POST a /api/jugador/registrar
            const apiUrl = '/api/jugador/registrar';

            const response = await fetch(apiUrl, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(formData)
            });

            // Intentar leer la respuesta JSON, incluso si es un error (Spring Boot a menudo envía JSON en errores)
            const responseBody = await response.json().catch(() => ({ message: response.statusText }));


            if (response.ok) {
                // Status 200-299 (ej. 201 Created)
                mostrarMensaje('success', '✅ ¡Registro completado con éxito! Ahora puedes iniciar sesión.');
                form.reset();
            } else if (response.status === 409) {
                // Status 409 Conflict: El usuario o email ya existen (definido en JugadorController)
                // Usamos el mensaje del backend si está disponible, sino el mensaje genérico
                 mostrarMensaje('error', responseBody.message || 'Error: El usuario o email ya están registrados.');
            } else {
                // Otros errores 4xx o 5xx
                mostrarMensaje('error', `Error ${response.status}: ${responseBody.message || 'Error desconocido al intentar registrar.'}`);
            }

        } catch (error) {
            console.error('Error de red/conexión:', error);
            mostrarMensaje('error', 'Error de conexión. Asegúrate de que tu servidor Spring Boot está iniciado.');
        } finally {
            btnSubmit.disabled = false; // Habilitar el botón de nuevo
        }
    });
});