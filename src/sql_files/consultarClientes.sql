SELECT P.Nombre,P.Direccion,P.Telefono,
date_format(P.FechaCumpleanos, '%d/%m/%Y') AS FechaCumpleanos
FROM Persona As P, cliente AS C
WHERE P.`idPersona`=C.`idCliente`;