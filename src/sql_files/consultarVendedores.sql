SELECT V.`idPersona`,V.Nombre
FROM Persona As V,Usuario AS U
WHERE V.`idPersona`=U.`idUsuario` AND U.`TipoUsuario`='Vendedor';