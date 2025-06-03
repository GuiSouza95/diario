if(password1){
    function validatePasswords() {
        if (password.value !== password1.value) {
            alert("As senhas não coincidem. Tente novamente.");
            return false;
        }

        return true;
    }
};