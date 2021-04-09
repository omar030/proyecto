$( document ).ready(function() {
    listar();
});

function crear(){
    var dataString = $('#create-form').serialize();

    $.ajax({
        type: 'POST',
        url: 'ajax/guardar.php',
        data: dataString,
        dataType: 'html',
        success: function(data) {
            listar();
        },
        error: function(error){
            console.log(error);
        }
    });
}
        
function eliminar($id){
    var conf = confirm("¿Está seguro, realmente desea eliminar el registro?");
    if(conf == true){
        $.ajax({
            type: 'POST',
            url: 'ajax/eliminar.php',
            cache: false,
            data: {id: $id},
            success: function(data) {
                $("#resultado").html("Registro Eliminado");
                setTimeout("$('#resultado').hide();", 5000);
                listar();
                
            },
            error: function(error){
                console.log(error);
            }
        });
    }
}

function listar(){
    $.ajax({
            type: 'GET',
            url: 'ajax/listar.php',
            cache: false,
            success: function(data) {
                $("#data").html(data);
                
            },
            error: function(error){
                console.log(error);
            }
        });
}