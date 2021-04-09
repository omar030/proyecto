<?php
class Database
{
    public static function StartUp()
    {
        $servername = "localhost";
        $database = "netberry";
        $username = "root";
        $password = "";

        $conn = new mysqli($servername, $username, $password, $database);

        if ($conn->connect_errno)
        {
            echo "Fallo al conectar a MySQL: (" . $conn->connect_errno . ") " . $conn->connect_error;
            exit();
        }
        @mysqli_query($conn, "SET NAMES 'utf8'");
        
        return $conn;
    }
}