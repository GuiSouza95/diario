document.addEventListener('DOMContentLoaded', function() {
    let password1 = document.getElementById('password1');
    let password = document.getElementById('password');

    function validatePasswords() {
        if (password && password1 && password.value !== password1.value) {
            alert("As senhas não coincidem. Tente novamente.");
            return false;
        }
        return true;
    };

    const roleSelect = document.getElementById('role');
    const tutorFields = document.getElementById('tutorFields');
    const petsitterFields = document.getElementById('petsitterFields');

    if (roleSelect && tutorFields && petsitterFields) {
        roleSelect.addEventListener('change', () => {
            if (roleSelect.value === 'TUTOR') {
                tutorFields.style.display = 'block';
                petsitterFields.style.display = 'none';

                petsitterFields.querySelectorAll('input').forEach(i => {
                    i.value = '';
                    i.removeAttribute('required');
                });

                tutorFields.querySelectorAll('input').forEach(i => {
                    i.setAttribute('required', true);
                });

            } else if (roleSelect.value === 'PETSITTER') {
                petsitterFields.style.display = 'block';
                tutorFields.style.display = 'none';

                tutorFields.querySelectorAll('input').forEach(i => {
                    i.value = '';
                    i.removeAttribute('required');
                });

                petsitterFields.querySelectorAll('input').forEach(i => {
                    i.setAttribute('required', true);
                });

            } else {
                tutorFields.style.display = 'block';
                petsitterFields.style.display = 'none';

                tutorFields.querySelectorAll('input').forEach(i => i.removeAttribute('required'));
                petsitterFields.querySelectorAll('input').forEach(i => i.removeAttribute('required'));
            }
        });
    }

    const petNameInput = document.getElementById("petName");
    const submitButton = document.getElementById("petNameBtn");

    if (petNameInput && submitButton) {
        petNameInput.addEventListener("input", function () {
            const name = petNameInput.value.trim();
            if (name) {
                submitButton.textContent = "Adicionar " + name;
            } else {
                submitButton.textContent = "Adicionar Pet";
            }
        });
    }

    const btnForm = document.getElementById("btnform");

    if (btnForm) {
        btnForm.addEventListener("click", function(){
            alert("Obrigado, iremos entrar em contacto consigo logo.")
        })
    }
});