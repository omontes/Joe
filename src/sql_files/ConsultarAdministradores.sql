SELECT P.Nombre,P.Direccion,P.Telefono,
date_format(P.FechaCumpleanos, '%d/%m/%Y') AS FechaCumpleanos
FROM Persona As P, usuario AS Ad
WHERE P.`idPersona`= Ad.`idUsuario` AND Ad.`TipoUsuario` = "Administrador";
