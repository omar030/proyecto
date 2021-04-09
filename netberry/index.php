<!DOCTYPE html>
<html lang="es">
<head>
    <title>NetBerry Solutions</title>

    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.css" integrity="sha512-aOG0c6nPNzGk+5zjwyJaoRUgCdOrfSDhmMID2u4+OIslr0GjpLKo7Xm0Ao3xmpM4T8AmIouRkqwj1nrdVsLKEQ==" crossorigin="anonymous" />
    <link rel="stylesheet" type="text/css" href="assets/css/style.css" />
</head>

<body>

    <div class="container box">


        <h3>Gestor de tareas</h3>
        <hr />
        <form action="" method="POST" id="create-form">
            <div class="row">
                <div class="col-7">
                    <input type="text" class="form-control" name="nombre" placeholder="Nueva tarea...">
                </div>
                <div class="col-3">
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="categoria[]" value="PHP" multiple>
                        <label class="form-check-label" for="">PHP</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="categoria[]" value="JavaScript" multiple>
                        <label class="form-check-label" for="categoria">JavaScript</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="checkbox" name="categoria[]" value="CSS" multiple>
                        <label class="form-check-label" for="categoria">CSS</label>
                    </div>
                </div>
                <div class="col-2">
                    <button type="button" class="btn btn-primary" onclick="crear()">Añadir</button>
                </div>
            </div>
        </form>


        <table class="table  table-striped  table-hover" id="tabla">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Categoria</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody id="data">
                
            </tbody>
        </table>
                    <div id="resultado"></div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous"></script>
    <script type="text/javascript" src="assets/js/scripts.js"></script>
</body>