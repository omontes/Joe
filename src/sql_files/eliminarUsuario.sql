DELETE  persona
FROM persona, usuario, tipousuario
WHERE persona.`Nombre`=? AND usuario.`idUsuario` = persona.`idPersona` 
AND usuario.`TipoUsuario`=? AND 
usuario.`TipoUsuario` = tipousuario.`TipoUsuario` ;