SELECT P.Nombre
FROM persona AS P,cliente AS C
WHERE P.Nombre=? AND P.`idPersona`=C.`idCliente`;
