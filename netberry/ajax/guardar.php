<?php
require_once ('../model/tarea.php');

if(isset($_POST["nombre"]) && isset($_POST["categoria"])){
        $tarea = new Tarea();
        $tarea->Registrar($_POST["nombre"], $_POST["categoria"]);
}
