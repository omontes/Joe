INSERT INTO usuario(`TipoUsuario`,`Clave`,`idUsuario`) SELECT ?,?, MAX(idPersona)
FROM persona;
     
