SELECT P.Nombre,P.Direccion,P.Telefono,
date_format(P.FechaCumpleanos, '%d/%m/%Y') AS FechaCumpleanos, U.`TipoUsuario`
FROM Persona As P, usuario AS U
WHERE P.`idPersona`= U.`idUsuario`;

