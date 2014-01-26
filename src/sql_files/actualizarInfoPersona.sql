UPDATE persona AS P
SET P.`Nombre`=?, P.`Direccion` = ?, P.`Cedula` = ?,P.`Telefono` = ?,
P.`FechaCumpleanos` = ?
WHERE P.`Nombre`=? AND P.`idTipoPersona` = ?;