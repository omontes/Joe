SELECT P.Nombre,P.Direccion,P.Telefono,P.FechaCumpleanos
FROM Persona As P, usuario AS U
WHERE P.`idPersona`= U.`idUsuario` AND U.`TipoUsuario` = "Vendedor";
