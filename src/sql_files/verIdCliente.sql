SELECT P.idPersona
FROM persona AS P,cliente AS C
WHERE P.Nombre=? AND C.`idCliente`=P.`idPersona`;
