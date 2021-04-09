<?php
require_once('database.php');

class Tarea
{
	private $conn;

	public function __CONSTRUCT()
	{
		try {
			$this->conn = Database::StartUp();
		} catch (Exception $e) {
			die($e->getMessage());
		}
	}

	public function Listar()
	{
		try {
			$result = mysqli_query($this->conn, "SELECT t.*, c.nombre_categoria as categorias FROM tarea t INNER JOIN categoria c ON t.id = c.id_tarea");

			$data = "";
			if (mysqli_num_rows($result) > 0) {
				while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) {
					$data .= '<tr>
						<td>' . $row['nombre_tarea'] . '</td>
						<td><span class="badge badge-secondary">' . $row['categorias'] . '</span></td>
						<td>
							<button onclick="eliminar(' . $row['id'] . ')" class="btn btn-danger">X</button>
						</td>
    				</tr>';
				}
			} else {
				$data .= '<tr><td colspan="6">No hay registros!</td></tr>';
			}

			echo $data;
		} catch (Exception $e) {
			die($e->getMessage());
		}
	}

	public function Eliminar($id)
	{
		try {
			$data = "";
			$stm = $this->conn->query("DELETE FROM tarea WHERE id = $id");
			
			if ($this->conn->query($stm)) {
				$data .= 'Se Elimino correctamente';
			} else {
				$data .= 'Ocurrió un error';
			}
			echo $data;
		} catch (Exception $e) {
			die($e->getMessage());
		}
	}


	public function Registrar($nombre, $categoria)
	{
		try {
			$value = "";
			$data = "";
			$consulta = "INSERT INTO tarea (nombre_tarea)VALUES('$nombre')";
			
			foreach ($categoria as $cate) {
				$value .= " ".$cate;
			}
			//$array = json_encode($categoria);
			if (mysqli_query($this->conn, $consulta)) {
				$lastID = mysqli_insert_id($this->conn);
				$sql = "INSERT INTO categoria (nombre_categoria, id_tarea)VALUES('$value', '$lastID')";

				if ($this->conn->query($sql)) {
					$data .= "Se Creo correctamente";
				} else {
					$data .= "Ocurrió un error";
				}
			}

			echo $data;

		} catch (Exception $e) {
			die($e->getMessage());
		}
	}
}
