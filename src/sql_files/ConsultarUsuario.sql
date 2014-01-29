SELECT U.`Clave`
FROM persona AS P, usuario AS U
WHERE P.`idPersona` = U.`idUsuario` AND U.`TipoUsuario` = ? AND
P.`Nombre` = ?;