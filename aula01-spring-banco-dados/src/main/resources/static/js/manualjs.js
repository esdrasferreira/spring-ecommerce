

$("#nome_error").hide();

var nome_error = false;

$("#nome").focusout(function () {
    check_fname();
});


function check_fname() {
    var pattern = /^[a - zA - Z] * $/;
    var fname = $("#nome").val();

    if (pattern.test(nome) && nome !== '') {
        $("#nome_error").hide();

    } else {
        $("#nome_error").html("Deve conter apenas letras.");
        $("#nome_error").show();
        nome_error = true;
    }

}

$("").submit(function () {
    nome_error = false;
    check_fname();

    if (nome_error === false) {
        alert("Cadastro realizado com sucesso.");
        window.location = ('cadastro-usuario.html')
        return true;
    } else {
        alert("Por favor verifique o preenchimento");
        return false;
    }

});