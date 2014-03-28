SELECT M.`Fecha`, M.`Detalle` AS Referencia, M.`ValorMovimiento`
FROM movimientos AS M, ubicacionproducto AS U, tipomovimiento AS T
WHERE M.`idTipoMovimiento` = T.`idTipoMovimiento` AND 
M.`idLugarMovimiento` = U.`idUbicacionProducto` AND T.`Nombre` = "Salida" 
AND U.`Lugar` = "Bodega" AND SUBSTRING(M.Fecha,1,10) BETWEEN ? AND ? 
AND M.`Detalle` = ?
ORDER BY M.`Detalle`;


