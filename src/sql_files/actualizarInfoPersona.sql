UPDATE persona AS P, cliente AS C
SET P.`Nombre`=?, P.`Direccion` = ?, P.`Cedula` = ?,P.`Telefono` = ?,
P.`FechaCumpleanos` = ?
WHERE P.`Nombre`=? AND P.`idPersona` = C.`idCliente`;