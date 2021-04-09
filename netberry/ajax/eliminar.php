<?php
require_once ('../model/tarea.php');
if(isset($_POST['id']) && isset($_POST['id']) != "")
{
    $tarea = new Tarea();

    $tarea->Eliminar($_REQUEST['id']);
}