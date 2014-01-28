SELECT P.Nombre,P.Direccion,P.Telefono,P.FechaCumpleanos
FROM Persona As P, cliente AS C
WHERE P.`idPersona`=C.`idCliente`;