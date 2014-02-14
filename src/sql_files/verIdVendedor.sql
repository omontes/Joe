SELECT P.idPersona
FROM persona AS P,usuario AS U
WHERE P.Nombre=? AND U.`idUsuario`=P.`idPersona`;
