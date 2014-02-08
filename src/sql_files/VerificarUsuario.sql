SELECT IF(U.`TipoUsuario`="Administrador",1,2)
FROM persona AS P, usuario AS U
WHERE U.`idUsuario` = P.`idPersona` AND P.`Nombre` = ? 
AND U.`Clave` = ?;