SELECT P.Nombre,P.Direccion,P.Telefono,P.FechaCumpleanos,P.`Cedula`
FROM Persona As P
WHERE P.`Nombre` = ?;
