SELECT P.Nombre,P.Direccion,P.Telefono,P.FechaCumpleanos
FROM Persona As P, usuario AS Ad
WHERE P.`idPersona`= Ad.`idUsuario` AND Ad.`TipoUsuario` = "Administrador";
