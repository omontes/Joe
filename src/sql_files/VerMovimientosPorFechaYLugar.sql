SELECT M.`Fecha`, M.`Detalle`, M.`ValorMovimiento`
FROM movimientos AS M, ubicacionproducto AS U, tipomovimiento AS T
WHERE M.`idTipoMovimiento` = T.`idTipoMovimiento` AND 
M.`idLugarMovimiento` = U.`idUbicacionProducto` AND T.`Nombre` = ? 
AND U.`Lugar` = ? AND SUBSTRING(M.Fecha,1,10) BETWEEN ? AND ?;
