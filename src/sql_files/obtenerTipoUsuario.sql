SELECT U.`TipoUsuario`
FROM persona AS P,usuario AS U
WHERE P.`Nombre`=? AND P.`idPersona`=U.`idUsuario`;
