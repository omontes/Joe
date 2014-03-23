SELECT M.`Fecha`,M.`Detalle`,T.`Nombre` AS Tipo,
IF(PCM.`Balance`is NULL,PCM.`CantidadMovida`,PCM.`Balance`) AS Balance,
PCM.`PrecioMov` AS Precio,PCM.`CantidadMovida`,
IF(T.`Nombre`="Entrada", PCM.`PrecioMov`*PCM.`CantidadMovida`, 0) AS PrecioEntrada,
IF(T.`Nombre`="Salida", PCM.`PrecioMov`*PCM.`CantidadMovida`, 0) AS PrecioSalida,
IF(T.`Nombre`="Entrada",PCM.`CantidadMovida`,0) AS CantidadEntrada,
IF(T.`Nombre`="Salida", PCM.`CantidadMovida`, 0) AS CantidadSalida
FROM movimientos AS M, productocantidadmovimiento AS PCM,tipomovimiento AS T, 
ubicacionproducto AS U
WHERE PCM.`idProductoMov`=? AND M.`idMovimientos`=PCM.`idMovimiento`
AND M.`idTipoMovimiento`=T.`idTipoMovimiento` AND U.`Lugar` = ? 
AND M.`idLugarMovimiento`=U.`idUbicacionProducto` 
AND SUBSTRING(M.Fecha,1,10) BETWEEN ? AND ?
GROUP BY PCM.`idProductoCantidadMovimiento`;

-- SELECT M.`Fecha`,M.`Detalle`,T.`Nombre` AS Tipo,
-- IF(PCM.`Balance`is NULL,PCM.`CantidadMovida`,PCM.`Balance`) AS Balance,
-- PCM.`PrecioMov` AS Precio,PCM.`CantidadMovida`,
-- IF(T.`Nombre`="Entrada", PCM.`PrecioMov`, 0) AS PrecioEntrada,
-- IF(T.`Nombre`="Salida", PCM.`PrecioMov`, 0) AS PrecioSalida,
-- IF(T.`Nombre`="Entrada",PCM.`CantidadMovida`,0) AS CantidadEntrada,
-- IF(T.`Nombre`="Salida", PCM.`CantidadMovida`, 0) AS CantidadSalida
-- FROM movimientos AS M, productocantidadmovimiento AS PCM,tipomovimiento AS T, 
-- ubicacionproducto AS U
-- WHERE PCM.`idProductoMov`=? AND M.`idMovimientos`=PCM.`idMovimiento`
-- AND M.`idTipoMovimiento`=T.`idTipoMovimiento` AND U.`Lugar` = ? 
-- AND M.`idLugarMovimiento`=U.`idUbicacionProducto` 
-- AND SUBSTRING(M.Fecha,1,10) BETWEEN ? AND ? 
-- GROUP BY PCM.`idProductoCantidadMovimiento`;