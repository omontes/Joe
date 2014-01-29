UPDATE usuario, persona
SET usuario.`Clave` = ?, persona.`Direccion` = ?, persona.`Telefono` = ?, 
persona.`FechaCumpleanos` = ?, persona.`Nombre` = ?
WHERE persona.`Nombre` =? AND usuario.`idUsuario` = persona.`idPersona` AND 
usuario.`TipoUsuario` = ?;
