SELECT P.Nombre,P.Direccion,
P.Telefono,date_format(P.FechaCumpleanos, '%d/%m/%Y') AS FechaCumpleanos,
P.`Cedula`
FROM Persona As P
WHERE P.`Nombre` = ?;
